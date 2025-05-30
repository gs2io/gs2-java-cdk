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

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.exchange.ref.NamespaceRef;
import io.gs2.cdk.exchange.model.CurrentMasterData;
import io.gs2.cdk.exchange.model.RateModel;
import io.gs2.cdk.exchange.model.IncrementalRateModel;

import io.gs2.cdk.exchange.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private Boolean enableAwaitExchange = null;
    private Boolean enableDirectExchange = null;
    private TransactionSetting transactionSetting = null;
    private ScriptSetting exchangeScript = null;
    private ScriptSetting incrementalExchangeScript = null;
    private ScriptSetting acquireAwaitScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Exchange_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.enableAwaitExchange = options.enableAwaitExchange;
        this.enableDirectExchange = options.enableDirectExchange;
        this.transactionSetting = options.transactionSetting;
        this.exchangeScript = options.exchangeScript;
        this.incrementalExchangeScript = options.incrementalExchangeScript;
        this.acquireAwaitScript = options.acquireAwaitScript;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name
    ) {
        super(
            "Exchange_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Exchange::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.enableAwaitExchange != null) {
            properties.put("EnableAwaitExchange", this.enableAwaitExchange);
        }
        if (this.enableDirectExchange != null) {
            properties.put("EnableDirectExchange", this.enableDirectExchange);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.exchangeScript != null) {
            properties.put("ExchangeScript", this.exchangeScript.properties(
            ));
        }
        if (this.incrementalExchangeScript != null) {
            properties.put("IncrementalExchangeScript", this.incrementalExchangeScript.properties(
            ));
        }
        if (this.acquireAwaitScript != null) {
            properties.put("AcquireAwaitScript", this.acquireAwaitScript.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            this,
            "Item.NamespaceId",
            null
        ));
    }

    public Namespace masterData(
        List<RateModel> rateModels,
        List<IncrementalRateModel> incrementalRateModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            rateModels,
            incrementalRateModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
