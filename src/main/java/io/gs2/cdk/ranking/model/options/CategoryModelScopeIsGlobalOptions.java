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
import io.gs2.cdk.ranking.model.FixedTiming;
import io.gs2.cdk.ranking.model.Scope;
import io.gs2.cdk.ranking.model.GlobalRankingSetting;
import io.gs2.cdk.ranking.model.enums.CategoryModelOrderDirection;
import io.gs2.cdk.ranking.model.enums.CategoryModelScope;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryModelScopeIsGlobalOptions {
    public String metadata;
    public Long minimumValue;
    public Long maximumValue;
    public String entryPeriodEventId;
    public String accessPeriodEventId;
    public Integer calculateFixedTimingHour;
    public Integer calculateFixedTimingMinute;
    public List<Scope> additionalScopes;
    public List<String> ignoreUserIds;
    public String generation;
    
    public CategoryModelScopeIsGlobalOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withMinimumValue(
        Long minimumValue
    ) {
        this.minimumValue = minimumValue;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withMaximumValue(
        Long maximumValue
    ) {
        this.maximumValue = maximumValue;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withEntryPeriodEventId(
        String entryPeriodEventId
    ) {
        this.entryPeriodEventId = entryPeriodEventId;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withAccessPeriodEventId(
        String accessPeriodEventId
    ) {
        this.accessPeriodEventId = accessPeriodEventId;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withCalculateFixedTimingHour(
        Integer calculateFixedTimingHour
    ) {
        this.calculateFixedTimingHour = calculateFixedTimingHour;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withCalculateFixedTimingMinute(
        Integer calculateFixedTimingMinute
    ) {
        this.calculateFixedTimingMinute = calculateFixedTimingMinute;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withAdditionalScopes(
        List<Scope> additionalScopes
    ) {
        this.additionalScopes = additionalScopes;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withIgnoreUserIds(
        List<String> ignoreUserIds
    ) {
        this.ignoreUserIds = ignoreUserIds;
        return this;
    }
    
    public CategoryModelScopeIsGlobalOptions withGeneration(
        String generation
    ) {
        this.generation = generation;
        return this;
    }
}
