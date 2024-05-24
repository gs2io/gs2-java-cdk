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
package io.gs2.cdk.schedule.model.options;
import io.gs2.cdk.schedule.model.enums.RepeatSettingRepeatType;
import io.gs2.cdk.schedule.model.enums.RepeatSettingBeginDayOfWeek;
import io.gs2.cdk.schedule.model.enums.RepeatSettingEndDayOfWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatSettingOptions {
    public Integer beginDayOfMonth;
    public Integer endDayOfMonth;
    public RepeatSettingBeginDayOfWeek beginDayOfWeek;
    public RepeatSettingEndDayOfWeek endDayOfWeek;
    public Integer beginHour;
    public Integer endHour;
    
    public RepeatSettingOptions withBeginDayOfMonth(
        Integer beginDayOfMonth
    ) {
        this.beginDayOfMonth = beginDayOfMonth;
        return this;
    }
    
    public RepeatSettingOptions withEndDayOfMonth(
        Integer endDayOfMonth
    ) {
        this.endDayOfMonth = endDayOfMonth;
        return this;
    }
    
    public RepeatSettingOptions withBeginDayOfWeek(
        RepeatSettingBeginDayOfWeek beginDayOfWeek
    ) {
        this.beginDayOfWeek = beginDayOfWeek;
        return this;
    }
    
    public RepeatSettingOptions withEndDayOfWeek(
        RepeatSettingEndDayOfWeek endDayOfWeek
    ) {
        this.endDayOfWeek = endDayOfWeek;
        return this;
    }
    
    public RepeatSettingOptions withBeginHour(
        Integer beginHour
    ) {
        this.beginHour = beginHour;
        return this;
    }
    
    public RepeatSettingOptions withEndHour(
        Integer endHour
    ) {
        this.endHour = endHour;
        return this;
    }
}

