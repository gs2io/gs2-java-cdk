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
package io.gs2.cdk.enhance.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.enhance.model.RateModel;
import io.gs2.cdk.enhance.model.UnleashRateModel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentMasterData extends CdkResource {
    private String version= "2020-08-22";
    private String namespaceName;
    private List<RateModel> rateModels;
    private List<UnleashRateModel> unleashRateModels;

    public CurrentMasterData(
        Stack stack,
        String namespaceName,
        List<RateModel> rateModels,
        List<UnleashRateModel> unleashRateModels
    ) {
        super(
            "Enhance_CurrentRateMaster_" + namespaceName
        );

        this.namespaceName = namespaceName;
        this.rateModels = rateModels;
        this.unleashRateModels = unleashRateModels;
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
        return "GS2::Enhance::CurrentRateMaster";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();
        var settings = new HashMap<String, Object>();

        settings.put("version", this.version);
        if (this.rateModels != null) {
            settings.put("rateModels", this.rateModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.unleashRateModels != null) {
            settings.put("unleashRateModels", this.unleashRateModels.stream().map(v -> v.properties(
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