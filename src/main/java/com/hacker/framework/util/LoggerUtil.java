package com.hacker.framework.util;

import org.slf4j.Logger;

/**
 * Created by hacker on 2019/3/29 0029.
 */
public class LoggerUtil {

    /**  线程编号修饰符 **/
    private static final String THREAD_RIGHT_TAG = "]";

    /**  线程编号修饰符 **/
    private static final String THREAD_LEFT_TAG = "[";

    /** 换行符 **/
    private static final char ENTERSTR = '\n';

    /** 逗号 **/
    private static final char VERTICAL_LINE = '|';

    private LoggerUtil(){}

    /**
     * 可处理任意多个参数，避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object...obj){
        if (logger.isDebugEnabled()){
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 可处理任意多个参数，避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param objects
     */
    public static void info(Logger logger, Object...objects){
        if (logger.isInfoEnabled()){
            logger.info(getLogString(objects));
        }
    }

    /**
     * 可处理任意多个参数，避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param objects
     */
    public static void warn(Logger logger, Object...objects){
        logger.warn(getLogString(objects));
    }

    /**
     * 可处理任意多个参数，避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param objects
     */
    public static void error(Logger logger, Object...objects){
        logger.error(getLogString(objects));
    }

    /**
     * 可处理任意多个参数，避免在日志级别不够时字符串拼接带来的资源浪费
     * @param logger
     * @param throwable
     * @param objects
     */
    public static void error(Logger logger, Throwable throwable, Object...objects){
        logger.error(getLogString(objects), throwable);
    }

    /**
     * 构建日志输出内容
     * @param objects
     * @return
     */
    private static String getLogString(Object...objects) {
        StringBuilder loggerBuilder = new StringBuilder();
        loggerBuilder.append(Thread.currentThread().getId());
        for (Object object : objects) {
            loggerBuilder.append(VERTICAL_LINE);
            loggerBuilder.append(object);
        }
        loggerBuilder.append(VERTICAL_LINE);
        return loggerBuilder.toString();
    }

}
