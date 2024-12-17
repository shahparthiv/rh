package com.temoral_worker.integration.step;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

public class HttpRequestStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestStep.class);

    @Override
    public Map<String, Object> execute(Map<String, Object> stepDetails, Map<String, Object> context) {

        logger.info("Performing HTTP Request:");

        // Implement HTTP Request Logic
        // Fetch the data using the httpRequest
        // One can fetch all the information related to API call from the stepDetails map which have the following information
        // In the key value pair:

        //       endpoint: "/detects/queries/detects/v1"
        //      method: "GET"
        //      headers:
        //        - name: "Authorization"
        //          value: "Bearer {{CROWDSTRIKE_API_KEY}}"
        //      query_parameters:
        //        - name: "filter"
        //          value: "status:'new'"

        // After fetching the data user can set the response in the context which can be accessible by other down stream
        // Steps

        // So following would be input for the other steps:
        context.put("response.body.detects", new ArrayList<Object>());


        context.put("HttpRequestStep", "done");
        logger.info("HTTP Request step completed successfully.");
        return context;
    }
}
