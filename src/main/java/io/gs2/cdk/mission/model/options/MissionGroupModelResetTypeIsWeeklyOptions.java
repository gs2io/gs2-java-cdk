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
import io.gs2.cdk.mission.model.TargetCounterModel;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.MissionTaskModel;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetType;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetDayOfWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionGroupModelResetTypeIsWeeklyOptions {
    public String metadata;
    public List<MissionTaskModel> tasks;
    public String completeNotificationNamespaceId;
    
    public MissionGroupModelResetTypeIsWeeklyOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public MissionGroupModelResetTypeIsWeeklyOptions withTasks(
        List<MissionTaskModel> tasks
    ) {
        this.tasks = tasks;
        return this;
    }
    
    public MissionGroupModelResetTypeIsWeeklyOptions withCompleteNotificationNamespaceId(
        String completeNotificationNamespaceId
    ) {
        this.completeNotificationNamespaceId = completeNotificationNamespaceId;
        return this;
    }
}
