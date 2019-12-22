package com.acoderx.repeat.logback;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.LoggerFactory;

@RunWith(BlockJUnit4ClassRunner.class)
public class Test {
    @org.junit.Test
    public void test() {
        LoggerFactory.getLogger("com.test").info("sss");
    }
}
