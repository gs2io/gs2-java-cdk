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

package io.gs2.cdk.stamina.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.stamina.ref.*;
import io.gs2.cdk.stamina.model.*;

import java.util.*;
import java.util.stream.*;

public class RecoverValueTable {
	public String name;
	public String metadata;
	public String experienceModelId;
	public List<Integer> values;

    public RecoverValueTable(
            String name,
            String experienceModelId,
            List<Integer> values
    ) {
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.values = values;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.experienceModelId != null) {
            properties.put("ExperienceModelId", this.experienceModelId);
        }
        if (this.values != null) {
            properties.put("Values", this.values);
        }
        return properties;
    }

    public RecoverValueTableRef ref(
            String namespaceName
    ) {
        return new RecoverValueTableRef(
            namespaceName,
            this.name
        );
    }
}
