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
package io.gs2.cdk.showcase.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.showcase.stampSheet.DecrementPurchaseCountByUserId;
import io.gs2.cdk.showcase.stampSheet.ForceReDrawByUserId;
import io.gs2.cdk.showcase.stampSheet.IncrementPurchaseCountByUserId;
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

    public DecrementPurchaseCountByUserId decrementPurchaseCount(
        String showcaseName,
        String displayItemName,
        Integer count,
        String userId
    ) {
        return (new DecrementPurchaseCountByUserId(
            this.namespaceName,
            showcaseName,
            displayItemName,
            count,
            userId
        ));
    }


    public DecrementPurchaseCountByUserId decrementPurchaseCount(
        String showcaseName,
        String displayItemName,
        Integer count
    ) {
        return (new DecrementPurchaseCountByUserId(
            this.namespaceName,
            showcaseName,
            displayItemName,
            count,
            "#{userId}"
        ));
    }

    public ForceReDrawByUserId forceReDraw(
        String showcaseName,
        String userId
    ) {
        return (new ForceReDrawByUserId(
            this.namespaceName,
            showcaseName,
            userId
        ));
    }


    public ForceReDrawByUserId forceReDraw(
        String showcaseName
    ) {
        return (new ForceReDrawByUserId(
            this.namespaceName,
            showcaseName,
            "#{userId}"
        ));
    }

    public IncrementPurchaseCountByUserId incrementPurchaseCount(
        String showcaseName,
        String displayItemName,
        Integer count,
        String userId
    ) {
        return (new IncrementPurchaseCountByUserId(
            this.namespaceName,
            showcaseName,
            displayItemName,
            count,
            userId
        ));
    }


    public IncrementPurchaseCountByUserId incrementPurchaseCount(
        String showcaseName,
        String displayItemName,
        Integer count
    ) {
        return (new IncrementPurchaseCountByUserId(
            this.namespaceName,
            showcaseName,
            displayItemName,
            count,
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
                "showcase",
                this.namespaceName
            )
        )).str(
        );
    }
}
