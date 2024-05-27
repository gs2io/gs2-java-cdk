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

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalRankingSettingOptions {
    public FixedTiming calculateFixedTiming;
    public List<Scope> additionalScopes;
    public List<String> ignoreUserIds;
    public String generation;
    
    public GlobalRankingSettingOptions withCalculateFixedTiming(
        FixedTiming calculateFixedTiming
    ) {
        this.calculateFixedTiming = calculateFixedTiming;
        return this;
    }
    
    public GlobalRankingSettingOptions withAdditionalScopes(
        List<Scope> additionalScopes
    ) {
        this.additionalScopes = additionalScopes;
        return this;
    }
    
    public GlobalRankingSettingOptions withIgnoreUserIds(
        List<String> ignoreUserIds
    ) {
        this.ignoreUserIds = ignoreUserIds;
        return this;
    }
    
    public GlobalRankingSettingOptions withGeneration(
        String generation
    ) {
        this.generation = generation;
        return this;
    }
}

