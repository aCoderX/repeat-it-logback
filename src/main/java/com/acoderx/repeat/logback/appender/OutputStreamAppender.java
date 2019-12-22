package com.acoderx.repeat.logback.appender;

import com.acoderx.repeat.logback.core.Appender;
import com.acoderx.repeat.logback.core.Layout;
import com.acoderx.repeat.logback.core.LoggingEvent;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Description:输出到输出流的输出源
 *
 * @author xudi
 * @since 2019-12-19
 */
public class OutputStreamAppender implements Appender {

    private Layout layout;

    protected OutputStream outputStream;

    @Override
    public void doAppend(LoggingEvent event) {
        String msg = layout.doLayout(event);

        try {
            outputStream.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

}
