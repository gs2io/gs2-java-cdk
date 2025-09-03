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
import io.gs2.cdk.core.model.TransactionSetting;
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

public class NamespaceOptions {
    public String description;
    public TransactionSetting transactionSetting;
    public Boolean enableRating;
    public NamespaceEnableDisconnectDetection enableDisconnectDetection;
    public Integer disconnectDetectionTimeoutSeconds;
    public String createGatheringTriggerRealtimeNamespaceId;
    public String createGatheringTriggerScriptId;
    public String completeMatchmakingTriggerRealtimeNamespaceId;
    public String completeMatchmakingTriggerScriptId;
    public NamespaceEnableCollaborateSeasonRating enableCollaborateSeasonRating;
    public String collaborateSeasonRatingNamespaceId;
    public Integer collaborateSeasonRatingTtl;
    public ScriptSetting changeRatingScript;
    public NotificationSetting joinNotification;
    public NotificationSetting leaveNotification;
    public NotificationSetting completeNotification;
    public NotificationSetting changeRatingNotification;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withTransactionSetting(
        TransactionSetting transactionSetting
    ) {
        this.transactionSetting = transactionSetting;
        return this;
    }
    
    public NamespaceOptions withEnableRating(
        Boolean enableRating
    ) {
        this.enableRating = enableRating;
        return this;
    }
    
    public NamespaceOptions withEnableDisconnectDetection(
        NamespaceEnableDisconnectDetection enableDisconnectDetection
    ) {
        this.enableDisconnectDetection = enableDisconnectDetection;
        return this;
    }
    
    public NamespaceOptions withDisconnectDetectionTimeoutSeconds(
        Integer disconnectDetectionTimeoutSeconds
    ) {
        this.disconnectDetectionTimeoutSeconds = disconnectDetectionTimeoutSeconds;
        return this;
    }
    
    public NamespaceOptions withCreateGatheringTriggerRealtimeNamespaceId(
        String createGatheringTriggerRealtimeNamespaceId
    ) {
        this.createGatheringTriggerRealtimeNamespaceId = createGatheringTriggerRealtimeNamespaceId;
        return this;
    }
    
    public NamespaceOptions withCreateGatheringTriggerScriptId(
        String createGatheringTriggerScriptId
    ) {
        this.createGatheringTriggerScriptId = createGatheringTriggerScriptId;
        return this;
    }
    
    public NamespaceOptions withCompleteMatchmakingTriggerRealtimeNamespaceId(
        String completeMatchmakingTriggerRealtimeNamespaceId
    ) {
        this.completeMatchmakingTriggerRealtimeNamespaceId = completeMatchmakingTriggerRealtimeNamespaceId;
        return this;
    }
    
    public NamespaceOptions withCompleteMatchmakingTriggerScriptId(
        String completeMatchmakingTriggerScriptId
    ) {
        this.completeMatchmakingTriggerScriptId = completeMatchmakingTriggerScriptId;
        return this;
    }
    
    public NamespaceOptions withEnableCollaborateSeasonRating(
        NamespaceEnableCollaborateSeasonRating enableCollaborateSeasonRating
    ) {
        this.enableCollaborateSeasonRating = enableCollaborateSeasonRating;
        return this;
    }
    
    public NamespaceOptions withCollaborateSeasonRatingNamespaceId(
        String collaborateSeasonRatingNamespaceId
    ) {
        this.collaborateSeasonRatingNamespaceId = collaborateSeasonRatingNamespaceId;
        return this;
    }
    
    public NamespaceOptions withCollaborateSeasonRatingTtl(
        Integer collaborateSeasonRatingTtl
    ) {
        this.collaborateSeasonRatingTtl = collaborateSeasonRatingTtl;
        return this;
    }
    
    public NamespaceOptions withChangeRatingScript(
        ScriptSetting changeRatingScript
    ) {
        this.changeRatingScript = changeRatingScript;
        return this;
    }
    
    public NamespaceOptions withJoinNotification(
        NotificationSetting joinNotification
    ) {
        this.joinNotification = joinNotification;
        return this;
    }
    
    public NamespaceOptions withLeaveNotification(
        NotificationSetting leaveNotification
    ) {
        this.leaveNotification = leaveNotification;
        return this;
    }
    
    public NamespaceOptions withCompleteNotification(
        NotificationSetting completeNotification
    ) {
        this.completeNotification = completeNotification;
        return this;
    }
    
    public NamespaceOptions withChangeRatingNotification(
        NotificationSetting changeRatingNotification
    ) {
        this.changeRatingNotification = changeRatingNotification;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

