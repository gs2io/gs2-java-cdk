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
import io.gs2.cdk.schedule.model.RepeatSetting;
import io.gs2.cdk.schedule.model.options.EventOptions;
import io.gs2.cdk.schedule.model.options.EventScheduleTypeIsAbsoluteOptions;
import io.gs2.cdk.schedule.model.options.EventScheduleTypeIsRelativeOptions;
import io.gs2.cdk.schedule.model.options.EventRepeatTypeIsAlwaysOptions;
import io.gs2.cdk.schedule.model.options.EventRepeatTypeIsDailyOptions;
import io.gs2.cdk.schedule.model.options.EventRepeatTypeIsWeeklyOptions;
import io.gs2.cdk.schedule.model.options.EventRepeatTypeIsMonthlyOptions;
import io.gs2.cdk.schedule.model.enums.EventScheduleType;
import io.gs2.cdk.schedule.model.enums.EventRepeatType;
import io.gs2.cdk.schedule.model.enums.EventRepeatBeginDayOfWeek;
import io.gs2.cdk.schedule.model.enums.EventRepeatEndDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Event {
    private String name;
    private EventScheduleType scheduleType;
    private RepeatSetting repeatSetting;
    private EventRepeatType repeatType;
    private String metadata = null;
    private Long absoluteBegin = null;
    private Long absoluteEnd = null;
    private String relativeTriggerName = null;
    private Integer repeatBeginDayOfMonth = null;
    private Integer repeatEndDayOfMonth = null;
    private EventRepeatBeginDayOfWeek repeatBeginDayOfWeek = null;
    private EventRepeatEndDayOfWeek repeatEndDayOfWeek = null;
    private Integer repeatBeginHour = null;
    private Integer repeatEndHour = null;

    public Event(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType,
        EventOptions options
    ) {
        this.name = name;
        this.scheduleType = scheduleType;
        this.repeatSetting = repeatSetting;
        this.repeatType = repeatType;
        this.metadata = options.metadata;
        this.absoluteBegin = options.absoluteBegin;
        this.absoluteEnd = options.absoluteEnd;
        this.relativeTriggerName = options.relativeTriggerName;
        this.repeatBeginDayOfMonth = options.repeatBeginDayOfMonth;
        this.repeatEndDayOfMonth = options.repeatEndDayOfMonth;
        this.repeatBeginDayOfWeek = options.repeatBeginDayOfWeek;
        this.repeatEndDayOfWeek = options.repeatEndDayOfWeek;
        this.repeatBeginHour = options.repeatBeginHour;
        this.repeatEndHour = options.repeatEndHour;
    }
    public Event(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType
    ) {
        this.name = name;
        this.scheduleType = scheduleType;
        this.repeatSetting = repeatSetting;
        this.repeatType = repeatType;
    }

    public static Event scheduleTypeIsAbsolute(
        String name,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType,
        EventScheduleTypeIsAbsoluteOptions options
    ) {
        return (new Event(
            name,
            EventScheduleType.ABSOLUTE,
            repeatSetting,
            repeatType,
            new EventOptions()
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event scheduleTypeIsAbsolute(
        String name,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType
    ) {
        return (new Event(
            name,
            EventScheduleType.ABSOLUTE,
            repeatSetting,
            repeatType
        ));
    }

    public static Event scheduleTypeIsRelative(
        String name,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType,
        String relativeTriggerName,
        EventScheduleTypeIsRelativeOptions options
    ) {
        return (new Event(
            name,
            EventScheduleType.RELATIVE,
            repeatSetting,
            repeatType,
            new EventOptions()
                .withRelativeTriggerName(relativeTriggerName)
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event scheduleTypeIsRelative(
        String name,
        RepeatSetting repeatSetting,
        EventRepeatType repeatType,
        String relativeTriggerName
    ) {
        return (new Event(
            name,
            EventScheduleType.RELATIVE,
            repeatSetting,
            repeatType
        ));
    }

    public static Event repeatTypeIsAlways(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        EventRepeatTypeIsAlwaysOptions options
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.ALWAYS,
            new EventOptions()
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event repeatTypeIsAlways(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.ALWAYS
        ));
    }

    public static Event repeatTypeIsDaily(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        Integer repeatBeginHour,
        Integer repeatEndHour,
        EventRepeatTypeIsDailyOptions options
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.DAILY,
            new EventOptions()
                .withRepeatBeginHour(repeatBeginHour)
                .withRepeatEndHour(repeatEndHour)
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event repeatTypeIsDaily(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        Integer repeatBeginHour,
        Integer repeatEndHour
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.DAILY
        ));
    }

    public static Event repeatTypeIsWeekly(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        EventRepeatBeginDayOfWeek repeatBeginDayOfWeek,
        EventRepeatEndDayOfWeek repeatEndDayOfWeek,
        Integer repeatBeginHour,
        Integer repeatEndHour,
        EventRepeatTypeIsWeeklyOptions options
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.WEEKLY,
            new EventOptions()
                .withRepeatBeginDayOfWeek(repeatBeginDayOfWeek)
                .withRepeatEndDayOfWeek(repeatEndDayOfWeek)
                .withRepeatBeginHour(repeatBeginHour)
                .withRepeatEndHour(repeatEndHour)
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event repeatTypeIsWeekly(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        EventRepeatBeginDayOfWeek repeatBeginDayOfWeek,
        EventRepeatEndDayOfWeek repeatEndDayOfWeek,
        Integer repeatBeginHour,
        Integer repeatEndHour
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.WEEKLY
        ));
    }

    public static Event repeatTypeIsMonthly(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        Integer repeatBeginDayOfMonth,
        Integer repeatEndDayOfMonth,
        Integer repeatBeginHour,
        Integer repeatEndHour,
        EventRepeatTypeIsMonthlyOptions options
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.MONTHLY,
            new EventOptions()
                .withRepeatBeginDayOfMonth(repeatBeginDayOfMonth)
                .withRepeatEndDayOfMonth(repeatEndDayOfMonth)
                .withRepeatBeginHour(repeatBeginHour)
                .withRepeatEndHour(repeatEndHour)
                .withMetadata(options.metadata)
                .withAbsoluteBegin(options.absoluteBegin)
                .withAbsoluteEnd(options.absoluteEnd)
        ));
    }


    public static Event repeatTypeIsMonthly(
        String name,
        EventScheduleType scheduleType,
        RepeatSetting repeatSetting,
        Integer repeatBeginDayOfMonth,
        Integer repeatEndDayOfMonth,
        Integer repeatBeginHour,
        Integer repeatEndHour
    ) {
        return (new Event(
            name,
            scheduleType,
            repeatSetting,
            EventRepeatType.MONTHLY
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
        if (this.scheduleType != null) {
            properties.put("scheduleType", this.scheduleType.toString(
            ));
        }
        if (this.absoluteBegin != null) {
            properties.put("absoluteBegin", this.absoluteBegin);
        }
        if (this.absoluteEnd != null) {
            properties.put("absoluteEnd", this.absoluteEnd);
        }
        if (this.relativeTriggerName != null) {
            properties.put("relativeTriggerName", this.relativeTriggerName);
        }
        if (this.repeatSetting != null) {
            properties.put("repeatSetting", this.repeatSetting.properties(
            ));
        }
        if (this.repeatType != null) {
            properties.put("repeatType", this.repeatType.toString(
            ));
        }
        if (this.repeatBeginDayOfMonth != null) {
            properties.put("repeatBeginDayOfMonth", this.repeatBeginDayOfMonth);
        }
        if (this.repeatEndDayOfMonth != null) {
            properties.put("repeatEndDayOfMonth", this.repeatEndDayOfMonth);
        }
        if (this.repeatBeginDayOfWeek != null) {
            properties.put("repeatBeginDayOfWeek", this.repeatBeginDayOfWeek.toString(
            ));
        }
        if (this.repeatEndDayOfWeek != null) {
            properties.put("repeatEndDayOfWeek", this.repeatEndDayOfWeek.toString(
            ));
        }
        if (this.repeatBeginHour != null) {
            properties.put("repeatBeginHour", this.repeatBeginHour);
        }
        if (this.repeatEndHour != null) {
            properties.put("repeatEndHour", this.repeatEndHour);
        }

        return properties;
    }
}
