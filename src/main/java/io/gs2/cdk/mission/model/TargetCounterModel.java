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
import io.gs2.cdk.mission.model.options.TargetCounterModelOptions;
import io.gs2.cdk.mission.model.options.TargetCounterModelScopeTypeIsResetTimingOptions;
import io.gs2.cdk.mission.model.options.TargetCounterModelScopeTypeIsVerifyActionOptions;
import io.gs2.cdk.mission.model.enums.TargetCounterModelScopeType;
import io.gs2.cdk.mission.model.enums.TargetCounterModelResetType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TargetCounterModel {
    private String counterName;
    private TargetCounterModelScopeType scopeType;
    private Long value;
    private TargetCounterModelResetType resetType = null;
    private String conditionName = null;

    public TargetCounterModel(
        String counterName,
        TargetCounterModelScopeType scopeType,
        Long value,
        TargetCounterModelOptions options
    ) {
        this.counterName = counterName;
        this.scopeType = scopeType;
        this.value = value;
        this.resetType = options.resetType;
        this.conditionName = options.conditionName;
    }
    public TargetCounterModel(
        String counterName,
        TargetCounterModelScopeType scopeType,
        Long value
    ) {
        this.counterName = counterName;
        this.scopeType = scopeType;
        this.value = value;
    }

    public static TargetCounterModel scopeTypeIsResetTiming(
        String counterName,
        Long value,
        TargetCounterModelScopeTypeIsResetTimingOptions options
    ) {
        return (new TargetCounterModel(
            counterName,
            TargetCounterModelScopeType.RESET_TIMING,
            value,
            new TargetCounterModelOptions()
                .withResetType(options.resetType)
        ));
    }


    public static TargetCounterModel scopeTypeIsResetTiming(
        String counterName,
        Long value
    ) {
        return (new TargetCounterModel(
            counterName,
            TargetCounterModelScopeType.RESET_TIMING,
            value
        ));
    }

    public static TargetCounterModel scopeTypeIsVerifyAction(
        String counterName,
        Long value,
        String conditionName,
        TargetCounterModelScopeTypeIsVerifyActionOptions options
    ) {
        return (new TargetCounterModel(
            counterName,
            TargetCounterModelScopeType.VERIFY_ACTION,
            value,
            new TargetCounterModelOptions()
                .withConditionName(conditionName)
                .withResetType(options.resetType)
        ));
    }


    public static TargetCounterModel scopeTypeIsVerifyAction(
        String counterName,
        Long value,
        String conditionName
    ) {
        return (new TargetCounterModel(
            counterName,
            TargetCounterModelScopeType.VERIFY_ACTION,
            value
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.counterName != null) {
            properties.put("counterName", this.counterName);
        }
        if (this.scopeType != null) {
            properties.put("scopeType", this.scopeType.toString(
            ));
        }
        if (this.resetType != null) {
            properties.put("resetType", this.resetType.toString(
            ));
        }
        if (this.conditionName != null) {
            properties.put("conditionName", this.conditionName);
        }
        if (this.value != null) {
            properties.put("value", this.value);
        }

        return properties;
    }
}
