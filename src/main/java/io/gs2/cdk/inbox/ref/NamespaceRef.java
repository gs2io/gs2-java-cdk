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
package io.gs2.cdk.inbox.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.inbox.ref.GlobalMessageRef;
import io.gs2.cdk.inbox.stampSheet.SendMessageByUserId;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.inbox.model.TimeSpan;
import io.gs2.cdk.inbox.stampSheet.OpenMessageByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceRef {
    private String namespaceName;

    public NamespaceRef(
        String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public GlobalMessageRef globalMessage(
        String globalMessageName
    ) {
        return (new GlobalMessageRef(
            this.namespaceName,
            globalMessageName
        ));
    }

    public SendMessageByUserId sendMessage(
        String metadata,
        List<AcquireAction> readAcquireActions,
        Long expiresAt,
        TimeSpan expiresTimeSpan,
        String userId
    ) {
        return (new SendMessageByUserId(
            this.namespaceName,
            metadata,
            readAcquireActions,
            expiresAt,
            expiresTimeSpan,
            userId
        ));
    }


    public SendMessageByUserId sendMessage(
        String metadata,
        List<AcquireAction> readAcquireActions,
        Long expiresAt,
        TimeSpan expiresTimeSpan
    ) {
        return (new SendMessageByUserId(
            this.namespaceName,
            metadata,
            readAcquireActions,
            expiresAt,
            expiresTimeSpan,
            "#{userId}"
        ));
    }

    public OpenMessageByUserId openMessage(
        String messageName,
        String userId
    ) {
        return (new OpenMessageByUserId(
            this.namespaceName,
            messageName,
            userId
        ));
    }


    public OpenMessageByUserId openMessage(
        String messageName
    ) {
        return (new OpenMessageByUserId(
            this.namespaceName,
            messageName,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "inbox",
                this.namespaceName
            )
        )).str(
        );
    }
}
