package com.acoderx.repeat.logback.layout;

import com.acoderx.repeat.logback.core.Layout;
import com.acoderx.repeat.logback.core.LoggingEvent;

/**
 * Description: 测试布局，默认布局
 *
 * @author xudi
 * @since 2019-12-20
 */
public class TTLLLayout implements Layout {

    @Override
    public String doLayout(LoggingEvent event) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(event.getLevel().toString());
        builder.append(",");
        builder.append(event.getMsg());
        builder.append("]");
        return builder.toString();
    }
}
