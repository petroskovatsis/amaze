package com.petroskovatsis.projects.amaze.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExecutionTimer {

    @Test
    public void testExec() {
        try {
            ExecutionTimer executionTimer = new ExecutionTimer();
            boolean b = executionTimer.exec(new ExecutionTimer.ExecMethod<Boolean>() {
                @Override
                public Boolean exec() throws Exception {
                    Thread.sleep(100);
                    return true;
                }
            });

            assertTrue(b);
            assertTrue(executionTimer.getTimeElapsed() >= 100);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
