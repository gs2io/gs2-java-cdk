/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.inventory.model.*;
import io.gs2.cdk.inventory.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class ItemModelRef {
    public String namespaceName;
    public String inventoryName;
    public String itemName;

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
            String itemSetName
    ) {
        return new AcquireItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            this.itemName,
            "#{userId}",
            acquireCount,
            expiresAt,
            createNewItemSet,
            itemSetName
        );
    }

    public AddReferenceOfByUserId addReferenceOf(
            String itemSetName,
            String referenceOf
    ) {
        return new AddReferenceOfByUserId(
            this.namespaceName,
            this.inventoryName,
            "#{userId}",
            this.itemName,
            itemSetName,
            referenceOf
        );
    }

    public ConsumeItemSetByUserId consumeItemSet(
            Long consumeCount,
            String itemSetName
    ) {
        return new ConsumeItemSetByUserId(
            this.namespaceName,
            this.inventoryName,
            "#{userId}",
            this.itemName,
            consumeCount,
            itemSetName
        );
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "inventory",
                this.namespaceName,
                "model",
                this.inventoryName,
                "item",
                this.itemName
            )
        ).str();
    }
}
