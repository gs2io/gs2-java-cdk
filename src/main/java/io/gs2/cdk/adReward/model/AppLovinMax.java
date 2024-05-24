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
package io.gs2.cdk.adReward.model;
import io.gs2.cdk.adReward.model.options.AppLovinMaxOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AppLovinMax {
    private String allowAdUnitId;
    private String eventKey;

    public AppLovinMax(
        String allowAdUnitId,
        String eventKey,
        AppLovinMaxOptions options
    ) {
        this.allowAdUnitId = allowAdUnitId;
        this.eventKey = eventKey;
    }
    public AppLovinMax(
        String allowAdUnitId,
        String eventKey
    ) {
        this.allowAdUnitId = allowAdUnitId;
        this.eventKey = eventKey;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.allowAdUnitId != null) {
            properties.put("allowAdUnitId", this.allowAdUnitId);
        }
        if (this.eventKey != null) {
            properties.put("eventKey", this.eventKey);
        }

        return properties;
    }
}
