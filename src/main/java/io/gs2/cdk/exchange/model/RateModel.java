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
package io.gs2.cdk.exchange.model;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.exchange.model.options.RateModelOptions;
import io.gs2.cdk.exchange.model.options.RateModelTimingTypeIsImmediateOptions;
import io.gs2.cdk.exchange.model.options.RateModelTimingTypeIsAwaitOptions;
import io.gs2.cdk.exchange.model.enums.RateModelTimingType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RateModel {
    private String name;
    private RateModelTimingType timingType;
    private String metadata = null;
    private List<ConsumeAction> consumeActions = null;
    private Integer lockTime = null;
    private List<AcquireAction> acquireActions = null;

    public RateModel(
        String name,
        RateModelTimingType timingType,
        RateModelOptions options
    ) {
        this.name = name;
        this.timingType = timingType;
        this.metadata = options.metadata;
        this.consumeActions = options.consumeActions;
        this.lockTime = options.lockTime;
        this.acquireActions = options.acquireActions;
    }
    public RateModel(
        String name,
        RateModelTimingType timingType
    ) {
        this.name = name;
        this.timingType = timingType;
    }

    public static RateModel timingTypeIsImmediate(
        String name,
        RateModelTimingTypeIsImmediateOptions options
    ) {
        return (new RateModel(
            name,
            RateModelTimingType.IMMEDIATE,
            new RateModelOptions()
                .withMetadata(options.metadata)
                .withConsumeActions(options.consumeActions)
                .withAcquireActions(options.acquireActions)
        ));
    }


    public static RateModel timingTypeIsImmediate(
        String name
    ) {
        return (new RateModel(
            name,
            RateModelTimingType.IMMEDIATE
        ));
    }

    public static RateModel timingTypeIsAwait(
        String name,
        Integer lockTime,
        RateModelTimingTypeIsAwaitOptions options
    ) {
        return (new RateModel(
            name,
            RateModelTimingType.AWAIT,
            new RateModelOptions()
                .withLockTime(lockTime)
                .withMetadata(options.metadata)
                .withConsumeActions(options.consumeActions)
                .withAcquireActions(options.acquireActions)
        ));
    }


    public static RateModel timingTypeIsAwait(
        String name,
        Integer lockTime
    ) {
        return (new RateModel(
            name,
            RateModelTimingType.AWAIT
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
        if (this.consumeActions != null) {
            properties.put("consumeActions", this.consumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.timingType != null) {
            properties.put("timingType", this.timingType.toString(
            ));
        }
        if (this.lockTime != null) {
            properties.put("lockTime", this.lockTime);
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
