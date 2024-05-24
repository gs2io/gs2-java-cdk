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
package io.gs2.cdk.matchmaking.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.matchmaking.ref.NamespaceRef;
import io.gs2.cdk.matchmaking.model.CurrentMasterData;
import io.gs2.cdk.matchmaking.model.RatingModel;
import io.gs2.cdk.matchmaking.model.enums.NamespaceEnableDisconnectDetection;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCreateGatheringTriggerType;
import io.gs2.cdk.matchmaking.model.enums.NamespaceCompleteMatchmakingTriggerType;
import io.gs2.cdk.matchmaking.model.enums.NamespaceEnableCollaborateSeasonRating;

import io.gs2.cdk.matchmaking.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private NamespaceCreateGatheringTriggerType createGatheringTriggerType;
    private NamespaceCompleteMatchmakingTriggerType completeMatchmakingTriggerType;
    private String description = null;
    private Boolean enableRating = null;
    private NamespaceEnableDisconnectDetection enableDisconnectDetection = null;
    private Integer disconnectDetectionTimeoutSeconds = null;
    private String createGatheringTriggerRealtimeNamespaceId = null;
    private String createGatheringTriggerScriptId = null;
    private String completeMatchmakingTriggerRealtimeNamespaceId = null;
    private String completeMatchmakingTriggerScriptId = null;
    private NamespaceEnableCollaborateSeasonRating enableCollaborateSeasonRating = null;
    private String collaborateSeasonRatingNamespaceId = null;
    private Integer collaborateSeasonRatingTtl = null;
    private ScriptSetting changeRatingScript = null;
    private NotificationSetting joinNotification = null;
    private NotificationSetting leaveNotification = null;
    private NotificationSetting completeNotification = null;
    private NotificationSetting changeRatingNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceCreateGatheringTriggerType createGatheringTriggerType,
        NamespaceCompleteMatchmakingTriggerType completeMatchmakingTriggerType,
        NamespaceOptions options
    ) {
        super(
            "Matchmaking_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.createGatheringTriggerType = createGatheringTriggerType;
        this.completeMatchmakingTriggerType = completeMatchmakingTriggerType;
        this.description = options.description;
        this.enableRating = options.enableRating;
        this.enableDisconnectDetection = options.enableDisconnectDetection;
        this.disconnectDetectionTimeoutSeconds = options.disconnectDetectionTimeoutSeconds;
        this.createGatheringTriggerRealtimeNamespaceId = options.createGatheringTriggerRealtimeNamespaceId;
        this.createGatheringTriggerScriptId = options.createGatheringTriggerScriptId;
        this.completeMatchmakingTriggerRealtimeNamespaceId = options.completeMatchmakingTriggerRealtimeNamespaceId;
        this.completeMatchmakingTriggerScriptId = options.completeMatchmakingTriggerScriptId;
        this.enableCollaborateSeasonRating = options.enableCollaborateSeasonRating;
        this.collaborateSeasonRatingNamespaceId = options.collaborateSeasonRatingNamespaceId;
        this.collaborateSeasonRatingTtl = options.collaborateSeasonRatingTtl;
        this.changeRatingScript = options.changeRatingScript;
        this.joinNotification = options.joinNotification;
        this.leaveNotification = options.leaveNotification;
        this.completeNotification = options.completeNotification;
        this.changeRatingNotification = options.changeRatingNotification;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        NamespaceCreateGatheringTriggerType createGatheringTriggerType,
        NamespaceCompleteMatchmakingTriggerType completeMatchmakingTriggerType
    ) {
        super(
            "Matchmaking_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.createGatheringTriggerType = createGatheringTriggerType;
        this.completeMatchmakingTriggerType = completeMatchmakingTriggerType;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Matchmaking::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.enableRating != null) {
            properties.put("EnableRating", this.enableRating);
        }
        if (this.enableDisconnectDetection != null) {
            properties.put("EnableDisconnectDetection", this.enableDisconnectDetection);
        }
        if (this.disconnectDetectionTimeoutSeconds != null) {
            properties.put("DisconnectDetectionTimeoutSeconds", this.disconnectDetectionTimeoutSeconds);
        }
        if (this.createGatheringTriggerType != null) {
            properties.put("CreateGatheringTriggerType", this.createGatheringTriggerType);
        }
        if (this.createGatheringTriggerRealtimeNamespaceId != null) {
            properties.put("CreateGatheringTriggerRealtimeNamespaceId", this.createGatheringTriggerRealtimeNamespaceId);
        }
        if (this.createGatheringTriggerScriptId != null) {
            properties.put("CreateGatheringTriggerScriptId", this.createGatheringTriggerScriptId);
        }
        if (this.completeMatchmakingTriggerType != null) {
            properties.put("CompleteMatchmakingTriggerType", this.completeMatchmakingTriggerType);
        }
        if (this.completeMatchmakingTriggerRealtimeNamespaceId != null) {
            properties.put("CompleteMatchmakingTriggerRealtimeNamespaceId", this.completeMatchmakingTriggerRealtimeNamespaceId);
        }
        if (this.completeMatchmakingTriggerScriptId != null) {
            properties.put("CompleteMatchmakingTriggerScriptId", this.completeMatchmakingTriggerScriptId);
        }
        if (this.enableCollaborateSeasonRating != null) {
            properties.put("EnableCollaborateSeasonRating", this.enableCollaborateSeasonRating);
        }
        if (this.collaborateSeasonRatingNamespaceId != null) {
            properties.put("CollaborateSeasonRatingNamespaceId", this.collaborateSeasonRatingNamespaceId);
        }
        if (this.collaborateSeasonRatingTtl != null) {
            properties.put("CollaborateSeasonRatingTtl", this.collaborateSeasonRatingTtl);
        }
        if (this.changeRatingScript != null) {
            properties.put("ChangeRatingScript", this.changeRatingScript.properties(
            ));
        }
        if (this.joinNotification != null) {
            properties.put("JoinNotification", this.joinNotification.properties(
            ));
        }
        if (this.leaveNotification != null) {
            properties.put("LeaveNotification", this.leaveNotification.properties(
            ));
        }
        if (this.completeNotification != null) {
            properties.put("CompleteNotification", this.completeNotification.properties(
            ));
        }
        if (this.changeRatingNotification != null) {
            properties.put("ChangeRatingNotification", this.changeRatingNotification.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            this,
            "Item.NamespaceId",
            null
        ));
    }

    public Namespace masterData(
        List<RatingModel> ratingModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            ratingModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
