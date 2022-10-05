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

package io.gs2.cdk.mission.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.mission.resource.*;

import java.util.*;
import java.util.stream.*;

public class CounterScopeModel {

    public enum ResetType {
        NOT_RESET,
        DAILY,
        WEEKLY,
        MONTHLY;

       public String toString() {
           switch (this) {
               case NOT_RESET:
                   return "notReset";
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

    public enum ResetDayOfWeek {
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
	public ResetType resetType;
	public Integer resetDayOfMonth;
	public ResetDayOfWeek resetDayOfWeek;
	public Integer resetHour;

    public CounterScopeModel(
            ResetType resetType
    ) {
        this.resetType = resetType;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.resetType != null) {
            properties.put("ResetType", this.resetType.toString());
        }
        if (this.resetDayOfMonth != null) {
            properties.put("ResetDayOfMonth", this.resetDayOfMonth);
        }
        if (this.resetDayOfWeek != null) {
            properties.put("ResetDayOfWeek", this.resetDayOfWeek.toString());
        }
        if (this.resetHour != null) {
            properties.put("ResetHour", this.resetHour);
        }
        return properties;
    }
}
