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
package io.gs2.cdk.enchant.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.enchant.ref.BalanceParameterModelRef;
import io.gs2.cdk.enchant.ref.RarityParameterModelRef;
import io.gs2.cdk.enchant.stampSheet.ReDrawBalanceParameterStatusByUserId;
import io.gs2.cdk.enchant.stampSheet.ReDrawRarityParameterStatusByUserId;
import io.gs2.cdk.enchant.stampSheet.AddRarityParameterStatusByUserId;
import io.gs2.cdk.enchant.stampSheet.VerifyRarityParameterStatusByUserId;
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

    public BalanceParameterModelRef balanceParameterModel(
        String parameterName
    ) {
        return (new BalanceParameterModelRef(
            this.namespaceName,
            parameterName
        ));
    }

    public RarityParameterModelRef rarityParameterModel(
        String parameterName
    ) {
        return (new RarityParameterModelRef(
            this.namespaceName,
            parameterName
        ));
    }

    public ReDrawBalanceParameterStatusByUserId reDrawBalanceParameterStatus(
        String parameterName,
        String propertyId,
        List<String> fixedParameterNames,
        String userId
    ) {
        return (new ReDrawBalanceParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            fixedParameterNames,
            userId
        ));
    }


    public ReDrawBalanceParameterStatusByUserId reDrawBalanceParameterStatus(
        String parameterName,
        String propertyId,
        List<String> fixedParameterNames
    ) {
        return (new ReDrawBalanceParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            fixedParameterNames,
            "#{userId}"
        ));
    }

    public ReDrawRarityParameterStatusByUserId reDrawRarityParameterStatus(
        String parameterName,
        String propertyId,
        List<String> fixedParameterNames,
        String userId
    ) {
        return (new ReDrawRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            fixedParameterNames,
            userId
        ));
    }


    public ReDrawRarityParameterStatusByUserId reDrawRarityParameterStatus(
        String parameterName,
        String propertyId,
        List<String> fixedParameterNames
    ) {
        return (new ReDrawRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            fixedParameterNames,
            "#{userId}"
        ));
    }

    public AddRarityParameterStatusByUserId addRarityParameterStatus(
        String parameterName,
        String propertyId,
        Integer count,
        String userId
    ) {
        return (new AddRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            count,
            userId
        ));
    }


    public AddRarityParameterStatusByUserId addRarityParameterStatus(
        String parameterName,
        String propertyId,
        Integer count
    ) {
        return (new AddRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            count,
            "#{userId}"
        ));
    }

    public VerifyRarityParameterStatusByUserId verifyRarityParameterStatus(
        String parameterName,
        String propertyId,
        String verifyType,
        String parameterValueName,
        Integer parameterCount,
        String userId
    ) {
        return (new VerifyRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            verifyType,
            parameterValueName,
            parameterCount,
            userId
        ));
    }


    public VerifyRarityParameterStatusByUserId verifyRarityParameterStatus(
        String parameterName,
        String propertyId,
        String verifyType,
        String parameterValueName,
        Integer parameterCount
    ) {
        return (new VerifyRarityParameterStatusByUserId(
            this.namespaceName,
            parameterName,
            propertyId,
            verifyType,
            parameterValueName,
            parameterCount,
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
                "enchant",
                this.namespaceName
            )
        )).str(
        );
    }
}
