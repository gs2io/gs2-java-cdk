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

package io.gs2.cdk.inbox.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.inbox.ref.*;
import io.gs2.cdk.inbox.model.*;

import java.util.*;
import java.util.stream.*;


public class GlobalMessageMaster extends CdkResource {

    public Stack stack;
    public String namespaceName;
    public String name;
    public String metadata;
    public List<AcquireAction> readAcquireActions;
    public TimeSpan expiresTimeSpan;
    public Long expiresAt;

    public GlobalMessageMaster(
            Stack stack,
            String namespaceName,
            String name,
            String metadata
    ) {
        super("Inbox_GlobalMessageMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.metadata = metadata;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Inbox::GlobalMessageMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.readAcquireActions != null) {
            properties.put("ReadAcquireActions", this.readAcquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.expiresTimeSpan != null) {
            properties.put("ExpiresTimeSpan", this.expiresTimeSpan.properties());
        }
        if (this.expiresAt != null) {
            properties.put("ExpiresAt", this.expiresAt);
        }
        return properties;
    }

    public GlobalMessageMasterRef ref(
            String namespaceName
    ) {
        return new GlobalMessageMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrGlobalMessageId() {
        return new GetAttr(
            "Item.GlobalMessageId"
        );
    }
}
