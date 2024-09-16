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
package io.gs2.cdk.mission.model;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.mission.model.CounterScopeModel;
import io.gs2.cdk.mission.model.options.CounterModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CounterModel {
    private String name;
    private List<CounterScopeModel> scopes;
    private String metadata = null;
    private String challengePeriodEventId = null;

    public CounterModel(
        String name,
        List<CounterScopeModel> scopes,
        CounterModelOptions options
    ) {
        this.name = name;
        this.scopes = scopes;
        this.metadata = options.metadata;
        this.challengePeriodEventId = options.challengePeriodEventId;
    }
    public CounterModel(
        String name,
        List<CounterScopeModel> scopes
    ) {
        this.name = name;
        this.scopes = scopes;
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
        if (this.scopes != null) {
            properties.put("scopes", this.scopes.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("challengePeriodEventId", this.challengePeriodEventId);
        }

        return properties;
    }
}
