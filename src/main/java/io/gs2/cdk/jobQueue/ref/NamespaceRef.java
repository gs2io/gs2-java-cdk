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
package io.gs2.cdk.jobQueue.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.jobQueue.stampSheet.PushByUserId;
import io.gs2.cdk.jobQueue.model.JobEntry;
import io.gs2.cdk.jobQueue.stampSheet.DeleteJobByUserId;
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

    public PushByUserId push(
        List<JobEntry> jobs,
        String userId
    ) {
        return (new PushByUserId(
            this.namespaceName,
            jobs,
            userId
        ));
    }


    public PushByUserId push(
        List<JobEntry> jobs
    ) {
        return (new PushByUserId(
            this.namespaceName,
            jobs,
            "#{userId}"
        ));
    }

    public DeleteJobByUserId deleteJob(
        String jobName,
        String userId
    ) {
        return (new DeleteJobByUserId(
            this.namespaceName,
            jobName,
            userId
        ));
    }


    public DeleteJobByUserId deleteJob(
        String jobName
    ) {
        return (new DeleteJobByUserId(
            this.namespaceName,
            jobName,
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
                "queue",
                this.namespaceName
            )
        )).str(
        );
    }
}
