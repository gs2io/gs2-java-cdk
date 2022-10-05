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


public class NamespaceRef {
    public String namespaceName;

    public NamespaceRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public CurrentRateMasterRef currentRateMaster(
    ) {
        return new CurrentRateMasterRef(
            this.namespaceName
        );
    }

    public RateModelRef rateModel(
            String rateName
    ) {
        return new RateModelRef(
            this.namespaceName,
            rateName
        );
    }

    public RateModelMasterRef rateModelMaster(
            String rateName
    ) {
        return new RateModelMasterRef(
            this.namespaceName,
            rateName
        );
    }

    public CreateProgressByUserId createProgress(
            String rateName,
            String targetItemSetId,
            List<Material> materials,
            Boolean force
    ) {
        return new CreateProgressByUserId(
            this.namespaceName,
            "#{userId}",
            rateName,
            targetItemSetId,
            materials,
            force
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
                "enhance",
                this.namespaceName
            )
        ).str();
    }
}
