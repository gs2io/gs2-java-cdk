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

package io.gs2.cdk.formation.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.formation.ref.*;
import io.gs2.cdk.formation.model.*;

import java.util.*;
import java.util.stream.*;


public class MoldModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public String formModelName;
    public Integer initialMaxCapacity;
    public Integer maxCapacity;

    public MoldModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            String formModelName,
            Integer initialMaxCapacity,
            Integer maxCapacity
    ) {
        super("Formation_MoldModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.formModelName = formModelName;
        this.initialMaxCapacity = initialMaxCapacity;
        this.maxCapacity = maxCapacity;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Formation::MoldModelMaster";
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
        if (this.formModelName != null) {
            properties.put("FormModelName", this.formModelName);
        }
        if (this.initialMaxCapacity != null) {
            properties.put("InitialMaxCapacity", this.initialMaxCapacity);
        }
        if (this.maxCapacity != null) {
            properties.put("MaxCapacity", this.maxCapacity);
        }
        return properties;
    }

    public MoldModelMasterRef ref(
            String namespaceName
    ) {
        return new MoldModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrMoldModelId() {
        return new GetAttr(
            "Item.MoldModelId"
        );
    }
}
