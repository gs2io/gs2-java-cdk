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

package io.gs2.cdk.exchange.stampSheet;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.exchange.ref.*;
import io.gs2.cdk.exchange.model.*;

import java.util.*;
import java.util.stream.*;


public class ExchangeByUserId extends AcquireAction {

    public ExchangeByUserId(
            String namespaceName,
            String rateName,
            String userId,
            Integer count,
            List<Config> config
    ) {
        super(
            "Gs2Exchange:ExchangeByUserId",
            new HashMap<String, Object>() {
                {
                    if (namespaceName != null) {
                        put("namespaceName", namespaceName);
                    }
                    if (rateName != null) {
                        put("rateName", rateName);
                    }
                    if (userId != null) {
                        put("userId", userId);
                    }
                    if (count != null) {
                        put("count", count);
                    }
                    if (config != null) {
                        put("config", config);
                    }
                }
            }
        );
    }
}
