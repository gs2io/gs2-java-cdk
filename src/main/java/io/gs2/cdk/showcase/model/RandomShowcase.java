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
import io.gs2.cdk.showcase.model.RandomDisplayItemModel;
import io.gs2.cdk.showcase.model.options.RandomShowcaseOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RandomShowcase {
    private String name;
    private Integer maximumNumberOfChoice;
    private List<RandomDisplayItemModel> displayItems;
    private Long baseTimestamp;
    private Integer resetIntervalHours;
    private String metadata = null;
    private String salesPeriodEventId = null;

    public RandomShowcase(
        String name,
        Integer maximumNumberOfChoice,
        List<RandomDisplayItemModel> displayItems,
        Long baseTimestamp,
        Integer resetIntervalHours,
        RandomShowcaseOptions options
    ) {
        this.name = name;
        this.maximumNumberOfChoice = maximumNumberOfChoice;
        this.displayItems = displayItems;
        this.baseTimestamp = baseTimestamp;
        this.resetIntervalHours = resetIntervalHours;
        this.metadata = options.metadata;
        this.salesPeriodEventId = options.salesPeriodEventId;
    }
    public RandomShowcase(
        String name,
        Integer maximumNumberOfChoice,
        List<RandomDisplayItemModel> displayItems,
        Long baseTimestamp,
        Integer resetIntervalHours
    ) {
        this.name = name;
        this.maximumNumberOfChoice = maximumNumberOfChoice;
        this.displayItems = displayItems;
        this.baseTimestamp = baseTimestamp;
        this.resetIntervalHours = resetIntervalHours;
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
        if (this.maximumNumberOfChoice != null) {
            properties.put("maximumNumberOfChoice", this.maximumNumberOfChoice);
        }
        if (this.displayItems != null) {
            properties.put("displayItems", this.displayItems.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.baseTimestamp != null) {
            properties.put("baseTimestamp", this.baseTimestamp);
        }
        if (this.resetIntervalHours != null) {
            properties.put("resetIntervalHours", this.resetIntervalHours);
        }
        if (this.salesPeriodEventId != null) {
            properties.put("salesPeriodEventId", this.salesPeriodEventId);
        }

        return properties;
    }
}
