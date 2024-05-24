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
import io.gs2.cdk.inventory.stampSheet.AcquireBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.SetBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyBigItemByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigItemModelRef {
    private String namespaceName;
    private String inventoryName;
    private String itemName;

    public BigItemModelRef(
        String namespaceName,
        String inventoryName,
        String itemName
    ) {
        this.namespaceName = namespaceName;
        this.inventoryName = inventoryName;
        this.itemName = itemName;
    }

    public AcquireBigItemByUserId acquireBigItem(
        String acquireCount,
        String userId
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            acquireCount,
            userId
        ));
    }


    public AcquireBigItemByUserId acquireBigItem(
        String acquireCount
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            acquireCount,
            "#{userId}"
        ));
    }

    public SetBigItemByUserId setBigItem(
        String count,
        String userId
    ) {
        return (new SetBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            count,
            userId
        ));
    }


    public SetBigItemByUserId setBigItem(
        String count
    ) {
        return (new SetBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            count,
            "#{userId}"
        ));
    }

    public ConsumeBigItemByUserId consumeBigItem(
        String consumeCount,
        String userId
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            consumeCount,
            userId
        ));
    }


    public ConsumeBigItemByUserId consumeBigItem(
        String consumeCount
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            consumeCount,
            "#{userId}"
        ));
    }

    public VerifyBigItemByUserId verifyBigItem(
        String verifyType,
        String count,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            verifyType,
            count,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyBigItemByUserId verifyBigItem(
        String verifyType,
        String count,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyBigItemByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            verifyType,
            count,
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
                "inventory",
                this.namespaceName,
                "big",
                "model",
                this.inventoryName,
                "item",
                this.itemName
            )
        )).str(
        );
    }
}
