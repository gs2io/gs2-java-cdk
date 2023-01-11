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
import io.gs2.cdk.identifier.model.options.AttachSecurityPolicyOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AttachSecurityPolicy extends CdkResource {

    Stack stack;
    String userName;
    String securityPolicyId;

    public AttachSecurityPolicy(
            Stack stack,
            String userName,
            String securityPolicyId
    ) {
        super("Identifier_AttachSecurityPolicy_" + userName);
        this.stack = stack;
        this.userName = userName;
        this.securityPolicyId = securityPolicyId;
    }

    @Override
    public String resourceType() {
        return "GS2::Identifier::AttachSecurityPolicy";
    }

    @Override
    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.userName != null) {
            properties.put("UserName", this.userName);
        }
        if (this.securityPolicyId != null) {
            properties.put("SecurityPolicyId", this.securityPolicyId);
        }
        return properties;
    }
}