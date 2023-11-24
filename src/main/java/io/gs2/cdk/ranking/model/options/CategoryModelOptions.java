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
package io.gs2.cdk.ranking.model.options;
import io.gs2.cdk.ranking.model.Scope;
import io.gs2.cdk.ranking.model.enums.CategoryModelOrderDirection;
import io.gs2.cdk.ranking.model.enums.CategoryModelScope;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryModelOptions {
    public String metadata;
    public Long minimumValue;
    public Long maximumValue;
    public Boolean uniqueByUserId;
    public Boolean sum;
    public Integer calculateFixedTimingHour;
    public Integer calculateFixedTimingMinute;
    public Integer calculateIntervalMinutes;
    public List<Scope> additionalScopes;
    public String entryPeriodEventId;
    public String accessPeriodEventId;
    public List<String> ignoreUserIds;
    public String generation;
    
    public CategoryModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public CategoryModelOptions withMinimumValue(
        Long minimumValue
    ) {
        this.minimumValue = minimumValue;
        return this;
    }
    
    public CategoryModelOptions withMaximumValue(
        Long maximumValue
    ) {
        this.maximumValue = maximumValue;
        return this;
    }
    
    public CategoryModelOptions withUniqueByUserId(
        Boolean uniqueByUserId
    ) {
        this.uniqueByUserId = uniqueByUserId;
        return this;
    }
    
    public CategoryModelOptions withSum(
        Boolean sum
    ) {
        this.sum = sum;
        return this;
    }
    
    public CategoryModelOptions withCalculateFixedTimingHour(
        Integer calculateFixedTimingHour
    ) {
        this.calculateFixedTimingHour = calculateFixedTimingHour;
        return this;
    }
    
    public CategoryModelOptions withCalculateFixedTimingMinute(
        Integer calculateFixedTimingMinute
    ) {
        this.calculateFixedTimingMinute = calculateFixedTimingMinute;
        return this;
    }
    
    public CategoryModelOptions withCalculateIntervalMinutes(
        Integer calculateIntervalMinutes
    ) {
        this.calculateIntervalMinutes = calculateIntervalMinutes;
        return this;
    }
    
    public CategoryModelOptions withAdditionalScopes(
        List<Scope> additionalScopes
    ) {
        this.additionalScopes = additionalScopes;
        return this;
    }
    
    public CategoryModelOptions withEntryPeriodEventId(
        String entryPeriodEventId
    ) {
        this.entryPeriodEventId = entryPeriodEventId;
        return this;
    }
    
    public CategoryModelOptions withAccessPeriodEventId(
        String accessPeriodEventId
    ) {
        this.accessPeriodEventId = accessPeriodEventId;
        return this;
    }
    
    public CategoryModelOptions withIgnoreUserIds(
        List<String> ignoreUserIds
    ) {
        this.ignoreUserIds = ignoreUserIds;
        return this;
    }
    
    public CategoryModelOptions withGeneration(
        String generation
    ) {
        this.generation = generation;
        return this;
    }
}

