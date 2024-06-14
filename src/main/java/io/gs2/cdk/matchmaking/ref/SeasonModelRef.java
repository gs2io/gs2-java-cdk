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
package io.gs2.cdk.matchmaking.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.matchmaking.stampSheet.VerifyIncludeParticipantByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonModelRef {
    private String namespaceName;
    private String seasonName;

    public SeasonModelRef(
        String namespaceName,
        String seasonName
    ) {
        this.namespaceName = namespaceName;
        this.seasonName = seasonName;
    }

    public VerifyIncludeParticipantByUserId verifyIncludeParticipant(
        Long season,
        Long tier,
        String verifyType,
        String seasonGatheringName,
        String userId
    ) {
        return (new VerifyIncludeParticipantByUserId(
            this.namespaceName,
            this.seasonName,
            season,
            tier,
            verifyType,
            seasonGatheringName,
            userId
        ));
    }


    public VerifyIncludeParticipantByUserId verifyIncludeParticipant(
        Long season,
        Long tier,
        String verifyType,
        String seasonGatheringName
    ) {
        return (new VerifyIncludeParticipantByUserId(
            this.namespaceName,
            this.seasonName,
            season,
            tier,
            verifyType,
            seasonGatheringName,
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
                "matchmaking",
                this.namespaceName,
                "model",
                this.seasonName
            )
        )).str(
        );
    }
}
