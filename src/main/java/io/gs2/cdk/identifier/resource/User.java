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
 *
 * deny overwrite
 */

package io.gs2.cdk.identifier.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.identifier.ref.*;
import io.gs2.cdk.identifier.model.*;

import java.util.*;


public class User extends CdkResource {

    Stack stack;
    String name;
    String description;

    public User(
            Stack stack,
            String name
    ) {
        super("Identifier_User_" + name);

        this.stack = stack;
        this.name = name;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Identifier::User";
    }

    public Map<String, Object> properties() {
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
        return new UserRef(
            this.name
        );
    }

    public User attach(
            SecurityPolicy securityPolicy
    ) {
        new AttachSecurityPolicy(
                this.stack,
                this.name,
                securityPolicy.getAttrSecurityPolicyId().str()
        ).addDependsOn(
                this
        ).addDependsOn(
                securityPolicy
        );
        return this;
    }

    public Identifier identifier() {
        return (Identifier) new Identifier(
                this.stack,
                this.name
        ).addDependsOn(
                this
        );
    }

    public GetAttr getAttrUserId() {
        return new GetAttr(
            "Item.UserId"
        );
    }
}
