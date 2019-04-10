package com.hacker.framework.component;

import com.alibaba.fastjson.JSONObject;
import com.hacker.framework.constants.InvoctionLogConstants;
import com.hacker.framework.constants.LoggerConstants;
import com.hacker.framework.context.PipelineContext;
import com.hacker.framework.hbase.CellUnit;
import com.hacker.framework.hbase.ColumnBaseStorageService;
import com.hacker.framework.hbase.RowUnit;
import com.hacker.framework.service.CommonQueryParam;
import com.hacker.framework.service.CommonQueryResult;
import com.hacker.framework.util.LoggerUtil;
import com.hacker.framework.util.Md5Util;
import org.codehaus.groovy.util.StringUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 2019/4/6 0006.
 */
public class LogDataviewComponentRunner implements ComponentRunner {

    private static final String family = "f";

    private static final Logger DATAVIEW_INVOCATION = LoggerConstants.DATAVIEW_INVOCATION;

    @Autowired
    private ColumnBaseStorageService columnBaseStorageService;

    @Override
    public Object runComponent(String comCode, PipelineContext ctx) {
        CommonQueryParam commonQueryParam = ctx.getCommonQueryParam();

        CommonQueryResult commonQueryResult = ctx.getCommonQueryResult();

        String success = commonQueryResult.isSuccess() ? "Y" : "N";
        String fromCache = commonQueryResult.isFromCache() ? "Y" : "N";
        long elapseTime = ctx.getEndTime() - ctx.getStartTime();
        String param = JSONObject.toJSONString(commonQueryParam.getQueryConditions());
        String result = JSONObject.toJSONString(commonQueryResult.getResultMap());

        List<CellUnit> cellUnits = new ArrayList<>();
        long timestamp = ctx.getEndTime();

        cellUnits.add(new CellUnit(family, InvoctionLogConstants.DATAVIEW_CODE, ctx.getDataviewCode(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.SUCCESS, success, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ERROR_CODE, commonQueryResult.getErrorCode(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ERROR_MSG, commonQueryResult.getErrorMessage(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.FROM_CACHE, fromCache, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_DOMAIN, commonQueryParam.getVisitDomain(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_BIZ, commonQueryParam.getVisitBiz(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.VISIT_BIZ_LINE, commonQueryParam.getVisitBizLine(), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.BIZ_NO, commonQueryParam.getBizNo(), timestamp));

        cellUnits.add(new CellUnit(family, InvoctionLogConstants.PARAM, param, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.RESULT, result, timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.START_TIME, String.valueOf(ctx.getStartTime()), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ENT_TIME, String.valueOf(ctx.getEndTime()), timestamp));
        cellUnits.add(new CellUnit(family, InvoctionLogConstants.ELAPSE_TIME, String.valueOf(elapseTime), timestamp));

        String rowKey = makeRowKey(ctx);

        LoggerUtil.monitor(DATAVIEW_INVOCATION,
                ctx.getCommonQueryParam().getBizNo(),
                commonQueryParam.getServiceName(),
                success,
                commonQueryResult.getErrorCode(),
                commonQueryResult.getErrorMessage(),
                commonQueryParam.getVisitBiz(),
                commonQueryParam.getVisitBizLine(),
                commonQueryParam.getVisitDomain(),
                fromCache,
                elapseTime,
                timestamp,
                param,
                result,
                rowKey);

        RowUnit rowUnit = new RowUnit(rowKey, cellUnits, timestamp);

        /**
         * 异步存储
         */
        columnBaseStorageService.asyncSaveRow(InvoctionLogConstants.DATAVIEW_INVOCATION_TABLE, rowUnit);

        return null;
    }

    private String makeRowKey(PipelineContext ctx) {
        StringBuilder rowKey = new StringBuilder();
        //apache-commons-lang 2.6 的 StringUtils
//        rowKey.append(SringUtils.subString(Md5Util.getMd5(ctx.getCommonQueryParam().getBizNo()), 0, 4)).append("#");
//        rowKey.append(StringUtils.trim(ctx.getDataviewCode())).append("#");
//        rowKey.append(StringUtils.trim(ctx.getCommonQueryParam().getBizNo())).append("#");
//        rowKey.append(String.valueOf(ctx.getEndTime()));
        return rowKey.toString();
    }
}
