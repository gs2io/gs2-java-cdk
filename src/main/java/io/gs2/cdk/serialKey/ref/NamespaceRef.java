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
 *
 * deny overwrite
 */
package io.gs2.cdk.serialKey.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.serialKey.ref.CampaignModelRef;
import io.gs2.cdk.serialKey.stampSheet.RevertUseByUserId;
import io.gs2.cdk.serialKey.stampSheet.IssueOnce;
import io.gs2.cdk.serialKey.stampSheet.UseByUserId;
import io.gs2.cdk.serialKey.stampSheet.VerifyCodeByUserId;
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

    public CampaignModelRef campaignModel(
        String campaignModelName
    ) {
        return (new CampaignModelRef(
            this.namespaceName,
            campaignModelName
        ));
    }

    public RevertUseByUserId revertUse(
        String code,
        String userId
    ) {
        return (new RevertUseByUserId(
            this.namespaceName,
            code,
            userId
        ));
    }


    public RevertUseByUserId revertUse(
        String code
    ) {
        return (new RevertUseByUserId(
            this.namespaceName,
            code,
            "#{userId}"
        ));
    }

    public IssueOnce issueOnce(
        String campaignModelName,
        String metadata
    ) {
        return (new IssueOnce(
            this.namespaceName,
            campaignModelName,
            metadata
        ));
    }


    public UseByUserId use(
        String code,
        String userId
    ) {
        return (new UseByUserId(
            this.namespaceName,
            code,
            userId
        ));
    }


    public UseByUserId use(
        String code
    ) {
        return (new UseByUserId(
            this.namespaceName,
            code,
            "#{userId}"
        ));
    }

    public VerifyCodeByUserId verifyCode(
        String code,
        String verifyType,
        String campaignModelName,
        String userId
    ) {
        return (new VerifyCodeByUserId(
            this.namespaceName,
            code,
            verifyType,
            campaignModelName,
            userId
        ));
    }


    public VerifyCodeByUserId verifyCode(
        String code,
        String verifyType,
        String campaignModelName
    ) {
        return (new VerifyCodeByUserId(
            this.namespaceName,
            code,
            verifyType,
            campaignModelName,
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
                "serialKey",
                this.namespaceName
            )
        )).str(
        );
    }
}
