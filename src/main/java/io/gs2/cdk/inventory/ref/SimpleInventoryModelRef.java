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
package io.gs2.cdk.inventory.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.inventory.ref.SimpleItemModelRef;
import io.gs2.cdk.inventory.stampSheet.AcquireSimpleItemsByUserId;
import io.gs2.cdk.inventory.model.AcquireCount;
import io.gs2.cdk.inventory.model.ConsumeCount;
import io.gs2.cdk.inventory.stampSheet.ConsumeSimpleItemsByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleInventoryModelRef {
    private String namespaceName;
    private String inventoryName;

    public SimpleInventoryModelRef(
        String namespaceName,
        String inventoryName
    ) {
        this.namespaceName = namespaceName;
        this.inventoryName = inventoryName;
    }

    public SimpleItemModelRef simpleItemModel(
        String itemName
    ) {
        return (new SimpleItemModelRef(
            this.namespaceName,
            this.inventoryName,
            itemName
        ));
    }

    public AcquireSimpleItemsByUserId acquireSimpleItems(
        List<AcquireCount> acquireCounts,
        String userId
    ) {
        return (new AcquireSimpleItemsByUserId(
            this.namespaceName,
            this.inventoryName,
            acquireCounts,
            userId
        ));
    }


    public AcquireSimpleItemsByUserId acquireSimpleItems(
        List<AcquireCount> acquireCounts
    ) {
        return (new AcquireSimpleItemsByUserId(
            this.namespaceName,
            this.inventoryName,
            acquireCounts,
            "#{userId}"
        ));
    }

    public ConsumeSimpleItemsByUserId consumeSimpleItems(
        List<ConsumeCount> consumeCounts,
        String userId
    ) {
        return (new ConsumeSimpleItemsByUserId(
            this.namespaceName,
            this.inventoryName,
            consumeCounts,
            userId
        ));
    }


    public ConsumeSimpleItemsByUserId consumeSimpleItems(
        List<ConsumeCount> consumeCounts
    ) {
        return (new ConsumeSimpleItemsByUserId(
            this.namespaceName,
            this.inventoryName,
            consumeCounts,
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
                "inventory",
                this.namespaceName,
                "simple",
                "model",
                this.inventoryName
            )
        )).str(
        );
    }
}
