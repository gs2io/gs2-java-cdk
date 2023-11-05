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
import io.gs2.cdk.formation.model.options.SlotWithSignatureOptions;
import io.gs2.cdk.formation.model.enums.SlotWithSignaturePropertyType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SlotWithSignature {
    private String name;
    private SlotWithSignaturePropertyType propertyType;
    private String body = null;
    private String signature = null;
    private String metadata = null;

    public SlotWithSignature(
        String name,
        SlotWithSignaturePropertyType propertyType,
        SlotWithSignatureOptions options
    ) {
        this.name = name;
        this.propertyType = propertyType;
        this.body = options.body;
        this.signature = options.signature;
        this.metadata = options.metadata;
    }
    public SlotWithSignature(
        String name,
        SlotWithSignaturePropertyType propertyType
    ) {
        this.name = name;
        this.propertyType = propertyType;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.propertyType != null) {
            properties.put("propertyType", this.propertyType.toString(
            ));
        }
        if (this.body != null) {
            properties.put("body", this.body);
        }
        if (this.signature != null) {
            properties.put("signature", this.signature);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }

        return properties;
    }
}
