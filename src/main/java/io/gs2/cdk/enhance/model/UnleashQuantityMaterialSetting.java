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
import io.gs2.cdk.enhance.model.options.UnleashQuantityMaterialSettingOptions;
import io.gs2.cdk.enhance.model.options.UnleashQuantityMaterialSettingMatchTypeIsSameGroupOptions;
import io.gs2.cdk.enhance.model.options.UnleashQuantityMaterialSettingMatchTypeIsSpecifiedOptions;
import io.gs2.cdk.enhance.model.enums.UnleashQuantityMaterialSettingMatchType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashQuantityMaterialSetting {
    private UnleashQuantityMaterialSettingMatchType matchType;
    private Integer count;
    private String materialInventoryModelId = null;
    private String itemModelId = null;

    public UnleashQuantityMaterialSetting(
        UnleashQuantityMaterialSettingMatchType matchType,
        Integer count,
        UnleashQuantityMaterialSettingOptions options
    ) {
        this.matchType = matchType;
        this.count = count;
        this.materialInventoryModelId = options.materialInventoryModelId;
        this.itemModelId = options.itemModelId;
    }
    public UnleashQuantityMaterialSetting(
        UnleashQuantityMaterialSettingMatchType matchType,
        Integer count
    ) {
        this.matchType = matchType;
        this.count = count;
    }

    public static UnleashQuantityMaterialSetting matchTypeIsSameGroup(
        Integer count,
        String materialInventoryModelId,
        UnleashQuantityMaterialSettingMatchTypeIsSameGroupOptions options
    ) {
        return (new UnleashQuantityMaterialSetting(
            UnleashQuantityMaterialSettingMatchType.SAME_GROUP,
            count,
            new UnleashQuantityMaterialSettingOptions()
                .withMaterialInventoryModelId(materialInventoryModelId)
        ));
    }


    public static UnleashQuantityMaterialSetting matchTypeIsSameGroup(
        Integer count,
        String materialInventoryModelId
    ) {
        return (new UnleashQuantityMaterialSetting(
            UnleashQuantityMaterialSettingMatchType.SAME_GROUP,
            count
        ));
    }

    public static UnleashQuantityMaterialSetting matchTypeIsSpecified(
        Integer count,
        String itemModelId,
        UnleashQuantityMaterialSettingMatchTypeIsSpecifiedOptions options
    ) {
        return (new UnleashQuantityMaterialSetting(
            UnleashQuantityMaterialSettingMatchType.SPECIFIED,
            count,
            new UnleashQuantityMaterialSettingOptions()
                .withItemModelId(itemModelId)
        ));
    }


    public static UnleashQuantityMaterialSetting matchTypeIsSpecified(
        Integer count,
        String itemModelId
    ) {
        return (new UnleashQuantityMaterialSetting(
            UnleashQuantityMaterialSettingMatchType.SPECIFIED,
            count
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.matchType != null) {
            properties.put("matchType", this.matchType.toString(
            ));
        }
        if (this.materialInventoryModelId != null) {
            properties.put("materialInventoryModelId", this.materialInventoryModelId);
        }
        if (this.itemModelId != null) {
            properties.put("itemModelId", this.itemModelId);
        }
        if (this.count != null) {
            properties.put("count", this.count);
        }

        return properties;
    }
}
