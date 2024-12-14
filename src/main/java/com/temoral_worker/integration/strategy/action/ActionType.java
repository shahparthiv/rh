package com.temoral_worker.integration.strategy.action;

import java.util.Map;

public interface ActionType {
    void execute(Map<String, Object> details);
}
