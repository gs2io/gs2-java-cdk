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

package io.gs2.cdk.enhance.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.enhance.model.*;
import io.gs2.cdk.enhance.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class RateModelRef {
    public String namespaceName;
    public String rateName;

    public RateModelRef(
            String namespaceName,
            String rateName
    ) {
        this.namespaceName = namespaceName;
        this.rateName = rateName;
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "enhance",
                this.namespaceName,
                "rateModel",
                this.rateName
            )
        ).str();
    }
}
