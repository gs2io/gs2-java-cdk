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
package io.gs2.cdk.inventory.model;
import io.gs2.cdk.inventory.model.ItemModel;
import io.gs2.cdk.inventory.model.options.InventoryModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryModel {
    private String name;
    private Integer initialCapacity;
    private Integer maxCapacity;
    private List<ItemModel> itemModels;
    private String metadata = null;
    private Boolean protectReferencedItem = null;

    public InventoryModel(
        String name,
        Integer initialCapacity,
        Integer maxCapacity,
        List<ItemModel> itemModels,
        InventoryModelOptions options
    ) {
        this.name = name;
        this.initialCapacity = initialCapacity;
        this.maxCapacity = maxCapacity;
        this.itemModels = itemModels;
        this.metadata = options.metadata;
        this.protectReferencedItem = options.protectReferencedItem;
    }
    public InventoryModel(
        String name,
        Integer initialCapacity,
        Integer maxCapacity,
        List<ItemModel> itemModels
    ) {
        this.name = name;
        this.initialCapacity = initialCapacity;
        this.maxCapacity = maxCapacity;
        this.itemModels = itemModels;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.initialCapacity != null) {
            properties.put("initialCapacity", this.initialCapacity);
        }
        if (this.maxCapacity != null) {
            properties.put("maxCapacity", this.maxCapacity);
        }
        if (this.protectReferencedItem != null) {
            properties.put("protectReferencedItem", this.protectReferencedItem);
        }
        if (this.itemModels != null) {
            properties.put("itemModels", this.itemModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
