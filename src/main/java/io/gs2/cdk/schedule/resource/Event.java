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

package io.gs2.cdk.schedule.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.schedule.ref.*;
import io.gs2.cdk.schedule.model.*;

import java.util.*;
import java.util.stream.*;

public class Event {

    public enum ScheduleType {
        ABSOLUTE,
        RELATIVE;

        public String toString() {
            switch (this) {
                case ABSOLUTE:
                    return "absolute";
                case RELATIVE:
                    return "relative";
            }
            return "unknown";
        }
    }

    public enum RepeatType {
        ALWAYS,
        DAILY,
        WEEKLY,
        MONTHLY;

        public String toString() {
            switch (this) {
                case ALWAYS:
                    return "always";
                case DAILY:
                    return "daily";
                case WEEKLY:
                    return "weekly";
                case MONTHLY:
                    return "monthly";
            }
            return "unknown";
        }
    }

    public enum RepeatBeginDayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        public String toString() {
            switch (this) {
                case SUNDAY:
                    return "sunday";
                case MONDAY:
                    return "monday";
                case TUESDAY:
                    return "tuesday";
                case WEDNESDAY:
                    return "wednesday";
                case THURSDAY:
                    return "thursday";
                case FRIDAY:
                    return "friday";
                case SATURDAY:
                    return "saturday";
            }
            return "unknown";
        }
    }

    public enum RepeatEndDayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        public String toString() {
            switch (this) {
                case SUNDAY:
                    return "sunday";
                case MONDAY:
                    return "monday";
                case TUESDAY:
                    return "tuesday";
                case WEDNESDAY:
                    return "wednesday";
                case THURSDAY:
                    return "thursday";
                case FRIDAY:
                    return "friday";
                case SATURDAY:
                    return "saturday";
            }
            return "unknown";
        }
    }
	public String name;
	public String metadata;
	public ScheduleType scheduleType;
	public RepeatType repeatType;
	public Long absoluteBegin;
	public Long absoluteEnd;
	public Integer repeatBeginDayOfMonth;
	public Integer repeatEndDayOfMonth;
	public RepeatBeginDayOfWeek repeatBeginDayOfWeek;
	public RepeatEndDayOfWeek repeatEndDayOfWeek;
	public Integer repeatBeginHour;
	public Integer repeatEndHour;
	public String relativeTriggerName;
	public Integer relativeDuration;

    public Event(
            String name,
            ScheduleType scheduleType
    ) {
        this.name = name;
        this.scheduleType = scheduleType;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.scheduleType != null) {
            properties.put("ScheduleType", this.scheduleType.toString());
        }
        if (this.repeatType != null) {
            properties.put("RepeatType", this.repeatType.toString());
        }
        if (this.absoluteBegin != null) {
            properties.put("AbsoluteBegin", this.absoluteBegin);
        }
        if (this.absoluteEnd != null) {
            properties.put("AbsoluteEnd", this.absoluteEnd);
        }
        if (this.repeatBeginDayOfMonth != null) {
            properties.put("RepeatBeginDayOfMonth", this.repeatBeginDayOfMonth);
        }
        if (this.repeatEndDayOfMonth != null) {
            properties.put("RepeatEndDayOfMonth", this.repeatEndDayOfMonth);
        }
        if (this.repeatBeginDayOfWeek != null) {
            properties.put("RepeatBeginDayOfWeek", this.repeatBeginDayOfWeek.toString());
        }
        if (this.repeatEndDayOfWeek != null) {
            properties.put("RepeatEndDayOfWeek", this.repeatEndDayOfWeek.toString());
        }
        if (this.repeatBeginHour != null) {
            properties.put("RepeatBeginHour", this.repeatBeginHour);
        }
        if (this.repeatEndHour != null) {
            properties.put("RepeatEndHour", this.repeatEndHour);
        }
        if (this.relativeTriggerName != null) {
            properties.put("RelativeTriggerName", this.relativeTriggerName);
        }
        if (this.relativeDuration != null) {
            properties.put("RelativeDuration", this.relativeDuration);
        }
        return properties;
    }
}
