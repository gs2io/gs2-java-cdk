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
package io.gs2.cdk.mission.model.options;
import io.gs2.cdk.mission.model.TargetCounterModel;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.enums.MissionTaskModelVerifyCompleteType;
import io.gs2.cdk.mission.model.enums.MissionTaskModelTargetResetType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions {
    public String metadata;
    public List<VerifyAction> verifyCompleteConsumeActions;
    public List<AcquireAction> completeAcquireActions;
    public String challengePeriodEventId;
    public String premiseMissionTaskName;
    public MissionTaskModelTargetResetType targetResetType;
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withVerifyCompleteConsumeActions(
        List<VerifyAction> verifyCompleteConsumeActions
    ) {
        this.verifyCompleteConsumeActions = verifyCompleteConsumeActions;
        return this;
    }
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withCompleteAcquireActions(
        List<AcquireAction> completeAcquireActions
    ) {
        this.completeAcquireActions = completeAcquireActions;
        return this;
    }
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withChallengePeriodEventId(
        String challengePeriodEventId
    ) {
        this.challengePeriodEventId = challengePeriodEventId;
        return this;
    }
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withPremiseMissionTaskName(
        String premiseMissionTaskName
    ) {
        this.premiseMissionTaskName = premiseMissionTaskName;
        return this;
    }
    
    public MissionTaskModelVerifyCompleteTypeIsVerifyActionsOptions withTargetResetType(
        MissionTaskModelTargetResetType targetResetType
    ) {
        this.targetResetType = targetResetType;
        return this;
    }
}
