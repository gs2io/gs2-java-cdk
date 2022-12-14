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

package io.gs2.cdk.schedule.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;

import java.util.*;
import java.util.stream.*;


public class CurrentEventMasterRef {
    public String namespaceName;

    public CurrentEventMasterRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "schedule",
                this.namespaceName
            )
        ).str();
    }
}
