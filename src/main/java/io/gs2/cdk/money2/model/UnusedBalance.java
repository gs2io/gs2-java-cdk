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
import io.gs2.cdk.money2.model.options.UnusedBalanceOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnusedBalance {
    private String currency;
    private Double balance;
    private Long revision = null;

    public UnusedBalance(
        String currency,
        Double balance,
        UnusedBalanceOptions options
    ) {
        this.currency = currency;
        this.balance = balance;
        this.revision = options.revision;
    }
    public UnusedBalance(
        String currency,
        Double balance
    ) {
        this.currency = currency;
        this.balance = balance;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.currency != null) {
            properties.put("currency", this.currency);
        }
        if (this.balance != null) {
            properties.put("balance", this.balance);
        }

        return properties;
    }
}
