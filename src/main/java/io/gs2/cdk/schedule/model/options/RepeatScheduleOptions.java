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

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatScheduleOptions {
    public Long currentRepeatStartAt;
    public Long currentRepeatEndAt;
    public Long lastRepeatEndAt;
    public Long nextRepeatStartAt;
    
    public RepeatScheduleOptions withCurrentRepeatStartAt(
        Long currentRepeatStartAt
    ) {
        this.currentRepeatStartAt = currentRepeatStartAt;
        return this;
    }
    
    public RepeatScheduleOptions withCurrentRepeatEndAt(
        Long currentRepeatEndAt
    ) {
        this.currentRepeatEndAt = currentRepeatEndAt;
        return this;
    }
    
    public RepeatScheduleOptions withLastRepeatEndAt(
        Long lastRepeatEndAt
    ) {
        this.lastRepeatEndAt = lastRepeatEndAt;
        return this;
    }
    
    public RepeatScheduleOptions withNextRepeatStartAt(
        Long nextRepeatStartAt
    ) {
        this.nextRepeatStartAt = nextRepeatStartAt;
        return this;
    }
}

