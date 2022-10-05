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
import io.gs2.cdk.lottery.resource.*;

import java.util.*;
import java.util.stream.*;

public class Prize {

    public enum Type {
        ACTION,
        PRIZE_TABLE;

       public String toString() {
           switch (this) {
               case ACTION:
                   return "action";
               case PRIZE_TABLE:
                   return "prize_table";
           }
           return "unknown";
       }
    }
	public String prizeId;
	public Type type;
	public List<AcquireAction> acquireActions;
	public Integer drawnLimit;
	public String limitFailOverPrizeId;
	public String prizeTableName;
	public Integer weight;

    public Prize(
            String prizeId,
            Type type,
            Integer weight
    ) {
        this.prizeId = prizeId;
        this.type = type;
        this.weight = weight;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.prizeId != null) {
            properties.put("PrizeId", this.prizeId);
        }
        if (this.type != null) {
            properties.put("Type", this.type.toString());
        }
        if (this.acquireActions != null) {
            properties.put("AcquireActions", this.acquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.drawnLimit != null) {
            properties.put("DrawnLimit", this.drawnLimit);
        }
        if (this.limitFailOverPrizeId != null) {
            properties.put("LimitFailOverPrizeId", this.limitFailOverPrizeId);
        }
        if (this.prizeTableName != null) {
            properties.put("PrizeTableName", this.prizeTableName);
        }
        if (this.weight != null) {
            properties.put("Weight", this.weight);
        }
        return properties;
    }
}
