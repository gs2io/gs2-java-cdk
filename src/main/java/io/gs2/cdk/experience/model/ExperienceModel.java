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
package io.gs2.cdk.experience.model;
import io.gs2.cdk.experience.model.Threshold;
import io.gs2.cdk.experience.model.AcquireActionRate;
import io.gs2.cdk.experience.model.options.ExperienceModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ExperienceModel {
    private String name;
    private Long defaultExperience;
    private Long defaultRankCap;
    private Long maxRankCap;
    private Threshold rankThreshold;
    private String metadata = null;
    private List<AcquireActionRate> acquireActionRates = null;

    public ExperienceModel(
        String name,
        Long defaultExperience,
        Long defaultRankCap,
        Long maxRankCap,
        Threshold rankThreshold,
        ExperienceModelOptions options
    ) {
        this.name = name;
        this.defaultExperience = defaultExperience;
        this.defaultRankCap = defaultRankCap;
        this.maxRankCap = maxRankCap;
        this.rankThreshold = rankThreshold;
        this.metadata = options.metadata;
        this.acquireActionRates = options.acquireActionRates;
    }
    public ExperienceModel(
        String name,
        Long defaultExperience,
        Long defaultRankCap,
        Long maxRankCap,
        Threshold rankThreshold
    ) {
        this.name = name;
        this.defaultExperience = defaultExperience;
        this.defaultRankCap = defaultRankCap;
        this.maxRankCap = maxRankCap;
        this.rankThreshold = rankThreshold;
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
        if (this.defaultExperience != null) {
            properties.put("defaultExperience", this.defaultExperience);
        }
        if (this.defaultRankCap != null) {
            properties.put("defaultRankCap", this.defaultRankCap);
        }
        if (this.maxRankCap != null) {
            properties.put("maxRankCap", this.maxRankCap);
        }
        if (this.rankThreshold != null) {
            properties.put("rankThreshold", this.rankThreshold.properties(
            ));
        }
        if (this.acquireActionRates != null) {
            properties.put("acquireActionRates", this.acquireActionRates.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
