package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class ScriptSetting {

    String triggerScriptId;
    String doneTriggerTargetType;
    String doneTriggerScriptId;
    String doneTriggerQueueNamespaceId;

    public ScriptSetting() {

    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("TriggerScriptId", triggerScriptId);
                put("DoneTriggerTargetType", doneTriggerTargetType);
                put("DoneTriggerScriptId", doneTriggerScriptId);
                put("DoneTriggerQueueNamespaceId", doneTriggerQueueNamespaceId);
            }
        };
    }
}
