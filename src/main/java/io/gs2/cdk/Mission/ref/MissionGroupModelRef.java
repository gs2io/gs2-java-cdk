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
package io.gs2.cdk.mission.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.mission.ref.MissionTaskModelRef;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissionGroupModelRef {
    private String namespaceName;
    private String missionGroupName;

    public MissionGroupModelRef(
        String namespaceName,
        String missionGroupName
    ) {
        this.namespaceName = namespaceName;
        this.missionGroupName = missionGroupName;
    }

    public MissionTaskModelRef missionTaskModel(
        String missionTaskName
    ) {
        return (new MissionTaskModelRef(
            this.namespaceName,
            this.missionGroupName,
            missionTaskName
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
                "mission",
                this.namespaceName,
                "group",
                this.missionGroupName
            )
        )).str(
        );
    }
}
