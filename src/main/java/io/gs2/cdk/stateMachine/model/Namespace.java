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
 *
 * deny overwrite
 */
package io.gs2.cdk.stateMachine.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.stateMachine.integration.StateMachineDefinition;
import io.gs2.cdk.stateMachine.ref.NamespaceRef;

import io.gs2.cdk.stateMachine.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private ScriptSetting startScript = null;
    private ScriptSetting passScript = null;
    private ScriptSetting errorScript = null;
    private Long lowestStateMachineVersion = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "StateMachine_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.startScript = options.startScript;
        this.passScript = options.passScript;
        this.errorScript = options.errorScript;
        this.lowestStateMachineVersion = options.lowestStateMachineVersion;
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
            "StateMachine_Namespace_" + name
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
        return "GS2::StateMachine::Namespace";
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
        if (this.startScript != null) {
            properties.put("StartScript", this.startScript.properties(
            ));
        }
        if (this.passScript != null) {
            properties.put("PassScript", this.passScript.properties(
            ));
        }
        if (this.errorScript != null) {
            properties.put("ErrorScript", this.errorScript.properties(
            ));
        }
        if (this.lowestStateMachineVersion != null) {
            properties.put("LowestStateMachineVersion", this.lowestStateMachineVersion);
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

    public void stateMachine(
            io.gs2.cdk.script.model.Namespace scriptNamespace,
            StateMachineDefinition definition
    ) {
        definition.appendScripts(
                stack,
                scriptNamespace
        );
        new io.gs2.cdk.stateMachine.model.StateMachineMaster(
                stack,
                name,
                definition.stateMachineName,
                definition.gsl().replace("{scriptNamespaceName}", scriptNamespace.getName())
        ).addDependsOn(
                this
        );
    }

}
