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
package io.gs2.cdk.mission.model.options;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetType;
import io.gs2.cdk.mission.model.enums.CounterScopeModelResetDayOfWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CounterScopeModelOptions {
    public Integer resetDayOfMonth;
    public CounterScopeModelResetDayOfWeek resetDayOfWeek;
    public Integer resetHour;
    
    public CounterScopeModelOptions withResetDayOfMonth(
        Integer resetDayOfMonth
    ) {
        this.resetDayOfMonth = resetDayOfMonth;
        return this;
    }
    
    public CounterScopeModelOptions withResetDayOfWeek(
        CounterScopeModelResetDayOfWeek resetDayOfWeek
    ) {
        this.resetDayOfWeek = resetDayOfWeek;
        return this;
    }
    
    public CounterScopeModelOptions withResetHour(
        Integer resetHour
    ) {
        this.resetHour = resetHour;
        return this;
    }
}

