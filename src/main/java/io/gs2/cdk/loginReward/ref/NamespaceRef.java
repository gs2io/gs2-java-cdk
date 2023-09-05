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
package io.gs2.cdk.loginReward.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.loginReward.ref.BonusModelRef;
import io.gs2.cdk.loginReward.stampSheet.DeleteReceiveStatusByUserId;
import io.gs2.cdk.loginReward.stampSheet.UnmarkReceivedByUserId;
import io.gs2.cdk.loginReward.stampSheet.MarkReceivedByUserId;
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

    public BonusModelRef bonusModel(
        String bonusModelName
    ) {
        return (new BonusModelRef(
            this.namespaceName,
            bonusModelName
        ));
    }

    public DeleteReceiveStatusByUserId deleteReceiveStatus(
        String bonusModelName,
        String userId
    ) {
        return (new DeleteReceiveStatusByUserId(
            this.namespaceName,
            bonusModelName,
            userId
        ));
    }


    public DeleteReceiveStatusByUserId deleteReceiveStatus(
        String bonusModelName
    ) {
        return (new DeleteReceiveStatusByUserId(
            this.namespaceName,
            bonusModelName,
            "#{userId}"
        ));
    }

    public UnmarkReceivedByUserId unmarkReceived(
        String bonusModelName,
        Integer stepNumber,
        String userId
    ) {
        return (new UnmarkReceivedByUserId(
            this.namespaceName,
            bonusModelName,
            stepNumber,
            userId
        ));
    }


    public UnmarkReceivedByUserId unmarkReceived(
        String bonusModelName,
        Integer stepNumber
    ) {
        return (new UnmarkReceivedByUserId(
            this.namespaceName,
            bonusModelName,
            stepNumber,
            "#{userId}"
        ));
    }

    public MarkReceivedByUserId markReceived(
        String bonusModelName,
        Integer stepNumber,
        String userId
    ) {
        return (new MarkReceivedByUserId(
            this.namespaceName,
            bonusModelName,
            stepNumber,
            userId
        ));
    }


    public MarkReceivedByUserId markReceived(
        String bonusModelName,
        Integer stepNumber
    ) {
        return (new MarkReceivedByUserId(
            this.namespaceName,
            bonusModelName,
            stepNumber,
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
                "loginReward",
                this.namespaceName
            )
        )).str(
        );
    }
}
