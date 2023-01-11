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
import io.gs2.cdk.core.model.Config;
import io.gs2.cdk.formation.model.options.AcquireActionConfigOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AcquireActionConfig {
    private String name;
    private List<Config> config = null;

    public AcquireActionConfig(
        String name,
        AcquireActionConfigOptions options
    ) {
        this.name = name;
        this.config = options.config;
    }
    public AcquireActionConfig(
        String name
    ) {
        this.name = name;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.config != null) {
            properties.put("config", this.config.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
