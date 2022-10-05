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

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.schedule.ref.*;
import io.gs2.cdk.schedule.model.*;

import java.util.*;
import java.util.stream.*;


public class EventMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public String scheduleType;
    public Long absoluteBegin;
    public Long absoluteEnd;
    public String repeatType;
    public Integer repeatBeginDayOfMonth;
    public Integer repeatEndDayOfMonth;
    public String repeatBeginDayOfWeek;
    public String repeatEndDayOfWeek;
    public Integer repeatBeginHour;
    public Integer repeatEndHour;
    public String relativeTriggerName;
    public Integer relativeDuration;

    public EventMaster(
            Stack stack,
            String namespaceName,
            String name,
            String scheduleType,
            Long absoluteBegin,
            Long absoluteEnd,
            String repeatType,
            Integer repeatBeginDayOfMonth,
            Integer repeatEndDayOfMonth,
            String repeatBeginDayOfWeek,
            String repeatEndDayOfWeek,
            Integer repeatBeginHour,
            Integer repeatEndHour,
            String relativeTriggerName,
            Integer relativeDuration
    ) {
        super("Schedule_EventMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.scheduleType = scheduleType;
        this.absoluteBegin = absoluteBegin;
        this.absoluteEnd = absoluteEnd;
        this.repeatType = repeatType;
        this.repeatBeginDayOfMonth = repeatBeginDayOfMonth;
        this.repeatEndDayOfMonth = repeatEndDayOfMonth;
        this.repeatBeginDayOfWeek = repeatBeginDayOfWeek;
        this.repeatEndDayOfWeek = repeatEndDayOfWeek;
        this.repeatBeginHour = repeatBeginHour;
        this.repeatEndHour = repeatEndHour;
        this.relativeTriggerName = relativeTriggerName;
        this.relativeDuration = relativeDuration;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Schedule::EventMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.scheduleType != null) {
            properties.put("ScheduleType", this.scheduleType.toString());
        }
        if (this.absoluteBegin != null) {
            properties.put("AbsoluteBegin", this.absoluteBegin);
        }
        if (this.absoluteEnd != null) {
            properties.put("AbsoluteEnd", this.absoluteEnd);
        }
        if (this.repeatType != null) {
            properties.put("RepeatType", this.repeatType.toString());
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

    public EventMasterRef ref(
            String namespaceName
    ) {
        return new EventMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrEventId() {
        return new GetAttr(
            "Item.EventId"
        );
    }
}
