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
package io.gs2.cdk.inventory.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.inventory.ref.BigItemModelRef;
import io.gs2.cdk.inventory.stampSheet.AcquireBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeBigItemByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigInventoryModelRef {
    private String namespaceName;
    private String inventoryName;

    public BigInventoryModelRef(
        String namespaceName,
        String inventoryName
    ) {
        this.namespaceName = namespaceName;
        this.inventoryName = inventoryName;
    }

    public BigItemModelRef bigItemModel(
        String itemName
    ) {
        return (new BigItemModelRef(
            this.namespaceName,
            this.inventoryName,
            itemName
        ));
    }

    public AcquireBigItemByUserId acquireBigItem(
        String itemName,
        String acquireCount,
        String userId
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            acquireCount,
            userId
        ));
    }


    public AcquireBigItemByUserId acquireBigItem(
        String itemName,
        String acquireCount
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            acquireCount,
            "#{userId}"
        ));
    }

    public ConsumeBigItemByUserId consumeBigItem(
        String itemName,
        String consumeCount,
        String userId
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            consumeCount,
            userId
        ));
    }


    public ConsumeBigItemByUserId consumeBigItem(
        String itemName,
        String consumeCount
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            consumeCount,
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
                "big",
                "model",
                this.inventoryName
            )
        )).str(
        );
    }
}
