package com.acoderx.repeat.logback.core;


import org.slf4j.event.Level;

/**
 * Description: 定义一次日志输出行为的上下文，包括这次输出的等级、字符串、占位符等信息
 *
 * @author xudi
 * @since 2019-12-20
 */
public class LoggingEvent {
    private Level level;
    private String msg;


    public LoggingEvent(Level level, String msg) {
        this.level = level;
        this.msg = msg;
    }


    public Level getLevel() {
        return level;
    }

    public String getMsg() {
        return msg;
    }
}
