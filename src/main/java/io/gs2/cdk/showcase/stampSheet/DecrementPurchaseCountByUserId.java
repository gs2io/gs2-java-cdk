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
package io.gs2.cdk.showcase.stampSheet;

import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.VerifyAction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DecrementPurchaseCountByUserId extends AcquireAction {

    public DecrementPurchaseCountByUserId(
        String namespaceName,
        String showcaseName,
        String displayItemName,
        Integer count,
        String userId
    ) {
        super(
            "Gs2Showcase:DecrementPurchaseCountByUserId",
            new HashMap<>() {
                {
                    put("namespaceName", namespaceName);
                    put("showcaseName", showcaseName);
                    put("displayItemName", displayItemName);
                    put("count", count);
                    put("userId", userId);
                }
            }
        );
    }
}
