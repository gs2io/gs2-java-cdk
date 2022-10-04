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
 */

package io.gs2.cdk;

import io.gs2.cdk.identifier.ref.*;

public class Identifier {

    public static UserRef user(
            String userName
    ) {
        return new UserRef(
            userName
        );
    }

    public static SecurityPolicyRef securityPolicy(
            String securityPolicyName
    ) {
        return new SecurityPolicyRef(
            securityPolicyName
        );
    }
}