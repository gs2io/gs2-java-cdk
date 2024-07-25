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
package io.gs2.cdk.showcase.model;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.showcase.model.options.RandomDisplayItemModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RandomDisplayItemModel {
    private String name;
    private List<AcquireAction> acquireActions;
    private Integer stock;
    private Integer weight;
    private String metadata = null;
    private List<VerifyAction> verifyActions = null;
    private List<ConsumeAction> consumeActions = null;

    public RandomDisplayItemModel(
        String name,
        List<AcquireAction> acquireActions,
        Integer stock,
        Integer weight,
        RandomDisplayItemModelOptions options
    ) {
        this.name = name;
        this.acquireActions = acquireActions;
        this.stock = stock;
        this.weight = weight;
        this.metadata = options.metadata;
        this.verifyActions = options.verifyActions;
        this.consumeActions = options.consumeActions;
    }
    public RandomDisplayItemModel(
        String name,
        List<AcquireAction> acquireActions,
        Integer stock,
        Integer weight
    ) {
        this.name = name;
        this.acquireActions = acquireActions;
        this.stock = stock;
        this.weight = weight;
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
        if (this.verifyActions != null) {
            properties.put("verifyActions", this.verifyActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.consumeActions != null) {
            properties.put("consumeActions", this.consumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.stock != null) {
            properties.put("stock", this.stock);
        }
        if (this.weight != null) {
            properties.put("weight", this.weight);
        }

        return properties;
    }
}
