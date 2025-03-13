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
package io.gs2.cdk.money2.model;
import io.gs2.cdk.money2.model.AppleAppStoreSubscriptionContent;
import io.gs2.cdk.money2.model.GooglePlaySubscriptionContent;
import io.gs2.cdk.money2.model.options.StoreSubscriptionContentModelOptions;
import io.gs2.cdk.money2.model.options.StoreSubscriptionContentModelTriggerExtendModeIsJustOptions;
import io.gs2.cdk.money2.model.options.StoreSubscriptionContentModelTriggerExtendModeIsRollupHourOptions;
import io.gs2.cdk.money2.model.enums.StoreSubscriptionContentModelTriggerExtendMode;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StoreSubscriptionContentModel {
    private String name;
    private String scheduleNamespaceId;
    private String triggerName;
    private StoreSubscriptionContentModelTriggerExtendMode triggerExtendMode;
    private Integer reallocateSpanDays;
    private String metadata = null;
    private Integer rollupHour = null;
    private AppleAppStoreSubscriptionContent appleAppStore = null;
    private GooglePlaySubscriptionContent googlePlay = null;

    public StoreSubscriptionContentModel(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        StoreSubscriptionContentModelTriggerExtendMode triggerExtendMode,
        Integer reallocateSpanDays,
        StoreSubscriptionContentModelOptions options
    ) {
        this.name = name;
        this.scheduleNamespaceId = scheduleNamespaceId;
        this.triggerName = triggerName;
        this.triggerExtendMode = triggerExtendMode;
        this.reallocateSpanDays = reallocateSpanDays;
        this.metadata = options.metadata;
        this.rollupHour = options.rollupHour;
        this.appleAppStore = options.appleAppStore;
        this.googlePlay = options.googlePlay;
    }
    public StoreSubscriptionContentModel(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        StoreSubscriptionContentModelTriggerExtendMode triggerExtendMode,
        Integer reallocateSpanDays
    ) {
        this.name = name;
        this.scheduleNamespaceId = scheduleNamespaceId;
        this.triggerName = triggerName;
        this.triggerExtendMode = triggerExtendMode;
        this.reallocateSpanDays = reallocateSpanDays;
    }

    public static StoreSubscriptionContentModel triggerExtendModeIsJust(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        Integer reallocateSpanDays,
        StoreSubscriptionContentModelTriggerExtendModeIsJustOptions options
    ) {
        return (new StoreSubscriptionContentModel(
            name,
            scheduleNamespaceId,
            triggerName,
            StoreSubscriptionContentModelTriggerExtendMode.JUST,
            reallocateSpanDays,
            new StoreSubscriptionContentModelOptions()
                .withMetadata(options.metadata)
                .withAppleAppStore(options.appleAppStore)
                .withGooglePlay(options.googlePlay)
        ));
    }


    public static StoreSubscriptionContentModel triggerExtendModeIsJust(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        Integer reallocateSpanDays
    ) {
        return (new StoreSubscriptionContentModel(
            name,
            scheduleNamespaceId,
            triggerName,
            StoreSubscriptionContentModelTriggerExtendMode.JUST,
            reallocateSpanDays
        ));
    }

    public static StoreSubscriptionContentModel triggerExtendModeIsRollupHour(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        Integer reallocateSpanDays,
        Integer rollupHour,
        StoreSubscriptionContentModelTriggerExtendModeIsRollupHourOptions options
    ) {
        return (new StoreSubscriptionContentModel(
            name,
            scheduleNamespaceId,
            triggerName,
            StoreSubscriptionContentModelTriggerExtendMode.ROLLUP_HOUR,
            reallocateSpanDays,
            new StoreSubscriptionContentModelOptions()
                .withRollupHour(rollupHour)
                .withMetadata(options.metadata)
                .withAppleAppStore(options.appleAppStore)
                .withGooglePlay(options.googlePlay)
        ));
    }


    public static StoreSubscriptionContentModel triggerExtendModeIsRollupHour(
        String name,
        String scheduleNamespaceId,
        String triggerName,
        Integer reallocateSpanDays,
        Integer rollupHour
    ) {
        return (new StoreSubscriptionContentModel(
            name,
            scheduleNamespaceId,
            triggerName,
            StoreSubscriptionContentModelTriggerExtendMode.ROLLUP_HOUR,
            reallocateSpanDays
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
        if (this.scheduleNamespaceId != null) {
            properties.put("scheduleNamespaceId", this.scheduleNamespaceId);
        }
        if (this.triggerName != null) {
            properties.put("triggerName", this.triggerName);
        }
        if (this.triggerExtendMode != null) {
            properties.put("triggerExtendMode", this.triggerExtendMode.toString(
            ));
        }
        if (this.rollupHour != null) {
            properties.put("rollupHour", this.rollupHour);
        }
        if (this.reallocateSpanDays != null) {
            properties.put("reallocateSpanDays", this.reallocateSpanDays);
        }
        if (this.appleAppStore != null) {
            properties.put("appleAppStore", this.appleAppStore.properties(
            ));
        }
        if (this.googlePlay != null) {
            properties.put("googlePlay", this.googlePlay.properties(
            ));
        }

        return properties;
    }
}
