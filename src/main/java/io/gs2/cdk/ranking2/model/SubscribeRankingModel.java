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
package io.gs2.cdk.ranking2.model;
import io.gs2.cdk.ranking2.model.options.SubscribeRankingModelOptions;
import io.gs2.cdk.ranking2.model.enums.SubscribeRankingModelOrderDirection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SubscribeRankingModel {
    private String name;
    private Boolean sum;
    private SubscribeRankingModelOrderDirection orderDirection;
    private String metadata = null;
    private Long minimumValue = null;
    private Long maximumValue = null;
    private String entryPeriodEventId = null;
    private String accessPeriodEventId = null;

    public SubscribeRankingModel(
        String name,
        Boolean sum,
        SubscribeRankingModelOrderDirection orderDirection,
        SubscribeRankingModelOptions options
    ) {
        this.name = name;
        this.sum = sum;
        this.orderDirection = orderDirection;
        this.metadata = options.metadata;
        this.minimumValue = options.minimumValue;
        this.maximumValue = options.maximumValue;
        this.entryPeriodEventId = options.entryPeriodEventId;
        this.accessPeriodEventId = options.accessPeriodEventId;
    }
    public SubscribeRankingModel(
        String name,
        Boolean sum,
        SubscribeRankingModelOrderDirection orderDirection
    ) {
        this.name = name;
        this.sum = sum;
        this.orderDirection = orderDirection;
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
        if (this.minimumValue != null) {
            properties.put("minimumValue", this.minimumValue);
        }
        if (this.maximumValue != null) {
            properties.put("maximumValue", this.maximumValue);
        }
        if (this.sum != null) {
            properties.put("sum", this.sum);
        }
        if (this.orderDirection != null) {
            properties.put("orderDirection", this.orderDirection.toString(
            ));
        }
        if (this.entryPeriodEventId != null) {
            properties.put("entryPeriodEventId", this.entryPeriodEventId);
        }
        if (this.accessPeriodEventId != null) {
            properties.put("accessPeriodEventId", this.accessPeriodEventId);
        }

        return properties;
    }
}
