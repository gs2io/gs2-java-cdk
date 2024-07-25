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
package io.gs2.cdk.loginReward.model.options;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.loginReward.model.Reward;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.loginReward.model.enums.BonusModelMode;
import io.gs2.cdk.loginReward.model.enums.BonusModelRepeat;
import io.gs2.cdk.loginReward.model.enums.BonusModelMissedReceiveRelief;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BonusModelModeIsStreamingOptions {
    public String metadata;
    public String periodEventId;
    public List<Reward> rewards;
    public List<VerifyAction> missedReceiveReliefVerifyActions;
    public List<ConsumeAction> missedReceiveReliefConsumeActions;
    
    public BonusModelModeIsStreamingOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public BonusModelModeIsStreamingOptions withPeriodEventId(
        String periodEventId
    ) {
        this.periodEventId = periodEventId;
        return this;
    }
    
    public BonusModelModeIsStreamingOptions withRewards(
        List<Reward> rewards
    ) {
        this.rewards = rewards;
        return this;
    }
    
    public BonusModelModeIsStreamingOptions withMissedReceiveReliefVerifyActions(
        List<VerifyAction> missedReceiveReliefVerifyActions
    ) {
        this.missedReceiveReliefVerifyActions = missedReceiveReliefVerifyActions;
        return this;
    }
    
    public BonusModelModeIsStreamingOptions withMissedReceiveReliefConsumeActions(
        List<ConsumeAction> missedReceiveReliefConsumeActions
    ) {
        this.missedReceiveReliefConsumeActions = missedReceiveReliefConsumeActions;
        return this;
    }
}
