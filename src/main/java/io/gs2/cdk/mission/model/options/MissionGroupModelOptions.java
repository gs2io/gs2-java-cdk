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
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.MissionTaskModel;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetType;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetDayOfWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionGroupModelOptions {
    public String metadata;
    public List<MissionTaskModel> tasks;
    public Integer resetDayOfMonth;
    public MissionGroupModelResetDayOfWeek resetDayOfWeek;
    public Integer resetHour;
    public String completeNotificationNamespaceId;
    
    public MissionGroupModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public MissionGroupModelOptions withTasks(
        List<MissionTaskModel> tasks
    ) {
        this.tasks = tasks;
        return this;
    }
    
    public MissionGroupModelOptions withResetDayOfMonth(
        Integer resetDayOfMonth
    ) {
        this.resetDayOfMonth = resetDayOfMonth;
        return this;
    }
    
    public MissionGroupModelOptions withResetDayOfWeek(
        MissionGroupModelResetDayOfWeek resetDayOfWeek
    ) {
        this.resetDayOfWeek = resetDayOfWeek;
        return this;
    }
    
    public MissionGroupModelOptions withResetHour(
        Integer resetHour
    ) {
        this.resetHour = resetHour;
        return this;
    }
    
    public MissionGroupModelOptions withCompleteNotificationNamespaceId(
        String completeNotificationNamespaceId
    ) {
        this.completeNotificationNamespaceId = completeNotificationNamespaceId;
        return this;
    }
}

