package com.temoral_worker.integration.step;

import java.util.Map;

public interface Step {
    Map<String, Object> execute(Map<String, Object> details, Map<String, Object> context);
}