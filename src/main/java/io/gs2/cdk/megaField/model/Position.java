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
import io.gs2.cdk.megaField.model.options.PositionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Position {
    private Float x;
    private Float y;
    private Float z;

    public Position(
        Float x,
        Float y,
        Float z,
        PositionOptions options
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Position(
        Float x,
        Float y,
        Float z
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.x != null) {
            properties.put("x", this.x);
        }
        if (this.y != null) {
            properties.put("y", this.y);
        }
        if (this.z != null) {
            properties.put("z", this.z);
        }

        return properties;
    }
}
