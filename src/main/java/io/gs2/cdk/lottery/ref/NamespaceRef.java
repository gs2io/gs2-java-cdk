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

package io.gs2.cdk.lottery.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.lottery.model.*;
import io.gs2.cdk.lottery.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class NamespaceRef {
    public String namespaceName;

    public NamespaceRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public CurrentLotteryMasterRef currentLotteryMaster(
    ) {
        return new CurrentLotteryMasterRef(
            this.namespaceName
        );
    }

    public PrizeTableRef prizeTable(
            String prizeTableName
    ) {
        return new PrizeTableRef(
            this.namespaceName,
            prizeTableName
        );
    }

    public LotteryModelRef lotteryModel(
            String lotteryName
    ) {
        return new LotteryModelRef(
            this.namespaceName,
            lotteryName
        );
    }

    public PrizeTableMasterRef prizeTableMaster(
            String prizeTableName
    ) {
        return new PrizeTableMasterRef(
            this.namespaceName,
            prizeTableName
        );
    }

    public LotteryModelMasterRef lotteryModelMaster(
            String lotteryName
    ) {
        return new LotteryModelMasterRef(
            this.namespaceName,
            lotteryName
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
                "lottery",
                this.namespaceName
            )
        ).str();
    }
}
