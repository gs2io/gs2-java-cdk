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
import io.gs2.cdk.enhance.model.UnleashRecipe;
import io.gs2.cdk.enhance.model.options.UnleashRateEntryModelOptions;
import io.gs2.cdk.enhance.model.options.UnleashRateEntryModelTypeIsSimpleOptions;
import io.gs2.cdk.enhance.model.options.UnleashRateEntryModelTypeIsRecipeOptions;
import io.gs2.cdk.enhance.model.enums.UnleashRateEntryModelType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashRateEntryModel {
    private Long gradeValue;
    private UnleashRateEntryModelType type;
    private Integer needCount = null;
    private List<UnleashRecipe> recipes = null;

    public UnleashRateEntryModel(
        Long gradeValue,
        UnleashRateEntryModelType type,
        UnleashRateEntryModelOptions options
    ) {
        this.gradeValue = gradeValue;
        this.type = type;
        this.needCount = options.needCount;
        this.recipes = options.recipes;
    }
    public UnleashRateEntryModel(
        Long gradeValue,
        UnleashRateEntryModelType type
    ) {
        this.gradeValue = gradeValue;
        this.type = type;
    }

    public static UnleashRateEntryModel typeIsSimple(
        Long gradeValue,
        Integer needCount,
        UnleashRateEntryModelTypeIsSimpleOptions options
    ) {
        return (new UnleashRateEntryModel(
            gradeValue,
            UnleashRateEntryModelType.SIMPLE,
            new UnleashRateEntryModelOptions()
                .withNeedCount(needCount)
        ));
    }


    public static UnleashRateEntryModel typeIsSimple(
        Long gradeValue,
        Integer needCount
    ) {
        return (new UnleashRateEntryModel(
            gradeValue,
            UnleashRateEntryModelType.SIMPLE
        ));
    }

    public static UnleashRateEntryModel typeIsRecipe(
        Long gradeValue,
        List<UnleashRecipe> recipes,
        UnleashRateEntryModelTypeIsRecipeOptions options
    ) {
        return (new UnleashRateEntryModel(
            gradeValue,
            UnleashRateEntryModelType.RECIPE,
            new UnleashRateEntryModelOptions()
                .withRecipes(recipes)
        ));
    }


    public static UnleashRateEntryModel typeIsRecipe(
        Long gradeValue,
        List<UnleashRecipe> recipes
    ) {
        return (new UnleashRateEntryModel(
            gradeValue,
            UnleashRateEntryModelType.RECIPE
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.gradeValue != null) {
            properties.put("gradeValue", this.gradeValue);
        }
        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.needCount != null) {
            properties.put("needCount", this.needCount);
        }
        if (this.recipes != null) {
            properties.put("recipes", this.recipes.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
