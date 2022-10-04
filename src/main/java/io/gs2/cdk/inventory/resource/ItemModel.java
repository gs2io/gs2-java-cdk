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

package io.gs2.cdk.inventory.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.inventory.ref.*;
import io.gs2.cdk.inventory.model.*;

import java.util.*;
import java.util.stream.*;

public class ItemModel {
	public String name;
	public String metadata;
	public Long stackingLimit;
	public Boolean allowMultipleStacks;
	public Integer sortValue;

    public ItemModel(
            String name,
            Long stackingLimit,
            Boolean allowMultipleStacks,
            Integer sortValue
    ) {
        this.name = name;
        this.stackingLimit = stackingLimit;
        this.allowMultipleStacks = allowMultipleStacks;
        this.sortValue = sortValue;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.stackingLimit != null) {
            properties.put("StackingLimit", this.stackingLimit);
        }
        if (this.allowMultipleStacks != null) {
            properties.put("AllowMultipleStacks", this.allowMultipleStacks);
        }
        if (this.sortValue != null) {
            properties.put("SortValue", this.sortValue);
        }
        return properties;
    }

    public ItemModelRef ref(
            String namespaceName,
            String inventoryName
    ) {
        return new ItemModelRef(
            namespaceName,
            inventoryName,
            this.name
        );
    }
}
