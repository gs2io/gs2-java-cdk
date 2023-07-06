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
package io.gs2.cdk.matchmaking.model.options;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCreateGatheringTriggerType;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCompleteMatchmakingTriggerType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions {
    public String description;
    public ScriptSetting changeRatingScript;
    public NotificationSetting joinNotification;
    public NotificationSetting leaveNotification;
    public NotificationSetting completeNotification;
    public NotificationSetting changeRatingNotification;
    public LogSetting logSetting;
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withChangeRatingScript(
        ScriptSetting changeRatingScript
    ) {
        this.changeRatingScript = changeRatingScript;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withJoinNotification(
        NotificationSetting joinNotification
    ) {
        this.joinNotification = joinNotification;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withLeaveNotification(
        NotificationSetting leaveNotification
    ) {
        this.leaveNotification = leaveNotification;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withCompleteNotification(
        NotificationSetting completeNotification
    ) {
        this.completeNotification = completeNotification;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withChangeRatingNotification(
        NotificationSetting changeRatingNotification
    ) {
        this.changeRatingNotification = changeRatingNotification;
        return this;
    }
    
    public NamespaceCompleteMatchmakingTriggerTypeIsGs2RealtimeOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}
