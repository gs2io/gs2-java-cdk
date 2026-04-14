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
package io.gs2.cdk.log.model;
import io.gs2.cdk.log.model.options.MetricModelOptions;
import io.gs2.cdk.log.model.enums.MetricModelType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class MetricModel {
    private String name;
    private MetricModelType type;
    private List<String> labels = null;

    public MetricModel(
        String name,
        MetricModelType type,
        MetricModelOptions options
    ) {
        this.name = name;
        this.type = type;
        this.labels = options.labels;
    }
    public MetricModel(
        String name,
        MetricModelType type
    ) {
        this.name = name;
        this.type = type;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.labels != null) {
            properties.put("labels", this.labels);
        }

        return properties;
    }
}
