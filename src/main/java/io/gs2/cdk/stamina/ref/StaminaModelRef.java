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

public class StaminaModelRef {
    private String namespaceName;
    private String staminaName;

    public StaminaModelRef(
        String namespaceName,
        String staminaName
    ) {
        this.namespaceName = namespaceName;
        this.staminaName = staminaName;
    }

    public RecoverStaminaByUserId recoverStamina(
        Integer recoverValue,
        String userId
    ) {
        return (new RecoverStaminaByUserId(
            this.namespaceName,
            this.staminaName,
            recoverValue,
            userId
        ));
    }


    public RecoverStaminaByUserId recoverStamina(
        Integer recoverValue
    ) {
        return (new RecoverStaminaByUserId(
            this.namespaceName,
            this.staminaName,
            recoverValue,
            "#{userId}"
        ));
    }

    public RaiseMaxValueByUserId raiseMaxValue(
        Integer raiseValue,
        String userId
    ) {
        return (new RaiseMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            raiseValue,
            userId
        ));
    }


    public RaiseMaxValueByUserId raiseMaxValue(
        Integer raiseValue
    ) {
        return (new RaiseMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            raiseValue,
            "#{userId}"
        ));
    }

    public SetMaxValueByUserId setMaxValue(
        Integer maxValue,
        String userId
    ) {
        return (new SetMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            maxValue,
            userId
        ));
    }


    public SetMaxValueByUserId setMaxValue(
        Integer maxValue
    ) {
        return (new SetMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            maxValue,
            "#{userId}"
        ));
    }

    public SetRecoverIntervalByUserId setRecoverInterval(
        Integer recoverIntervalMinutes,
        String userId
    ) {
        return (new SetRecoverIntervalByUserId(
            this.namespaceName,
            this.staminaName,
            recoverIntervalMinutes,
            userId
        ));
    }


    public SetRecoverIntervalByUserId setRecoverInterval(
        Integer recoverIntervalMinutes
    ) {
        return (new SetRecoverIntervalByUserId(
            this.namespaceName,
            this.staminaName,
            recoverIntervalMinutes,
            "#{userId}"
        ));
    }

    public SetRecoverValueByUserId setRecoverValue(
        Integer recoverValue,
        String userId
    ) {
        return (new SetRecoverValueByUserId(
            this.namespaceName,
            this.staminaName,
            recoverValue,
            userId
        ));
    }


    public SetRecoverValueByUserId setRecoverValue(
        Integer recoverValue
    ) {
        return (new SetRecoverValueByUserId(
            this.namespaceName,
            this.staminaName,
            recoverValue,
            "#{userId}"
        ));
    }

    public DecreaseMaxValueByUserId decreaseMaxValue(
        Integer decreaseValue,
        String userId
    ) {
        return (new DecreaseMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            decreaseValue,
            userId
        ));
    }


    public DecreaseMaxValueByUserId decreaseMaxValue(
        Integer decreaseValue
    ) {
        return (new DecreaseMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            decreaseValue,
            "#{userId}"
        ));
    }

    public ConsumeStaminaByUserId consumeStamina(
        Integer consumeValue,
        String userId
    ) {
        return (new ConsumeStaminaByUserId(
            this.namespaceName,
            this.staminaName,
            consumeValue,
            userId
        ));
    }


    public ConsumeStaminaByUserId consumeStamina(
        Integer consumeValue
    ) {
        return (new ConsumeStaminaByUserId(
            this.namespaceName,
            this.staminaName,
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
                this.namespaceName,
                "model",
                this.staminaName
            )
        )).str(
        );
    }
}
