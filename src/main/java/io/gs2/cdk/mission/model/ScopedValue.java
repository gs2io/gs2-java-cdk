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

package io.gs2.cdk.mission.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.mission.resource.*;

import java.util.*;
import java.util.stream.*;

public class ScopedValue {

    public enum ResetType {
        NOT_RESET,
        DAILY,
        WEEKLY,
        MONTHLY;

       public String toString() {
           switch (this) {
               case NOT_RESET:
                   return "notReset";
               case DAILY:
                   return "daily";
               case WEEKLY:
                   return "weekly";
               case MONTHLY:
                   return "monthly";
           }
           return "unknown";
       }
    }
	public ResetType resetType;
	public Long value;
	public Long nextResetAt;
	public Long updatedAt;

    public ScopedValue(
            ResetType resetType,
            Long value,
            Long updatedAt
    ) {
        this.resetType = resetType;
        this.value = value;
        this.updatedAt = updatedAt;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.resetType != null) {
            properties.put("ResetType", this.resetType.toString());
        }
        if (this.value != null) {
            properties.put("Value", this.value);
        }
        if (this.nextResetAt != null) {
            properties.put("NextResetAt", this.nextResetAt);
        }
        if (this.updatedAt != null) {
            properties.put("UpdatedAt", this.updatedAt);
        }
        return properties;
    }
}
