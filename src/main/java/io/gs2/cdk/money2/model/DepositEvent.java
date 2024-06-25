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
import io.gs2.cdk.money2.model.DepositTransaction;
import io.gs2.cdk.money2.model.WalletSummary;
import io.gs2.cdk.money2.model.options.DepositEventOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DepositEvent {
    private Integer slot;
    private WalletSummary status;
    private List<DepositTransaction> depositTransactions = null;

    public DepositEvent(
        Integer slot,
        WalletSummary status,
        DepositEventOptions options
    ) {
        this.slot = slot;
        this.status = status;
        this.depositTransactions = options.depositTransactions;
    }
    public DepositEvent(
        Integer slot,
        WalletSummary status
    ) {
        this.slot = slot;
        this.status = status;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.slot != null) {
            properties.put("slot", this.slot);
        }
        if (this.depositTransactions != null) {
            properties.put("depositTransactions", this.depositTransactions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.status != null) {
            properties.put("status", this.status.properties(
            ));
        }

        return properties;
    }
}
