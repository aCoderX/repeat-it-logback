package com.acoderx.repeat.logback.spi;

import com.acoderx.repeat.logback.core.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/**
 * Description: spi(service provider interface) 规范加载
 * 用于LoggerFactory,初始化、持有上下文信息
 *
 * @author xudi
 * @since 2019-12-18
 */
public class LogbackServiceProvider implements SLF4JServiceProvider {
    private ILoggerFactory loggerContext;
    @Override
    public void initialize() {
        loggerContext = new LoggerContext();
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerContext;
    }

    @Override
    public IMarkerFactory getMarkerFactory() {
        return null;
    }

    @Override
    public MDCAdapter getMDCAdapter() {
        return null;
    }

    @Override
    public String getRequesteApiVersion() {
        return "1.8";
    }
}
