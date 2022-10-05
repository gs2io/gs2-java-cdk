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

package io.gs2.cdk.experience.stampSheet;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.experience.ref.*;
import io.gs2.cdk.experience.model.*;

import java.util.*;
import java.util.stream.*;


public class AddRankCapByUserId extends AcquireAction {

    public AddRankCapByUserId(
            String namespaceName,
            String userId,
            String experienceName,
            String propertyId,
            Long rankCapValue
    ) {
        super(
            "Gs2Experience:AddRankCapByUserId",
            new HashMap<String, Object>() {
                {
                    if (namespaceName != null) {
                        put("namespaceName", namespaceName);
                    }
                    if (userId != null) {
                        put("userId", userId);
                    }
                    if (experienceName != null) {
                        put("experienceName", experienceName);
                    }
                    if (propertyId != null) {
                        put("propertyId", propertyId);
                    }
                    if (rankCapValue != null) {
                        put("rankCapValue", rankCapValue);
                    }
                }
            }
        );
    }
}
