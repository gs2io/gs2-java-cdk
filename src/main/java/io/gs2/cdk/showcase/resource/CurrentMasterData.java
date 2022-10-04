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

package io.gs2.cdk.showcase.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.showcase.ref.*;
import io.gs2.cdk.showcase.model.*;

import java.util.*;
import java.util.stream.*;

public class CurrentMasterData extends CdkResource {

    String version = "2019-04-04";
    public String namespaceName;
    public List<Showcase> showcases;

    public CurrentMasterData(
            Stack stack,
            String namespaceName,
            List<Showcase> showcases
    ) {
        super("Showcase_CurrentShowcaseMaster_" + namespaceName);

        this.namespaceName = namespaceName;
        this.showcases = showcases;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Showcase::CurrentShowcaseMaster";
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("NamespaceName", namespaceName);
                put("Settings", new HashMap<>() {
                    {
                        put("version", version);
                        put("showcases", showcases.stream().map(Showcase::properties).collect(Collectors.toList()));
                    }
                });
            }
        };
    }
}