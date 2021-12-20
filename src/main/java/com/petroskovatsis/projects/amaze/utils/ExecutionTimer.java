package com.petroskovatsis.projects.amaze.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

public class ExecutionTimer {
    private final Logger logger = LoggerFactory.getLogger(ExecutionTimer.class);

    public interface ExecMethod<T> {
        T exec() throws Exception;
    }

    public <T> T exec(ExecMethod<T> method) throws Exception {
        Instant start = Instant.now();
        T o = method.exec();
        Instant end = Instant.now();
        logger.info("Execution time: {} ms", Duration.between(start, end).toNanos());
        return o;
    }
}
