package com.acoderx.repeat.logback.core;

/**
 * Description: 定义日志的输入格式,已经占位符填充
 *
 * @author xudi
 * @since 2019-12-19
 */
public interface Layout {

    /**
     * 对本次日志打印事件，进行输出的格式定义
     * @param event
     * @return 返回将被输出的日志字符串
     */
    String doLayout(LoggingEvent event);

}
