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
package io.gs2.cdk.ranking2.model.options;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.ranking2.model.RankingReward;
import io.gs2.cdk.ranking2.model.enums.GlobalRankingModelOrderDirection;
import io.gs2.cdk.ranking2.model.enums.GlobalRankingModelRewardCalculationIndex;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalRankingModelOptions {
    public String metadata;
    public Long minimumValue;
    public Long maximumValue;
    public String entryPeriodEventId;
    public List<RankingReward> rankingRewards;
    public String accessPeriodEventId;
    
    public GlobalRankingModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public GlobalRankingModelOptions withMinimumValue(
        Long minimumValue
    ) {
        this.minimumValue = minimumValue;
        return this;
    }
    
    public GlobalRankingModelOptions withMaximumValue(
        Long maximumValue
    ) {
        this.maximumValue = maximumValue;
        return this;
    }
    
    public GlobalRankingModelOptions withEntryPeriodEventId(
        String entryPeriodEventId
    ) {
        this.entryPeriodEventId = entryPeriodEventId;
        return this;
    }
    
    public GlobalRankingModelOptions withRankingRewards(
        List<RankingReward> rankingRewards
    ) {
        this.rankingRewards = rankingRewards;
        return this;
    }
    
    public GlobalRankingModelOptions withAccessPeriodEventId(
        String accessPeriodEventId
    ) {
        this.accessPeriodEventId = accessPeriodEventId;
        return this;
    }
}

