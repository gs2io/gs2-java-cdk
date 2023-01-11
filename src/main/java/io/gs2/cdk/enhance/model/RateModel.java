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
import io.gs2.cdk.enhance.model.BonusRate;
import io.gs2.cdk.enhance.model.options.RateModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RateModel {
    private String name;
    private String targetInventoryModelId;
    private String acquireExperienceSuffix;
    private String materialInventoryModelId;
    private String experienceModelId;
    private String description = null;
    private String metadata = null;
    private List<String> acquireExperienceHierarchy = null;
    private List<BonusRate> bonusRates = null;

    public RateModel(
        String name,
        String targetInventoryModelId,
        String acquireExperienceSuffix,
        String materialInventoryModelId,
        String experienceModelId,
        RateModelOptions options
    ) {
        this.name = name;
        this.targetInventoryModelId = targetInventoryModelId;
        this.acquireExperienceSuffix = acquireExperienceSuffix;
        this.materialInventoryModelId = materialInventoryModelId;
        this.experienceModelId = experienceModelId;
        this.description = options.description;
        this.metadata = options.metadata;
        this.acquireExperienceHierarchy = options.acquireExperienceHierarchy;
        this.bonusRates = options.bonusRates;
    }
    public RateModel(
        String name,
        String targetInventoryModelId,
        String acquireExperienceSuffix,
        String materialInventoryModelId,
        String experienceModelId
    ) {
        this.name = name;
        this.targetInventoryModelId = targetInventoryModelId;
        this.acquireExperienceSuffix = acquireExperienceSuffix;
        this.materialInventoryModelId = materialInventoryModelId;
        this.experienceModelId = experienceModelId;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.description != null) {
            properties.put("description", this.description);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.targetInventoryModelId != null) {
            properties.put("targetInventoryModelId", this.targetInventoryModelId);
        }
        if (this.acquireExperienceSuffix != null) {
            properties.put("acquireExperienceSuffix", this.acquireExperienceSuffix);
        }
        if (this.materialInventoryModelId != null) {
            properties.put("materialInventoryModelId", this.materialInventoryModelId);
        }
        if (this.acquireExperienceHierarchy != null) {
            properties.put("acquireExperienceHierarchy", this.acquireExperienceHierarchy);
        }
        if (this.experienceModelId != null) {
            properties.put("experienceModelId", this.experienceModelId);
        }
        if (this.bonusRates != null) {
            properties.put("bonusRates", this.bonusRates.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
