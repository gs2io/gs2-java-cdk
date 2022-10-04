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

package io.gs2.cdk.inbox.stampSheet;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.inbox.ref.*;
import io.gs2.cdk.inbox.model.*;

import java.util.*;
import java.util.stream.*;


public class OpenMessageByUserId extends ConsumeAction {

    public OpenMessageByUserId(
            String namespaceName,
            String userId,
            String messageName
    ) {
        super(
            "Gs2Inbox:OpenMessageByUserId",
            new HashMap<String, Object>() {
                {
                    if (namespaceName != null) {
                        put("namespaceName", namespaceName);
                    }
                    if (userId != null) {
                        put("userId", userId);
                    }
                    if (messageName != null) {
                        put("messageName", messageName);
                    }
                }
            }
        );
    }
}
