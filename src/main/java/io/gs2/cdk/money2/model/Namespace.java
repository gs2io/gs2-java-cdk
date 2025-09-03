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

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.money2.model.PlatformSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.money2.ref.NamespaceRef;
import io.gs2.cdk.money2.model.CurrentMasterData;
import io.gs2.cdk.money2.model.StoreContentModel;
import io.gs2.cdk.money2.model.StoreSubscriptionContentModel;
import io.gs2.cdk.money2.model.enums.NamespaceCurrencyUsagePriority;

import io.gs2.cdk.money2.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private NamespaceCurrencyUsagePriority currencyUsagePriority;
    private Boolean sharedFreeCurrency;
    private PlatformSetting platformSetting;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private ScriptSetting depositBalanceScript = null;
    private ScriptSetting withdrawBalanceScript = null;
    private ScriptSetting verifyReceiptScript = null;
    private String subscribeScript = null;
    private String renewScript = null;
    private String unsubscribeScript = null;
    private ScriptSetting takeOverScript = null;
    private NotificationSetting changeSubscriptionStatusNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceCurrencyUsagePriority currencyUsagePriority,
        Boolean sharedFreeCurrency,
        PlatformSetting platformSetting,
        NamespaceOptions options
    ) {
        super(
            "Money2_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.currencyUsagePriority = currencyUsagePriority;
        this.sharedFreeCurrency = sharedFreeCurrency;
        this.platformSetting = platformSetting;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.depositBalanceScript = options.depositBalanceScript;
        this.withdrawBalanceScript = options.withdrawBalanceScript;
        this.verifyReceiptScript = options.verifyReceiptScript;
        this.subscribeScript = options.subscribeScript;
        this.renewScript = options.renewScript;
        this.unsubscribeScript = options.unsubscribeScript;
        this.takeOverScript = options.takeOverScript;
        this.changeSubscriptionStatusNotification = options.changeSubscriptionStatusNotification;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        NamespaceCurrencyUsagePriority currencyUsagePriority,
        Boolean sharedFreeCurrency,
        PlatformSetting platformSetting
    ) {
        super(
            "Money2_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.currencyUsagePriority = currencyUsagePriority;
        this.sharedFreeCurrency = sharedFreeCurrency;
        this.platformSetting = platformSetting;
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
        return "GS2::Money2::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.currencyUsagePriority != null) {
            properties.put("CurrencyUsagePriority", this.currencyUsagePriority);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.sharedFreeCurrency != null) {
            properties.put("SharedFreeCurrency", this.sharedFreeCurrency);
        }
        if (this.platformSetting != null) {
            properties.put("PlatformSetting", this.platformSetting.properties(
            ));
        }
        if (this.depositBalanceScript != null) {
            properties.put("DepositBalanceScript", this.depositBalanceScript.properties(
            ));
        }
        if (this.withdrawBalanceScript != null) {
            properties.put("WithdrawBalanceScript", this.withdrawBalanceScript.properties(
            ));
        }
        if (this.verifyReceiptScript != null) {
            properties.put("VerifyReceiptScript", this.verifyReceiptScript.properties(
            ));
        }
        if (this.subscribeScript != null) {
            properties.put("SubscribeScript", this.subscribeScript);
        }
        if (this.renewScript != null) {
            properties.put("RenewScript", this.renewScript);
        }
        if (this.unsubscribeScript != null) {
            properties.put("UnsubscribeScript", this.unsubscribeScript);
        }
        if (this.takeOverScript != null) {
            properties.put("TakeOverScript", this.takeOverScript.properties(
            ));
        }
        if (this.changeSubscriptionStatusNotification != null) {
            properties.put("ChangeSubscriptionStatusNotification", this.changeSubscriptionStatusNotification.properties(
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
        List<StoreContentModel> storeContentModels,
        List<StoreSubscriptionContentModel> storeSubscriptionContentModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            storeContentModels,
            storeSubscriptionContentModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
