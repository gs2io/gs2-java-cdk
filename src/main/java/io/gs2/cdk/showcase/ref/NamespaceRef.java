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

package io.gs2.cdk.showcase.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;

import java.util.*;
import java.util.stream.*;


public class NamespaceRef {
    public String namespaceName;

    public NamespaceRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public CurrentShowcaseMasterRef currentShowcaseMaster(
    ) {
        return new CurrentShowcaseMasterRef(
            this.namespaceName
        );
    }

    public DisplayItemRef displayItem(
    ) {
        return new DisplayItemRef(
            this.namespaceName
        );
    }

    public SalesItemMasterRef salesItemMaster(
            String salesItemName
    ) {
        return new SalesItemMasterRef(
            this.namespaceName,
            salesItemName
        );
    }

    public SalesItemGroupMasterRef salesItemGroupMaster(
            String salesItemGroupName
    ) {
        return new SalesItemGroupMasterRef(
            this.namespaceName,
            salesItemGroupName
        );
    }

    public ShowcaseMasterRef showcaseMaster(
            String showcaseName
    ) {
        return new ShowcaseMasterRef(
            this.namespaceName,
            showcaseName
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
                "showcase",
                this.namespaceName
            )
        ).str();
    }
}
