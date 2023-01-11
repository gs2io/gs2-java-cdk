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
package io.gs2.cdk.lottery.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.lottery.stampSheet.DrawByUserId;
import io.gs2.cdk.core.model.Config;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryModelRef {
    private String namespaceName;
    private String lotteryName;

    public LotteryModelRef(
        String namespaceName,
        String lotteryName
    ) {
        this.namespaceName = namespaceName;
        this.lotteryName = lotteryName;
    }

    public DrawByUserId draw(
        Integer count,
        List<Config> config,
        String userId
    ) {
        return (new DrawByUserId(
            this.namespaceName,
            this.lotteryName,
            count,
            config,
            userId
        ));
    }


    public DrawByUserId draw(
        Integer count,
        List<Config> config
    ) {
        return (new DrawByUserId(
            this.namespaceName,
            this.lotteryName,
            count,
            config,
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
                "lottery",
                this.namespaceName,
                "lotteryModel",
                this.lotteryName
            )
        )).str(
        );
    }
}
