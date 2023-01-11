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
package io.gs2.cdk.lottery.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.lottery.model.options.BoxItemOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BoxItem {
    private Integer remaining;
    private Integer initial;
    private List<AcquireAction> acquireActions = null;

    public BoxItem(
        Integer remaining,
        Integer initial,
        BoxItemOptions options
    ) {
        this.remaining = remaining;
        this.initial = initial;
        this.acquireActions = options.acquireActions;
    }
    public BoxItem(
        Integer remaining,
        Integer initial
    ) {
        this.remaining = remaining;
        this.initial = initial;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.remaining != null) {
            properties.put("remaining", this.remaining);
        }
        if (this.initial != null) {
            properties.put("initial", this.initial);
        }

        return properties;
    }
}
