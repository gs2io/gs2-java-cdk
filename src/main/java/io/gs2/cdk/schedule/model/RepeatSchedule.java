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
import io.gs2.cdk.schedule.model.options.RepeatScheduleOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatSchedule {
    private Integer repeatCount;
    private Long currentRepeatStartAt = null;
    private Long currentRepeatEndAt = null;
    private Long lastRepeatEndAt = null;
    private Long nextRepeatStartAt = null;

    public RepeatSchedule(
        Integer repeatCount,
        RepeatScheduleOptions options
    ) {
        this.repeatCount = repeatCount;
        this.currentRepeatStartAt = options.currentRepeatStartAt;
        this.currentRepeatEndAt = options.currentRepeatEndAt;
        this.lastRepeatEndAt = options.lastRepeatEndAt;
        this.nextRepeatStartAt = options.nextRepeatStartAt;
    }
    public RepeatSchedule(
        Integer repeatCount
    ) {
        this.repeatCount = repeatCount;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.repeatCount != null) {
            properties.put("repeatCount", this.repeatCount);
        }
        if (this.currentRepeatStartAt != null) {
            properties.put("currentRepeatStartAt", this.currentRepeatStartAt);
        }
        if (this.currentRepeatEndAt != null) {
            properties.put("currentRepeatEndAt", this.currentRepeatEndAt);
        }
        if (this.lastRepeatEndAt != null) {
            properties.put("lastRepeatEndAt", this.lastRepeatEndAt);
        }
        if (this.nextRepeatStartAt != null) {
            properties.put("nextRepeatStartAt", this.nextRepeatStartAt);
        }

        return properties;
    }
}
