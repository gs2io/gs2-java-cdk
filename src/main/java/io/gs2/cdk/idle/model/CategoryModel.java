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
package io.gs2.cdk.idle.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.idle.model.AcquireActionList;
import io.gs2.cdk.idle.model.options.CategoryModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryModel {
    private String name;
    private Integer rewardIntervalMinutes;
    private Integer defaultMaximumIdleMinutes;
    private List<AcquireActionList> acquireActions;
    private String metadata = null;
    private String idlePeriodScheduleId = null;
    private String receivePeriodScheduleId = null;

    public CategoryModel(
        String name,
        Integer rewardIntervalMinutes,
        Integer defaultMaximumIdleMinutes,
        List<AcquireActionList> acquireActions,
        CategoryModelOptions options
    ) {
        this.name = name;
        this.rewardIntervalMinutes = rewardIntervalMinutes;
        this.defaultMaximumIdleMinutes = defaultMaximumIdleMinutes;
        this.acquireActions = acquireActions;
        this.metadata = options.metadata;
        this.idlePeriodScheduleId = options.idlePeriodScheduleId;
        this.receivePeriodScheduleId = options.receivePeriodScheduleId;
    }
    public CategoryModel(
        String name,
        Integer rewardIntervalMinutes,
        Integer defaultMaximumIdleMinutes,
        List<AcquireActionList> acquireActions
    ) {
        this.name = name;
        this.rewardIntervalMinutes = rewardIntervalMinutes;
        this.defaultMaximumIdleMinutes = defaultMaximumIdleMinutes;
        this.acquireActions = acquireActions;
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
        if (this.rewardIntervalMinutes != null) {
            properties.put("rewardIntervalMinutes", this.rewardIntervalMinutes);
        }
        if (this.defaultMaximumIdleMinutes != null) {
            properties.put("defaultMaximumIdleMinutes", this.defaultMaximumIdleMinutes);
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.idlePeriodScheduleId != null) {
            properties.put("idlePeriodScheduleId", this.idlePeriodScheduleId);
        }
        if (this.receivePeriodScheduleId != null) {
            properties.put("receivePeriodScheduleId", this.receivePeriodScheduleId);
        }

        return properties;
    }
}
