package com.temoral_worker.integration.step;

import com.temoral_worker.integration.factory.ActionFactory;
import com.temoral_worker.integration.pojo.ActionStepDetails;
import com.temoral_worker.integration.strategy.action.ActionType;
import com.util.MapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ActionStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(ActionStep.class);

    @Override
    public void execute(Map<String, Object> stepDetails) {
        // Implement Action Logic
        ActionStepDetails actionStepDetails = MapperUtil.mapToObject(stepDetails, ActionStepDetails.class);
        ActionType actionType = ActionFactory.getActionType(actionStepDetails.getActionType());
        actionType.execute(stepDetails);
        logger.info("Executed Action: {}", stepDetails.get("action_type"));
    }
}
