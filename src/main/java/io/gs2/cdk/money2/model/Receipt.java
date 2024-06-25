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
import io.gs2.cdk.money2.model.options.ReceiptOptions;
import io.gs2.cdk.money2.model.enums.ReceiptStore;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Receipt {
    private ReceiptStore store;
    private String transactionID;
    private String payload;

    public Receipt(
        ReceiptStore store,
        String transactionID,
        String payload,
        ReceiptOptions options
    ) {
        this.store = store;
        this.transactionID = transactionID;
        this.payload = payload;
    }
    public Receipt(
        ReceiptStore store,
        String transactionID,
        String payload
    ) {
        this.store = store;
        this.transactionID = transactionID;
        this.payload = payload;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.store != null) {
            properties.put("store", this.store.toString(
            ));
        }
        if (this.transactionID != null) {
            properties.put("transactionID", this.transactionID);
        }
        if (this.payload != null) {
            properties.put("payload", this.payload);
        }

        return properties;
    }
}
