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
package io.gs2.cdk.identifier.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.guard.model.Namespace;
import io.gs2.cdk.identifier.ref.IdentifierRef;

import io.gs2.cdk.identifier.model.options.IdentifierOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Identifier extends CdkResource {
    private Stack stack;
    private String userName;

    public Identifier(
        Stack stack,
        String userName,
        IdentifierOptions options
    ) {
        super(
            "Identifier_Identifier_" + userName
        );

        this.stack = stack;
        this.userName = userName;
        stack.addResource(
            this
        );
    }

    public Identifier(
        Stack stack,
        String userName
    ) {
        super(
            "Identifier_Identifier_" + userName
        );

        this.stack = stack;
        this.userName = userName;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "userName";
    }

    public String resourceType(
    ) {
        return "GS2::Identifier::Identifier";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.userName != null) {
            properties.put("UserName", this.userName);
        }

        return properties;
    }

    public IdentifierRef ref(
        String clientId
    ) {
        return (new IdentifierRef(
            this.userName,
            clientId
        ));
    }

    public Identifier attach(
        Namespace guardNamespace
    ) {
        (new AttachGuard(
            this.stack,
            this.userName,
            this.getAttrClientId().str(),
            guardNamespace.getAttrNamespaceId(
            ).str(
            )
        )).addDependsOn(
            this
        ).addDependsOn(
            guardNamespace
        );

        return this;
    }

    public Identifier attachGrn(
        String guardNamespaceGrn
    ) {
        (new AttachGuard(
            this.stack,
            this.userName,
            this.getAttrClientId().str(),
            guardNamespaceGrn
        )).addDependsOn(
            this
        );

        return this;
    }

    public GetAttr getAttrClientId(
    ) {
        return (new GetAttr(
            this,
            "Item.ClientId",
            null
        ));
    }


    public GetAttr getAttrClientSecret(
    ) {
        return (new GetAttr(
            this,
            "ClientSecret",
            null
        ));
    }
}
