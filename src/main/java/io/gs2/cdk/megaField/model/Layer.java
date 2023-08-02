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
import io.gs2.cdk.megaField.model.options.LayerOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Layer {
    private String areaModelName;
    private String layerModelName;
    private Integer numberOfMinEntries;
    private Integer numberOfMaxEntries;
    private Integer height;
    private String root = null;

    public Layer(
        String areaModelName,
        String layerModelName,
        Integer numberOfMinEntries,
        Integer numberOfMaxEntries,
        Integer height,
        LayerOptions options
    ) {
        this.areaModelName = areaModelName;
        this.layerModelName = layerModelName;
        this.numberOfMinEntries = numberOfMinEntries;
        this.numberOfMaxEntries = numberOfMaxEntries;
        this.height = height;
        this.root = options.root;
    }
    public Layer(
        String areaModelName,
        String layerModelName,
        Integer numberOfMinEntries,
        Integer numberOfMaxEntries,
        Integer height
    ) {
        this.areaModelName = areaModelName;
        this.layerModelName = layerModelName;
        this.numberOfMinEntries = numberOfMinEntries;
        this.numberOfMaxEntries = numberOfMaxEntries;
        this.height = height;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.areaModelName != null) {
            properties.put("areaModelName", this.areaModelName);
        }
        if (this.layerModelName != null) {
            properties.put("layerModelName", this.layerModelName);
        }
        if (this.root != null) {
            properties.put("root", this.root);
        }
        if (this.numberOfMinEntries != null) {
            properties.put("numberOfMinEntries", this.numberOfMinEntries);
        }
        if (this.numberOfMaxEntries != null) {
            properties.put("numberOfMaxEntries", this.numberOfMaxEntries);
        }
        if (this.height != null) {
            properties.put("height", this.height);
        }

        return properties;
    }
}
