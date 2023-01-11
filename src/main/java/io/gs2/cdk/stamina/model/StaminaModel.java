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
package io.gs2.cdk.stamina.model;
import io.gs2.cdk.stamina.model.MaxStaminaTable;
import io.gs2.cdk.stamina.model.RecoverIntervalTable;
import io.gs2.cdk.stamina.model.RecoverValueTable;
import io.gs2.cdk.stamina.model.options.StaminaModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StaminaModel {
    private String name;
    private Integer recoverIntervalMinutes;
    private Integer recoverValue;
    private Integer initialCapacity;
    private Boolean isOverflow;
    private String metadata = null;
    private Integer maxCapacity = null;
    private MaxStaminaTable maxStaminaTable = null;
    private RecoverIntervalTable recoverIntervalTable = null;
    private RecoverValueTable recoverValueTable = null;

    public StaminaModel(
        String name,
        Integer recoverIntervalMinutes,
        Integer recoverValue,
        Integer initialCapacity,
        Boolean isOverflow,
        StaminaModelOptions options
    ) {
        this.name = name;
        this.recoverIntervalMinutes = recoverIntervalMinutes;
        this.recoverValue = recoverValue;
        this.initialCapacity = initialCapacity;
        this.isOverflow = isOverflow;
        this.metadata = options.metadata;
        this.maxCapacity = options.maxCapacity;
        this.maxStaminaTable = options.maxStaminaTable;
        this.recoverIntervalTable = options.recoverIntervalTable;
        this.recoverValueTable = options.recoverValueTable;
    }
    public StaminaModel(
        String name,
        Integer recoverIntervalMinutes,
        Integer recoverValue,
        Integer initialCapacity,
        Boolean isOverflow
    ) {
        this.name = name;
        this.recoverIntervalMinutes = recoverIntervalMinutes;
        this.recoverValue = recoverValue;
        this.initialCapacity = initialCapacity;
        this.isOverflow = isOverflow;
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
        if (this.recoverIntervalMinutes != null) {
            properties.put("recoverIntervalMinutes", this.recoverIntervalMinutes);
        }
        if (this.recoverValue != null) {
            properties.put("recoverValue", this.recoverValue);
        }
        if (this.initialCapacity != null) {
            properties.put("initialCapacity", this.initialCapacity);
        }
        if (this.isOverflow != null) {
            properties.put("isOverflow", this.isOverflow);
        }
        if (this.maxCapacity != null) {
            properties.put("maxCapacity", this.maxCapacity);
        }
        if (this.maxStaminaTable != null) {
            properties.put("maxStaminaTable", this.maxStaminaTable.properties(
            ));
        }
        if (this.recoverIntervalTable != null) {
            properties.put("recoverIntervalTable", this.recoverIntervalTable.properties(
            ));
        }
        if (this.recoverValueTable != null) {
            properties.put("recoverValueTable", this.recoverValueTable.properties(
            ));
        }

        return properties;
    }
}
