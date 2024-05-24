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
import io.gs2.cdk.formation.ref.MoldModelRef;
import io.gs2.cdk.formation.ref.PropertyFormModelRef;
import io.gs2.cdk.formation.stampSheet.AddMoldCapacityByUserId;
import io.gs2.cdk.formation.stampSheet.SetMoldCapacityByUserId;
import io.gs2.cdk.formation.stampSheet.AcquireActionsToFormProperties;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.core.model.Config;
import io.gs2.cdk.formation.stampSheet.SetFormByUserId;
import io.gs2.cdk.formation.model.Slot;
import io.gs2.cdk.formation.stampSheet.AcquireActionsToPropertyFormProperties;
import io.gs2.cdk.formation.stampSheet.SubMoldCapacityByUserId;
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

    public MoldModelRef moldModel(
        String moldModelName
    ) {
        return (new MoldModelRef(
            this.namespaceName,
            moldModelName
        ));
    }

    public PropertyFormModelRef propertyFormModel(
        String propertyFormModelName
    ) {
        return (new PropertyFormModelRef(
            this.namespaceName,
            propertyFormModelName
        ));
    }

    public AddMoldCapacityByUserId addMoldCapacity(
        String moldModelName,
        Integer capacity,
        String userId
    ) {
        return (new AddMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
            capacity,
            userId
        ));
    }


    public AddMoldCapacityByUserId addMoldCapacity(
        String moldModelName,
        Integer capacity
    ) {
        return (new AddMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
            capacity,
            "#{userId}"
        ));
    }

    public SetMoldCapacityByUserId setMoldCapacity(
        String moldModelName,
        Integer capacity,
        String userId
    ) {
        return (new SetMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
            capacity,
            userId
        ));
    }


    public SetMoldCapacityByUserId setMoldCapacity(
        String moldModelName,
        Integer capacity
    ) {
        return (new SetMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
            capacity,
            "#{userId}"
        ));
    }

    public AcquireActionsToFormProperties acquireActionsToFormProperties(
        String moldModelName,
        Integer index,
        AcquireAction acquireAction,
        List<Config> config,
        String userId
    ) {
        return (new AcquireActionsToFormProperties(
            this.namespaceName,
            moldModelName,
            index,
            acquireAction,
            config,
            userId
        ));
    }


    public AcquireActionsToFormProperties acquireActionsToFormProperties(
        String moldModelName,
        Integer index,
        AcquireAction acquireAction,
        List<Config> config
    ) {
        return (new AcquireActionsToFormProperties(
            this.namespaceName,
            moldModelName,
            index,
            acquireAction,
            config,
            "#{userId}"
        ));
    }

    public SetFormByUserId setForm(
        String moldModelName,
        Integer index,
        List<Slot> slots,
        String userId
    ) {
        return (new SetFormByUserId(
            this.namespaceName,
            moldModelName,
            index,
            slots,
            userId
        ));
    }


    public SetFormByUserId setForm(
        String moldModelName,
        Integer index,
        List<Slot> slots
    ) {
        return (new SetFormByUserId(
            this.namespaceName,
            moldModelName,
            index,
            slots,
            "#{userId}"
        ));
    }

    public AcquireActionsToPropertyFormProperties acquireActionsToPropertyFormProperties(
        String propertyFormModelName,
        String propertyId,
        AcquireAction acquireAction,
        List<Config> config,
        String userId
    ) {
        return (new AcquireActionsToPropertyFormProperties(
            this.namespaceName,
            propertyFormModelName,
            propertyId,
            acquireAction,
            config,
            userId
        ));
    }


    public AcquireActionsToPropertyFormProperties acquireActionsToPropertyFormProperties(
        String propertyFormModelName,
        String propertyId,
        AcquireAction acquireAction,
        List<Config> config
    ) {
        return (new AcquireActionsToPropertyFormProperties(
            this.namespaceName,
            propertyFormModelName,
            propertyId,
            acquireAction,
            config,
            "#{userId}"
        ));
    }

    public SubMoldCapacityByUserId subMoldCapacity(
        String moldModelName,
        Integer capacity,
        String userId
    ) {
        return (new SubMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
            capacity,
            userId
        ));
    }


    public SubMoldCapacityByUserId subMoldCapacity(
        String moldModelName,
        Integer capacity
    ) {
        return (new SubMoldCapacityByUserId(
            this.namespaceName,
            moldModelName,
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
                this.namespaceName
            )
        )).str(
        );
    }
}
