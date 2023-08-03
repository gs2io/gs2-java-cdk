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
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.enums.MissionTaskModelTargetResetType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionTaskModelOptions {
    public String metadata;
    public MissionTaskModelTargetResetType targetResetType;
    public List<AcquireAction> completeAcquireActions;
    public String challengePeriodEventId;
    public String premiseMissionTaskName;
    
    public MissionTaskModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public MissionTaskModelOptions withTargetResetType(
        MissionTaskModelTargetResetType targetResetType
    ) {
        this.targetResetType = targetResetType;
        return this;
    }
    
    public MissionTaskModelOptions withCompleteAcquireActions(
        List<AcquireAction> completeAcquireActions
    ) {
        this.completeAcquireActions = completeAcquireActions;
        return this;
    }
    
    public MissionTaskModelOptions withChallengePeriodEventId(
        String challengePeriodEventId
    ) {
        this.challengePeriodEventId = challengePeriodEventId;
        return this;
    }
    
    public MissionTaskModelOptions withPremiseMissionTaskName(
        String premiseMissionTaskName
    ) {
        this.premiseMissionTaskName = premiseMissionTaskName;
        return this;
    }
}

