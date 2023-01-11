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
package io.gs2.cdk.identifier.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.identifier.model.Identifier;
import io.gs2.cdk.identifier.model.AttachSecurityPolicy;
import io.gs2.cdk.identifier.model.SecurityPolicy;

import io.gs2.cdk.identifier.ref.UserRef;

import io.gs2.cdk.identifier.model.options.UserOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class User extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;

    public User(
        Stack stack,
        String name,
        UserOptions options
    ) {
        super(
            "Identifier_User_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        stack.addResource(
            this
        );
    }

    public User(
        Stack stack,
        String name
    ) {
        super(
            "Identifier_User_" + name
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
        return "GS2::Identifier::User";
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

        return properties;
    }

    public UserRef ref(
    ) {
        return (new UserRef(
            this.name
        ));
    }


    public User attach(
        SecurityPolicy securityPolicy
    ) {
        (new AttachSecurityPolicy(
            this.stack,
            this.name,
            securityPolicy.getAttrSecurityPolicyId(
            ).str(
            )
        )).addDependsOn(
            this
        ).addDependsOn(
            securityPolicy
        );

        return this;
    }

    public User attachGrn(
        String securityPolicyGrn
    ) {
        (new AttachSecurityPolicy(
            this.stack,
            this.name,
            securityPolicyGrn
        )).addDependsOn(
            this
        );

        return this;
    }

    public Identifier identifier(
    ) {
        var identifier = (new Identifier(
            this.stack,
            this.name
        ));
        identifier.addDependsOn(
            this
        );

        return identifier;
    }

    public GetAttr getAttrUserId(
    ) {
        return (new GetAttr(
            null,
            null,
            "Item.UserId"
        ));
    }
}
