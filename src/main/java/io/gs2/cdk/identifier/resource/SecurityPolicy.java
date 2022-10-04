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


public class SecurityPolicy extends CdkResource {

    Stack stack;
    String name;
    String description;
    Policy policy;

    public SecurityPolicy(
            Stack stack,
            String name,
            Policy policy
    ) {
        super("Identifier_SecurityPolicy_" + name);

        this.stack = stack;
        this.name = name;
        this.policy = policy;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Identifier::SecurityPolicy";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.policy != null) {
            properties.put("Policy", this.policy.properties());
        }
        return properties;
    }

    public SecurityPolicyRef ref(
    ) {
        return new SecurityPolicyRef(
            this.name
        );
    }

    public GetAttr getAttrSecurityPolicyId() {
        return new GetAttr(
            "Item.SecurityPolicyId"
        );
    }
}
