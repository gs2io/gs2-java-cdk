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
import io.gs2.cdk.ranking.model.Scope;
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
    private CategoryModelOrderDirection orderDirection;
    private CategoryModelScope scope;
    private Boolean uniqueByUserId;
    private String metadata = null;
    private Long minimumValue = null;
    private Long maximumValue = null;
    private Boolean sum = null;
    private Integer calculateFixedTimingHour = null;
    private Integer calculateFixedTimingMinute = null;
    private Integer calculateIntervalMinutes = null;
    private List<Scope> additionalScopes = null;
    private String entryPeriodEventId = null;
    private String accessPeriodEventId = null;
    private List<String> ignoreUserIds = null;
    private String generation = null;

    public CategoryModel(
        String name,
        CategoryModelOrderDirection orderDirection,
        CategoryModelScope scope,
        Boolean uniqueByUserId,
        CategoryModelOptions options
    ) {
        this.name = name;
        this.orderDirection = orderDirection;
        this.scope = scope;
        this.uniqueByUserId = uniqueByUserId;
        this.metadata = options.metadata;
        this.minimumValue = options.minimumValue;
        this.maximumValue = options.maximumValue;
        this.sum = options.sum;
        this.calculateFixedTimingHour = options.calculateFixedTimingHour;
        this.calculateFixedTimingMinute = options.calculateFixedTimingMinute;
        this.calculateIntervalMinutes = options.calculateIntervalMinutes;
        this.additionalScopes = options.additionalScopes;
        this.entryPeriodEventId = options.entryPeriodEventId;
        this.accessPeriodEventId = options.accessPeriodEventId;
        this.ignoreUserIds = options.ignoreUserIds;
        this.generation = options.generation;
    }
    public CategoryModel(
        String name,
        CategoryModelOrderDirection orderDirection,
        CategoryModelScope scope,
        Boolean uniqueByUserId
    ) {
        this.name = name;
        this.orderDirection = orderDirection;
        this.scope = scope;
        this.uniqueByUserId = uniqueByUserId;
    }

    public static CategoryModel scopeIsGlobal(
        String name,
        CategoryModelOrderDirection orderDirection,
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes,
        CategoryModelScopeIsGlobalOptions options
    ) {
        return (new CategoryModel(
            name,
            orderDirection,
            CategoryModelScope.GLOBAL,
            uniqueByUserId,
            new CategoryModelOptions()
                .withCalculateIntervalMinutes(calculateIntervalMinutes)
                .withMetadata(options.metadata)
                .withMinimumValue(options.minimumValue)
                .withMaximumValue(options.maximumValue)
                .withCalculateFixedTimingHour(options.calculateFixedTimingHour)
                .withCalculateFixedTimingMinute(options.calculateFixedTimingMinute)
                .withAdditionalScopes(options.additionalScopes)
                .withEntryPeriodEventId(options.entryPeriodEventId)
                .withAccessPeriodEventId(options.accessPeriodEventId)
                .withIgnoreUserIds(options.ignoreUserIds)
                .withGeneration(options.generation)
        ));
    }


    public static CategoryModel scopeIsGlobal(
        String name,
        CategoryModelOrderDirection orderDirection,
        Boolean uniqueByUserId,
        Integer calculateIntervalMinutes
    ) {
        return (new CategoryModel(
            name,
            orderDirection,
            CategoryModelScope.GLOBAL,
            uniqueByUserId
        ));
    }

    public static CategoryModel scopeIsScoped(
        String name,
        CategoryModelOrderDirection orderDirection,
        Boolean uniqueByUserId,
        CategoryModelScopeIsScopedOptions options
    ) {
        return (new CategoryModel(
            name,
            orderDirection,
            CategoryModelScope.SCOPED,
            uniqueByUserId,
            new CategoryModelOptions()
                .withMetadata(options.metadata)
                .withMinimumValue(options.minimumValue)
                .withMaximumValue(options.maximumValue)
                .withCalculateFixedTimingHour(options.calculateFixedTimingHour)
                .withCalculateFixedTimingMinute(options.calculateFixedTimingMinute)
                .withAdditionalScopes(options.additionalScopes)
                .withEntryPeriodEventId(options.entryPeriodEventId)
                .withAccessPeriodEventId(options.accessPeriodEventId)
                .withIgnoreUserIds(options.ignoreUserIds)
                .withGeneration(options.generation)
        ));
    }


    public static CategoryModel scopeIsScoped(
        String name,
        CategoryModelOrderDirection orderDirection,
        Boolean uniqueByUserId
    ) {
        return (new CategoryModel(
            name,
            orderDirection,
            CategoryModelScope.SCOPED,
            uniqueByUserId
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
        if (this.orderDirection != null) {
            properties.put("orderDirection", this.orderDirection.toString(
            ));
        }
        if (this.scope != null) {
            properties.put("scope", this.scope.toString(
            ));
        }
        if (this.uniqueByUserId != null) {
            properties.put("uniqueByUserId", this.uniqueByUserId);
        }
        if (this.sum != null) {
            properties.put("sum", this.sum);
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
        if (this.entryPeriodEventId != null) {
            properties.put("entryPeriodEventId", this.entryPeriodEventId);
        }
        if (this.accessPeriodEventId != null) {
            properties.put("accessPeriodEventId", this.accessPeriodEventId);
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
