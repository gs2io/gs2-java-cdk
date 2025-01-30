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
package io.gs2.cdk.limit.model;
import io.gs2.cdk.limit.model.options.LimitModelOptions;
import io.gs2.cdk.limit.model.options.LimitModelResetTypeIsNotResetOptions;
import io.gs2.cdk.limit.model.options.LimitModelResetTypeIsDailyOptions;
import io.gs2.cdk.limit.model.options.LimitModelResetTypeIsWeeklyOptions;
import io.gs2.cdk.limit.model.options.LimitModelResetTypeIsMonthlyOptions;
import io.gs2.cdk.limit.model.options.LimitModelResetTypeIsDaysOptions;
import io.gs2.cdk.limit.model.enums.LimitModelResetType;
import io.gs2.cdk.limit.model.enums.LimitModelResetDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LimitModel {
    private String name;
    private LimitModelResetType resetType;
    private String metadata = null;
    private Integer resetDayOfMonth = null;
    private LimitModelResetDayOfWeek resetDayOfWeek = null;
    private Integer resetHour = null;
    private Long anchorTimestamp = null;
    private Integer days = null;

    public LimitModel(
        String name,
        LimitModelResetType resetType,
        LimitModelOptions options
    ) {
        this.name = name;
        this.resetType = resetType;
        this.metadata = options.metadata;
        this.resetDayOfMonth = options.resetDayOfMonth;
        this.resetDayOfWeek = options.resetDayOfWeek;
        this.resetHour = options.resetHour;
        this.anchorTimestamp = options.anchorTimestamp;
        this.days = options.days;
    }
    public LimitModel(
        String name,
        LimitModelResetType resetType
    ) {
        this.name = name;
        this.resetType = resetType;
    }

    public static LimitModel resetTypeIsNotReset(
        String name,
        LimitModelResetTypeIsNotResetOptions options
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.NOT_RESET,
            new LimitModelOptions()
                .withMetadata(options.metadata)
        ));
    }


    public static LimitModel resetTypeIsNotReset(
        String name
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.NOT_RESET
        ));
    }

    public static LimitModel resetTypeIsDaily(
        String name,
        Integer resetHour,
        LimitModelResetTypeIsDailyOptions options
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.DAILY,
            new LimitModelOptions()
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
        ));
    }


    public static LimitModel resetTypeIsDaily(
        String name,
        Integer resetHour
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.DAILY
        ));
    }

    public static LimitModel resetTypeIsWeekly(
        String name,
        LimitModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour,
        LimitModelResetTypeIsWeeklyOptions options
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.WEEKLY,
            new LimitModelOptions()
                .withResetDayOfWeek(resetDayOfWeek)
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
        ));
    }


    public static LimitModel resetTypeIsWeekly(
        String name,
        LimitModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.WEEKLY
        ));
    }

    public static LimitModel resetTypeIsMonthly(
        String name,
        Integer resetDayOfMonth,
        Integer resetHour,
        LimitModelResetTypeIsMonthlyOptions options
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.MONTHLY,
            new LimitModelOptions()
                .withResetDayOfMonth(resetDayOfMonth)
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
        ));
    }


    public static LimitModel resetTypeIsMonthly(
        String name,
        Integer resetDayOfMonth,
        Integer resetHour
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.MONTHLY
        ));
    }

    public static LimitModel resetTypeIsDays(
        String name,
        Long anchorTimestamp,
        Integer days,
        LimitModelResetTypeIsDaysOptions options
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.DAYS,
            new LimitModelOptions()
                .withAnchorTimestamp(anchorTimestamp)
                .withDays(days)
                .withMetadata(options.metadata)
        ));
    }


    public static LimitModel resetTypeIsDays(
        String name,
        Long anchorTimestamp,
        Integer days
    ) {
        return (new LimitModel(
            name,
            LimitModelResetType.DAYS
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
        if (this.anchorTimestamp != null) {
            properties.put("anchorTimestamp", this.anchorTimestamp);
        }
        if (this.days != null) {
            properties.put("days", this.days);
        }

        return properties;
    }
}
