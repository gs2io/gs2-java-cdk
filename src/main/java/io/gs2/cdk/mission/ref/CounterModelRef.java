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
import io.gs2.cdk.mission.stampSheet.IncreaseCounterByUserId;
import io.gs2.cdk.mission.stampSheet.DecreaseCounterByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CounterModelRef {
    private String namespaceName;
    private String counterName;

    public CounterModelRef(
        String namespaceName,
        String counterName
    ) {
        this.namespaceName = namespaceName;
        this.counterName = counterName;
    }

    public IncreaseCounterByUserId increaseCounter(
        Long value,
        String userId
    ) {
        return (new IncreaseCounterByUserId(
            this.namespaceName,
            this.counterName,
            value,
            userId
        ));
    }


    public IncreaseCounterByUserId increaseCounter(
        Long value
    ) {
        return (new IncreaseCounterByUserId(
            this.namespaceName,
            this.counterName,
            value,
            "#{userId}"
        ));
    }

    public DecreaseCounterByUserId decreaseCounter(
        Long value,
        String userId
    ) {
        return (new DecreaseCounterByUserId(
            this.namespaceName,
            this.counterName,
            value,
            userId
        ));
    }


    public DecreaseCounterByUserId decreaseCounter(
        Long value
    ) {
        return (new DecreaseCounterByUserId(
            this.namespaceName,
            this.counterName,
            value,
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
                this.namespaceName,
                "counter",
                this.counterName
            )
        )).str(
        );
    }
}
