package com.temoral_worker.integration.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class DataTransformationStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(DataTransformationStep.class);

    @Override
    public Map<String, Object> execute(Map<String, Object> stepDetails, Map<String, Object> context) {

        logger.info("Performing DataTransformationStep");

        // Fetch the inputdata field from stepdetails map:

        String inputData = (String) stepDetails.get("input_data");

        // Now from that key fetch the results from the context which is shared across the steps

        List<Object> data = (List<Object>) context.get("response.body.detects");


        // Apply all the transformation logic on data

            // Here we can define multiple strategy like extract field, rename field, drop field etc and
            // add all those classes inside the strategy package and implement the logic

        context.put("DataTransformationStep", "done");
        logger.info("DataTransformationStep step completed successfully.");
        return context;
    }
}