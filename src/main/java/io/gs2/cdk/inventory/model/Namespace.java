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
package io.gs2.cdk.inventory.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.inventory.ref.NamespaceRef;
import io.gs2.cdk.inventory.model.CurrentMasterData;
import io.gs2.cdk.inventory.model.InventoryModel;
import io.gs2.cdk.inventory.model.SimpleInventoryModel;
import io.gs2.cdk.inventory.model.BigInventoryModel;

import io.gs2.cdk.inventory.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private ScriptSetting acquireScript = null;
    private ScriptSetting overflowScript = null;
    private ScriptSetting consumeScript = null;
    private ScriptSetting simpleItemAcquireScript = null;
    private ScriptSetting simpleItemConsumeScript = null;
    private ScriptSetting bigItemAcquireScript = null;
    private ScriptSetting bigItemConsumeScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Inventory_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.acquireScript = options.acquireScript;
        this.overflowScript = options.overflowScript;
        this.consumeScript = options.consumeScript;
        this.simpleItemAcquireScript = options.simpleItemAcquireScript;
        this.simpleItemConsumeScript = options.simpleItemConsumeScript;
        this.bigItemAcquireScript = options.bigItemAcquireScript;
        this.bigItemConsumeScript = options.bigItemConsumeScript;
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
            "Inventory_Namespace_" + name
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
        return "GS2::Inventory::Namespace";
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
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.acquireScript != null) {
            properties.put("AcquireScript", this.acquireScript.properties(
            ));
        }
        if (this.overflowScript != null) {
            properties.put("OverflowScript", this.overflowScript.properties(
            ));
        }
        if (this.consumeScript != null) {
            properties.put("ConsumeScript", this.consumeScript.properties(
            ));
        }
        if (this.simpleItemAcquireScript != null) {
            properties.put("SimpleItemAcquireScript", this.simpleItemAcquireScript.properties(
            ));
        }
        if (this.simpleItemConsumeScript != null) {
            properties.put("SimpleItemConsumeScript", this.simpleItemConsumeScript.properties(
            ));
        }
        if (this.bigItemAcquireScript != null) {
            properties.put("BigItemAcquireScript", this.bigItemAcquireScript.properties(
            ));
        }
        if (this.bigItemConsumeScript != null) {
            properties.put("BigItemConsumeScript", this.bigItemConsumeScript.properties(
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
        List<InventoryModel> inventoryModels,
        List<SimpleInventoryModel> simpleInventoryModels,
        List<BigInventoryModel> bigInventoryModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            inventoryModels,
            simpleInventoryModels,
            bigInventoryModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
