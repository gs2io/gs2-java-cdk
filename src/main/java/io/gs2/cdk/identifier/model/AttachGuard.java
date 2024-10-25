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
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AttachGuard extends CdkResource {

    Stack stack;
    String userName;
    String clientId;
    String guardNamespaceId;

    public AttachGuard(
            Stack stack,
            String userName,
            String clientId,
            String guardNamespaceId
    ) {
        super("Identifier_AttachGuard_" + userName);
        this.stack = stack;
        this.userName = userName;
        this.clientId = clientId;
        this.guardNamespaceId = guardNamespaceId;
    }

    @Override
    public String resourceType() {
        return "GS2::Identifier::AttachGuard";
    }

    @Override
    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.userName != null) {
            properties.put("UserName", this.userName);
        }
        if (this.clientId != null) {
            properties.put("ClientId", this.clientId);
        }
        if (this.guardNamespaceId != null) {
            properties.put("GuardId", this.guardNamespaceId);
        }
        return properties;
    }
}