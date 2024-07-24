package io.gs2.cdk.core.model;

import java.util.Map;

public class VerifyAction extends ConsumeAction {

    public VerifyAction(
            String action,
            Map<String, Object> request
    ) {
        super(action, request);
    }
}
