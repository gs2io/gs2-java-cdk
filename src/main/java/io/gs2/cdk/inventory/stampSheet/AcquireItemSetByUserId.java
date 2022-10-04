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

package io.gs2.cdk.inventory.stampSheet;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.inventory.ref.*;
import io.gs2.cdk.inventory.model.*;

import java.util.*;
import java.util.stream.*;


public class AcquireItemSetByUserId extends AcquireAction {

    public AcquireItemSetByUserId(
            String namespaceName,
            String inventoryName,
            String itemName,
            String userId,
            Long acquireCount,
            Long expiresAt,
            Boolean createNewItemSet,
            String itemSetName
    ) {
        super(
            "Gs2Inventory:AcquireItemSetByUserId",
            new HashMap<String, Object>() {
                {
                    if (namespaceName != null) {
                        put("namespaceName", namespaceName);
                    }
                    if (inventoryName != null) {
                        put("inventoryName", inventoryName);
                    }
                    if (itemName != null) {
                        put("itemName", itemName);
                    }
                    if (userId != null) {
                        put("userId", userId);
                    }
                    if (acquireCount != null) {
                        put("acquireCount", acquireCount);
                    }
                    if (expiresAt != null) {
                        put("expiresAt", expiresAt);
                    }
                    if (createNewItemSet != null) {
                        put("createNewItemSet", createNewItemSet);
                    }
                    if (itemSetName != null) {
                        put("itemSetName", itemSetName);
                    }
                }
            }
        );
    }
}
