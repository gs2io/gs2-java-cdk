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
import io.gs2.cdk.log.model.FacetValueCount;
import io.gs2.cdk.log.model.NumericRange;
import io.gs2.cdk.log.model.options.FacetOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Facet {
    private String field;
    private List<FacetValueCount> values = null;
    private NumericRange range = null;
    private NumericRange globalRange = null;

    public Facet(
        String field,
        FacetOptions options
    ) {
        this.field = field;
        this.values = options.values;
        this.range = options.range;
        this.globalRange = options.globalRange;
    }
    public Facet(
        String field
    ) {
        this.field = field;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.field != null) {
            properties.put("field", this.field);
        }
        if (this.values != null) {
            properties.put("values", this.values.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.range != null) {
            properties.put("range", this.range.properties(
            ));
        }
        if (this.globalRange != null) {
            properties.put("globalRange", this.globalRange.properties(
            ));
        }

        return properties;
    }
}
