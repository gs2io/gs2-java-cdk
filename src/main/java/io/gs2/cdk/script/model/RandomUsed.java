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
package io.gs2.cdk.script.model;
import io.gs2.cdk.script.model.options.RandomUsedOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUsed {
    private Long category;
    private Long used;

    public RandomUsed(
        Long category,
        Long used,
        RandomUsedOptions options
    ) {
        this.category = category;
        this.used = used;
    }
    public RandomUsed(
        Long category,
        Long used
    ) {
        this.category = category;
        this.used = used;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.category != null) {
            properties.put("category", this.category);
        }
        if (this.used != null) {
            properties.put("used", this.used);
        }

        return properties;
    }
}
