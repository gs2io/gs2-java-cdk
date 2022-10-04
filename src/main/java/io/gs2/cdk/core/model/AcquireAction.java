package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class AcquireAction {

    String action;
    Map<String, Object> request;

    public AcquireAction(
            String action,
            Map<String, Object> request
    ) {
        this.action = action;
        this.request = request;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("action", action);
                put("request", request);
            }
        };
    }
}
