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
package io.gs2.cdk.formation.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.formation.ref.FormModelRef;
import io.gs2.cdk.formation.stampSheet.AddMoldCapacityByUserId;
import io.gs2.cdk.formation.stampSheet.SetMoldCapacityByUserId;
import io.gs2.cdk.formation.stampSheet.AcquireActionsToFormProperties;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.formation.model.AcquireActionConfig;
import io.gs2.cdk.formation.stampSheet.SubMoldCapacityByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoldModelRef {
    private String namespaceName;
    private String moldModelName;

    public MoldModelRef(
        String namespaceName,
        String moldModelName
    ) {
        this.namespaceName = namespaceName;
        this.moldModelName = moldModelName;
    }

    public FormModelRef formModel(
        String formModelName
    ) {
        return (new FormModelRef(
            this.namespaceName,
            this.moldModelName,
            formModelName
        ));
    }

    public AddMoldCapacityByUserId addMoldCapacity(
        String moldName,
        Integer capacity,
        String userId
    ) {
        return (new AddMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
            userId
        ));
    }


    public AddMoldCapacityByUserId addMoldCapacity(
        String moldName,
        Integer capacity
    ) {
        return (new AddMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
            "#{userId}"
        ));
    }

    public SetMoldCapacityByUserId setMoldCapacity(
        String moldName,
        Integer capacity,
        String userId
    ) {
        return (new SetMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
            userId
        ));
    }


    public SetMoldCapacityByUserId setMoldCapacity(
        String moldName,
        Integer capacity
    ) {
        return (new SetMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
            "#{userId}"
        ));
    }

    public AcquireActionsToFormProperties acquireActionsToFormProperties(
        String moldName,
        Integer index,
        AcquireAction acquireAction,
        List<AcquireActionConfig> config,
        String userId
    ) {
        return (new AcquireActionsToFormProperties(
            this.namespaceName,
            moldName,
            index,
            acquireAction,
            config,
            userId
        ));
    }


    public AcquireActionsToFormProperties acquireActionsToFormProperties(
        String moldName,
        Integer index,
        AcquireAction acquireAction,
        List<AcquireActionConfig> config
    ) {
        return (new AcquireActionsToFormProperties(
            this.namespaceName,
            moldName,
            index,
            acquireAction,
            config,
            "#{userId}"
        ));
    }

    public SubMoldCapacityByUserId subMoldCapacity(
        String moldName,
        Integer capacity,
        String userId
    ) {
        return (new SubMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
            userId
        ));
    }


    public SubMoldCapacityByUserId subMoldCapacity(
        String moldName,
        Integer capacity
    ) {
        return (new SubMoldCapacityByUserId(
            this.namespaceName,
            moldName,
            capacity,
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
                "formation",
                this.namespaceName,
                "model",
                "mold",
                this.moldModelName
            )
        )).str(
        );
    }
}
