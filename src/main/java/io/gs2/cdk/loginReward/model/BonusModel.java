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
package io.gs2.cdk.loginReward.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.loginReward.model.Reward;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.loginReward.model.options.BonusModelOptions;
import io.gs2.cdk.loginReward.model.options.BonusModelModeIsScheduleOptions;
import io.gs2.cdk.loginReward.model.options.BonusModelModeIsStreamingOptions;
import io.gs2.cdk.loginReward.model.options.BonusModelMissedReceiveReliefIsEnabledOptions;
import io.gs2.cdk.loginReward.model.options.BonusModelMissedReceiveReliefIsDisabledOptions;
import io.gs2.cdk.loginReward.model.enums.BonusModelMode;
import io.gs2.cdk.loginReward.model.enums.BonusModelRepeat;
import io.gs2.cdk.loginReward.model.enums.BonusModelMissedReceiveRelief;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BonusModel {
    private String name;
    private BonusModelMode mode;
    private BonusModelMissedReceiveRelief missedReceiveRelief;
    private String metadata = null;
    private String periodEventId = null;
    private Integer resetHour = null;
    private BonusModelRepeat repeat = null;
    private List<Reward> rewards = null;
    private List<ConsumeAction> missedReceiveReliefConsumeActions = null;

    public BonusModel(
        String name,
        BonusModelMode mode,
        BonusModelMissedReceiveRelief missedReceiveRelief,
        BonusModelOptions options
    ) {
        this.name = name;
        this.mode = mode;
        this.missedReceiveRelief = missedReceiveRelief;
        this.metadata = options.metadata;
        this.periodEventId = options.periodEventId;
        this.resetHour = options.resetHour;
        this.repeat = options.repeat;
        this.rewards = options.rewards;
        this.missedReceiveReliefConsumeActions = options.missedReceiveReliefConsumeActions;
    }
    public BonusModel(
        String name,
        BonusModelMode mode,
        BonusModelMissedReceiveRelief missedReceiveRelief
    ) {
        this.name = name;
        this.mode = mode;
        this.missedReceiveRelief = missedReceiveRelief;
    }

    public static BonusModel modeIsSchedule(
        String name,
        BonusModelMissedReceiveRelief missedReceiveRelief,
        BonusModelModeIsScheduleOptions options
    ) {
        return (new BonusModel(
            name,
            BonusModelMode.SCHEDULE,
            missedReceiveRelief,
            new BonusModelOptions()
                .withMetadata(options.metadata)
                .withPeriodEventId(options.periodEventId)
                .withRewards(options.rewards)
                .withMissedReceiveReliefConsumeActions(options.missedReceiveReliefConsumeActions)
        ));
    }


    public static BonusModel modeIsSchedule(
        String name,
        BonusModelMissedReceiveRelief missedReceiveRelief
    ) {
        return (new BonusModel(
            name,
            BonusModelMode.SCHEDULE,
            missedReceiveRelief
        ));
    }

    public static BonusModel modeIsStreaming(
        String name,
        BonusModelMissedReceiveRelief missedReceiveRelief,
        BonusModelRepeat repeat,
        BonusModelModeIsStreamingOptions options
    ) {
        return (new BonusModel(
            name,
            BonusModelMode.STREAMING,
            missedReceiveRelief,
            new BonusModelOptions()
                .withRepeat(repeat)
                .withMetadata(options.metadata)
                .withPeriodEventId(options.periodEventId)
                .withRewards(options.rewards)
                .withMissedReceiveReliefConsumeActions(options.missedReceiveReliefConsumeActions)
        ));
    }


    public static BonusModel modeIsStreaming(
        String name,
        BonusModelMissedReceiveRelief missedReceiveRelief,
        BonusModelRepeat repeat
    ) {
        return (new BonusModel(
            name,
            BonusModelMode.STREAMING,
            missedReceiveRelief
        ));
    }

    public static BonusModel missedReceiveReliefIsEnabled(
        String name,
        BonusModelMode mode,
        BonusModelMissedReceiveReliefIsEnabledOptions options
    ) {
        return (new BonusModel(
            name,
            mode,
            BonusModelMissedReceiveRelief.ENABLED,
            new BonusModelOptions()
                .withMetadata(options.metadata)
                .withPeriodEventId(options.periodEventId)
                .withRewards(options.rewards)
                .withMissedReceiveReliefConsumeActions(options.missedReceiveReliefConsumeActions)
        ));
    }


    public static BonusModel missedReceiveReliefIsEnabled(
        String name,
        BonusModelMode mode
    ) {
        return (new BonusModel(
            name,
            mode,
            BonusModelMissedReceiveRelief.ENABLED
        ));
    }

    public static BonusModel missedReceiveReliefIsDisabled(
        String name,
        BonusModelMode mode,
        BonusModelMissedReceiveReliefIsDisabledOptions options
    ) {
        return (new BonusModel(
            name,
            mode,
            BonusModelMissedReceiveRelief.DISABLED,
            new BonusModelOptions()
                .withMetadata(options.metadata)
                .withPeriodEventId(options.periodEventId)
                .withRewards(options.rewards)
                .withMissedReceiveReliefConsumeActions(options.missedReceiveReliefConsumeActions)
        ));
    }


    public static BonusModel missedReceiveReliefIsDisabled(
        String name,
        BonusModelMode mode
    ) {
        return (new BonusModel(
            name,
            mode,
            BonusModelMissedReceiveRelief.DISABLED
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
        if (this.mode != null) {
            properties.put("mode", this.mode.toString(
            ));
        }
        if (this.periodEventId != null) {
            properties.put("periodEventId", this.periodEventId);
        }
        if (this.resetHour != null) {
            properties.put("resetHour", this.resetHour);
        }
        if (this.repeat != null) {
            properties.put("repeat", this.repeat.toString(
            ));
        }
        if (this.rewards != null) {
            properties.put("rewards", this.rewards.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.missedReceiveRelief != null) {
            properties.put("missedReceiveRelief", this.missedReceiveRelief.toString(
            ));
        }
        if (this.missedReceiveReliefConsumeActions != null) {
            properties.put("missedReceiveReliefConsumeActions", this.missedReceiveReliefConsumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
