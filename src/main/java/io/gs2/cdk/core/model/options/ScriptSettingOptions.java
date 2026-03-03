/*
 * Copyright 2016- Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.gs2.cdk.core.model.options;

import io.gs2.cdk.core.model.enums.ScriptSettingDoneTriggerTargetType;

public class ScriptSettingOptions {
    public String triggerScriptId;
    public ScriptSettingDoneTriggerTargetType doneTriggerTargetType;
    public String doneTriggerScriptId;
    public String doneTriggerQueueNamespaceId;

    public ScriptSettingOptions withTriggerScriptId(
            String triggerScriptId
    ) {
        this.triggerScriptId = triggerScriptId;
        return this;
    }
    
    public ScriptSettingOptions withDoneTriggerTargetType(
            ScriptSettingDoneTriggerTargetType doneTriggerTargetType
    ) {
        this.doneTriggerTargetType = doneTriggerTargetType;
        return this;
    }

    public ScriptSettingOptions withDoneTriggerScriptId(
            String doneTriggerScriptId
    ) {
        this.doneTriggerScriptId = doneTriggerScriptId;
        return this;
    }

    public ScriptSettingOptions withDoneTriggerQueueNamespaceId(
            String doneTriggerQueueNamespaceId
    ) {
        this.doneTriggerQueueNamespaceId = doneTriggerQueueNamespaceId;
        return this;
    }
}
