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
package io.gs2.cdk.schedule.model;
import io.gs2.cdk.schedule.model.options.RepeatSettingOptions;
import io.gs2.cdk.schedule.model.options.RepeatSettingRepeatTypeIsAlwaysOptions;
import io.gs2.cdk.schedule.model.options.RepeatSettingRepeatTypeIsDailyOptions;
import io.gs2.cdk.schedule.model.options.RepeatSettingRepeatTypeIsWeeklyOptions;
import io.gs2.cdk.schedule.model.options.RepeatSettingRepeatTypeIsMonthlyOptions;
import io.gs2.cdk.schedule.model.options.RepeatSettingRepeatTypeIsCustomOptions;
import io.gs2.cdk.schedule.model.enums.RepeatSettingRepeatType;
import io.gs2.cdk.schedule.model.enums.RepeatSettingBeginDayOfWeek;
import io.gs2.cdk.schedule.model.enums.RepeatSettingEndDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatSetting {
    private RepeatSettingRepeatType repeatType;
    private Integer beginDayOfMonth = null;
    private Integer endDayOfMonth = null;
    private RepeatSettingBeginDayOfWeek beginDayOfWeek = null;
    private RepeatSettingEndDayOfWeek endDayOfWeek = null;
    private Integer beginHour = null;
    private Integer endHour = null;
    private Long anchorTimestamp = null;
    private Integer activeDays = null;
    private Integer inactiveDays = null;

    public RepeatSetting(
        RepeatSettingRepeatType repeatType,
        RepeatSettingOptions options
    ) {
        this.repeatType = repeatType;
        this.beginDayOfMonth = options.beginDayOfMonth;
        this.endDayOfMonth = options.endDayOfMonth;
        this.beginDayOfWeek = options.beginDayOfWeek;
        this.endDayOfWeek = options.endDayOfWeek;
        this.beginHour = options.beginHour;
        this.endHour = options.endHour;
        this.anchorTimestamp = options.anchorTimestamp;
        this.activeDays = options.activeDays;
        this.inactiveDays = options.inactiveDays;
    }
    public RepeatSetting(
        RepeatSettingRepeatType repeatType
    ) {
        this.repeatType = repeatType;
    }

    public static RepeatSetting repeatTypeIsAlways(
        RepeatSettingRepeatTypeIsAlwaysOptions options
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.ALWAYS,
            new RepeatSettingOptions()
        ));
    }


    public static RepeatSetting repeatTypeIsAlways(
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.ALWAYS
        ));
    }

    public static RepeatSetting repeatTypeIsDaily(
        Integer beginHour,
        Integer endHour,
        RepeatSettingRepeatTypeIsDailyOptions options
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.DAILY,
            new RepeatSettingOptions()
                .withBeginHour(beginHour)
                .withEndHour(endHour)
        ));
    }


    public static RepeatSetting repeatTypeIsDaily(
        Integer beginHour,
        Integer endHour
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.DAILY
        ));
    }

    public static RepeatSetting repeatTypeIsWeekly(
        RepeatSettingBeginDayOfWeek beginDayOfWeek,
        RepeatSettingEndDayOfWeek endDayOfWeek,
        Integer beginHour,
        Integer endHour,
        RepeatSettingRepeatTypeIsWeeklyOptions options
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.WEEKLY,
            new RepeatSettingOptions()
                .withBeginDayOfWeek(beginDayOfWeek)
                .withEndDayOfWeek(endDayOfWeek)
                .withBeginHour(beginHour)
                .withEndHour(endHour)
        ));
    }


    public static RepeatSetting repeatTypeIsWeekly(
        RepeatSettingBeginDayOfWeek beginDayOfWeek,
        RepeatSettingEndDayOfWeek endDayOfWeek,
        Integer beginHour,
        Integer endHour
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.WEEKLY
        ));
    }

    public static RepeatSetting repeatTypeIsMonthly(
        Integer beginDayOfMonth,
        Integer endDayOfMonth,
        Integer beginHour,
        Integer endHour,
        RepeatSettingRepeatTypeIsMonthlyOptions options
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.MONTHLY,
            new RepeatSettingOptions()
                .withBeginDayOfMonth(beginDayOfMonth)
                .withEndDayOfMonth(endDayOfMonth)
                .withBeginHour(beginHour)
                .withEndHour(endHour)
        ));
    }


    public static RepeatSetting repeatTypeIsMonthly(
        Integer beginDayOfMonth,
        Integer endDayOfMonth,
        Integer beginHour,
        Integer endHour
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.MONTHLY
        ));
    }

    public static RepeatSetting repeatTypeIsCustom(
        Long anchorTimestamp,
        Integer activeDays,
        Integer inactiveDays,
        RepeatSettingRepeatTypeIsCustomOptions options
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.CUSTOM,
            new RepeatSettingOptions()
                .withAnchorTimestamp(anchorTimestamp)
                .withActiveDays(activeDays)
                .withInactiveDays(inactiveDays)
        ));
    }


    public static RepeatSetting repeatTypeIsCustom(
        Long anchorTimestamp,
        Integer activeDays,
        Integer inactiveDays
    ) {
        return (new RepeatSetting(
            RepeatSettingRepeatType.CUSTOM
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.repeatType != null) {
            properties.put("repeatType", this.repeatType.toString(
            ));
        }
        if (this.beginDayOfMonth != null) {
            properties.put("beginDayOfMonth", this.beginDayOfMonth);
        }
        if (this.endDayOfMonth != null) {
            properties.put("endDayOfMonth", this.endDayOfMonth);
        }
        if (this.beginDayOfWeek != null) {
            properties.put("beginDayOfWeek", this.beginDayOfWeek.toString(
            ));
        }
        if (this.endDayOfWeek != null) {
            properties.put("endDayOfWeek", this.endDayOfWeek.toString(
            ));
        }
        if (this.beginHour != null) {
            properties.put("beginHour", this.beginHour);
        }
        if (this.endHour != null) {
            properties.put("endHour", this.endHour);
        }
        if (this.anchorTimestamp != null) {
            properties.put("anchorTimestamp", this.anchorTimestamp);
        }
        if (this.activeDays != null) {
            properties.put("activeDays", this.activeDays);
        }
        if (this.inactiveDays != null) {
            properties.put("inactiveDays", this.inactiveDays);
        }

        return properties;
    }
}
