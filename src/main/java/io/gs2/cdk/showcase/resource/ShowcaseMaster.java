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

package io.gs2.cdk.showcase.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.showcase.ref.*;
import io.gs2.cdk.showcase.model.*;

import java.util.*;
import java.util.stream.*;


public class ShowcaseMaster extends CdkResource {

    public Stack stack;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public List<DisplayItemMaster> displayItems;
    public String salesPeriodEventId;

    public ShowcaseMaster(
            Stack stack,
            String namespaceName,
            String name,
            List<DisplayItemMaster> displayItems
    ) {
        super("Showcase_ShowcaseMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.displayItems = displayItems;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Showcase::ShowcaseMaster";
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
        if (this.displayItems != null) {
            properties.put("DisplayItems", this.displayItems.stream().map(DisplayItemMaster::properties).collect(Collectors.toList()));
        }
        if (this.salesPeriodEventId != null) {
            properties.put("SalesPeriodEventId", this.salesPeriodEventId);
        }
        return properties;
    }

    public ShowcaseMasterRef ref(
            String namespaceName
    ) {
        return new ShowcaseMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrShowcaseId() {
        return new GetAttr(
            "Item.ShowcaseId"
        );
    }
}
