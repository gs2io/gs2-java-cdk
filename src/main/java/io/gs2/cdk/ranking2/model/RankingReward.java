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
package io.gs2.cdk.ranking2.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.ranking2.model.options.RankingRewardOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RankingReward {
    private Integer thresholdRank;
    private String metadata = null;
    private List<AcquireAction> acquireActions = null;

    public RankingReward(
        Integer thresholdRank,
        RankingRewardOptions options
    ) {
        this.thresholdRank = thresholdRank;
        this.metadata = options.metadata;
        this.acquireActions = options.acquireActions;
    }
    public RankingReward(
        Integer thresholdRank
    ) {
        this.thresholdRank = thresholdRank;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.thresholdRank != null) {
            properties.put("thresholdRank", this.thresholdRank);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
