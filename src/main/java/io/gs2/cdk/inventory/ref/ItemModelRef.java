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
import io.gs2.cdk.inventory.stampSheet.AcquireItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.AddReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.DeleteReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyReferenceOfByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemModelRef {
    private String namespaceName;
    private String inventoryName;
    private String itemName;

    public ItemModelRef(
        String namespaceName,
        String inventoryName,
        String itemName
    ) {
        this.namespaceName = namespaceName;
        this.inventoryName = inventoryName;
        this.itemName = itemName;
    }

    public AcquireItemSetByUserId acquireItemSet(
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName,
        String userId
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            userId
        ));
    }


    public AcquireItemSetByUserId acquireItemSet(
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            "#{userId}"
        ));
    }

    public AddReferenceOfByUserId addReferenceOf(
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public AddReferenceOfByUserId addReferenceOf(
        String itemSetName,
        String referenceOf
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public DeleteReferenceOfByUserId deleteReferenceOf(
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public DeleteReferenceOfByUserId deleteReferenceOf(
        String itemSetName,
        String referenceOf
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public ConsumeItemSetByUserId consumeItemSet(
        Long consumeCount,
        String itemSetName,
        String userId
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            consumeCount,
            itemSetName,
            userId
        ));
    }


    public ConsumeItemSetByUserId consumeItemSet(
        Long consumeCount,
        String itemSetName
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            consumeCount,
            itemSetName,
            "#{userId}"
        ));
    }

    public VerifyReferenceOfByUserId verifyReferenceOf(
        String itemSetName,
        String referenceOf,
        String verifyType,
        String userId
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            itemSetName,
            referenceOf,
            verifyType,
            userId
        ));
    }


    public VerifyReferenceOfByUserId verifyReferenceOf(
        String itemSetName,
        String referenceOf,
        String verifyType
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
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
                this.inventoryName,
                "item",
                this.itemName
            )
        )).str(
        );
    }
}
