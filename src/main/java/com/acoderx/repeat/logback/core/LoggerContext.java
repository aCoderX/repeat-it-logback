package com.acoderx.repeat.logback.core;

import com.acoderx.repeat.logback.appender.ConsoleAppender;
import com.acoderx.repeat.logback.layout.TTLLLayout;
import org.slf4j.ILoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: logger上下文，负责logger的创建，以及缓存
 *
 * @author xudi
 * @since 2019-12-18
 */
public class LoggerContext implements ILoggerFactory {

    private Logger root;

    private Map<String, Logger> logCache = new HashMap<>();

    public LoggerContext() {
        root = new Logger(Logger.ROOT_NAME, null, null);
        doDefaultSet();
    }

    /**
     * 设置默认配置
     */
    private void doDefaultSet() {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(new TTLLLayout());
        root.addAppender(consoleAppender);
    }

    @Override
    public Logger getLogger(String name) {
        Logger l = logCache.get(name);
        if (l != null) {
            return l;
        }

        //如果是根logger
        if (Logger.ROOT_NAME.equals(name)) {
            return root;
        }

        int i = 0;
        //每次都从root根去生成logger
        Logger logger = root;
        while (true) {
            //根据'.'分隔，来解析
            int h = name.indexOf(".",i);
            String childName ;
            if (h == -1) {
                childName = name;
            } else {
                childName = name.substring(0, h);
            }
            i = h + 1;

            Logger child = logger.getChildByName(childName);
            if (child == null) {
                child = logger.createChildByName(childName);
                logCache.put(childName, child);
            }

            logger = child;
            if (h == -1) {
                return logger;
            }
        }
    }
}
