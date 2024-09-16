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
package io.gs2.cdk.exchange.model;
import io.gs2.cdk.exchange.model.options.LogCostOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LogCost {
    private Double base;
    private List<Double> adds;
    private List<Double> subs = null;

    public LogCost(
        Double base,
        List<Double> adds,
        LogCostOptions options
    ) {
        this.base = base;
        this.adds = adds;
        this.subs = options.subs;
    }
    public LogCost(
        Double base,
        List<Double> adds
    ) {
        this.base = base;
        this.adds = adds;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.base != null) {
            properties.put("base", this.base);
        }
        if (this.adds != null) {
            properties.put("adds", this.adds);
        }
        if (this.subs != null) {
            properties.put("subs", this.subs);
        }

        return properties;
    }
}
