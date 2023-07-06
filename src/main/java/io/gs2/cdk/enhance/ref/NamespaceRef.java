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
package io.gs2.cdk.enhance.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.enhance.ref.RateModelRef;
import io.gs2.cdk.enhance.stampSheet.CreateProgressByUserId;
import io.gs2.cdk.enhance.model.Material;
import io.gs2.cdk.enhance.stampSheet.DeleteProgressByUserId;
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

    public RateModelRef rateModel(
        String rateName
    ) {
        return (new RateModelRef(
            this.namespaceName,
            rateName
        ));
    }

    public CreateProgressByUserId createProgress(
        String rateName,
        String targetItemSetId,
        List<Material> materials,
        Boolean force,
        String userId
    ) {
        return (new CreateProgressByUserId(
            this.namespaceName,
            rateName,
            targetItemSetId,
            materials,
            force,
            userId
        ));
    }


    public CreateProgressByUserId createProgress(
        String rateName,
        String targetItemSetId,
        Boolean force,
        List<Material> materials
    ) {
        return (new CreateProgressByUserId(
            this.namespaceName,
            rateName,
            targetItemSetId,
            materials,
            force,
            "#{userId}"
        ));
    }

    public DeleteProgressByUserId deleteProgress(
        String userId
    ) {
        return (new DeleteProgressByUserId(
            this.namespaceName,
            userId
        ));
    }


    public DeleteProgressByUserId deleteProgress(
    ) {
        return (new DeleteProgressByUserId(
            this.namespaceName,
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
                "enhance",
                this.namespaceName
            )
        )).str(
        );
    }
}
