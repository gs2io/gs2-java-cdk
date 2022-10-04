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

package io.gs2.cdk.stamina.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.stamina.ref.*;
import io.gs2.cdk.stamina.model.*;

import java.util.*;
import java.util.stream.*;


public class MaxStaminaTableMaster extends CdkResource {

    public Stack stack;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public String experienceModelId;
    public List<Integer> values;

    public MaxStaminaTableMaster(
            Stack stack,
            String namespaceName,
            String name,
            String experienceModelId,
            List<Integer> values
    ) {
        super("Stamina_MaxStaminaTableMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.values = values;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Stamina::MaxStaminaTableMaster";
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
        if (this.experienceModelId != null) {
            properties.put("ExperienceModelId", this.experienceModelId);
        }
        if (this.values != null) {
            properties.put("Values", this.values);
        }
        return properties;
    }

    public MaxStaminaTableMasterRef ref(
            String namespaceName
    ) {
        return new MaxStaminaTableMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrMaxStaminaTableId() {
        return new GetAttr(
            "Item.MaxStaminaTableId"
        );
    }
}
