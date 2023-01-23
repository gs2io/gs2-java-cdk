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
package io.gs2.cdk.money.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.money.ref.NamespaceRef;
import io.gs2.cdk.money.model.enums.NamespacePriority;
import io.gs2.cdk.money.model.enums.NamespaceCurrency;

import io.gs2.cdk.money.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private NamespacePriority priority;
    private Boolean shareFree;
    private NamespaceCurrency currency;
    private String description = null;
    private String appleKey = null;
    private String googleKey = null;
    private Boolean enableFakeReceipt = null;
    private ScriptSetting createWalletScript = null;
    private ScriptSetting depositScript = null;
    private ScriptSetting withdrawScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespacePriority priority,
        Boolean shareFree,
        NamespaceCurrency currency,
        NamespaceOptions options
    ) {
        super(
            "Money_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.priority = priority;
        this.shareFree = shareFree;
        this.currency = currency;
        this.description = options.description;
        this.appleKey = options.appleKey;
        this.googleKey = options.googleKey;
        this.enableFakeReceipt = options.enableFakeReceipt;
        this.createWalletScript = options.createWalletScript;
        this.depositScript = options.depositScript;
        this.withdrawScript = options.withdrawScript;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        NamespacePriority priority,
        Boolean shareFree,
        NamespaceCurrency currency
    ) {
        super(
            "Money_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.priority = priority;
        this.shareFree = shareFree;
        this.currency = currency;
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
        return "GS2::Money::Namespace";
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
        if (this.priority != null) {
            properties.put("Priority", this.priority);
        }
        if (this.shareFree != null) {
            properties.put("ShareFree", this.shareFree);
        }
        if (this.currency != null) {
            properties.put("Currency", this.currency);
        }
        if (this.appleKey != null) {
            properties.put("AppleKey", this.appleKey);
        }
        if (this.googleKey != null) {
            properties.put("GoogleKey", this.googleKey);
        }
        if (this.enableFakeReceipt != null) {
            properties.put("EnableFakeReceipt", this.enableFakeReceipt);
        }
        if (this.createWalletScript != null) {
            properties.put("CreateWalletScript", this.createWalletScript.properties(
            ));
        }
        if (this.depositScript != null) {
            properties.put("DepositScript", this.depositScript.properties(
            ));
        }
        if (this.withdrawScript != null) {
            properties.put("WithdrawScript", this.withdrawScript.properties(
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
            null,
            null,
            "Item.NamespaceId"
        ));
    }
}
