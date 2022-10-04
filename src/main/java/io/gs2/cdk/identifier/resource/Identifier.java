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


public class Identifier extends CdkResource {

    Stack stack;
    String userName;

    public Identifier(
            Stack stack,
            String userName
    ) {
        super("Identifier_Identifier_");

        this.stack = stack;
        this.userName = userName;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Identifier::Identifier";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.userName != null) {
            properties.put("UserName", this.userName);
        }
        return properties;
    }

    public GetAttr getAttrClientId() {
        return new GetAttr(
                "Item.ClientId"
        );
    }

    public GetAttr getAttrClientSecret() {
        return new GetAttr(
                "ClientSecret"
        );
    }
}
