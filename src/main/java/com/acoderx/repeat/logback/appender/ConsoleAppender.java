package com.acoderx.repeat.logback.appender;

/**
 * Description: 输出日志到控制台
 *
 * @author xudi
 * @since 2019-12-20
 */
public class ConsoleAppender extends OutputStreamAppender {

    public ConsoleAppender() {
        super();

        //将控制台的输出流设置成输出流
        this.outputStream = System.out;
    }
}
