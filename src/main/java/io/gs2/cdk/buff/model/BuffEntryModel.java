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
package io.gs2.cdk.buff.model;
import io.gs2.cdk.buff.model.BuffTargetGrn;
import io.gs2.cdk.buff.model.BuffTargetModel;
import io.gs2.cdk.buff.model.BuffTargetAction;
import io.gs2.cdk.buff.model.options.BuffEntryModelOptions;
import io.gs2.cdk.buff.model.options.BuffEntryModelTargetTypeIsModelOptions;
import io.gs2.cdk.buff.model.options.BuffEntryModelTargetTypeIsActionOptions;
import io.gs2.cdk.buff.model.enums.BuffEntryModelTargetType;
import io.gs2.cdk.buff.model.enums.BuffEntryModelExpression;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BuffEntryModel {
    private String name;
    private BuffEntryModelTargetType targetType;
    private BuffEntryModelExpression expression;
    private Integer priority;
    private String metadata = null;
    private BuffTargetModel targetModel = null;
    private BuffTargetAction targetAction = null;
    private String applyPeriodScheduleEventId = null;

    public BuffEntryModel(
        String name,
        BuffEntryModelTargetType targetType,
        BuffEntryModelExpression expression,
        Integer priority,
        BuffEntryModelOptions options
    ) {
        this.name = name;
        this.targetType = targetType;
        this.expression = expression;
        this.priority = priority;
        this.metadata = options.metadata;
        this.targetModel = options.targetModel;
        this.targetAction = options.targetAction;
        this.applyPeriodScheduleEventId = options.applyPeriodScheduleEventId;
    }
    public BuffEntryModel(
        String name,
        BuffEntryModelTargetType targetType,
        BuffEntryModelExpression expression,
        Integer priority
    ) {
        this.name = name;
        this.targetType = targetType;
        this.expression = expression;
        this.priority = priority;
    }

    public static BuffEntryModel targetTypeIsModel(
        String name,
        BuffEntryModelExpression expression,
        Integer priority,
        BuffTargetModel targetModel,
        BuffEntryModelTargetTypeIsModelOptions options
    ) {
        return (new BuffEntryModel(
            name,
            BuffEntryModelTargetType.MODEL,
            expression,
            priority,
            new BuffEntryModelOptions()
                .withTargetModel(targetModel)
                .withMetadata(options.metadata)
                .withApplyPeriodScheduleEventId(options.applyPeriodScheduleEventId)
        ));
    }


    public static BuffEntryModel targetTypeIsModel(
        String name,
        BuffEntryModelExpression expression,
        Integer priority,
        BuffTargetModel targetModel
    ) {
        return (new BuffEntryModel(
            name,
            BuffEntryModelTargetType.MODEL,
            expression,
            priority
        ));
    }

    public static BuffEntryModel targetTypeIsAction(
        String name,
        BuffEntryModelExpression expression,
        Integer priority,
        BuffTargetAction targetAction,
        BuffEntryModelTargetTypeIsActionOptions options
    ) {
        return (new BuffEntryModel(
            name,
            BuffEntryModelTargetType.ACTION,
            expression,
            priority,
            new BuffEntryModelOptions()
                .withTargetAction(targetAction)
                .withMetadata(options.metadata)
                .withApplyPeriodScheduleEventId(options.applyPeriodScheduleEventId)
        ));
    }


    public static BuffEntryModel targetTypeIsAction(
        String name,
        BuffEntryModelExpression expression,
        Integer priority,
        BuffTargetAction targetAction
    ) {
        return (new BuffEntryModel(
            name,
            BuffEntryModelTargetType.ACTION,
            expression,
            priority
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
        if (this.targetType != null) {
            properties.put("targetType", this.targetType.toString(
            ));
        }
        if (this.targetModel != null) {
            properties.put("targetModel", this.targetModel.properties(
            ));
        }
        if (this.targetAction != null) {
            properties.put("targetAction", this.targetAction.properties(
            ));
        }
        if (this.expression != null) {
            properties.put("expression", this.expression.toString(
            ));
        }
        if (this.priority != null) {
            properties.put("priority", this.priority);
        }
        if (this.applyPeriodScheduleEventId != null) {
            properties.put("applyPeriodScheduleEventId", this.applyPeriodScheduleEventId);
        }

        return properties;
    }
}
