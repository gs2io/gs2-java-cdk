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
package io.gs2.cdk.stamina.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.stamina.ref.StaminaModelRef;
import io.gs2.cdk.stamina.stampSheet.RecoverStaminaByUserId;
import io.gs2.cdk.stamina.stampSheet.RaiseMaxValueByUserId;
import io.gs2.cdk.stamina.stampSheet.SetMaxValueByUserId;
import io.gs2.cdk.stamina.stampSheet.SetRecoverIntervalByUserId;
import io.gs2.cdk.stamina.stampSheet.SetRecoverValueByUserId;
import io.gs2.cdk.stamina.stampSheet.DecreaseMaxValueByUserId;
import io.gs2.cdk.stamina.stampSheet.ConsumeStaminaByUserId;
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

    public StaminaModelRef staminaModel(
        String staminaName
    ) {
        return (new StaminaModelRef(
            this.namespaceName,
            staminaName
        ));
    }

    public RecoverStaminaByUserId recoverStamina(
        String staminaName,
        Integer recoverValue,
        String userId
    ) {
        return (new RecoverStaminaByUserId(
            this.namespaceName,
            staminaName,
            recoverValue,
            userId
        ));
    }


    public RecoverStaminaByUserId recoverStamina(
        String staminaName,
        Integer recoverValue
    ) {
        return (new RecoverStaminaByUserId(
            this.namespaceName,
            staminaName,
            recoverValue,
            "#{userId}"
        ));
    }

    public RaiseMaxValueByUserId raiseMaxValue(
        String staminaName,
        Integer raiseValue,
        String userId
    ) {
        return (new RaiseMaxValueByUserId(
            this.namespaceName,
            staminaName,
            raiseValue,
            userId
        ));
    }


    public RaiseMaxValueByUserId raiseMaxValue(
        String staminaName,
        Integer raiseValue
    ) {
        return (new RaiseMaxValueByUserId(
            this.namespaceName,
            staminaName,
            raiseValue,
            "#{userId}"
        ));
    }

    public SetMaxValueByUserId setMaxValue(
        String staminaName,
        Integer maxValue,
        String userId
    ) {
        return (new SetMaxValueByUserId(
            this.namespaceName,
            staminaName,
            maxValue,
            userId
        ));
    }


    public SetMaxValueByUserId setMaxValue(
        String staminaName,
        Integer maxValue
    ) {
        return (new SetMaxValueByUserId(
            this.namespaceName,
            staminaName,
            maxValue,
            "#{userId}"
        ));
    }

    public SetRecoverIntervalByUserId setRecoverInterval(
        String staminaName,
        Integer recoverIntervalMinutes,
        String userId
    ) {
        return (new SetRecoverIntervalByUserId(
            this.namespaceName,
            staminaName,
            recoverIntervalMinutes,
            userId
        ));
    }


    public SetRecoverIntervalByUserId setRecoverInterval(
        String staminaName,
        Integer recoverIntervalMinutes
    ) {
        return (new SetRecoverIntervalByUserId(
            this.namespaceName,
            staminaName,
            recoverIntervalMinutes,
            "#{userId}"
        ));
    }

    public SetRecoverValueByUserId setRecoverValue(
        String staminaName,
        Integer recoverValue,
        String userId
    ) {
        return (new SetRecoverValueByUserId(
            this.namespaceName,
            staminaName,
            recoverValue,
            userId
        ));
    }


    public SetRecoverValueByUserId setRecoverValue(
        String staminaName,
        Integer recoverValue
    ) {
        return (new SetRecoverValueByUserId(
            this.namespaceName,
            staminaName,
            recoverValue,
            "#{userId}"
        ));
    }

    public DecreaseMaxValueByUserId decreaseMaxValue(
        String staminaName,
        Integer decreaseValue,
        String userId
    ) {
        return (new DecreaseMaxValueByUserId(
            this.namespaceName,
            staminaName,
            decreaseValue,
            userId
        ));
    }


    public DecreaseMaxValueByUserId decreaseMaxValue(
        String staminaName,
        Integer decreaseValue
    ) {
        return (new DecreaseMaxValueByUserId(
            this.namespaceName,
            staminaName,
            decreaseValue,
            "#{userId}"
        ));
    }

    public ConsumeStaminaByUserId consumeStamina(
        String staminaName,
        Integer consumeValue,
        String userId
    ) {
        return (new ConsumeStaminaByUserId(
            this.namespaceName,
            staminaName,
            consumeValue,
            userId
        ));
    }


    public ConsumeStaminaByUserId consumeStamina(
        String staminaName,
        Integer consumeValue
    ) {
        return (new ConsumeStaminaByUserId(
            this.namespaceName,
            staminaName,
            consumeValue,
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
                "stamina",
                this.namespaceName
            )
        )).str(
        );
    }
}
