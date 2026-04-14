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
import io.gs2.cdk.log.model.options.AggregationConfigOptions;
import io.gs2.cdk.log.model.enums.AggregationConfigType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AggregationConfig {
    private AggregationConfigType type = null;
    private String field = null;

    public AggregationConfig(
        AggregationConfigOptions options
    ) {
        this.type = options.type;
        this.field = options.field;
    }
    public AggregationConfig(
    ) {
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.field != null) {
            properties.put("field", this.field);
        }

        return properties;
    }
}
