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
package io.gs2.cdk.enhance.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.enhance.ref.NamespaceRef;
import io.gs2.cdk.enhance.model.CurrentMasterData;
import io.gs2.cdk.enhance.model.RateModel;

import io.gs2.cdk.enhance.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private TransactionSetting transactionSetting;
    private String description = null;
    private Boolean enableDirectEnhance = null;
    private ScriptSetting enhanceScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        TransactionSetting transactionSetting,
        NamespaceOptions options
    ) {
        super(
            "Enhance_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.transactionSetting = transactionSetting;
        this.description = options.description;
        this.enableDirectEnhance = options.enableDirectEnhance;
        this.enhanceScript = options.enhanceScript;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        TransactionSetting transactionSetting
    ) {
        super(
            "Enhance_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.transactionSetting = transactionSetting;
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
        return "GS2::Enhance::Namespace";
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
        if (this.enableDirectEnhance != null) {
            properties.put("EnableDirectEnhance", this.enableDirectEnhance);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.enhanceScript != null) {
            properties.put("EnhanceScript", this.enhanceScript.properties(
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
        List<RateModel> rateModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            rateModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
