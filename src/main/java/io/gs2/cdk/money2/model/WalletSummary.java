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
package io.gs2.cdk.money2.model;
import io.gs2.cdk.money2.model.options.WalletSummaryOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class WalletSummary {
    private Integer paid;
    private Integer free;
    private Integer total;

    public WalletSummary(
        Integer paid,
        Integer free,
        Integer total,
        WalletSummaryOptions options
    ) {
        this.paid = paid;
        this.free = free;
        this.total = total;
    }
    public WalletSummary(
        Integer paid,
        Integer free,
        Integer total
    ) {
        this.paid = paid;
        this.free = free;
        this.total = total;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.paid != null) {
            properties.put("paid", this.paid);
        }
        if (this.free != null) {
            properties.put("free", this.free);
        }
        if (this.total != null) {
            properties.put("total", this.total);
        }

        return properties;
    }
}
