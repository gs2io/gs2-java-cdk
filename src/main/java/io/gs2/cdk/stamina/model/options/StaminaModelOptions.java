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
package io.gs2.cdk.stamina.model.options;
import io.gs2.cdk.stamina.model.MaxStaminaTable;
import io.gs2.cdk.stamina.model.RecoverIntervalTable;
import io.gs2.cdk.stamina.model.RecoverValueTable;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StaminaModelOptions {
    public String metadata;
    public Integer maxCapacity;
    public MaxStaminaTable maxStaminaTable;
    public RecoverIntervalTable recoverIntervalTable;
    public RecoverValueTable recoverValueTable;
    
    public StaminaModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public StaminaModelOptions withMaxCapacity(
        Integer maxCapacity
    ) {
        this.maxCapacity = maxCapacity;
        return this;
    }
    
    public StaminaModelOptions withMaxStaminaTable(
        MaxStaminaTable maxStaminaTable
    ) {
        this.maxStaminaTable = maxStaminaTable;
        return this;
    }
    
    public StaminaModelOptions withRecoverIntervalTable(
        RecoverIntervalTable recoverIntervalTable
    ) {
        this.recoverIntervalTable = recoverIntervalTable;
        return this;
    }
    
    public StaminaModelOptions withRecoverValueTable(
        RecoverValueTable recoverValueTable
    ) {
        this.recoverValueTable = recoverValueTable;
        return this;
    }
}

