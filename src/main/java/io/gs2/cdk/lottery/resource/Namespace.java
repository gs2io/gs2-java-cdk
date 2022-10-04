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

package io.gs2.cdk.lottery.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.lottery.ref.*;
import io.gs2.cdk.lottery.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String name;
    public String description;
    public TransactionSetting transactionSetting;
    public String lotteryTriggerScriptId;
    public String choicePrizeTableScriptId;
    public LogSetting logSetting;

    public Namespace(
            Stack stack,
            String name,
            TransactionSetting transactionSetting
    ) {
        super("Lottery_Namespace_" + name);

        this.stack = stack;
        this.name = name;
        this.transactionSetting = transactionSetting;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Lottery::Namespace";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties());
        }
        if (this.lotteryTriggerScriptId != null) {
            properties.put("LotteryTriggerScriptId", this.lotteryTriggerScriptId);
        }
        if (this.choicePrizeTableScriptId != null) {
            properties.put("ChoicePrizeTableScriptId", this.choicePrizeTableScriptId);
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties());
        }
        return properties;
    }

    public NamespaceRef ref(
    ) {
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }

    public Namespace masterData(
            List<LotteryModel> lotteryModels,
            List<PrizeTable> prizeTables
    ) {
        new CurrentMasterData(
            this.stack,
            this.name,
            lotteryModels,
            prizeTables
        ).addDependsOn(
            this
        );
        return this;
    }
}
