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
package io.gs2.cdk.buff.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.buff.model.BuffEntryModel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentMasterData extends CdkResource {
    private String version= "2024-04-15";
    private String namespaceName;
    private List<BuffEntryModel> buffEntryModels;

    public CurrentMasterData(
        Stack stack,
        String namespaceName,
        List<BuffEntryModel> buffEntryModels
    ) {
        super(
            "Buff_CurrentBuffMaster_" + namespaceName
        );

        this.namespaceName = namespaceName;
        this.buffEntryModels = buffEntryModels;
        stack.addResource(
            this
        );
    }

    public String alternateKeys(
    ) {
        return this.namespaceName;
    }

    public String resourceType(
    ) {
        return "GS2::Buff::CurrentBuffMaster";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();
        var settings = new HashMap<String, Object>();

        settings.put("version", this.version);
        if (this.buffEntryModels != null) {
            settings.put("buffEntryModels", this.buffEntryModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (settings != null) {
            properties.put("Settings", settings);
        }

        return properties;
    }
}