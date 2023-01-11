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
package io.gs2.cdk.showcase.model;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.showcase.model.SalesItem;
import io.gs2.cdk.showcase.model.SalesItemGroup;
import io.gs2.cdk.showcase.model.options.DisplayItemOptions;
import io.gs2.cdk.showcase.model.options.DisplayItemTypeIsSalesItemOptions;
import io.gs2.cdk.showcase.model.options.DisplayItemTypeIsSalesItemGroupOptions;
import io.gs2.cdk.showcase.model.enums.DisplayItemType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayItem {
    private String displayItemId;
    private DisplayItemType type;
    private SalesItem salesItem = null;
    private SalesItemGroup salesItemGroup = null;
    private String salesPeriodEventId = null;

    public DisplayItem(
        String displayItemId,
        DisplayItemType type,
        DisplayItemOptions options
    ) {
        this.displayItemId = displayItemId;
        this.type = type;
        this.salesItem = options.salesItem;
        this.salesItemGroup = options.salesItemGroup;
        this.salesPeriodEventId = options.salesPeriodEventId;
    }
    public DisplayItem(
        String displayItemId,
        DisplayItemType type
    ) {
        this.displayItemId = displayItemId;
        this.type = type;
    }

    public static DisplayItem typeIsSalesItem(
        String displayItemId,
        SalesItem salesItem,
        DisplayItemTypeIsSalesItemOptions options
    ) {
        return (new DisplayItem(
            displayItemId,
            DisplayItemType.SALES_ITEM,
            new DisplayItemOptions()
                .withSalesItem(salesItem)
                .withSalesPeriodEventId(options.salesPeriodEventId)
        ));
    }


    public static DisplayItem typeIsSalesItem(
        String displayItemId,
        SalesItem salesItem
    ) {
        return (new DisplayItem(
            displayItemId,
            DisplayItemType.SALES_ITEM
        ));
    }

    public static DisplayItem typeIsSalesItemGroup(
        String displayItemId,
        SalesItemGroup salesItemGroup,
        DisplayItemTypeIsSalesItemGroupOptions options
    ) {
        return (new DisplayItem(
            displayItemId,
            DisplayItemType.SALES_ITEM_GROUP,
            new DisplayItemOptions()
                .withSalesItemGroup(salesItemGroup)
                .withSalesPeriodEventId(options.salesPeriodEventId)
        ));
    }


    public static DisplayItem typeIsSalesItemGroup(
        String displayItemId,
        SalesItemGroup salesItemGroup
    ) {
        return (new DisplayItem(
            displayItemId,
            DisplayItemType.SALES_ITEM_GROUP
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.displayItemId != null) {
            properties.put("displayItemId", this.displayItemId);
        }
        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.salesItem != null) {
            properties.put("salesItem", this.salesItem.properties(
            ));
        }
        if (this.salesItemGroup != null) {
            properties.put("salesItemGroup", this.salesItemGroup.properties(
            ));
        }
        if (this.salesPeriodEventId != null) {
            properties.put("salesPeriodEventId", this.salesPeriodEventId);
        }

        return properties;
    }
}
