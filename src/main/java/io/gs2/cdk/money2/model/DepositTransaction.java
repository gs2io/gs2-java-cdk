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
import io.gs2.cdk.money2.model.options.DepositTransactionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DepositTransaction {
    private Float price;
    private Integer count;
    private String currency = null;
    private Long depositedAt = null;

    public DepositTransaction(
        Float price,
        Integer count,
        DepositTransactionOptions options
    ) {
        this.price = price;
        this.count = count;
        this.currency = options.currency;
        this.depositedAt = options.depositedAt;
    }
    public DepositTransaction(
        Float price,
        Integer count
    ) {
        this.price = price;
        this.count = count;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.price != null) {
            properties.put("price", this.price);
        }
        if (this.currency != null) {
            properties.put("currency", this.currency);
        }
        if (this.count != null) {
            properties.put("count", this.count);
        }
        if (this.depositedAt != null) {
            properties.put("depositedAt", this.depositedAt);
        }

        return properties;
    }
}
