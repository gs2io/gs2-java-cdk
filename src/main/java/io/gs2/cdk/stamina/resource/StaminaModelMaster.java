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


public class StaminaModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public Integer recoverIntervalMinutes;
    public Integer recoverValue;
    public Integer initialCapacity;
    public Boolean isOverflow;
    public Integer maxCapacity;
    public String maxStaminaTableName;
    public String recoverIntervalTableName;
    public String recoverValueTableName;

    public StaminaModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            Integer recoverIntervalMinutes,
            Integer recoverValue,
            Integer initialCapacity,
            Boolean isOverflow,
            Integer maxCapacity
    ) {
        super("Stamina_StaminaModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.recoverIntervalMinutes = recoverIntervalMinutes;
        this.recoverValue = recoverValue;
        this.initialCapacity = initialCapacity;
        this.isOverflow = isOverflow;
        this.maxCapacity = maxCapacity;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Stamina::StaminaModelMaster";
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
        if (this.recoverIntervalMinutes != null) {
            properties.put("RecoverIntervalMinutes", this.recoverIntervalMinutes);
        }
        if (this.recoverValue != null) {
            properties.put("RecoverValue", this.recoverValue);
        }
        if (this.initialCapacity != null) {
            properties.put("InitialCapacity", this.initialCapacity);
        }
        if (this.isOverflow != null) {
            properties.put("IsOverflow", this.isOverflow);
        }
        if (this.maxCapacity != null) {
            properties.put("MaxCapacity", this.maxCapacity);
        }
        if (this.maxStaminaTableName != null) {
            properties.put("MaxStaminaTableName", this.maxStaminaTableName);
        }
        if (this.recoverIntervalTableName != null) {
            properties.put("RecoverIntervalTableName", this.recoverIntervalTableName);
        }
        if (this.recoverValueTableName != null) {
            properties.put("RecoverValueTableName", this.recoverValueTableName);
        }
        return properties;
    }

    public StaminaModelMasterRef ref(
            String namespaceName
    ) {
        return new StaminaModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrStaminaModelId() {
        return new GetAttr(
            "Item.StaminaModelId"
        );
    }
}
