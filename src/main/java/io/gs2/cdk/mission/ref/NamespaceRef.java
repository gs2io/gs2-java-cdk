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
import io.gs2.cdk.mission.ref.MissionGroupModelRef;
import io.gs2.cdk.mission.ref.CounterModelRef;
import io.gs2.cdk.mission.stampSheet.RevertReceiveByUserId;
import io.gs2.cdk.mission.stampSheet.IncreaseCounterByUserId;
import io.gs2.cdk.mission.stampSheet.SetCounterByUserId;
import io.gs2.cdk.mission.model.ScopedValue;
import io.gs2.cdk.mission.stampSheet.ReceiveByUserId;
import io.gs2.cdk.mission.stampSheet.DecreaseCounterByUserId;
import io.gs2.cdk.mission.stampSheet.VerifyCompleteByUserId;
import io.gs2.cdk.mission.stampSheet.VerifyCounterValueByUserId;
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

    public MissionGroupModelRef missionGroupModel(
        String missionGroupName
    ) {
        return (new MissionGroupModelRef(
            this.namespaceName,
            missionGroupName
        ));
    }

    public CounterModelRef counterModel(
        String counterName
    ) {
        return (new CounterModelRef(
            this.namespaceName,
            counterName
        ));
    }

    public RevertReceiveByUserId revertReceive(
        String missionGroupName,
        String missionTaskName,
        String userId
    ) {
        return (new RevertReceiveByUserId(
            this.namespaceName,
            missionGroupName,
            missionTaskName,
            userId
        ));
    }


    public RevertReceiveByUserId revertReceive(
        String missionGroupName,
        String missionTaskName
    ) {
        return (new RevertReceiveByUserId(
            this.namespaceName,
            missionGroupName,
            missionTaskName,
            "#{userId}"
        ));
    }

    public IncreaseCounterByUserId increaseCounter(
        String counterName,
        Long value,
        String userId
    ) {
        return (new IncreaseCounterByUserId(
            this.namespaceName,
            counterName,
            value,
            userId
        ));
    }


    public IncreaseCounterByUserId increaseCounter(
        String counterName,
        Long value
    ) {
        return (new IncreaseCounterByUserId(
            this.namespaceName,
            counterName,
            value,
            "#{userId}"
        ));
    }

    public SetCounterByUserId setCounter(
        String counterName,
        List<ScopedValue> values,
        String userId
    ) {
        return (new SetCounterByUserId(
            this.namespaceName,
            counterName,
            values,
            userId
        ));
    }


    public SetCounterByUserId setCounter(
        String counterName,
        List<ScopedValue> values
    ) {
        return (new SetCounterByUserId(
            this.namespaceName,
            counterName,
            values,
            "#{userId}"
        ));
    }

    public ReceiveByUserId receive(
        String missionGroupName,
        String missionTaskName,
        String userId
    ) {
        return (new ReceiveByUserId(
            this.namespaceName,
            missionGroupName,
            missionTaskName,
            userId
        ));
    }


    public ReceiveByUserId receive(
        String missionGroupName,
        String missionTaskName
    ) {
        return (new ReceiveByUserId(
            this.namespaceName,
            missionGroupName,
            missionTaskName,
            "#{userId}"
        ));
    }

    public DecreaseCounterByUserId decreaseCounter(
        String counterName,
        Long value,
        String userId
    ) {
        return (new DecreaseCounterByUserId(
            this.namespaceName,
            counterName,
            value,
            userId
        ));
    }


    public DecreaseCounterByUserId decreaseCounter(
        String counterName,
        Long value
    ) {
        return (new DecreaseCounterByUserId(
            this.namespaceName,
            counterName,
            value,
            "#{userId}"
        ));
    }

    public VerifyCompleteByUserId verifyComplete(
        String missionGroupName,
        String verifyType,
        String missionTaskName,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyCompleteByUserId(
            this.namespaceName,
            missionGroupName,
            verifyType,
            missionTaskName,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyCompleteByUserId verifyComplete(
        String missionGroupName,
        String verifyType,
        String missionTaskName,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyCompleteByUserId(
            this.namespaceName,
            missionGroupName,
            verifyType,
            missionTaskName,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public VerifyCounterValueByUserId verifyCounterValue(
        String counterName,
        String verifyType,
        String resetType,
        Long value,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyCounterValueByUserId(
            this.namespaceName,
            counterName,
            verifyType,
            resetType,
            value,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyCounterValueByUserId verifyCounterValue(
        String counterName,
        String verifyType,
        String resetType,
        Long value,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyCounterValueByUserId(
            this.namespaceName,
            counterName,
            verifyType,
            resetType,
            value,
            multiplyValueSpecifyingQuantity,
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
                "mission",
                this.namespaceName
            )
        )).str(
        );
    }
}
