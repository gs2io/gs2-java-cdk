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
import io.gs2.cdk.schedule.model.RepeatSetting;
import io.gs2.cdk.schedule.model.enums.EventScheduleType;
import io.gs2.cdk.schedule.model.enums.EventRepeatType;
import io.gs2.cdk.schedule.model.enums.EventRepeatBeginDayOfWeek;
import io.gs2.cdk.schedule.model.enums.EventRepeatEndDayOfWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class EventScheduleTypeIsAbsoluteOptions {
    public String metadata;
    public Long absoluteBegin;
    public Long absoluteEnd;
    
    public EventScheduleTypeIsAbsoluteOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public EventScheduleTypeIsAbsoluteOptions withAbsoluteBegin(
        Long absoluteBegin
    ) {
        this.absoluteBegin = absoluteBegin;
        return this;
    }
    
    public EventScheduleTypeIsAbsoluteOptions withAbsoluteEnd(
        Long absoluteEnd
    ) {
        this.absoluteEnd = absoluteEnd;
        return this;
    }
}
