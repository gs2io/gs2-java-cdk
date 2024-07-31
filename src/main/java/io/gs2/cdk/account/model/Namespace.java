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
package io.gs2.cdk.account.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.account.ref.NamespaceRef;
import io.gs2.cdk.account.model.CurrentMasterData;
import io.gs2.cdk.account.model.TakeOverTypeModel;

import io.gs2.cdk.account.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private Boolean changePasswordIfTakeOver = null;
    private Boolean differentUserIdForLoginAndDataRetention = null;
    private ScriptSetting createAccountScript = null;
    private ScriptSetting authenticationScript = null;
    private ScriptSetting createTakeOverScript = null;
    private ScriptSetting doTakeOverScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Account_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.changePasswordIfTakeOver = options.changePasswordIfTakeOver;
        this.differentUserIdForLoginAndDataRetention = options.differentUserIdForLoginAndDataRetention;
        this.createAccountScript = options.createAccountScript;
        this.authenticationScript = options.authenticationScript;
        this.createTakeOverScript = options.createTakeOverScript;
        this.doTakeOverScript = options.doTakeOverScript;
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
            "Account_Namespace_" + name
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
        return "GS2::Account::Namespace";
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
        if (this.changePasswordIfTakeOver != null) {
            properties.put("ChangePasswordIfTakeOver", this.changePasswordIfTakeOver);
        }
        if (this.differentUserIdForLoginAndDataRetention != null) {
            properties.put("DifferentUserIdForLoginAndDataRetention", this.differentUserIdForLoginAndDataRetention);
        }
        if (this.createAccountScript != null) {
            properties.put("CreateAccountScript", this.createAccountScript.properties(
            ));
        }
        if (this.authenticationScript != null) {
            properties.put("AuthenticationScript", this.authenticationScript.properties(
            ));
        }
        if (this.createTakeOverScript != null) {
            properties.put("CreateTakeOverScript", this.createTakeOverScript.properties(
            ));
        }
        if (this.doTakeOverScript != null) {
            properties.put("DoTakeOverScript", this.doTakeOverScript.properties(
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
        List<TakeOverTypeModel> takeOverTypeModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            takeOverTypeModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
