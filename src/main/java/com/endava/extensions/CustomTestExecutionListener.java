package com.endava.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class CustomTestExecutionListener implements TestExecutionListener, Ordered {

    private static final Logger LOGGER = LogManager.getLogger(CustomTestExecutionListener.class);
    @Override
    public void beforeTestExecution(TestContext testContext) {
        LOGGER.info("beforeTestExecution : {}", testContext.getTestClass().getSimpleName(), testContext.getTestMethod());
    }

    @Override
    public void afterTestExecution(TestContext testContext) {
        LOGGER.info("afterTestExecution : {}", testContext.getTestClass().getSimpleName(), testContext.getTestMethod());
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
