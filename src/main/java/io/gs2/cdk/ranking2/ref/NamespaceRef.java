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
package io.gs2.cdk.ranking2.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.ranking2.ref.GlobalRankingModelRef;
import io.gs2.cdk.ranking2.ref.SubscribeRankingModelRef;
import io.gs2.cdk.ranking2.ref.ClusterRankingModelRef;
import io.gs2.cdk.ranking2.stampSheet.CreateGlobalRankingReceivedRewardByUserId;
import io.gs2.cdk.ranking2.stampSheet.CreateClusterRankingReceivedRewardByUserId;
import io.gs2.cdk.ranking2.stampSheet.VerifyGlobalRankingScoreByUserId;
import io.gs2.cdk.ranking2.stampSheet.VerifyClusterRankingScoreByUserId;
import io.gs2.cdk.ranking2.stampSheet.VerifySubscribeRankingScoreByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceRef {
    private String namespaceName;

    public NamespaceRef(
        String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public GlobalRankingModelRef globalRankingModel(
        String rankingName
    ) {
        return (new GlobalRankingModelRef(
            this.namespaceName,
            rankingName
        ));
    }

    public SubscribeRankingModelRef subscribeRankingModel(
        String rankingName
    ) {
        return (new SubscribeRankingModelRef(
            this.namespaceName,
            rankingName
        ));
    }

    public ClusterRankingModelRef clusterRankingModel(
        String rankingName
    ) {
        return (new ClusterRankingModelRef(
            this.namespaceName,
            rankingName
        ));
    }

    public CreateGlobalRankingReceivedRewardByUserId createGlobalRankingReceivedReward(
        String rankingName,
        Long season,
        String userId
    ) {
        return (new CreateGlobalRankingReceivedRewardByUserId(
            this.namespaceName,
            rankingName,
            season,
            userId
        ));
    }


    public CreateGlobalRankingReceivedRewardByUserId createGlobalRankingReceivedReward(
        String rankingName,
        Long season
    ) {
        return (new CreateGlobalRankingReceivedRewardByUserId(
            this.namespaceName,
            rankingName,
            season,
            "#{userId}"
        ));
    }

    public CreateClusterRankingReceivedRewardByUserId createClusterRankingReceivedReward(
        String rankingName,
        String clusterName,
        Long season,
        String userId
    ) {
        return (new CreateClusterRankingReceivedRewardByUserId(
            this.namespaceName,
            rankingName,
            clusterName,
            season,
            userId
        ));
    }


    public CreateClusterRankingReceivedRewardByUserId createClusterRankingReceivedReward(
        String rankingName,
        String clusterName,
        Long season
    ) {
        return (new CreateClusterRankingReceivedRewardByUserId(
            this.namespaceName,
            rankingName,
            clusterName,
            season,
            "#{userId}"
        ));
    }

    public VerifyGlobalRankingScoreByUserId verifyGlobalRankingScore(
        String rankingName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyGlobalRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyGlobalRankingScoreByUserId verifyGlobalRankingScore(
        String rankingName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyGlobalRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public VerifyClusterRankingScoreByUserId verifyClusterRankingScore(
        String rankingName,
        String clusterName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyClusterRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            clusterName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyClusterRankingScoreByUserId verifyClusterRankingScore(
        String rankingName,
        String clusterName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyClusterRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            clusterName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public VerifySubscribeRankingScoreByUserId verifySubscribeRankingScore(
        String rankingName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifySubscribeRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifySubscribeRankingScoreByUserId verifySubscribeRankingScore(
        String rankingName,
        String verifyType,
        Long score,
        Long season,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifySubscribeRankingScoreByUserId(
            this.namespaceName,
            rankingName,
            verifyType,
            score,
            season,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "ranking2",
                this.namespaceName
            )
        )).str(
        );
    }
}
