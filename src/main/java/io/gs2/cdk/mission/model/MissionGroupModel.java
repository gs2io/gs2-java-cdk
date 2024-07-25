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
package io.gs2.cdk.mission.model;
import io.gs2.cdk.mission.model.TargetCounterModel;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.mission.model.MissionTaskModel;
import io.gs2.cdk.mission.model.options.MissionGroupModelOptions;
import io.gs2.cdk.mission.model.options.MissionGroupModelResetTypeIsNotResetOptions;
import io.gs2.cdk.mission.model.options.MissionGroupModelResetTypeIsDailyOptions;
import io.gs2.cdk.mission.model.options.MissionGroupModelResetTypeIsWeeklyOptions;
import io.gs2.cdk.mission.model.options.MissionGroupModelResetTypeIsMonthlyOptions;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetType;
import io.gs2.cdk.mission.model.enums.MissionGroupModelResetDayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MissionGroupModel {
    private String name;
    private MissionGroupModelResetType resetType;
    private String metadata = null;
    private List<MissionTaskModel> tasks = null;
    private Integer resetDayOfMonth = null;
    private MissionGroupModelResetDayOfWeek resetDayOfWeek = null;
    private Integer resetHour = null;
    private String completeNotificationNamespaceId = null;

    public MissionGroupModel(
        String name,
        MissionGroupModelResetType resetType,
        MissionGroupModelOptions options
    ) {
        this.name = name;
        this.resetType = resetType;
        this.metadata = options.metadata;
        this.tasks = options.tasks;
        this.resetDayOfMonth = options.resetDayOfMonth;
        this.resetDayOfWeek = options.resetDayOfWeek;
        this.resetHour = options.resetHour;
        this.completeNotificationNamespaceId = options.completeNotificationNamespaceId;
    }
    public MissionGroupModel(
        String name,
        MissionGroupModelResetType resetType
    ) {
        this.name = name;
        this.resetType = resetType;
    }

    public static MissionGroupModel resetTypeIsNotReset(
        String name,
        MissionGroupModelResetTypeIsNotResetOptions options
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.NOT_RESET,
            new MissionGroupModelOptions()
                .withMetadata(options.metadata)
                .withTasks(options.tasks)
                .withCompleteNotificationNamespaceId(options.completeNotificationNamespaceId)
        ));
    }


    public static MissionGroupModel resetTypeIsNotReset(
        String name
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.NOT_RESET
        ));
    }

    public static MissionGroupModel resetTypeIsDaily(
        String name,
        Integer resetHour,
        MissionGroupModelResetTypeIsDailyOptions options
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.DAILY,
            new MissionGroupModelOptions()
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
                .withTasks(options.tasks)
                .withCompleteNotificationNamespaceId(options.completeNotificationNamespaceId)
        ));
    }


    public static MissionGroupModel resetTypeIsDaily(
        String name,
        Integer resetHour
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.DAILY
        ));
    }

    public static MissionGroupModel resetTypeIsWeekly(
        String name,
        MissionGroupModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour,
        MissionGroupModelResetTypeIsWeeklyOptions options
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.WEEKLY,
            new MissionGroupModelOptions()
                .withResetDayOfWeek(resetDayOfWeek)
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
                .withTasks(options.tasks)
                .withCompleteNotificationNamespaceId(options.completeNotificationNamespaceId)
        ));
    }


    public static MissionGroupModel resetTypeIsWeekly(
        String name,
        MissionGroupModelResetDayOfWeek resetDayOfWeek,
        Integer resetHour
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.WEEKLY
        ));
    }

    public static MissionGroupModel resetTypeIsMonthly(
        String name,
        Integer resetDayOfMonth,
        Integer resetHour,
        MissionGroupModelResetTypeIsMonthlyOptions options
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.MONTHLY,
            new MissionGroupModelOptions()
                .withResetDayOfMonth(resetDayOfMonth)
                .withResetHour(resetHour)
                .withMetadata(options.metadata)
                .withTasks(options.tasks)
                .withCompleteNotificationNamespaceId(options.completeNotificationNamespaceId)
        ));
    }


    public static MissionGroupModel resetTypeIsMonthly(
        String name,
        Integer resetDayOfMonth,
        Integer resetHour
    ) {
        return (new MissionGroupModel(
            name,
            MissionGroupModelResetType.MONTHLY
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.tasks != null) {
            properties.put("tasks", this.tasks.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.resetType != null) {
            properties.put("resetType", this.resetType.toString(
            ));
        }
        if (this.resetDayOfMonth != null) {
            properties.put("resetDayOfMonth", this.resetDayOfMonth);
        }
        if (this.resetDayOfWeek != null) {
            properties.put("resetDayOfWeek", this.resetDayOfWeek.toString(
            ));
        }
        if (this.resetHour != null) {
            properties.put("resetHour", this.resetHour);
        }
        if (this.completeNotificationNamespaceId != null) {
            properties.put("completeNotificationNamespaceId", this.completeNotificationNamespaceId);
        }

        return properties;
    }
}
