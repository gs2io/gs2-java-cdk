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

package io.gs2.cdk.inbox.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.inbox.model.*;
import io.gs2.cdk.inbox.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class NamespaceRef {
    public String namespaceName;

    public NamespaceRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public CurrentMessageMasterRef currentMessageMaster(
    ) {
        return new CurrentMessageMasterRef(
            this.namespaceName
        );
    }

    public GlobalMessageRef globalMessage(
            String globalMessageName
    ) {
        return new GlobalMessageRef(
            this.namespaceName,
            globalMessageName
        );
    }

    public GlobalMessageMasterRef globalMessageMaster(
            String globalMessageName
    ) {
        return new GlobalMessageMasterRef(
            this.namespaceName,
            globalMessageName
        );
    }

    public SendMessageByUserId sendMessage(
            String metadata,
            List<AcquireAction> readAcquireActions,
            Long expiresAt,
            TimeSpan expiresTimeSpan
    ) {
        return new SendMessageByUserId(
            this.namespaceName,
            "#{userId}",
            metadata,
            readAcquireActions,
            expiresAt,
            expiresTimeSpan
        );
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "inbox",
                this.namespaceName
            )
        ).str();
    }
}
