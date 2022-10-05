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

package io.gs2.cdk.quest.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.quest.resource.*;

import java.util.*;
import java.util.stream.*;

public class Contents {
	public String metadata;
	public List<AcquireAction> completeAcquireActions;
	public Integer weight;

    public Contents(
            Integer weight
    ) {
        this.weight = weight;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.completeAcquireActions != null) {
            properties.put("CompleteAcquireActions", this.completeAcquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.weight != null) {
            properties.put("Weight", this.weight);
        }
        return properties;
    }
}
