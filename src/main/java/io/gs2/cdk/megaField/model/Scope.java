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
package io.gs2.cdk.megaField.model;
import io.gs2.cdk.megaField.model.options.ScopeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Scope {
    private String layerName;
    private Float r;
    private Integer limit;

    public Scope(
        String layerName,
        Float r,
        Integer limit,
        ScopeOptions options
    ) {
        this.layerName = layerName;
        this.r = r;
        this.limit = limit;
    }
    public Scope(
        String layerName,
        Float r,
        Integer limit
    ) {
        this.layerName = layerName;
        this.r = r;
        this.limit = limit;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.layerName != null) {
            properties.put("layerName", this.layerName);
        }
        if (this.r != null) {
            properties.put("r", this.r);
        }
        if (this.limit != null) {
            properties.put("limit", this.limit);
        }

        return properties;
    }
}
