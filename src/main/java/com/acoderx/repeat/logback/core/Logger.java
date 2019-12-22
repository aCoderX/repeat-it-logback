package com.acoderx.repeat.logback.core;

import org.slf4j.Marker;
import org.slf4j.event.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 日志交互类，用于用户直接调用来打印日志
 *
 * @author xudi
 * @since 2019-12-18
 */
public class Logger implements org.slf4j.Logger {

    public static final String ROOT_NAME = "ROOT";
    /**
     ** 父logger，例如com.test的parent为com,com.test.hello的parent为com.test
     */
    private Logger parent;

    private List<Logger> child = new ArrayList<>();

    private LoggerContext loggerContext;

    private String name;

    private List<Appender> appenders = new ArrayList<>();

    public Logger(String name, Logger parent, LoggerContext loggerContext) {
        this.parent = parent;
        this.loggerContext = loggerContext;
        this.name = name;
    }

    public Logger getChildByName(String name) {
        for (Logger logger : child) {
            if (logger.getName().equals(this.getName())) {
                return logger;
            }
        }
        return null;
    }

    public Logger createChildByName(String name) {
        Logger logger = new Logger(name, this, loggerContext);
        child.add(logger);
        return logger;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String msg) {

    }

    @Override
    public void trace(String format, Object arg) {

    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {

    }

    @Override
    public void trace(String format, Object... arguments) {

    }

    @Override
    public void trace(String msg, Throwable t) {

    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String msg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {

    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String msg) {

    }

    @Override
    public void debug(String format, Object arg) {

    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {

    }

    @Override
    public void debug(String format, Object... arguments) {

    }

    @Override
    public void debug(String msg, Throwable t) {

    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String msg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String msg) {
        filterAndAppend(Level.INFO, msg);
    }

    @Override
    public void info(String format, Object arg) {

    }

    @Override
    public void info(String format, Object arg1, Object arg2) {

    }

    @Override
    public void info(String format, Object... arguments) {

    }

    @Override
    public void info(String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String msg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String msg) {

    }

    @Override
    public void warn(String format, Object arg) {

    }

    @Override
    public void warn(String format, Object... arguments) {

    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {

    }

    @Override
    public void warn(String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String msg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void error(String format, Object arg) {

    }

    @Override
    public void error(String format, Object arg1, Object arg2) {

    }

    @Override
    public void error(String format, Object... arguments) {

    }

    @Override
    public void error(String msg, Throwable t) {

    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String msg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {

    }


    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }


    /**
     *
     * 过滤
     * 执行过滤器TurboFilterList(未实现，logback用于做全局的过滤)
     * 根据日志level控制是否输出
     * 构建本次logger行为的上下文，loggerEvent
     * 调用Appenders,来输出到各个输出源
     * @param level
     * @param msg
     */
    private void filterAndAppend(Level level, String msg) {
        //TODO TurboFilterList

        //控制level等级

        //构建本次logger行为的上下文，LoggingEvent
        LoggingEvent loggingEvent = new LoggingEvent(level, msg);

        //调用Appenders
        Logger logger = this;
        do {
            logger.invokeAppenders(loggingEvent);
            logger = logger.parent;
        } while (logger != null);

    }

    private void invokeAppenders(LoggingEvent event) {
        for (Appender appender : appenders) {
            appender.doAppend(event);
        }
    }
}
