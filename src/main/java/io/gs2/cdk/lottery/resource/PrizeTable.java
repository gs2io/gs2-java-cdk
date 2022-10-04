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

package io.gs2.cdk.lottery.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.lottery.ref.*;
import io.gs2.cdk.lottery.model.*;

import java.util.*;
import java.util.stream.*;

public class PrizeTable {
	public String name;
	public String metadata;
	public List<Prize> prizes;

    public PrizeTable(
            String name,
            List<Prize> prizes
    ) {
        this.name = name;
        this.prizes = prizes;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.prizes != null) {
            properties.put("Prizes", this.prizes.stream().map(Prize::properties).collect(Collectors.toList()));
        }
        return properties;
    }

    public PrizeTableRef ref(
            String namespaceName
    ) {
        return new PrizeTableRef(
            namespaceName,
            this.name
        );
    }
}
