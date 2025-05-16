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
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsNotResetOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsDailyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsWeeklyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsMonthlyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsDaysOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelScopeTypeIsResetTimingOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelScopeTypeIsVerifyActionOptions;
import io.gs2.cdk.mission.model.enums.CounterScopeModelScopeType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CounterScopeModel {
    private CounterScopeModelScopeType scopeType;
    private CounterScopeModelResetType resetType;
    private Integer resetDayOfMonth = null;
    private CounterScopeModelResetDayOfWeek resetDayOfWeek = null;
    private Integer resetHour = null;
    private String conditionName = null;
    private VerifyAction condition = null;
    private Long anchorTimestamp = null;
    private Integer days = null;

    public CounterScopeModel(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetType resetType,
        CounterScopeModelOptions options
    ) {
        this.scopeType = scopeType;
        this.resetType = resetType;
        this.resetDayOfMonth = options.resetDayOfMonth;
        this.resetDayOfWeek = options.resetDayOfWeek;
        this.resetHour = options.resetHour;
        this.conditionName = options.conditionName;
        this.condition = options.condition;
        this.anchorTimestamp = options.anchorTimestamp;
        this.days = options.days;
    }
    public CounterScopeModel(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetType resetType
    ) {
        this.scopeType = scopeType;
        this.resetType = resetType;
    }

    public static CounterScopeModel resetTypeIsNotReset(
        CounterScopeModelScopeType scopeType,
        CounterScopeModelResetTypeIsNotResetOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.NOT_RESET,
            new CounterScopeModelOptions()
        ));
    }


    public static CounterScopeModel resetTypeIsNotReset(
        CounterScopeModelScopeType scopeType
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.NOT_RESET
        ));
    }

    public static CounterScopeModel resetTypeIsDaily(
        CounterScopeModelScopeType scopeType,
        Integer resetHour,
        CounterScopeModelResetTypeIsDailyOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.DAILY,
            new CounterScopeModelOptions()
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsDaily(
        CounterScopeModelScopeType scopeType,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.DAILY
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
            CounterScopeModelResetType.WEEKLY,
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
            scopeType,
            CounterScopeModelResetType.WEEKLY
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
            CounterScopeModelResetType.MONTHLY,
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
            scopeType,
            CounterScopeModelResetType.MONTHLY
        ));
    }

    public static CounterScopeModel resetTypeIsDays(
        CounterScopeModelScopeType scopeType,
        Long anchorTimestamp,
        Integer days,
        CounterScopeModelResetTypeIsDaysOptions options
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.DAYS,
            new CounterScopeModelOptions()
                .withAnchorTimestamp(anchorTimestamp)
                .withDays(days)
        ));
    }


    public static CounterScopeModel resetTypeIsDays(
        CounterScopeModelScopeType scopeType,
        Long anchorTimestamp,
        Integer days
    ) {
        return (new CounterScopeModel(
            scopeType,
            CounterScopeModelResetType.DAYS
        ));
    }

    public static CounterScopeModel scopeTypeIsResetTiming(
        CounterScopeModelResetType resetType,
        CounterScopeModelScopeTypeIsResetTimingOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.RESET_TIMING,
            resetType,
            new CounterScopeModelOptions()
        ));
    }


    public static CounterScopeModel scopeTypeIsResetTiming(
        CounterScopeModelResetType resetType
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.RESET_TIMING,
            resetType
        ));
    }

    public static CounterScopeModel scopeTypeIsVerifyAction(
        CounterScopeModelResetType resetType,
        String conditionName,
        VerifyAction condition,
        CounterScopeModelScopeTypeIsVerifyActionOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.VERIFY_ACTION,
            resetType,
            new CounterScopeModelOptions()
                .withConditionName(conditionName)
                .withCondition(condition)
        ));
    }


    public static CounterScopeModel scopeTypeIsVerifyAction(
        CounterScopeModelResetType resetType,
        String conditionName,
        VerifyAction condition
    ) {
        return (new CounterScopeModel(
            CounterScopeModelScopeType.VERIFY_ACTION,
            resetType
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
        if (this.anchorTimestamp != null) {
            properties.put("anchorTimestamp", this.anchorTimestamp);
        }
        if (this.days != null) {
            properties.put("days", this.days);
        }

        return properties;
    }
}
