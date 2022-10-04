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

package io.gs2.cdk.showcase.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.showcase.ref.*;
import io.gs2.cdk.showcase.model.*;

import java.util.*;
import java.util.stream.*;

public class DisplayItem {

    public enum Type {
        SALES_ITEM,
        SALES_ITEM_GROUP;

        public String toString() {
            switch (this) {
                case SALES_ITEM:
                    return "salesItem";
                case SALES_ITEM_GROUP:
                    return "salesItemGroup";
            }
            return "unknown";
        }
    }
	public String displayItemId;
	public Type type;
	public SalesItem salesItem;
	public SalesItemGroup salesItemGroup;
	public String salesPeriodEventId;

    public DisplayItem(
            String displayItemId,
            Type type
    ) {
        this.displayItemId = displayItemId;
        this.type = type;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.displayItemId != null) {
            properties.put("DisplayItemId", this.displayItemId);
        }
        if (this.type != null) {
            properties.put("Type", this.type.toString());
        }
        if (this.salesItem != null) {
            properties.put("SalesItem", this.salesItem.properties());
        }
        if (this.salesItemGroup != null) {
            properties.put("SalesItemGroup", this.salesItemGroup.properties());
        }
        if (this.salesPeriodEventId != null) {
            properties.put("SalesPeriodEventId", this.salesPeriodEventId);
        }
        return properties;
    }

    public DisplayItemRef ref(
            String namespaceName
    ) {
        return new DisplayItemRef(
            namespaceName
        );
    }
}
