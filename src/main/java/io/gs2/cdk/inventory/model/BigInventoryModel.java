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
import io.gs2.cdk.inventory.model.BigItemModel;
import io.gs2.cdk.inventory.model.options.BigInventoryModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BigInventoryModel {
    private String name;
    private List<BigItemModel> bigItemModels;
    private String metadata = null;

    public BigInventoryModel(
        String name,
        List<BigItemModel> bigItemModels,
        BigInventoryModelOptions options
    ) {
        this.name = name;
        this.bigItemModels = bigItemModels;
        this.metadata = options.metadata;
    }
    public BigInventoryModel(
        String name,
        List<BigItemModel> bigItemModels
    ) {
        this.name = name;
        this.bigItemModels = bigItemModels;
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
        if (this.bigItemModels != null) {
            properties.put("bigItemModels", this.bigItemModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
