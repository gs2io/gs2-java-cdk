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
import io.gs2.cdk.enchant.model.options.RarityParameterCountModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RarityParameterCountModel {
    private Integer count;
    private Integer weight;

    public RarityParameterCountModel(
        Integer count,
        Integer weight,
        RarityParameterCountModelOptions options
    ) {
        this.count = count;
        this.weight = weight;
    }
    public RarityParameterCountModel(
        Integer count,
        Integer weight
    ) {
        this.count = count;
        this.weight = weight;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.count != null) {
            properties.put("count", this.count);
        }
        if (this.weight != null) {
            properties.put("weight", this.weight);
        }

        return properties;
    }
}
