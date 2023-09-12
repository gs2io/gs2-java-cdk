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
package io.gs2.cdk.skillTree.model;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.skillTree.model.options.NodeModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NodeModel {
    private String name;
    private List<ConsumeAction> releaseConsumeActions;
    private Float restrainReturnRate;
    private String metadata = null;
    private List<AcquireAction> returnAcquireActions = null;
    private List<String> premiseNodeNames = null;

    public NodeModel(
        String name,
        List<ConsumeAction> releaseConsumeActions,
        Float restrainReturnRate,
        NodeModelOptions options
    ) {
        this.name = name;
        this.releaseConsumeActions = releaseConsumeActions;
        this.restrainReturnRate = restrainReturnRate;
        this.metadata = options.metadata;
        this.returnAcquireActions = options.returnAcquireActions;
        this.premiseNodeNames = options.premiseNodeNames;
    }
    public NodeModel(
        String name,
        List<ConsumeAction> releaseConsumeActions,
        Float restrainReturnRate
    ) {
        this.name = name;
        this.releaseConsumeActions = releaseConsumeActions;
        this.restrainReturnRate = restrainReturnRate;
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
        if (this.releaseConsumeActions != null) {
            properties.put("releaseConsumeActions", this.releaseConsumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.restrainReturnRate != null) {
            properties.put("restrainReturnRate", this.restrainReturnRate);
        }
        if (this.premiseNodeNames != null) {
            properties.put("premiseNodeNames", this.premiseNodeNames);
        }

        return properties;
    }
}
