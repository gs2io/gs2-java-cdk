/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.matchmaking.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.matchmaking.ref.*;
import io.gs2.cdk.matchmaking.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String name;
    public String description;
    public Boolean enableRating;
    public String createGatheringTriggerType;
    public String createGatheringTriggerRealtimeNamespaceId;
    public String createGatheringTriggerScriptId;
    public String completeMatchmakingTriggerType;
    public String completeMatchmakingTriggerRealtimeNamespaceId;
    public String completeMatchmakingTriggerScriptId;
    public ScriptSetting changeRatingScript;
    public NotificationSetting joinNotification;
    public NotificationSetting leaveNotification;
    public NotificationSetting completeNotification;
    public LogSetting logSetting;

    public Namespace(
            Stack stack,
            String name,
            Boolean enableRating,
            String createGatheringTriggerType,
            String createGatheringTriggerRealtimeNamespaceId,
            String createGatheringTriggerScriptId,
            String completeMatchmakingTriggerType,
            String completeMatchmakingTriggerRealtimeNamespaceId,
            String completeMatchmakingTriggerScriptId
    ) {
        super("Matchmaking_Namespace_" + name);

        this.stack = stack;
        this.name = name;
        this.enableRating = enableRating;
        this.createGatheringTriggerType = createGatheringTriggerType;
        this.createGatheringTriggerRealtimeNamespaceId = createGatheringTriggerRealtimeNamespaceId;
        this.createGatheringTriggerScriptId = createGatheringTriggerScriptId;
        this.completeMatchmakingTriggerType = completeMatchmakingTriggerType;
        this.completeMatchmakingTriggerRealtimeNamespaceId = completeMatchmakingTriggerRealtimeNamespaceId;
        this.completeMatchmakingTriggerScriptId = completeMatchmakingTriggerScriptId;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Matchmaking::Namespace";
    }

    public Map<String, Object> properties() {
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
        if (this.createGatheringTriggerType != null) {
            properties.put("CreateGatheringTriggerType", this.createGatheringTriggerType.toString());
        }
        if (this.createGatheringTriggerRealtimeNamespaceId != null) {
            properties.put("CreateGatheringTriggerRealtimeNamespaceId", this.createGatheringTriggerRealtimeNamespaceId);
        }
        if (this.createGatheringTriggerScriptId != null) {
            properties.put("CreateGatheringTriggerScriptId", this.createGatheringTriggerScriptId);
        }
        if (this.completeMatchmakingTriggerType != null) {
            properties.put("CompleteMatchmakingTriggerType", this.completeMatchmakingTriggerType.toString());
        }
        if (this.completeMatchmakingTriggerRealtimeNamespaceId != null) {
            properties.put("CompleteMatchmakingTriggerRealtimeNamespaceId", this.completeMatchmakingTriggerRealtimeNamespaceId);
        }
        if (this.completeMatchmakingTriggerScriptId != null) {
            properties.put("CompleteMatchmakingTriggerScriptId", this.completeMatchmakingTriggerScriptId);
        }
        if (this.changeRatingScript != null) {
            properties.put("ChangeRatingScript", this.changeRatingScript.properties());
        }
        if (this.joinNotification != null) {
            properties.put("JoinNotification", this.joinNotification.properties());
        }
        if (this.leaveNotification != null) {
            properties.put("LeaveNotification", this.leaveNotification.properties());
        }
        if (this.completeNotification != null) {
            properties.put("CompleteNotification", this.completeNotification.properties());
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties());
        }
        return properties;
    }

    public NamespaceRef ref(
    ) {
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }

    public Namespace masterData(
            List<RatingModel> ratingModels
    ) {
        new CurrentMasterData(
            this.stack,
            this.name,
            ratingModels
        ).addDependsOn(
            this
        );
        return this;
    }
}
