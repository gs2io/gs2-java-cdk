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

package io.gs2.cdk.enhance.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.enhance.ref.*;
import io.gs2.cdk.enhance.model.*;

import java.util.*;
import java.util.stream.*;

public class RateModel {
	public String name;
	public String description;
	public String metadata;
	public String targetInventoryModelId;
	public String acquireExperienceSuffix;
	public String materialInventoryModelId;
	public List<String> acquireExperienceHierarchy;
	public String experienceModelId;
	public List<BonusRate> bonusRates;

    public RateModel(
            String name,
            String targetInventoryModelId,
            String acquireExperienceSuffix,
            String materialInventoryModelId,
            String experienceModelId
    ) {
        this.name = name;
        this.targetInventoryModelId = targetInventoryModelId;
        this.acquireExperienceSuffix = acquireExperienceSuffix;
        this.materialInventoryModelId = materialInventoryModelId;
        this.experienceModelId = experienceModelId;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.targetInventoryModelId != null) {
            properties.put("TargetInventoryModelId", this.targetInventoryModelId);
        }
        if (this.acquireExperienceSuffix != null) {
            properties.put("AcquireExperienceSuffix", this.acquireExperienceSuffix);
        }
        if (this.materialInventoryModelId != null) {
            properties.put("MaterialInventoryModelId", this.materialInventoryModelId);
        }
        if (this.acquireExperienceHierarchy != null) {
            properties.put("AcquireExperienceHierarchy", this.acquireExperienceHierarchy);
        }
        if (this.experienceModelId != null) {
            properties.put("ExperienceModelId", this.experienceModelId);
        }
        if (this.bonusRates != null) {
            properties.put("BonusRates", this.bonusRates.stream().map(BonusRate::properties).collect(Collectors.toList()));
        }
        return properties;
    }

    public RateModelRef ref(
            String namespaceName
    ) {
        return new RateModelRef(
            namespaceName,
            this.name
        );
    }
}
