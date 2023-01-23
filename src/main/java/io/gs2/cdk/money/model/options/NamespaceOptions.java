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
package io.gs2.cdk.money.model.options;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public String appleKey;
    public String googleKey;
    public Boolean enableFakeReceipt;
    public ScriptSetting createWalletScript;
    public ScriptSetting depositScript;
    public ScriptSetting withdrawScript;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withAppleKey(
        String appleKey
    ) {
        this.appleKey = appleKey;
        return this;
    }
    
    public NamespaceOptions withGoogleKey(
        String googleKey
    ) {
        this.googleKey = googleKey;
        return this;
    }
    
    public NamespaceOptions withEnableFakeReceipt(
        Boolean enableFakeReceipt
    ) {
        this.enableFakeReceipt = enableFakeReceipt;
        return this;
    }
    
    public NamespaceOptions withCreateWalletScript(
        ScriptSetting createWalletScript
    ) {
        this.createWalletScript = createWalletScript;
        return this;
    }
    
    public NamespaceOptions withDepositScript(
        ScriptSetting depositScript
    ) {
        this.depositScript = depositScript;
        return this;
    }
    
    public NamespaceOptions withWithdrawScript(
        ScriptSetting withdrawScript
    ) {
        this.withdrawScript = withdrawScript;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

