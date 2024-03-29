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
package io.gs2.cdk.stateMachine.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;
import io.gs2.cdk.stateMachine.model.enums.NamespaceSupportSpeculativeExecution;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceSupportSpeculativeExecutionIsDisableOptions {
    public String description;
    public TransactionSetting transactionSetting;
    public ScriptSetting startScript;
    public ScriptSetting passScript;
    public ScriptSetting errorScript;
    public Long lowestStateMachineVersion;
    public LogSetting logSetting;
    public Long revision;
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withTransactionSetting(
        TransactionSetting transactionSetting
    ) {
        this.transactionSetting = transactionSetting;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withStartScript(
        ScriptSetting startScript
    ) {
        this.startScript = startScript;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withPassScript(
        ScriptSetting passScript
    ) {
        this.passScript = passScript;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withErrorScript(
        ScriptSetting errorScript
    ) {
        this.errorScript = errorScript;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withLowestStateMachineVersion(
        Long lowestStateMachineVersion
    ) {
        this.lowestStateMachineVersion = lowestStateMachineVersion;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
    
    public NamespaceSupportSpeculativeExecutionIsDisableOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}
