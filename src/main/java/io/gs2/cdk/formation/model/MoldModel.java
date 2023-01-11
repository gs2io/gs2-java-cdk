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
package io.gs2.cdk.formation.model;
import io.gs2.cdk.formation.model.SlotModel;
import io.gs2.cdk.formation.model.FormModel;
import io.gs2.cdk.formation.model.options.MoldModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MoldModel {
    private String name;
    private Integer initialMaxCapacity;
    private Integer maxCapacity;
    private FormModel formModel;
    private String metadata = null;

    public MoldModel(
        String name,
        Integer initialMaxCapacity,
        Integer maxCapacity,
        FormModel formModel,
        MoldModelOptions options
    ) {
        this.name = name;
        this.initialMaxCapacity = initialMaxCapacity;
        this.maxCapacity = maxCapacity;
        this.formModel = formModel;
        this.metadata = options.metadata;
    }
    public MoldModel(
        String name,
        Integer initialMaxCapacity,
        Integer maxCapacity,
        FormModel formModel
    ) {
        this.name = name;
        this.initialMaxCapacity = initialMaxCapacity;
        this.maxCapacity = maxCapacity;
        this.formModel = formModel;
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
        if (this.initialMaxCapacity != null) {
            properties.put("initialMaxCapacity", this.initialMaxCapacity);
        }
        if (this.maxCapacity != null) {
            properties.put("maxCapacity", this.maxCapacity);
        }
        if (this.formModel != null) {
            properties.put("formModel", this.formModel.properties(
            ));
        }

        return properties;
    }
}
