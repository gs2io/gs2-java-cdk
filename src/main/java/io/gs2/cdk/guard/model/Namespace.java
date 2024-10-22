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
package io.gs2.cdk.guard.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.guard.model.BlockingPolicyModel;

import io.gs2.cdk.guard.ref.NamespaceRef;
import io.gs2.cdk.guard.model.enums.NamespaceStatus;

import io.gs2.cdk.guard.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private BlockingPolicyModel blockingPolicy;
    private String description = null;

    public Namespace(
        Stack stack,
        String name,
        BlockingPolicyModel blockingPolicy,
        NamespaceOptions options
    ) {
        super(
            "Guard_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.blockingPolicy = blockingPolicy;
        this.description = options.description;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        BlockingPolicyModel blockingPolicy
    ) {
        super(
            "Guard_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.blockingPolicy = blockingPolicy;
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
        return "GS2::Guard::Namespace";
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
        if (this.blockingPolicy != null) {
            properties.put("BlockingPolicy", this.blockingPolicy.properties(
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
}
