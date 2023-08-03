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
package io.gs2.cdk.enchant.model;
import io.gs2.cdk.enchant.model.options.RarityParameterValueModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RarityParameterValueModel {
    private String name;
    private String resourceName;
    private Long resourceValue;
    private Integer weight;
    private String metadata = null;

    public RarityParameterValueModel(
        String name,
        String resourceName,
        Long resourceValue,
        Integer weight,
        RarityParameterValueModelOptions options
    ) {
        this.name = name;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
        this.weight = weight;
        this.metadata = options.metadata;
    }
    public RarityParameterValueModel(
        String name,
        String resourceName,
        Long resourceValue,
        Integer weight
    ) {
        this.name = name;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
        this.weight = weight;
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
        if (this.resourceName != null) {
            properties.put("resourceName", this.resourceName);
        }
        if (this.resourceValue != null) {
            properties.put("resourceValue", this.resourceValue);
        }
        if (this.weight != null) {
            properties.put("weight", this.weight);
        }

        return properties;
    }
}
