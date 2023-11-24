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
package io.gs2.cdk.quest.model;
import io.gs2.cdk.quest.model.options.RewardOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Reward {
    private String action;
    private String request;
    private String itemId;
    private Integer value;

    public Reward(
        String action,
        String request,
        String itemId,
        Integer value,
        RewardOptions options
    ) {
        this.action = action;
        this.request = request;
        this.itemId = itemId;
        this.value = value;
    }
    public Reward(
        String action,
        String request,
        String itemId,
        Integer value
    ) {
        this.action = action;
        this.request = request;
        this.itemId = itemId;
        this.value = value;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.action != null) {
            properties.put("action", this.action);
        }
        if (this.request != null) {
            properties.put("request", this.request);
        }
        if (this.itemId != null) {
            properties.put("itemId", this.itemId);
        }
        if (this.value != null) {
            properties.put("value", this.value);
        }

        return properties;
    }
}
