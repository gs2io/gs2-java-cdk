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

package io.gs2.cdk.experience.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.experience.model.*;
import io.gs2.cdk.experience.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class ThresholdMasterRef {
    public String namespaceName;
    public String thresholdName;

    public ThresholdMasterRef(
            String namespaceName,
            String thresholdName
    ) {
        this.namespaceName = namespaceName;
        this.thresholdName = thresholdName;
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "experience",
                this.namespaceName,
                "threshold",
                this.thresholdName
            )
        ).str();
    }
}
