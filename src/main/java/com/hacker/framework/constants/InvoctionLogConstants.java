package com.hacker.framework.constants;

/**
 * Created by hacker on 2019/4/10 0010.
 */
public interface InvoctionLogConstants {

    /**
     * 整个链路的保存日志的两张表，一个是渠道，一个是日志
     */
    String CHANNEL_INVOCATION_TABLE = "channel_invocation_log";

    String DATAVIEW_INVOCATION_TABLE = "dataview_invocation_log";

    /**
     * COMMON
     */
    String CHANNEL_CODE = "channel_code";

    String DATAVIEW_CODE = "dataview_code";

    String BIZ_NO = "biz_no";

    String VISIT_DOMAIN = "visit_domain";

    String VISIT_BIZ = "visit_biz";

    String VISIT_BIZ_LINE = "visit_biz_line";

    String START_TIME = "start_time";

    String ENT_TIME = "end_time";

    String ELAPSE_TIME = "elapse_time";

    String REMOTE_INVOKE = "remote_invoke";



    /**
     * DATAVIEW
     */
    String SUCCESS = "success";
    String ERROR_CODE = "error_code";
    String ERROR_MSG = "error_msg";
    String FROM_CACHE = "from_cache";
    String PARAM = "param_conditions";
    String RESULT = "result";

    /**
     * CHANNEL
     */
    String CHARGE_MSG = "charge_msg";
    String CHARGE_KEY = "charge_key";
    String CHARGE_EXT = "charge_ext";
    String ENT_MSG = "net_msg";
    String CHANNEL_STATUS = "channel_status";
    String CHANNEL_STATUS_MSG = "channel_status_msg";
    String EXTERNAL_BIZ_NO = "external_biz_no";


}
