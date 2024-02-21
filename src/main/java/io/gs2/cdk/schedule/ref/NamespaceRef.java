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
package io.gs2.cdk.schedule.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.schedule.stampSheet.TriggerByUserId;
import io.gs2.cdk.schedule.stampSheet.DeleteTriggerByUserId;
import io.gs2.cdk.schedule.stampSheet.VerifyEventByUserId;
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

    public TriggerByUserId trigger(
        String triggerName,
        String triggerStrategy,
        Integer ttl,
        String userId
    ) {
        return (new TriggerByUserId(
            this.namespaceName,
            triggerName,
            triggerStrategy,
            ttl,
            userId
        ));
    }


    public TriggerByUserId trigger(
        String triggerName,
        String triggerStrategy,
        Integer ttl
    ) {
        return (new TriggerByUserId(
            this.namespaceName,
            triggerName,
            triggerStrategy,
            ttl,
            "#{userId}"
        ));
    }

    public DeleteTriggerByUserId deleteTrigger(
        String triggerName,
        String userId
    ) {
        return (new DeleteTriggerByUserId(
            this.namespaceName,
            triggerName,
            userId
        ));
    }


    public DeleteTriggerByUserId deleteTrigger(
        String triggerName
    ) {
        return (new DeleteTriggerByUserId(
            this.namespaceName,
            triggerName,
            "#{userId}"
        ));
    }

    public VerifyEventByUserId verifyEvent(
        String eventName,
        String verifyType,
        String userId
    ) {
        return (new VerifyEventByUserId(
            this.namespaceName,
            eventName,
            verifyType,
            userId
        ));
    }


    public VerifyEventByUserId verifyEvent(
        String eventName,
        String verifyType
    ) {
        return (new VerifyEventByUserId(
            this.namespaceName,
            eventName,
            verifyType,
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
                "schedule",
                this.namespaceName
            )
        )).str(
        );
    }
}
