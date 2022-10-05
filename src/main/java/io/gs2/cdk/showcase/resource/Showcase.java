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

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.showcase.ref.*;
import io.gs2.cdk.showcase.model.*;

import java.util.*;
import java.util.stream.*;

public class Showcase {
	public String name;
	public String metadata;
	public String salesPeriodEventId;
	public List<DisplayItem> displayItems;

    public Showcase(
            String name,
            List<DisplayItem> displayItems
    ) {
        this.name = name;
        this.displayItems = displayItems;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.salesPeriodEventId != null) {
            properties.put("SalesPeriodEventId", this.salesPeriodEventId);
        }
        if (this.displayItems != null) {
            properties.put("DisplayItems", this.displayItems.stream().map(DisplayItem::properties).collect(Collectors.toList()));
        }
        return properties;
    }
}
