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
import io.gs2.cdk.ranking.model.GlobalRankingSetting;
import io.gs2.cdk.ranking.model.options.CategoryModelOptions;
import io.gs2.cdk.ranking.model.options.CategoryModelScopeIsGlobalOptions;
import io.gs2.cdk.ranking.model.options.CategoryModelScopeIsScopedOptions;
import io.gs2.cdk.ranking.model.enums.CategoryModelOrderDirection;
import io.gs2.cdk.ranking.model.enums.CategoryModelScope;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryModel {
    private String name;
    private Boolean sum;
    private CategoryModelOrderDirection orderDirection;
    private CategoryModelScope scope;
    private String metadata = null;
    private Long minimumValue = null;
    private Long maximumValue = null;
    private GlobalRankingSetting globalRankingSetting = null;
    private String entryPeriodEventId = null;
    private String accessPeriodEventId = null;
    private Boolean uniqueByUserId = null;
    private Integer calculateFixedTimingHour = null;
    private Integer calculateFixedTimingMinute = null;
    private Integer calculateIntervalMinutes = null;
    private List<Scope> additionalScopes = null;
    private List<String> ignoreUserIds = null;
    private String generation = null;

    public CategoryModel(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection,
        CategoryModelScope scope,
        CategoryModelOptions options
    ) {
        this.name = name;
        this.sum = sum;
        this.orderDirection = orderDirection;
        this.scope = scope;
        this.metadata = options.metadata;
        this.minimumValue = options.minimumValue;
        this.maximumValue = options.maximumValue;
        this.globalRankingSetting = options.globalRankingSetting;
        this.entryPeriodEventId = options.entryPeriodEventId;
        this.accessPeriodEventId = options.accessPeriodEventId;
        this.uniqueByUserId = options.uniqueByUserId;
        this.calculateFixedTimingHour = options.calculateFixedTimingHour;
        this.calculateFixedTimingMinute = options.calculateFixedTimingMinute;
        this.calculateIntervalMinutes = options.calculateIntervalMinutes;
        this.additionalScopes = options.additionalScopes;
        this.ignoreUserIds = options.ignoreUserIds;
        this.generation = options.generation;
    }
    public CategoryModel(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection,
        CategoryModelScope scope
    ) {
        this.name = name;
        this.sum = sum;
        this.orderDirection = orderDirection;
        this.scope = scope;
    }

    public static CategoryModel scopeIsGlobal(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection,
        GlobalRankingSetting globalRankingSetting,
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes,
        CategoryModelScopeIsGlobalOptions options
    ) {
        return (new CategoryModel(
            name,
            sum,
            orderDirection,
            CategoryModelScope.GLOBAL,
            new CategoryModelOptions()
                .withGlobalRankingSetting(globalRankingSetting)
                .withUniqueByUserId(uniqueByUserId)
                .withCalculateIntervalMinutes(calculateIntervalMinutes)
                .withMetadata(options.metadata)
                .withMinimumValue(options.minimumValue)
                .withMaximumValue(options.maximumValue)
                .withEntryPeriodEventId(options.entryPeriodEventId)
                .withAccessPeriodEventId(options.accessPeriodEventId)
                .withCalculateFixedTimingHour(options.calculateFixedTimingHour)
                .withCalculateFixedTimingMinute(options.calculateFixedTimingMinute)
                .withAdditionalScopes(options.additionalScopes)
                .withIgnoreUserIds(options.ignoreUserIds)
                .withGeneration(options.generation)
        ));
    }


    public static CategoryModel scopeIsGlobal(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection,
        GlobalRankingSetting globalRankingSetting,
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes
    ) {
        return (new CategoryModel(
            name,
            sum,
            orderDirection,
            CategoryModelScope.GLOBAL
        ));
    }

    public static CategoryModel scopeIsScoped(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection,
        CategoryModelScopeIsScopedOptions options
    ) {
        return (new CategoryModel(
            name,
            sum,
            orderDirection,
            CategoryModelScope.SCOPED,
            new CategoryModelOptions()
                .withMetadata(options.metadata)
                .withMinimumValue(options.minimumValue)
                .withMaximumValue(options.maximumValue)
                .withEntryPeriodEventId(options.entryPeriodEventId)
                .withAccessPeriodEventId(options.accessPeriodEventId)
                .withCalculateFixedTimingHour(options.calculateFixedTimingHour)
                .withCalculateFixedTimingMinute(options.calculateFixedTimingMinute)
                .withAdditionalScopes(options.additionalScopes)
                .withIgnoreUserIds(options.ignoreUserIds)
                .withGeneration(options.generation)
        ));
    }


    public static CategoryModel scopeIsScoped(
        String name,
        Boolean sum,
        CategoryModelOrderDirection orderDirection
    ) {
        return (new CategoryModel(
            name,
            sum,
            orderDirection,
            CategoryModelScope.SCOPED
        ));
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
        if (this.scope != null) {
            properties.put("scope", this.scope.toString(
            ));
        }
        if (this.globalRankingSetting != null) {
            properties.put("globalRankingSetting", this.globalRankingSetting.properties(
            ));
        }
        if (this.entryPeriodEventId != null) {
            properties.put("entryPeriodEventId", this.entryPeriodEventId);
        }
        if (this.accessPeriodEventId != null) {
            properties.put("accessPeriodEventId", this.accessPeriodEventId);
        }
        if (this.uniqueByUserId != null) {
            properties.put("uniqueByUserId", this.uniqueByUserId);
        }
        if (this.calculateFixedTimingHour != null) {
            properties.put("calculateFixedTimingHour", this.calculateFixedTimingHour);
        }
        if (this.calculateFixedTimingMinute != null) {
            properties.put("calculateFixedTimingMinute", this.calculateFixedTimingMinute);
        }
        if (this.calculateIntervalMinutes != null) {
            properties.put("calculateIntervalMinutes", this.calculateIntervalMinutes);
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
