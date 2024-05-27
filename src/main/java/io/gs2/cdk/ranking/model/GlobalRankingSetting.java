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
package io.gs2.cdk.ranking.model;
import io.gs2.cdk.ranking.model.FixedTiming;
import io.gs2.cdk.ranking.model.Scope;
import io.gs2.cdk.ranking.model.options.GlobalRankingSettingOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalRankingSetting {
    private Boolean uniqueByUserId;
    private Integer calculateIntervalMinutes;
    private FixedTiming calculateFixedTiming = null;
    private List<Scope> additionalScopes = null;
    private List<String> ignoreUserIds = null;
    private String generation = null;

    public GlobalRankingSetting(
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes,
        GlobalRankingSettingOptions options
    ) {
        this.uniqueByUserId = uniqueByUserId;
        this.calculateIntervalMinutes = calculateIntervalMinutes;
        this.calculateFixedTiming = options.calculateFixedTiming;
        this.additionalScopes = options.additionalScopes;
        this.ignoreUserIds = options.ignoreUserIds;
        this.generation = options.generation;
    }
    public GlobalRankingSetting(
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes
    ) {
        this.uniqueByUserId = uniqueByUserId;
        this.calculateIntervalMinutes = calculateIntervalMinutes;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.uniqueByUserId != null) {
            properties.put("uniqueByUserId", this.uniqueByUserId);
        }
        if (this.calculateIntervalMinutes != null) {
            properties.put("calculateIntervalMinutes", this.calculateIntervalMinutes);
        }
        if (this.calculateFixedTiming != null) {
            properties.put("calculateFixedTiming", this.calculateFixedTiming.properties(
            ));
        }
        if (this.additionalScopes != null) {
            properties.put("additionalScopes", this.additionalScopes.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.ignoreUserIds != null) {
            properties.put("ignoreUserIds", this.ignoreUserIds);
        }
        if (this.generation != null) {
            properties.put("generation", this.generation);
        }

        return properties;
    }
}
