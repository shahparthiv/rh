package com.temoral_worker.integration.step;

import java.util.Map;

public interface Step {
    void execute(Map<String, Object> details);
}