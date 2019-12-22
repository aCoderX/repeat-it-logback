package com.acoderx.repeat.logback.core;

/**
 * Description: 定义输出源头，以及输出行为,如ConsoleAppender是输出到控制台
 *
 * @author xudi
 * @since 2019-12-18
 */
public interface Appender {
    /**
     * 输出日志到各自输出源
     * @param loggingEvent
     */
    void doAppend(LoggingEvent loggingEvent);
}
