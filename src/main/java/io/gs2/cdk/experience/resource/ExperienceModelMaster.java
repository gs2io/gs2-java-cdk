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

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.experience.ref.*;
import io.gs2.cdk.experience.model.*;

import java.util.*;
import java.util.stream.*;


public class ExperienceModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public Long defaultExperience;
    public Long defaultRankCap;
    public Long maxRankCap;
    public String rankThresholdName;

    public ExperienceModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            Long defaultExperience,
            Long defaultRankCap,
            Long maxRankCap,
            String rankThresholdName
    ) {
        super("Experience_ExperienceModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.defaultExperience = defaultExperience;
        this.defaultRankCap = defaultRankCap;
        this.maxRankCap = maxRankCap;
        this.rankThresholdName = rankThresholdName;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Experience::ExperienceModelMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
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
        if (this.rankThresholdName != null) {
            properties.put("RankThresholdName", this.rankThresholdName);
        }
        return properties;
    }

    public ExperienceModelMasterRef ref(
            String namespaceName
    ) {
        return new ExperienceModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrExperienceModelId() {
        return new GetAttr(
            "Item.ExperienceModelId"
        );
    }
}
