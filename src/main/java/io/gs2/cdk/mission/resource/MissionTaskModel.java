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

package io.gs2.cdk.mission.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.mission.ref.*;
import io.gs2.cdk.mission.model.*;

import java.util.*;
import java.util.stream.*;

public class MissionTaskModel {
	public String name;
	public String metadata;
	public String counterName;
	public Long targetValue;
	public List<AcquireAction> completeAcquireActions;
	public String challengePeriodEventId;
	public String premiseMissionTaskName;

    public MissionTaskModel(
            String name,
            String counterName,
            Long targetValue
    ) {
        this.name = name;
        this.counterName = counterName;
        this.targetValue = targetValue;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.counterName != null) {
            properties.put("CounterName", this.counterName);
        }
        if (this.targetValue != null) {
            properties.put("TargetValue", this.targetValue);
        }
        if (this.completeAcquireActions != null) {
            properties.put("CompleteAcquireActions", this.completeAcquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("ChallengePeriodEventId", this.challengePeriodEventId);
        }
        if (this.premiseMissionTaskName != null) {
            properties.put("PremiseMissionTaskName", this.premiseMissionTaskName);
        }
        return properties;
    }

    public MissionTaskModelRef ref(
            String namespaceName,
            String missionGroupName
    ) {
        return new MissionTaskModelRef(
            namespaceName,
            missionGroupName,
            this.name
        );
    }
}
