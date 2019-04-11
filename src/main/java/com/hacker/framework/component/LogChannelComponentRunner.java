package com.hacker.framework.component;

import com.hacker.framework.constants.InvoctionLogConstants;
import com.hacker.framework.constants.LoggerConstants;
import com.hacker.framework.context.ChannelContext;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.hbase.CellUnit;
import com.hacker.framework.hbase.ColumnBaseStorageService;
import com.hacker.framework.hbase.RowUnit;
import com.hacker.framework.net.NetResponse;
import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.util.LoggerUtil;
import com.hacker.framework.util.Md5Util;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class LogChannelComponentRunner implements ComponentRunner {

    private static final Logger CHANNEL_INVOCATION = LoggerConstants.CHANNEL_INVOCATION;

    private static final String family = "f";

    @Autowired
    private ColumnBaseStorageService columnBaseStorageService;

    @Override
    public Object runComponent(String comCode, PipelineContext ctx) {

        ChannelContext channelContext = ctx.getChannelContext(comCode);

        CommonQueryParam commonQueryParam = ctx.getCommonQueryParam();

        long timestamp = channelContext.getEndTime();
        long elapseTime = channelContext.getEndTime() - channelContext.getStartTime();
        String dataviewCode = ctx.getDataviewCode();
        String channelCode = channelContext.getChannelCode();
        String bizNo = commonQueryParam.getBizNo();
        String channelStatus = channelContext.getChannelStatusEnum().getStatus();
        String channelStatusMsg = channelContext.getStatusMsg();

        String visitDomain = commonQueryParam.getVisitDomain();
        String visitBiz = commonQueryParam.getVisitBiz();
        String visitBizLine = commonQueryParam.getVisitBizLine();

        List<CellUnit> cellUnits = new ArrayList<>();
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.DATAVIEW_CODE, dataviewCode, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHANNEL_CODE, channelCode, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHANNEL_STATUS, channelStatus, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHANNEL_STATUS_MSG, channelStatusMsg, timestamp));

        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_DOMAIN, visitDomain, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_BIZ, visitBiz, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_BIZ_LINE, visitBizLine, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.BIZ_NO, bizNo, timestamp));

        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHARGE_EXT, channelContext.getChargeExt(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHARGE_MSG, channelContext.getChargeMsg(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.CHARGE_KEY, channelContext.getChargeKey(), timestamp));

        NetResponse netResponse = channelContext.getNetResponse();
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ENT_MSG, netResponse != null? netResponse.toString():"", timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.START_TIME, String.valueOf(channelContext.getStartTime()), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ENT_TIME, String.valueOf(channelContext.getEndTime()), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ELAPSE_TIME, String.valueOf(elapseTime), timestamp));
        String isRemoteInvoke = channelContext.isEnableRemoteInvoke() ? "Y" : "N";
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.REMOTE_INVOKE, isRemoteInvoke, timestamp));

        String rowKey = makeRowKey(channelContext, ctx);

        LoggerUtil.monitor(CHANNEL_INVOCATION,
                bizNo,
                dataviewCode,
                channelCode,
                channelStatus,
                channelStatusMsg,
                elapseTime,
                visitDomain,
                visitBiz,
                visitBizLine,
                isRemoteInvoke,
                rowKey,
                channelContext.getChargeMsg(),
                channelContext.getChargeExt(),
                channelContext.getChargeKey());

        RowUnit rowUnit = new RowUnit(rowKey, cellUnits, timestamp);
        /**
         * 异步存储
         */
        columnBaseStorageService.asyncSaveRow(InvoctionLogConstants.CHANNEL_INVOCATION_TABLE, rowUnit);

        return null;
    }

    private String makeRowKey(ChannelContext channelContext, PipelineContext ctx) {
        StringBuilder rowkey = new StringBuilder();
        String bizNo = ctx.getCommonQueryParam().getBizNo();
        String md5 = Md5Util.getMd5(bizNo);
        rowkey.append(md5.substring(0, 4)).append("#");
        rowkey.append(channelContext.getChannelCode().trim()).append("#");
        rowkey.append(bizNo.trim()).append("#");
        rowkey.append(String.valueOf(channelContext.getEndTime()));
        return rowkey.toString();
    }
}
