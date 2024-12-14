package com.temoral_worker.integration.factory;


import com.temoral_worker.integration.strategy.action.ActionType;
import com.temoral_worker.integration.strategy.action.SendEmailAction;
import com.temoral_worker.integration.strategy.action.SendSlackAction;

public class ActionFactory {
    private ActionFactory() {
        throw new IllegalStateException("Utility class");
    }
    public static ActionType getActionType(String actionType) {
        switch (actionType) {
            case "Send Email":
                return new SendEmailAction();
            case "Send Slack":
                return new SendSlackAction();
            default:
                throw new IllegalArgumentException("Unsupported action type: " + actionType);
        }
    }
}
