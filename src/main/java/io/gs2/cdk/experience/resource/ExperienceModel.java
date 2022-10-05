/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.experience.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.experience.ref.*;
import io.gs2.cdk.experience.model.*;

import java.util.*;
import java.util.stream.*;

public class ExperienceModel {
	public String name;
	public String metadata;
	public Long defaultExperience;
	public Long defaultRankCap;
	public Long maxRankCap;
	public Threshold rankThreshold;

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

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.defaultExperience != null) {
            properties.put("DefaultExperience", this.defaultExperience);
        }
        if (this.defaultRankCap != null) {
            properties.put("DefaultRankCap", this.defaultRankCap);
        }
        if (this.maxRankCap != null) {
            properties.put("MaxRankCap", this.maxRankCap);
        }
        if (this.rankThreshold != null) {
            properties.put("RankThreshold", this.rankThreshold.properties());
        }
        return properties;
    }

    public ExperienceModelRef ref(
            String namespaceName
    ) {
        return new ExperienceModelRef(
            namespaceName,
            this.name
        );
    }
}
