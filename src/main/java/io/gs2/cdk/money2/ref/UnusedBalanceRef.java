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
package io.gs2.cdk.money2.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnusedBalanceRef {
    private String namespaceName;
    private String currency;

    public UnusedBalanceRef(
        String namespaceName,
        String currency
    ) {
        this.namespaceName = namespaceName;
        this.currency = currency;
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
                "money2",
                this.namespaceName,
                "unused",
                this.currency
            )
        )).str(
        );
    }
}
