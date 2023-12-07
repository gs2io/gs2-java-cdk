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
package io.gs2.cdk.inventory.model;
import io.gs2.cdk.inventory.model.options.HeldCountOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class HeldCount {
    private String itemName;
    private Long count;

    public HeldCount(
        String itemName,
        Long count,
        HeldCountOptions options
    ) {
        this.itemName = itemName;
        this.count = count;
    }
    public HeldCount(
        String itemName,
        Long count
    ) {
        this.itemName = itemName;
        this.count = count;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.itemName != null) {
            properties.put("itemName", this.itemName);
        }
        if (this.count != null) {
            properties.put("count", this.count);
        }

        return properties;
    }
}
