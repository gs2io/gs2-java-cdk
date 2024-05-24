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
import io.gs2.cdk.inventory.ref.InventoryModelRef;
import io.gs2.cdk.inventory.ref.SimpleInventoryModelRef;
import io.gs2.cdk.inventory.ref.BigInventoryModelRef;
import io.gs2.cdk.inventory.stampSheet.AddCapacityByUserId;
import io.gs2.cdk.inventory.stampSheet.SetCapacityByUserId;
import io.gs2.cdk.inventory.stampSheet.AcquireItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.AcquireItemSetWithGradeByUserId;
import io.gs2.cdk.inventory.stampSheet.AddReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.DeleteReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.AcquireSimpleItemsByUserId;
import io.gs2.cdk.inventory.model.AcquireCount;
import io.gs2.cdk.inventory.stampSheet.SetSimpleItemsByUserId;
import io.gs2.cdk.inventory.model.HeldCount;
import io.gs2.cdk.inventory.stampSheet.AcquireBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.SetBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyInventoryCurrentMaxCapacityByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyItemSetByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyReferenceOfByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeSimpleItemsByUserId;
import io.gs2.cdk.inventory.model.ConsumeCount;
import io.gs2.cdk.inventory.stampSheet.VerifySimpleItemByUserId;
import io.gs2.cdk.inventory.stampSheet.ConsumeBigItemByUserId;
import io.gs2.cdk.inventory.stampSheet.VerifyBigItemByUserId;
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

    public InventoryModelRef inventoryModel(
        String inventoryName
    ) {
        return (new InventoryModelRef(
            this.namespaceName,
            inventoryName
        ));
    }

    public SimpleInventoryModelRef simpleInventoryModel(
        String inventoryName
    ) {
        return (new SimpleInventoryModelRef(
            this.namespaceName,
            inventoryName
        ));
    }

    public BigInventoryModelRef bigInventoryModel(
        String inventoryName
    ) {
        return (new BigInventoryModelRef(
            this.namespaceName,
            inventoryName
        ));
    }

    public AddCapacityByUserId addCapacity(
        String inventoryName,
        Integer addCapacityValue,
        String userId
    ) {
        return (new AddCapacityByUserId(
            this.namespaceName,
            inventoryName,
            addCapacityValue,
            userId
        ));
    }


    public AddCapacityByUserId addCapacity(
        String inventoryName,
        Integer addCapacityValue
    ) {
        return (new AddCapacityByUserId(
            this.namespaceName,
            inventoryName,
            addCapacityValue,
            "#{userId}"
        ));
    }

    public SetCapacityByUserId setCapacity(
        String inventoryName,
        Integer newCapacityValue,
        String userId
    ) {
        return (new SetCapacityByUserId(
            this.namespaceName,
            inventoryName,
            newCapacityValue,
            userId
        ));
    }


    public SetCapacityByUserId setCapacity(
        String inventoryName,
        Integer newCapacityValue
    ) {
        return (new SetCapacityByUserId(
            this.namespaceName,
            inventoryName,
            newCapacityValue,
            "#{userId}"
        ));
    }

    public AcquireItemSetByUserId acquireItemSet(
        String inventoryName,
        String itemName,
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName,
        String userId
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            userId
        ));
    }


    public AcquireItemSetByUserId acquireItemSet(
        String inventoryName,
        String itemName,
        Long acquireCount,
        Long expiresAt,
        Boolean createNewItemSet,
        String itemSetName
    ) {
        return (new AcquireItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName,
            "#{userId}"
        ));
    }

    public AcquireItemSetWithGradeByUserId acquireItemSetWithGrade(
        String inventoryName,
        String itemName,
        String gradeModelId,
        Long gradeValue,
        String userId
    ) {
        return (new AcquireItemSetWithGradeByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            gradeModelId,
            gradeValue,
            userId
        ));
    }


    public AcquireItemSetWithGradeByUserId acquireItemSetWithGrade(
        String inventoryName,
        String itemName,
        String gradeModelId,
        Long gradeValue
    ) {
        return (new AcquireItemSetWithGradeByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            gradeModelId,
            gradeValue,
            "#{userId}"
        ));
    }

    public AddReferenceOfByUserId addReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public AddReferenceOfByUserId addReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf
    ) {
        return (new AddReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public DeleteReferenceOfByUserId deleteReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf,
        String userId
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            userId
        ));
    }


    public DeleteReferenceOfByUserId deleteReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf
    ) {
        return (new DeleteReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            "#{userId}"
        ));
    }

    public AcquireSimpleItemsByUserId acquireSimpleItems(
        String inventoryName,
        List<AcquireCount> acquireCounts,
        String userId
    ) {
        return (new AcquireSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            acquireCounts,
            userId
        ));
    }


    public AcquireSimpleItemsByUserId acquireSimpleItems(
        String inventoryName,
        List<AcquireCount> acquireCounts
    ) {
        return (new AcquireSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            acquireCounts,
            "#{userId}"
        ));
    }

    public SetSimpleItemsByUserId setSimpleItems(
        String inventoryName,
        List<HeldCount> counts,
        String userId
    ) {
        return (new SetSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            counts,
            userId
        ));
    }


    public SetSimpleItemsByUserId setSimpleItems(
        String inventoryName,
        List<HeldCount> counts
    ) {
        return (new SetSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            counts,
            "#{userId}"
        ));
    }

    public AcquireBigItemByUserId acquireBigItem(
        String inventoryName,
        String itemName,
        String acquireCount,
        String userId
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            acquireCount,
            userId
        ));
    }


    public AcquireBigItemByUserId acquireBigItem(
        String inventoryName,
        String itemName,
        String acquireCount
    ) {
        return (new AcquireBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            acquireCount,
            "#{userId}"
        ));
    }

    public SetBigItemByUserId setBigItem(
        String inventoryName,
        String itemName,
        String count,
        String userId
    ) {
        return (new SetBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            count,
            userId
        ));
    }


    public SetBigItemByUserId setBigItem(
        String inventoryName,
        String itemName,
        String count
    ) {
        return (new SetBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            count,
            "#{userId}"
        ));
    }

    public VerifyInventoryCurrentMaxCapacityByUserId verifyInventoryCurrentMaxCapacity(
        String inventoryName,
        String verifyType,
        Integer currentInventoryMaxCapacity,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyInventoryCurrentMaxCapacityByUserId(
            this.namespaceName,
            inventoryName,
            verifyType,
            currentInventoryMaxCapacity,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyInventoryCurrentMaxCapacityByUserId verifyInventoryCurrentMaxCapacity(
        String inventoryName,
        String verifyType,
        Integer currentInventoryMaxCapacity,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyInventoryCurrentMaxCapacityByUserId(
            this.namespaceName,
            inventoryName,
            verifyType,
            currentInventoryMaxCapacity,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public ConsumeItemSetByUserId consumeItemSet(
        String inventoryName,
        String itemName,
        Long consumeCount,
        String itemSetName,
        String userId
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            consumeCount,
            itemSetName,
            userId
        ));
    }


    public ConsumeItemSetByUserId consumeItemSet(
        String inventoryName,
        String itemName,
        Long consumeCount,
        String itemSetName
    ) {
        return (new ConsumeItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            consumeCount,
            itemSetName,
            "#{userId}"
        ));
    }

    public VerifyItemSetByUserId verifyItemSet(
        String inventoryName,
        String itemName,
        String verifyType,
        Long count,
        String itemSetName,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            verifyType,
            count,
            itemSetName,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyItemSetByUserId verifyItemSet(
        String inventoryName,
        String itemName,
        String verifyType,
        Long count,
        String itemSetName,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyItemSetByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            verifyType,
            count,
            itemSetName,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public VerifyReferenceOfByUserId verifyReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf,
        String verifyType,
        String userId
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            verifyType,
            userId
        ));
    }


    public VerifyReferenceOfByUserId verifyReferenceOf(
        String inventoryName,
        String itemName,
        String itemSetName,
        String referenceOf,
        String verifyType
    ) {
        return (new VerifyReferenceOfByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            itemSetName,
            referenceOf,
            verifyType,
            "#{userId}"
        ));
    }

    public ConsumeSimpleItemsByUserId consumeSimpleItems(
        String inventoryName,
        List<ConsumeCount> consumeCounts,
        String userId
    ) {
        return (new ConsumeSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            consumeCounts,
            userId
        ));
    }


    public ConsumeSimpleItemsByUserId consumeSimpleItems(
        String inventoryName,
        List<ConsumeCount> consumeCounts
    ) {
        return (new ConsumeSimpleItemsByUserId(
            this.namespaceName,
            inventoryName,
            consumeCounts,
            "#{userId}"
        ));
    }

    public VerifySimpleItemByUserId verifySimpleItem(
        String inventoryName,
        String itemName,
        String verifyType,
        Long count,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifySimpleItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            verifyType,
            count,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifySimpleItemByUserId verifySimpleItem(
        String inventoryName,
        String itemName,
        String verifyType,
        Long count,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifySimpleItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            verifyType,
            count,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public ConsumeBigItemByUserId consumeBigItem(
        String inventoryName,
        String itemName,
        String consumeCount,
        String userId
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            consumeCount,
            userId
        ));
    }


    public ConsumeBigItemByUserId consumeBigItem(
        String inventoryName,
        String itemName,
        String consumeCount
    ) {
        return (new ConsumeBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            consumeCount,
            "#{userId}"
        ));
    }

    public VerifyBigItemByUserId verifyBigItem(
        String inventoryName,
        String itemName,
        String verifyType,
        String count,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
            verifyType,
            count,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyBigItemByUserId verifyBigItem(
        String inventoryName,
        String itemName,
        String verifyType,
        String count,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyBigItemByUserId(
            this.namespaceName,
            inventoryName,
            itemName,
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
                this.namespaceName
            )
        )).str(
        );
    }
}
