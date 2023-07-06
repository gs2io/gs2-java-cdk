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
import io.gs2.cdk.exchange.model.options.IncrementalRateModelOptions;
import io.gs2.cdk.exchange.model.options.IncrementalRateModelCalculateTypeIsLinearOptions;
import io.gs2.cdk.exchange.model.options.IncrementalRateModelCalculateTypeIsPowerOptions;
import io.gs2.cdk.exchange.model.options.IncrementalRateModelCalculateTypeIsGs2ScriptOptions;
import io.gs2.cdk.exchange.model.enums.IncrementalRateModelCalculateType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class IncrementalRateModel {
    private String name;
    private ConsumeAction consumeAction;
    private IncrementalRateModelCalculateType calculateType;
    private String exchangeCountId;
    private String metadata = null;
    private Long baseValue = null;
    private Long coefficientValue = null;
    private String calculateScriptId = null;
    private List<AcquireAction> acquireActions = null;

    public IncrementalRateModel(
        String name,
        ConsumeAction consumeAction,
        IncrementalRateModelCalculateType calculateType,
        String exchangeCountId,
        IncrementalRateModelOptions options
    ) {
        this.name = name;
        this.consumeAction = consumeAction;
        this.calculateType = calculateType;
        this.exchangeCountId = exchangeCountId;
        this.metadata = options.metadata;
        this.baseValue = options.baseValue;
        this.coefficientValue = options.coefficientValue;
        this.calculateScriptId = options.calculateScriptId;
        this.acquireActions = options.acquireActions;
    }
    public IncrementalRateModel(
        String name,
        ConsumeAction consumeAction,
        IncrementalRateModelCalculateType calculateType,
        String exchangeCountId
    ) {
        this.name = name;
        this.consumeAction = consumeAction;
        this.calculateType = calculateType;
        this.exchangeCountId = exchangeCountId;
    }

    public static IncrementalRateModel calculateTypeIsLinear(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        Long baseValue,
        Long coefficientValue,
        IncrementalRateModelCalculateTypeIsLinearOptions options
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.LINEAR,
            exchangeCountId,
            new IncrementalRateModelOptions()
                .withBaseValue(baseValue)
                .withCoefficientValue(coefficientValue)
                .withMetadata(options.metadata)
                .withAcquireActions(options.acquireActions)
        ));
    }


    public static IncrementalRateModel calculateTypeIsLinear(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        Long baseValue,
        Long coefficientValue
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.LINEAR,
            exchangeCountId
        ));
    }

    public static IncrementalRateModel calculateTypeIsPower(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        Long coefficientValue,
        IncrementalRateModelCalculateTypeIsPowerOptions options
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.POWER,
            exchangeCountId,
            new IncrementalRateModelOptions()
                .withCoefficientValue(coefficientValue)
                .withMetadata(options.metadata)
                .withAcquireActions(options.acquireActions)
        ));
    }


    public static IncrementalRateModel calculateTypeIsPower(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        Long coefficientValue
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.POWER,
            exchangeCountId
        ));
    }

    public static IncrementalRateModel calculateTypeIsGs2Script(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        String calculateScriptId,
        IncrementalRateModelCalculateTypeIsGs2ScriptOptions options
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.GS2_SCRIPT,
            exchangeCountId,
            new IncrementalRateModelOptions()
                .withCalculateScriptId(calculateScriptId)
                .withMetadata(options.metadata)
                .withAcquireActions(options.acquireActions)
        ));
    }


    public static IncrementalRateModel calculateTypeIsGs2Script(
        String name,
        ConsumeAction consumeAction,
        String exchangeCountId,
        String calculateScriptId
    ) {
        return (new IncrementalRateModel(
            name,
            consumeAction,
            IncrementalRateModelCalculateType.GS2_SCRIPT,
            exchangeCountId
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
        if (this.consumeAction != null) {
            properties.put("consumeAction", this.consumeAction.properties(
            ));
        }
        if (this.calculateType != null) {
            properties.put("calculateType", this.calculateType.toString(
            ));
        }
        if (this.baseValue != null) {
            properties.put("baseValue", this.baseValue);
        }
        if (this.coefficientValue != null) {
            properties.put("coefficientValue", this.coefficientValue);
        }
        if (this.calculateScriptId != null) {
            properties.put("calculateScriptId", this.calculateScriptId);
        }
        if (this.exchangeCountId != null) {
            properties.put("exchangeCountId", this.exchangeCountId);
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
