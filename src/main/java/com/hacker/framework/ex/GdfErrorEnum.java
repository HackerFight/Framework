package com.hacker.framework.ex;

/**
 * Created by hacker on 2019/3/30 0030.
 */
public enum GdfErrorEnum implements ErrorCode{

    /*--------------------  业务异常 --------------------------*/
    ILLEGAL_BIZ_ARGUMENT("ILLEGAL_BIZ_ARGUMENT", "入参错误", true),

    SERVICE_NOT_AVAIABLE("SERVICE_NOT_AVAIABLE", "业务暂不可用，请联系owner", true),

    NO_SERVICE("NO_SERVICE", "无该服务，请检查配置", true),

    NO_PERMISSION("NO_PERMISSION", "无调用权限", true),

    REMOTE_IO_EXCEPTION("REMOTE_IO_EXCEPTION", "数据源网络IO异常", true),

    HTTP_STATUS_EXCEPTION("HTTP_STATUS_EXCEPTION", "HTTP返回码异常", true),

    NET_MSG_PARSE_EXCEPTION("NET_MSG_PARSE_EXCEPTION", "报文解析异常", true),


    /*--------------------- 系统异常  ---------------------------*/
    SYS_EXCEPTION("SYS_EXCEPTION", "系统异常"),

    TELECOM_EXCEPTION("TELECOM_EXCEPTION", "通信异常"),

    CACHE_EXCEPTION("CACHE_EXCEPTION", "缓存读写异常"),

    HBASE_EXCEPTION("HBASE_EXCEPTION", "Hbase 读写异常"),

    OTS_EXCEPTION("OTS_EXCEPTION", "OTS 读写异常"),

    COM_UNSUPPORT("COM_UNSUPPORT", "组件不支持异常"),

    CHANNEL_CONTEXT_EMPTY("CHANNEL_CONTEXT_EMPTY", "渠道上下文为空"),

    OTS_COM_EXCEPTION("OTS_COM_EXCEPTION", "OTS组件异常"),

    COM_CONF_EMPTY_ERROR("COM_CONF_EMPTY_ERROR", "组件配置错误"),

    META_COM_LOAD_ERROR("META_COM_LOAD_ERROR", "元组件配置加载异常"),

    CHANNEL_LOAD_ERROR("CHANNEL_LOAD_ERROR", "渠道配置异常"),

    CHANNEL_ORCHESTRATION_LOAD_ERROR("CHANNEL_ORCHESTRATION_LOAD_ERROR", "渠道编排错误" ),

    COMPONENT_ORCHESTRATION_LOAD_ERROR("COMPONENT_ORCHESTRATION_LOAD_ERROR", "组件编排错误" ),

    DATA_VIEW_LOAD_ERROR("DATA_VIEW_LOAD_ERROR", "试图加载错误"),

    DYNAMIC_COM_LOAD_ERROR("DYNAMIC_COM_LOAD_ERROR", "动态组件加载失败"),

    ;


    private String code;
    private String msg;
    private boolean exposeToBiz = false;

    GdfErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    GdfErrorEnum(String code, String msg, boolean exposeToBiz){
        this.code = code;
        this.msg = msg;
        this.exposeToBiz = exposeToBiz;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
