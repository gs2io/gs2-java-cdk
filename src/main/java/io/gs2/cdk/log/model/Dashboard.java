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
package io.gs2.cdk.log.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.log.ref.DashboardRef;

import io.gs2.cdk.log.model.options.DashboardOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Dashboard extends CdkResource {
    private Stack stack;
    private String namespaceName;
    private String displayName;
    private String description = null;

    public Dashboard(
        Stack stack,
        String namespaceName,
        String displayName,
        DashboardOptions options
    ) {
        super(
            "Log_Dashboard_" + displayName
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.displayName = displayName;
        this.description = options.description;
        stack.addResource(
            this
        );
    }

    public Dashboard(
        Stack stack,
        String namespaceName,
        String displayName
    ) {
        super(
            "Log_Dashboard_" + displayName
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.displayName = displayName;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Log::Dashboard";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.displayName != null) {
            properties.put("DisplayName", this.displayName);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }

        return properties;
    }

    public DashboardRef ref(
        String name
    ) {
        return (new DashboardRef(
            this.namespaceName,
            name
        ));
    }

    public GetAttr getAttrDashboardId(
    ) {
        return (new GetAttr(
            this,
            "Item.DashboardId",
            null
        ));
    }
}
