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

package io.gs2.cdk.limit.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.limit.ref.*;
import io.gs2.cdk.limit.model.*;

import java.util.*;
import java.util.stream.*;

public class CurrentMasterData extends CdkResource {

    String version = "2019-04-05";
    public String namespaceName;
    public List<LimitModel> limitModels;

    public CurrentMasterData(
            Stack stack,
            String namespaceName,
            List<LimitModel> limitModels
    ) {
        super("Limit_CurrentLimitMaster_" + namespaceName);

        this.namespaceName = namespaceName;
        this.limitModels = limitModels;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Limit::CurrentLimitMaster";
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("NamespaceName", namespaceName);
                put("Settings", new HashMap<>() {
                    {
                        put("version", version);
                        put("limitModels", limitModels.stream().map(LimitModel::properties).collect(Collectors.toList()));
                    }
                });
            }
        };
    }
}