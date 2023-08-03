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
import io.gs2.cdk.enchant.model.options.RarityParameterValueOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RarityParameterValue {
    private String name;
    private String resourceName;
    private Long resourceValue;

    public RarityParameterValue(
        String name,
        String resourceName,
        Long resourceValue,
        RarityParameterValueOptions options
    ) {
        this.name = name;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
    }
    public RarityParameterValue(
        String name,
        String resourceName,
        Long resourceValue
    ) {
        this.name = name;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.resourceName != null) {
            properties.put("resourceName", this.resourceName);
        }
        if (this.resourceValue != null) {
            properties.put("resourceValue", this.resourceValue);
        }

        return properties;
    }
}
