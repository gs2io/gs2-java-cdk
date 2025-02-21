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
 *
 * deny overwrite
 */
package io.gs2.cdk.mission.model;
import io.gs2.cdk.mission.model.TargetCounterModel;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.options.MissionTaskModelOptions;
import io.gs2.cdk.mission.model.options.MissionTaskModelVerifyCompleteTypeIsCounterOptions;
import io.gs2.cdk.mission.model.options.MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions;
import io.gs2.cdk.mission.model.enums.MissionTaskModelVerifyCompleteType;
import io.gs2.cdk.mission.model.enums.MissionTaskModelTargetResetType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionTaskModel {
    private String name;
    private MissionTaskModelVerifyCompleteType verifyCompleteType;
    private String metadata = null;
    private TargetCounterModel targetCounter = null;
    private List<VerifyAction> verifyCompleteConsumeActions = null;
    private List<AcquireAction> completeAcquireActions = null;
    private String challengePeriodEventId = null;
    private String premiseMissionTaskName = null;
    private MissionTaskModelTargetResetType targetResetType = null;

    public MissionTaskModel(
        String name,
        MissionTaskModelVerifyCompleteType verifyCompleteType,
        MissionTaskModelOptions options
    ) {
        this.name = name;
        this.verifyCompleteType = verifyCompleteType;
        this.metadata = options.metadata;
        this.targetCounter = options.targetCounter;
        this.verifyCompleteConsumeActions = options.verifyCompleteConsumeActions;
        this.completeAcquireActions = options.completeAcquireActions;
        this.challengePeriodEventId = options.challengePeriodEventId;
        this.premiseMissionTaskName = options.premiseMissionTaskName;
        this.targetResetType = options.targetResetType;
    }
    public MissionTaskModel(
        String name,
        MissionTaskModelVerifyCompleteType verifyCompleteType
    ) {
        this.name = name;
        this.verifyCompleteType = verifyCompleteType;
    }

    public static MissionTaskModel verifyCompleteTypeIsCounter(
        String name,
        TargetCounterModel targetCounter,
        MissionTaskModelVerifyCompleteTypeIsCounterOptions options
    ) {
        return (new MissionTaskModel(
            name,
            MissionTaskModelVerifyCompleteType.COUNTER,
            new MissionTaskModelOptions()
                .withTargetCounter(targetCounter)
                .withMetadata(options.metadata)
                .withVerifyCompleteConsumeActions(options.verifyCompleteConsumeActions)
                .withCompleteAcquireActions(options.completeAcquireActions)
                .withChallengePeriodEventId(options.challengePeriodEventId)
                .withPremiseMissionTaskName(options.premiseMissionTaskName)
                .withTargetResetType(options.targetResetType)
        ));
    }


    public static MissionTaskModel verifyCompleteTypeIsCounter(
        String name,
        TargetCounterModel targetCounter
    ) {
        return (new MissionTaskModel(
            name,
            MissionTaskModelVerifyCompleteType.COUNTER
        ));
    }

    public static MissionTaskModel verifyCompleteTypeIsVerifyActions(
        String name,
        MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions options
    ) {
        return (new MissionTaskModel(
            name,
            MissionTaskModelVerifyCompleteType.VERIFY_ACTIONS,
            new MissionTaskModelOptions()
                .withMetadata(options.metadata)
                .withVerifyCompleteConsumeActions(options.verifyCompleteConsumeActions)
                .withCompleteAcquireActions(options.completeAcquireActions)
                .withChallengePeriodEventId(options.challengePeriodEventId)
                .withPremiseMissionTaskName(options.premiseMissionTaskName)
                .withTargetResetType(options.targetResetType)
        ));
    }


    public static MissionTaskModel verifyCompleteTypeIsVerifyActions(
        String name
    ) {
        return (new MissionTaskModel(
            name,
            MissionTaskModelVerifyCompleteType.VERIFY_ACTIONS
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.verifyCompleteType != null) {
            properties.put("verifyCompleteType", this.verifyCompleteType.toString(
            ));
        }
        if (this.targetCounter != null) {
            properties.put("targetCounter", this.targetCounter.properties(
            ));
        }
        if (this.verifyCompleteConsumeActions != null) {
            properties.put("verifyCompleteConsumeActions", this.verifyCompleteConsumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.completeAcquireActions != null) {
            properties.put("completeAcquireActions", this.completeAcquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("challengePeriodEventId", this.challengePeriodEventId);
        }
        if (this.premiseMissionTaskName != null) {
            properties.put("premiseMissionTaskName", this.premiseMissionTaskName);
        }
        if (this.targetResetType != null) {
            properties.put("targetResetType", this.targetResetType.toString(
            ));
        }

        return properties;
    }
}
