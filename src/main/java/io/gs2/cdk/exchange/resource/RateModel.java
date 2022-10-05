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

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.exchange.ref.*;
import io.gs2.cdk.exchange.model.*;

import java.util.*;
import java.util.stream.*;

public class RateModel {

    public enum TimingType {
        IMMEDIATE,
        AWAIT;

        public String toString() {
            switch (this) {
                case IMMEDIATE:
                    return "immediate";
                case AWAIT:
                    return "await";
            }
            return "unknown";
        }
    }
	public String name;
	public String metadata;
	public List<ConsumeAction> consumeActions;
	public TimingType timingType;
	public Integer lockTime;
	public Boolean enableSkip;
	public List<ConsumeAction> skipConsumeActions;
	public List<AcquireAction> acquireActions;

    public RateModel(
            String name,
            TimingType timingType
    ) {
        this.name = name;
        this.timingType = timingType;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.consumeActions != null) {
            properties.put("ConsumeActions", this.consumeActions.stream().map(ConsumeAction::properties).collect(Collectors.toList()));
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
        return properties;
    }

    public RateModelRef ref(
            String namespaceName
    ) {
        return new RateModelRef(
            namespaceName,
            this.name
        );
    }
}
