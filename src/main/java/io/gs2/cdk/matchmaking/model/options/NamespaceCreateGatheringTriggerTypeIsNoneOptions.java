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
import io.gs2.cdk.matchmaking.model.enums.NamespaceEnableDisconnectDetection;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCreateGatheringTriggerType;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCompleteMatchmakingTriggerType;
import io.gs2.cdk.matchmaking.model.enums.NamespaceEnableCollaborateSeasonRating;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceCreateGatheringTriggerTypeIsNoneOptions {
    public String description;
    public ScriptSetting changeRatingScript;
    public NotificationSetting joinNotification;
    public NotificationSetting leaveNotification;
    public NotificationSetting completeNotification;
    public NotificationSetting changeRatingNotification;
    public LogSetting logSetting;
    public Long revision;
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withChangeRatingScript(
        ScriptSetting changeRatingScript
    ) {
        this.changeRatingScript = changeRatingScript;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withJoinNotification(
        NotificationSetting joinNotification
    ) {
        this.joinNotification = joinNotification;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withLeaveNotification(
        NotificationSetting leaveNotification
    ) {
        this.leaveNotification = leaveNotification;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withCompleteNotification(
        NotificationSetting completeNotification
    ) {
        this.completeNotification = completeNotification;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withChangeRatingNotification(
        NotificationSetting changeRatingNotification
    ) {
        this.changeRatingNotification = changeRatingNotification;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
    
    public NamespaceCreateGatheringTriggerTypeIsNoneOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}
