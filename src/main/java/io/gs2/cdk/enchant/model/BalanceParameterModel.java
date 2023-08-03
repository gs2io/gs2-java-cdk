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
import io.gs2.cdk.enchant.model.BalanceParameterValueModel;
import io.gs2.cdk.enchant.model.options.BalanceParameterModelOptions;
import io.gs2.cdk.enchant.model.enums.BalanceParameterModelInitialValueStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceParameterModel {
    private String name;
    private Long totalValue;
    private BalanceParameterModelInitialValueStrategy initialValueStrategy;
    private List<BalanceParameterValueModel> parameters;
    private String metadata = null;

    public BalanceParameterModel(
        String name,
        Long totalValue,
        BalanceParameterModelInitialValueStrategy initialValueStrategy,
        List<BalanceParameterValueModel> parameters,
        BalanceParameterModelOptions options
    ) {
        this.name = name;
        this.totalValue = totalValue;
        this.initialValueStrategy = initialValueStrategy;
        this.parameters = parameters;
        this.metadata = options.metadata;
    }
    public BalanceParameterModel(
        String name,
        Long totalValue,
        BalanceParameterModelInitialValueStrategy initialValueStrategy,
        List<BalanceParameterValueModel> parameters
    ) {
        this.name = name;
        this.totalValue = totalValue;
        this.initialValueStrategy = initialValueStrategy;
        this.parameters = parameters;
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
        if (this.totalValue != null) {
            properties.put("totalValue", this.totalValue);
        }
        if (this.initialValueStrategy != null) {
            properties.put("initialValueStrategy", this.initialValueStrategy.toString(
            ));
        }
        if (this.parameters != null) {
            properties.put("parameters", this.parameters.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
