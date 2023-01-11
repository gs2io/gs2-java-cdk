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
import io.gs2.cdk.inventory.ref.ItemModelRef;
import io.gs2.cdk.inventory.stampSheet.AddCapacityByUserId;
import io.gs2.cdk.inventory.stampSheet.SetCapacityByUserId;
import io.gs2.cdk.inventory.stampSheet.AcquireItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.AddReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.DeleteReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyReferenceOfByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryModelRef {
    private String namespaceName;
    private String inventoryName;

    public InventoryModelRef(
        String namespaceName,
        String inventoryName
    ) {
        this.namespaceName = namespaceName;
        this.inventoryName = inventoryName;
    }

    public ItemModelRef itemModel(
        String itemName
    ) {
        return (new ItemModelRef(
            this.namespaceName,
            this.inventoryName,
            itemName
        ));
    }

    public AddCapacityByUserId addCapacity(
        Integer addCapacityValue,
        String userId
    ) {
        return (new AddCapacityByUserId(
            this.namespaceName,
            this.inventoryName,
            addCapacityValue,
            userId
        ));
    }


    public AddCapacityByUserId addCapacity(
        Integer addCapacityValue
    ) {
        return (new AddCapacityByUserId(
            this.namespaceName,
            this.inventoryName,
            addCapacityValue,
            "#{userId}"
        ));
    }

    public SetCapacityByUserId setCapacity(
        Integer newCapacityValue,
        String userId
    ) {
        return (new SetCapacityByUserId(
            this.namespaceName,
            this.inventoryName,
            newCapacityValue,
            userId
        ));
    }


    public SetCapacityByUserId setCapacity(
        Integer newCapacityValue
    ) {
        return (new SetCapacityByUserId(
            this.namespaceName,
            this.inventoryName,
            newCapacityValue,
            "#{userId}"
        ));
    }

    public AcquireItemSetByUserId acquireItemSet(
        String itemName,
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName,
        String userId
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            userId
        ));
    }


    public AcquireItemSetByUserId acquireItemSet(
        String itemName,
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            "#{userId}"
        ));
    }

    public AddReferenceOfByUserId addReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public AddReferenceOfByUserId addReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public DeleteReferenceOfByUserId deleteReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public DeleteReferenceOfByUserId deleteReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public ConsumeItemSetByUserId consumeItemSet(
        String itemName,
        Long consumeCount,
        String itemSetName,
        String userId
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            consumeCount,
            itemSetName,
            userId
        ));
    }


    public ConsumeItemSetByUserId consumeItemSet(
        String itemName,
        Long consumeCount,
        String itemSetName
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            consumeCount,
            itemSetName,
            "#{userId}"
        ));
    }

    public VerifyReferenceOfByUserId verifyReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf,
        String verifyType,
        String userId
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            verifyType,
            userId
        ));
    }


    public VerifyReferenceOfByUserId verifyReferenceOf(
        String itemName,
        String itemSetName,
        String referenceOf,
        String verifyType
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            verifyType,
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
                "model",
                this.inventoryName
            )
        )).str(
        );
    }
}
