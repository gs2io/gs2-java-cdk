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
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.mission.model.options.CounterScopeModelOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelScopeTypeIsResetTimingOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelScopeTypeIsVerifyActionOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsNotResetOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsDailyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsWeeklyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsMonthlyOptions;
import io.gs2.cdk.mission.model.enums.CounterScopeModelScopeType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CounterScopeModel {
    private CounterScopeModelScopeType scopeType;
    private CounterScopeModelResetType resetType = null;
    private Integer resetDayOfMonth = null;
    private CounterScopeModelResetDayOfWeek resetDayOfWeek = null;
    private Integer resetHour = null;
    private String conditionName = null;
    private VerifyAction condition = null;

    public CounterScopeModel(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelOptions options
    ) {
        this.scopeType = scopeType;
        this.resetType = options.resetType;
        this.resetDayOfMonth = options.resetDayOfMonth;
        this.resetDayOfWeek = options.resetDayOfWeek;
        this.resetHour = options.resetHour;
        this.conditionName = options.conditionName;
        this.condition = options.condition;
    }
    public CounterScopeModel(
        CounterScopeModelScopeType scopeType
    ) {
        this.scopeType = scopeType;
    }

    public static CounterScopeModel scopeTypeIsResetTiming(
        CounterScopeModelResetType resetType,
        CounterScopeModelScopeTypeIsResetTimingOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.RESET_TIMING,
            new CounterScopeModelOptions()
                .withResetType(resetType)
        ));
    }


    public static CounterScopeModel scopeTypeIsResetTiming(
        CounterScopeModelResetType resetType
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.RESET_TIMING
        ));
    }

    public static CounterScopeModel scopeTypeIsVerifyAction(
        String conditionName,
        VerifyAction condition,
        CounterScopeModelScopeTypeIsVerifyActionOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.VERIFY_ACTION,
            new CounterScopeModelOptions()
                .withConditionName(conditionName)
                .withCondition(condition)
        ));
    }


    public static CounterScopeModel scopeTypeIsVerifyAction(
        String conditionName,
        VerifyAction condition
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.VERIFY_ACTION
        ));
    }

    public static CounterScopeModel resetTypeIsNotReset(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetTypeIsNotResetOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            new CounterScopeModelOptions()
        ));
    }


    public static CounterScopeModel resetTypeIsNotReset(
        CounterScopeModelScopeType scopeType
    ) {
        return (new CounterScopeModel(
            scopeType
        ));
    }

    public static CounterScopeModel resetTypeIsDaily(
        CounterScopeModelScopeType scopeType,
        Integer resetHour,
        CounterScopeModelResetTypeIsDailyOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            new CounterScopeModelOptions()
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsDaily(
        CounterScopeModelScopeType scopeType,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            scopeType
        ));
    }

    public static CounterScopeModel resetTypeIsWeekly(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour,
        CounterScopeModelResetTypeIsWeeklyOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            new CounterScopeModelOptions()
                .withResetDayOfWeek(resetDayOfWeek)
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsWeekly(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            scopeType
        ));
    }

    public static CounterScopeModel resetTypeIsMonthly(
        CounterScopeModelScopeType scopeType,
        Integer resetDayOfMonth,
        Integer resetHour,
        CounterScopeModelResetTypeIsMonthlyOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            new CounterScopeModelOptions()
                .withResetDayOfMonth(resetDayOfMonth)
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsMonthly(
        CounterScopeModelScopeType scopeType,
        Integer resetDayOfMonth,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            scopeType
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
        if (this.resetDayOfMonth != null) {
            properties.put("resetDayOfMonth", this.resetDayOfMonth);
        }
        if (this.resetDayOfWeek != null) {
            properties.put("resetDayOfWeek", this.resetDayOfWeek.toString(
            ));
        }
        if (this.resetHour != null) {
            properties.put("resetHour", this.resetHour);
        }
        if (this.conditionName != null) {
            properties.put("conditionName", this.conditionName);
        }
        if (this.condition != null) {
            properties.put("condition", this.condition.properties(
            ));
        }

        return properties;
    }
}
