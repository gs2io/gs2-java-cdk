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
import io.gs2.cdk.enhance.model.options.UnleashMaterialOptions;
import io.gs2.cdk.enhance.model.options.UnleashMaterialMaterialTypeIsIndividualOptions;
import io.gs2.cdk.enhance.model.options.UnleashMaterialMaterialTypeIsQuantityOptions;
import io.gs2.cdk.enhance.model.enums.UnleashMaterialMaterialType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashMaterial {
    private String name;
    private UnleashMaterialMaterialType materialType;
    private UnleashIndividualMaterialSetting individualSetting = null;
    private UnleashQuantityMaterialSetting quantitySetting = null;

    public UnleashMaterial(
        String name,
        UnleashMaterialMaterialType materialType,
        UnleashMaterialOptions options
    ) {
        this.name = name;
        this.materialType = materialType;
        this.individualSetting = options.individualSetting;
        this.quantitySetting = options.quantitySetting;
    }
    public UnleashMaterial(
        String name,
        UnleashMaterialMaterialType materialType
    ) {
        this.name = name;
        this.materialType = materialType;
    }

    public static UnleashMaterial materialTypeIsIndividual(
        String name,
        UnleashIndividualMaterialSetting individualSetting,
        UnleashMaterialMaterialTypeIsIndividualOptions options
    ) {
        return (new UnleashMaterial(
            name,
            UnleashMaterialMaterialType.INDIVIDUAL,
            new UnleashMaterialOptions()
                .withIndividualSetting(individualSetting)
        ));
    }


    public static UnleashMaterial materialTypeIsIndividual(
        String name,
        UnleashIndividualMaterialSetting individualSetting
    ) {
        return (new UnleashMaterial(
            name,
            UnleashMaterialMaterialType.INDIVIDUAL
        ));
    }

    public static UnleashMaterial materialTypeIsQuantity(
        String name,
        UnleashQuantityMaterialSetting quantitySetting,
        UnleashMaterialMaterialTypeIsQuantityOptions options
    ) {
        return (new UnleashMaterial(
            name,
            UnleashMaterialMaterialType.QUANTITY,
            new UnleashMaterialOptions()
                .withQuantitySetting(quantitySetting)
        ));
    }


    public static UnleashMaterial materialTypeIsQuantity(
        String name,
        UnleashQuantityMaterialSetting quantitySetting
    ) {
        return (new UnleashMaterial(
            name,
            UnleashMaterialMaterialType.QUANTITY
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.materialType != null) {
            properties.put("materialType", this.materialType.toString(
            ));
        }
        if (this.individualSetting != null) {
            properties.put("individualSetting", this.individualSetting.properties(
            ));
        }
        if (this.quantitySetting != null) {
            properties.put("quantitySetting", this.quantitySetting.properties(
            ));
        }

        return properties;
    }
}
