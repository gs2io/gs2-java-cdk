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
import io.gs2.cdk.ranking2.model.RankingReward;
import io.gs2.cdk.ranking2.model.options.ClusterRankingModelOptions;
import io.gs2.cdk.ranking2.model.enums.ClusterRankingModelClusterType;
import io.gs2.cdk.ranking2.model.enums.ClusterRankingModelOrderDirection;
import io.gs2.cdk.ranking2.model.enums.ClusterRankingModelRewardCalculationIndex;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ClusterRankingModel {
    private String name;
    private ClusterRankingModelClusterType clusterType;
    private Boolean sum;
    private ClusterRankingModelOrderDirection orderDirection;
    private ClusterRankingModelRewardCalculationIndex rewardCalculationIndex;
    private String metadata = null;
    private Long minimumValue = null;
    private Long maximumValue = null;
    private String entryPeriodEventId = null;
    private List<RankingReward> rankingRewards = null;
    private String accessPeriodEventId = null;

    public ClusterRankingModel(
        String name,
        ClusterRankingModelClusterType clusterType,
        Boolean sum,
        ClusterRankingModelOrderDirection orderDirection,
        ClusterRankingModelRewardCalculationIndex rewardCalculationIndex,
        ClusterRankingModelOptions options
    ) {
        this.name = name;
        this.clusterType = clusterType;
        this.sum = sum;
        this.orderDirection = orderDirection;
        this.rewardCalculationIndex = rewardCalculationIndex;
        this.metadata = options.metadata;
        this.minimumValue = options.minimumValue;
        this.maximumValue = options.maximumValue;
        this.entryPeriodEventId = options.entryPeriodEventId;
        this.rankingRewards = options.rankingRewards;
        this.accessPeriodEventId = options.accessPeriodEventId;
    }
    public ClusterRankingModel(
        String name,
        ClusterRankingModelClusterType clusterType,
        Boolean sum,
        ClusterRankingModelOrderDirection orderDirection,
        ClusterRankingModelRewardCalculationIndex rewardCalculationIndex
    ) {
        this.name = name;
        this.clusterType = clusterType;
        this.sum = sum;
        this.orderDirection = orderDirection;
        this.rewardCalculationIndex = rewardCalculationIndex;
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
        if (this.clusterType != null) {
            properties.put("clusterType", this.clusterType.toString(
            ));
        }
        if (this.minimumValue != null) {
            properties.put("minimumValue", this.minimumValue);
        }
        if (this.maximumValue != null) {
            properties.put("maximumValue", this.maximumValue);
        }
        if (this.sum != null) {
            properties.put("sum", this.sum);
        }
        if (this.orderDirection != null) {
            properties.put("orderDirection", this.orderDirection.toString(
            ));
        }
        if (this.entryPeriodEventId != null) {
            properties.put("entryPeriodEventId", this.entryPeriodEventId);
        }
        if (this.rankingRewards != null) {
            properties.put("rankingRewards", this.rankingRewards.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.accessPeriodEventId != null) {
            properties.put("accessPeriodEventId", this.accessPeriodEventId);
        }
        if (this.rewardCalculationIndex != null) {
            properties.put("rewardCalculationIndex", this.rewardCalculationIndex.toString(
            ));
        }

        return properties;
    }
}
