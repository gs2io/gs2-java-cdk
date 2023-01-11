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
package io.gs2.cdk.key.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.key.ref.KeyRef;

import io.gs2.cdk.key.model.options.KeyOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Key extends CdkResource {
    private Stack stack;
    private String namespaceName;
    private String name;
    private String description = null;

    public Key(
        Stack stack,
        String namespaceName,
        String name,
        KeyOptions options
    ) {
        super(
            "Key_Key_" + name
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.description = options.description;
        stack.addResource(
            this
        );
    }

    public Key(
        Stack stack,
        String namespaceName,
        String name
    ) {
        super(
            "Key_Key_" + name
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
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
        return "GS2::Key::Key";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }

        return properties;
    }

    public KeyRef ref(
    ) {
        return (new KeyRef(
            this.namespaceName,
            this.name
        ));
    }

    public GetAttr getAttrKeyId(
    ) {
        return (new GetAttr(
            null,
            null,
            "Item.KeyId"
        ));
    }
}
