/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.money.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.money.ref.*;
import io.gs2.cdk.money.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String name;
    public String description;
    public String priority;
    public Boolean shareFree;
    public String currency;
    public String appleKey;
    public String googleKey;
    public Boolean enableFakeReceipt;
    public ScriptSetting createWalletScript;
    public ScriptSetting depositScript;
    public ScriptSetting withdrawScript;
    public LogSetting logSetting;

    public Namespace(
            Stack stack,
            String name,
            String priority,
            Boolean shareFree,
            String currency,
            Boolean enableFakeReceipt
    ) {
        super("Money_Namespace_" + name);

        this.stack = stack;
        this.name = name;
        this.priority = priority;
        this.shareFree = shareFree;
        this.currency = currency;
        this.enableFakeReceipt = enableFakeReceipt;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Money::Namespace";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.priority != null) {
            properties.put("Priority", this.priority.toString());
        }
        if (this.shareFree != null) {
            properties.put("ShareFree", this.shareFree);
        }
        if (this.currency != null) {
            properties.put("Currency", this.currency.toString());
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
            properties.put("CreateWalletScript", this.createWalletScript.properties());
        }
        if (this.depositScript != null) {
            properties.put("DepositScript", this.depositScript.properties());
        }
        if (this.withdrawScript != null) {
            properties.put("WithdrawScript", this.withdrawScript.properties());
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties());
        }
        return properties;
    }

    public NamespaceRef ref(
    ) {
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }
}
