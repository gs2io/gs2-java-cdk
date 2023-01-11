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
package io.gs2.cdk.quest.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.quest.model.options.ContentsOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Contents {
    private Integer weight;
    private String metadata = null;
    private List<AcquireAction> completeAcquireActions = null;

    public Contents(
        Integer weight,
        ContentsOptions options
    ) {
        this.weight = weight;
        this.metadata = options.metadata;
        this.completeAcquireActions = options.completeAcquireActions;
    }
    public Contents(
        Integer weight
    ) {
        this.weight = weight;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.completeAcquireActions != null) {
            properties.put("completeAcquireActions", this.completeAcquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.weight != null) {
            properties.put("weight", this.weight);
        }

        return properties;
    }
}
