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
package io.gs2.cdk.mission.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.options.MissionTaskModelOptions;
import io.gs2.cdk.mission.model.enums.MissionTaskModelTargetResetType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionTaskModel {
    private String name;
    private String counterName;
    private Long targetValue;
    private String metadata = null;
    private MissionTaskModelTargetResetType targetResetType = null;
    private List<AcquireAction> completeAcquireActions = null;
    private String challengePeriodEventId = null;
    private String premiseMissionTaskName = null;

    public MissionTaskModel(
        String name,
        String counterName,
        Long targetValue,
        MissionTaskModelOptions options
    ) {
        this.name = name;
        this.counterName = counterName;
        this.targetValue = targetValue;
        this.metadata = options.metadata;
        this.targetResetType = options.targetResetType;
        this.completeAcquireActions = options.completeAcquireActions;
        this.challengePeriodEventId = options.challengePeriodEventId;
        this.premiseMissionTaskName = options.premiseMissionTaskName;
    }
    public MissionTaskModel(
        String name,
        String counterName,
        Long targetValue
    ) {
        this.name = name;
        this.counterName = counterName;
        this.targetValue = targetValue;
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
        if (this.counterName != null) {
            properties.put("counterName", this.counterName);
        }
        if (this.targetResetType != null) {
            properties.put("targetResetType", this.targetResetType.toString(
            ));
        }
        if (this.targetValue != null) {
            properties.put("targetValue", this.targetValue);
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

        return properties;
    }
}
