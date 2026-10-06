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
package io.gs2.cdk.enhance.model;
import io.gs2.cdk.enhance.model.UnleashIndividualMaterialSetting;
import io.gs2.cdk.enhance.model.UnleashQuantityMaterialSetting;
import io.gs2.cdk.enhance.model.UnleashMaterial;
import io.gs2.cdk.enhance.model.options.UnleashRecipeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashRecipe {
    private String name;
    private List<UnleashMaterial> materials;
    private String metadata = null;
    private List<String> targetGroupKeys = null;

    public UnleashRecipe(
        String name,
        List<UnleashMaterial> materials,
        UnleashRecipeOptions options
    ) {
        this.name = name;
        this.materials = materials;
        this.metadata = options.metadata;
        this.targetGroupKeys = options.targetGroupKeys;
    }
    public UnleashRecipe(
        String name,
        List<UnleashMaterial> materials
    ) {
        this.name = name;
        this.materials = materials;
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
        if (this.targetGroupKeys != null) {
            properties.put("targetGroupKeys", this.targetGroupKeys);
        }
        if (this.materials != null) {
            properties.put("materials", this.materials.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
