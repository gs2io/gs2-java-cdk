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

import io.gs2.cdk.stateMachine.ref.StateMachineMasterRef;

import io.gs2.cdk.stateMachine.model.options.StateMachineMasterOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StateMachineMaster extends CdkResource {
    private Stack stack;
    private String namespaceName;
    private String mainStateMachineName;
    private String payload;

    public StateMachineMaster(
        Stack stack,
        String namespaceName,
        String mainStateMachineName,
        String payload,
        StateMachineMasterOptions options
    ) {
        super(
            "StateMachine_StateMachineMaster_" + namespaceName
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.mainStateMachineName = mainStateMachineName;
        this.payload = payload;
        stack.addResource(
            this
        );
    }

    public StateMachineMaster(
        Stack stack,
        String namespaceName,
        String mainStateMachineName,
        String payload
    ) {
        super(
            "StateMachine_StateMachineMaster_" + namespaceName
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.mainStateMachineName = mainStateMachineName;
        this.payload = payload;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "version";
    }

    public String resourceType(
    ) {
        return "GS2::StateMachine::StateMachineMaster";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.mainStateMachineName != null) {
            properties.put("MainStateMachineName", this.mainStateMachineName);
        }
        if (this.payload != null) {
            properties.put("Payload", this.payload);
        }

        return properties;
    }

    public StateMachineMasterRef ref(
        Long version
    ) {
        return (new StateMachineMasterRef(
            this.namespaceName,
            version
        ));
    }

    public GetAttr getAttrStateMachineId(
    ) {
        return (new GetAttr(
            null,
            null,
            "Item.StateMachineId"
        ));
    }
}
