package io.gs2.cdk.core.model;

import io.gs2.cdk.core.model.enums.ScriptSettingDoneTriggerTargetType;
import io.gs2.cdk.core.model.options.ScriptSettingOptions;

import java.util.HashMap;
import java.util.Map;

public class ScriptSetting {

    String triggerScriptId = null;
    ScriptSettingDoneTriggerTargetType doneTriggerTargetType = ScriptSettingDoneTriggerTargetType.NONE;
    String doneTriggerScriptId = null;
    String doneTriggerQueueNamespaceId = null;

    public ScriptSetting(
            ScriptSettingOptions options
    ) {
        this.triggerScriptId = options.triggerScriptId;
        this.doneTriggerTargetType = options.doneTriggerTargetType;
        this.doneTriggerScriptId = options.doneTriggerScriptId;
        this.doneTriggerQueueNamespaceId = options.doneTriggerQueueNamespaceId;
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
