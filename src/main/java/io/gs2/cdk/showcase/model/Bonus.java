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
package io.gs2.cdk.showcase.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.showcase.model.options.BonusOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Bonus {
    private String routeKey;
    private List<AcquireAction> acquireActions;

    public Bonus(
        String routeKey,
        List<AcquireAction> acquireActions,
        BonusOptions options
    ) {
        this.routeKey = routeKey;
        this.acquireActions = acquireActions;
    }
    public Bonus(
        String routeKey,
        List<AcquireAction> acquireActions
    ) {
        this.routeKey = routeKey;
        this.acquireActions = acquireActions;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.routeKey != null) {
            properties.put("routeKey", this.routeKey);
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
