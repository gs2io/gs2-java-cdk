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
package io.gs2.cdk.realtime.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.realtime.ref.NamespaceRef;
import io.gs2.cdk.realtime.model.enums.NamespaceServerType;
import io.gs2.cdk.realtime.model.enums.NamespaceServerSpec;

import io.gs2.cdk.realtime.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private NamespaceServerType serverType;
    private NamespaceServerSpec serverSpec;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private NotificationSetting createNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceServerType serverType,
        NamespaceServerSpec serverSpec,
        NamespaceOptions options
    ) {
        super(
            "Realtime_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.serverType = serverType;
        this.serverSpec = serverSpec;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.createNotification = options.createNotification;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        NamespaceServerType serverType,
        NamespaceServerSpec serverSpec
    ) {
        super(
            "Realtime_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.serverType = serverType;
        this.serverSpec = serverSpec;
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
        return "GS2::Realtime::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.serverType != null) {
            properties.put("ServerType", this.serverType);
        }
        if (this.serverSpec != null) {
            properties.put("ServerSpec", this.serverSpec);
        }
        if (this.createNotification != null) {
            properties.put("CreateNotification", this.createNotification.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            this,
            "Item.NamespaceId",
            null
        ));
    }
}
