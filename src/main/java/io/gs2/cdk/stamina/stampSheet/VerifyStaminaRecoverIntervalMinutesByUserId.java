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
package io.gs2.cdk.stamina.stampSheet;

import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.VerifyAction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VerifyStaminaRecoverIntervalMinutesByUserId extends VerifyAction {

    public VerifyStaminaRecoverIntervalMinutesByUserId(
        String namespaceName,
        String staminaName,
        String verifyType,
        Integer value,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        super(
            "Gs2Stamina:VerifyStaminaRecoverIntervalMinutesByUserId",
            new HashMap<>() {
                {
                    put("namespaceName", namespaceName);
                    put("staminaName", staminaName);
                    put("verifyType", verifyType);
                    put("value", value);
                    put("multiplyValueSpecifyingQuantity", multiplyValueSpecifyingQuantity);
                    put("userId", userId);
                }
            }
        );
    }
}
