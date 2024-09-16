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
import io.gs2.cdk.mission.model.options.ScopedValueOptions;
import io.gs2.cdk.mission.model.options.ScopedValueScopeTypeIsResetTimingOptions;
import io.gs2.cdk.mission.model.options.ScopedValueScopeTypeIsVerifyActionOptions;
import io.gs2.cdk.mission.model.enums.ScopedValueScopeType;
import io.gs2.cdk.mission.model.enums.ScopedValueResetType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ScopedValue {
    private ScopedValueScopeType scopeType;
    private Long value;
    private ScopedValueResetType resetType = null;
    private String conditionName = null;
    private Long nextResetAt = null;

    public ScopedValue(
        ScopedValueScopeType scopeType,
        Long value,
        ScopedValueOptions options
    ) {
        this.scopeType = scopeType;
        this.value = value;
        this.resetType = options.resetType;
        this.conditionName = options.conditionName;
        this.nextResetAt = options.nextResetAt;
    }
    public ScopedValue(
        ScopedValueScopeType scopeType,
        Long value
    ) {
        this.scopeType = scopeType;
        this.value = value;
    }

    public static ScopedValue scopeTypeIsResetTiming(
        Long value,
        ScopedValueResetType resetType,
        ScopedValueScopeTypeIsResetTimingOptions options
    ) {
        return (new ScopedValue(
            ScopedValueScopeType.RESET_TIMING,
            value,
            new ScopedValueOptions()
                .withResetType(resetType)
                .withNextResetAt(options.nextResetAt)
        ));
    }


    public static ScopedValue scopeTypeIsResetTiming(
        Long value,
        ScopedValueResetType resetType
    ) {
        return (new ScopedValue(
            ScopedValueScopeType.RESET_TIMING,
            value
        ));
    }

    public static ScopedValue scopeTypeIsVerifyAction(
        Long value,
        String conditionName,
        ScopedValueScopeTypeIsVerifyActionOptions options
    ) {
        return (new ScopedValue(
            ScopedValueScopeType.VERIFY_ACTION,
            value,
            new ScopedValueOptions()
                .withConditionName(conditionName)
                .withNextResetAt(options.nextResetAt)
        ));
    }


    public static ScopedValue scopeTypeIsVerifyAction(
        Long value,
        String conditionName
    ) {
        return (new ScopedValue(
            ScopedValueScopeType.VERIFY_ACTION,
            value
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

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
        if (this.nextResetAt != null) {
            properties.put("nextResetAt", this.nextResetAt);
        }

        return properties;
    }
}
