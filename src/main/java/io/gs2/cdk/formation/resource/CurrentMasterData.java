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

package io.gs2.cdk.formation.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.formation.ref.*;
import io.gs2.cdk.formation.model.*;

import java.util.*;
import java.util.stream.*;

public class CurrentMasterData extends CdkResource {

    String version = "2019-09-09";
    public String namespaceName;
    public List<MoldModel> moldModels;
    public List<FormModel> formModels;

    public CurrentMasterData(
            Stack stack,
            String namespaceName,
            List<MoldModel> moldModels,
            List<FormModel> formModels
    ) {
        super("Formation_CurrentFormMaster_" + namespaceName);

        this.namespaceName = namespaceName;
        this.moldModels = moldModels;
        this.formModels = formModels;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Formation::CurrentFormMaster";
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("NamespaceName", namespaceName);
                put("Settings", new HashMap<>() {
                    {
                        put("version", version);
                        put("moldModels", moldModels.stream().map(MoldModel::properties).collect(Collectors.toList()));
                        put("formModels", formModels.stream().map(FormModel::properties).collect(Collectors.toList()));
                    }
                });
            }
        };
    }
}