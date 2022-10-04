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

package io.gs2.cdk.lottery.model;

import io.gs2.cdk.core.model.*;

import java.util.*;
import java.util.stream.*;

public class BoxItems {
	public String boxId;
	public String prizeTableName;
	public String userId;
	public List<BoxItem> items;

    public BoxItems(
            String boxId,
            String prizeTableName,
            String userId
    ) {
        this.boxId = boxId;
        this.prizeTableName = prizeTableName;
        this.userId = userId;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.boxId != null) {
            properties.put("BoxId", this.boxId);
        }
        if (this.prizeTableName != null) {
            properties.put("PrizeTableName", this.prizeTableName);
        }
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.items != null) {
            properties.put("Items", this.items.stream().map(BoxItem::properties).collect(Collectors.toList()));
        }
        return properties;
    }
}
