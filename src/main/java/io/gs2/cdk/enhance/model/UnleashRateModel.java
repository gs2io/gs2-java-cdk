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
import io.gs2.cdk.enhance.model.UnleashRateEntryModel;
import io.gs2.cdk.enhance.model.options.UnleashRateModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashRateModel {
    private String name;
    private String targetInventoryModelId;
    private String gradeModelId;
    private List<UnleashRateEntryModel> gradeEntries;
    private String description = null;
    private String metadata = null;

    public UnleashRateModel(
        String name,
        String targetInventoryModelId,
        String gradeModelId,
        List<UnleashRateEntryModel> gradeEntries,
        UnleashRateModelOptions options
    ) {
        this.name = name;
        this.targetInventoryModelId = targetInventoryModelId;
        this.gradeModelId = gradeModelId;
        this.gradeEntries = gradeEntries;
        this.description = options.description;
        this.metadata = options.metadata;
    }
    public UnleashRateModel(
        String name,
        String targetInventoryModelId,
        String gradeModelId,
        List<UnleashRateEntryModel> gradeEntries
    ) {
        this.name = name;
        this.targetInventoryModelId = targetInventoryModelId;
        this.gradeModelId = gradeModelId;
        this.gradeEntries = gradeEntries;
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
        if (this.gradeModelId != null) {
            properties.put("gradeModelId", this.gradeModelId);
        }
        if (this.gradeEntries != null) {
            properties.put("gradeEntries", this.gradeEntries.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
