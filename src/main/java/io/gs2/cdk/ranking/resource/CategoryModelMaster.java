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

package io.gs2.cdk.ranking.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.ranking.ref.*;
import io.gs2.cdk.ranking.model.*;

import java.util.*;
import java.util.stream.*;


public class CategoryModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public Long minimumValue;
    public Long maximumValue;
    public String orderDirection;
    public String scope;
    public Boolean uniqueByUserId;
    public Integer calculateFixedTimingHour;
    public Integer calculateFixedTimingMinute;
    public Integer calculateIntervalMinutes;
    public String entryPeriodEventId;
    public String accessPeriodEventId;
    public String generation;

    public CategoryModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            String orderDirection,
            String scope,
            Boolean uniqueByUserId,
            Integer calculateIntervalMinutes
    ) {
        super("Ranking_CategoryModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.orderDirection = orderDirection;
        this.scope = scope;
        this.uniqueByUserId = uniqueByUserId;
        this.calculateIntervalMinutes = calculateIntervalMinutes;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Ranking::CategoryModelMaster";
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
        if (this.minimumValue != null) {
            properties.put("MinimumValue", this.minimumValue);
        }
        if (this.maximumValue != null) {
            properties.put("MaximumValue", this.maximumValue);
        }
        if (this.orderDirection != null) {
            properties.put("OrderDirection", this.orderDirection.toString());
        }
        if (this.scope != null) {
            properties.put("Scope", this.scope.toString());
        }
        if (this.uniqueByUserId != null) {
            properties.put("UniqueByUserId", this.uniqueByUserId);
        }
        if (this.calculateFixedTimingHour != null) {
            properties.put("CalculateFixedTimingHour", this.calculateFixedTimingHour);
        }
        if (this.calculateFixedTimingMinute != null) {
            properties.put("CalculateFixedTimingMinute", this.calculateFixedTimingMinute);
        }
        if (this.calculateIntervalMinutes != null) {
            properties.put("CalculateIntervalMinutes", this.calculateIntervalMinutes);
        }
        if (this.entryPeriodEventId != null) {
            properties.put("EntryPeriodEventId", this.entryPeriodEventId);
        }
        if (this.accessPeriodEventId != null) {
            properties.put("AccessPeriodEventId", this.accessPeriodEventId);
        }
        if (this.generation != null) {
            properties.put("Generation", this.generation);
        }
        return properties;
    }

    public CategoryModelMasterRef ref(
            String namespaceName
    ) {
        return new CategoryModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrCategoryModelId() {
        return new GetAttr(
            "Item.CategoryModelId"
        );
    }
}
