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
import io.gs2.cdk.mission.model.options.CounterScopeModelOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsNotResetOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsDailyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsWeeklyOptions;
import io.gs2.cdk.mission.model.options.CounterScopeModelResetTypeIsMonthlyOptions;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CounterScopeModel {
    private CounterScopeModelResetType resetType;
    private Integer resetDayOfMonth = null;
    private CounterScopeModelResetDayOfWeek resetDayOfWeek = null;
    private Integer resetHour = null;

    public CounterScopeModel(
        CounterScopeModelResetType resetType,
        CounterScopeModelOptions options
    ) {
        this.resetType = resetType;
        this.resetDayOfMonth = options.resetDayOfMonth;
        this.resetDayOfWeek = options.resetDayOfWeek;
        this.resetHour = options.resetHour;
    }
    public CounterScopeModel(
        CounterScopeModelResetType resetType
    ) {
        this.resetType = resetType;
    }

    public static CounterScopeModel resetTypeIsNotReset(
        CounterScopeModelResetTypeIsNotResetOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.NOT_RESET,
            new CounterScopeModelOptions()
        ));
    }


    public static CounterScopeModel resetTypeIsNotReset(
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.NOT_RESET
        ));
    }

    public static CounterScopeModel resetTypeIsDaily(
        Integer resetHour,
        CounterScopeModelResetTypeIsDailyOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.DAILY,
            new CounterScopeModelOptions()
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsDaily(
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.DAILY
        ));
    }

    public static CounterScopeModel resetTypeIsWeekly(
        CounterScopeModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour,
        CounterScopeModelResetTypeIsWeeklyOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.WEEKLY,
            new CounterScopeModelOptions()
                .withResetDayOfWeek(resetDayOfWeek)
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsWeekly(
        CounterScopeModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.WEEKLY
        ));
    }

    public static CounterScopeModel resetTypeIsMonthly(
        Integer resetDayOfMonth,
        Integer resetHour,
        CounterScopeModelResetTypeIsMonthlyOptions options
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.MONTHLY,
            new CounterScopeModelOptions()
                .withResetDayOfMonth(resetDayOfMonth)
                .withResetHour(resetHour)
        ));
    }


    public static CounterScopeModel resetTypeIsMonthly(
        Integer resetDayOfMonth,
        Integer resetHour
    ) {
        return (new CounterScopeModel(
            CounterScopeModelResetType.MONTHLY
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

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

        return properties;
    }
}
