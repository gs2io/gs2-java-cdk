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


public class PrizeTableRef {
    public String namespaceName;
    public String prizeTableName;

    public PrizeTableRef(
            String namespaceName,
            String prizeTableName
    ) {
        this.namespaceName = namespaceName;
        this.prizeTableName = prizeTableName;
    }

    public PrizeLimitRef prizeLimit(
            String prizeId
    ) {
        return new PrizeLimitRef(
            this.namespaceName,
            this.prizeTableName,
            prizeId
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
                this.namespaceName,
                "table",
                this.prizeTableName
            )
        ).str();
    }
}
