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

package io.gs2.cdk.stamina.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.stamina.model.*;
import io.gs2.cdk.stamina.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class StaminaModelRef {
    public String namespaceName;
    public String staminaName;

    public StaminaModelRef(
            String namespaceName,
            String staminaName
    ) {
        this.namespaceName = namespaceName;
        this.staminaName = staminaName;
    }

    public RecoverStaminaByUserId recoverStamina(
            Integer recoverValue
    ) {
        return new RecoverStaminaByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            recoverValue
        );
    }

    public RaiseMaxValueByUserId raiseMaxValue(
            Integer raiseValue
    ) {
        return new RaiseMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            raiseValue
        );
    }

    public SetMaxValueByUserId setMaxValue(
            Integer maxValue
    ) {
        return new SetMaxValueByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            maxValue
        );
    }

    public SetRecoverIntervalByUserId setRecoverInterval(
            Integer recoverIntervalMinutes
    ) {
        return new SetRecoverIntervalByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            recoverIntervalMinutes
        );
    }

    public SetRecoverValueByUserId setRecoverValue(
            Integer recoverValue
    ) {
        return new SetRecoverValueByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            recoverValue
        );
    }

    public ConsumeStaminaByUserId consumeStamina(
            Integer consumeValue
    ) {
        return new ConsumeStaminaByUserId(
            this.namespaceName,
            this.staminaName,
            "#{userId}",
            consumeValue
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
                "stamina",
                this.namespaceName,
                "model",
                this.staminaName
            )
        ).str();
    }
}
