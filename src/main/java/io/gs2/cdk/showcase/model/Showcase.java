/*
 * Copyright 2016- Game Server Services, Inc. or its affiliates. All Rights
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
package io.gs2.cdk.showcase.model;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.showcase.model.SalesItem;
import io.gs2.cdk.showcase.model.SalesItemGroup;
import io.gs2.cdk.showcase.model.DisplayItem;
import io.gs2.cdk.showcase.model.options.ShowcaseOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Showcase {
    private String name;
    private List<DisplayItem> displayItems;
    private String metadata = null;
    private String salesPeriodEventId = null;

    public Showcase(
        String name,
        List<DisplayItem> displayItems,
        ShowcaseOptions options
    ) {
        this.name = name;
        this.displayItems = displayItems;
        this.metadata = options.metadata;
        this.salesPeriodEventId = options.salesPeriodEventId;
    }
    public Showcase(
        String name,
        List<DisplayItem> displayItems
    ) {
        this.name = name;
        this.displayItems = displayItems;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.salesPeriodEventId != null) {
            properties.put("salesPeriodEventId", this.salesPeriodEventId);
        }
        if (this.displayItems != null) {
            properties.put("displayItems", this.displayItems.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
