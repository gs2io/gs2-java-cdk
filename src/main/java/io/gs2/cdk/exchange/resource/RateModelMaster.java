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

package io.gs2.cdk.exchange.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.exchange.ref.*;
import io.gs2.cdk.exchange.model.*;

import java.util.*;
import java.util.stream.*;


public class RateModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public String timingType;
    public Integer lockTime;
    public Boolean enableSkip;
    public List<ConsumeAction> skipConsumeActions;
    public List<AcquireAction> acquireActions;
    public List<ConsumeAction> consumeActions;

    public RateModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            String timingType,
            Integer lockTime,
            Boolean enableSkip
    ) {
        super("Exchange_RateModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.timingType = timingType;
        this.lockTime = lockTime;
        this.enableSkip = enableSkip;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Exchange::RateModelMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.timingType != null) {
            properties.put("TimingType", this.timingType.toString());
        }
        if (this.lockTime != null) {
            properties.put("LockTime", this.lockTime);
        }
        if (this.enableSkip != null) {
            properties.put("EnableSkip", this.enableSkip);
        }
        if (this.skipConsumeActions != null) {
            properties.put("SkipConsumeActions", this.skipConsumeActions.stream().map(ConsumeAction::properties).collect(Collectors.toList()));
        }
        if (this.acquireActions != null) {
            properties.put("AcquireActions", this.acquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.consumeActions != null) {
            properties.put("ConsumeActions", this.consumeActions.stream().map(ConsumeAction::properties).collect(Collectors.toList()));
        }
        return properties;
    }

    public RateModelMasterRef ref(
            String namespaceName
    ) {
        return new RateModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrRateModelId() {
        return new GetAttr(
            "Item.RateModelId"
        );
    }
}
