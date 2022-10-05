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

package io.gs2.cdk.limit.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.limit.ref.*;
import io.gs2.cdk.limit.model.*;

import java.util.*;
import java.util.stream.*;


public class LimitModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public String resetType;
    public Integer resetDayOfMonth;
    public String resetDayOfWeek;
    public Integer resetHour;

    public LimitModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            String resetType,
            Integer resetDayOfMonth,
            String resetDayOfWeek,
            Integer resetHour
    ) {
        super("Limit_LimitModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.resetType = resetType;
        this.resetDayOfMonth = resetDayOfMonth;
        this.resetDayOfWeek = resetDayOfWeek;
        this.resetHour = resetHour;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Limit::LimitModelMaster";
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
        if (this.resetType != null) {
            properties.put("ResetType", this.resetType.toString());
        }
        if (this.resetDayOfMonth != null) {
            properties.put("ResetDayOfMonth", this.resetDayOfMonth);
        }
        if (this.resetDayOfWeek != null) {
            properties.put("ResetDayOfWeek", this.resetDayOfWeek.toString());
        }
        if (this.resetHour != null) {
            properties.put("ResetHour", this.resetHour);
        }
        return properties;
    }

    public LimitModelMasterRef ref(
            String namespaceName
    ) {
        return new LimitModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrLimitModelId() {
        return new GetAttr(
            "Item.LimitModelId"
        );
    }
}
