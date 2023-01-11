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
package io.gs2.cdk.stamina.model;
import io.gs2.cdk.stamina.model.options.RecoverIntervalTableOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RecoverIntervalTable {
    private String name;
    private String experienceModelId;
    private List<Integer> values;
    private String metadata = null;

    public RecoverIntervalTable(
        String name,
        String experienceModelId,
        List<Integer> values,
        RecoverIntervalTableOptions options
    ) {
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.values = values;
        this.metadata = options.metadata;
    }
    public RecoverIntervalTable(
        String name,
        String experienceModelId,
        List<Integer> values
    ) {
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.values = values;
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
        if (this.experienceModelId != null) {
            properties.put("experienceModelId", this.experienceModelId);
        }
        if (this.values != null) {
            properties.put("values", this.values);
        }

        return properties;
    }
}
