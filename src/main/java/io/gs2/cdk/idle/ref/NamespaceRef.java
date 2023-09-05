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
package io.gs2.cdk.idle.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.idle.ref.CategoryModelRef;
import io.gs2.cdk.idle.stampSheet.IncreaseMaximumIdleMinutesByUserId;
import io.gs2.cdk.idle.stampSheet.DecreaseMaximumIdleMinutesByUserId;
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

    public CategoryModelRef categoryModel(
        String categoryName
    ) {
        return (new CategoryModelRef(
            this.namespaceName,
            categoryName
        ));
    }

    public IncreaseMaximumIdleMinutesByUserId increaseMaximumIdleMinutes(
        String categoryName,
        Integer increaseMinutes,
        String userId
    ) {
        return (new IncreaseMaximumIdleMinutesByUserId(
            this.namespaceName,
            categoryName,
            increaseMinutes,
            userId
        ));
    }


    public IncreaseMaximumIdleMinutesByUserId increaseMaximumIdleMinutes(
        String categoryName,
        Integer increaseMinutes
    ) {
        return (new IncreaseMaximumIdleMinutesByUserId(
            this.namespaceName,
            categoryName,
            increaseMinutes,
            "#{userId}"
        ));
    }

    public DecreaseMaximumIdleMinutesByUserId decreaseMaximumIdleMinutes(
        String categoryName,
        Integer decreaseMinutes,
        String userId
    ) {
        return (new DecreaseMaximumIdleMinutesByUserId(
            this.namespaceName,
            categoryName,
            decreaseMinutes,
            userId
        ));
    }


    public DecreaseMaximumIdleMinutesByUserId decreaseMaximumIdleMinutes(
        String categoryName,
        Integer decreaseMinutes
    ) {
        return (new DecreaseMaximumIdleMinutesByUserId(
            this.namespaceName,
            categoryName,
            decreaseMinutes,
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
                "idle",
                this.namespaceName
            )
        )).str(
        );
    }
}
