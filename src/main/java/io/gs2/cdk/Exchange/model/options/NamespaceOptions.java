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
package io.gs2.cdk.exchange.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public Boolean enableAwaitExchange;
    public Boolean enableDirectExchange;
    public ScriptSetting exchangeScript;
    public LogSetting logSetting;
    public String queueNamespaceId;
    public String keyId;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withEnableAwaitExchange(
        Boolean enableAwaitExchange
    ) {
        this.enableAwaitExchange = enableAwaitExchange;
        return this;
    }
    
    public NamespaceOptions withEnableDirectExchange(
        Boolean enableDirectExchange
    ) {
        this.enableDirectExchange = enableDirectExchange;
        return this;
    }
    
    public NamespaceOptions withExchangeScript(
        ScriptSetting exchangeScript
    ) {
        this.exchangeScript = exchangeScript;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
    
    public NamespaceOptions withQueueNamespaceId(
        String queueNamespaceId
    ) {
        this.queueNamespaceId = queueNamespaceId;
        return this;
    }
    
    public NamespaceOptions withKeyId(
        String keyId
    ) {
        this.keyId = keyId;
        return this;
    }
}

