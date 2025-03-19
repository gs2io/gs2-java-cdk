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
import io.gs2.cdk.money2.model.AppleAppStoreVerifyReceiptEvent;
import io.gs2.cdk.money2.model.GooglePlayVerifyReceiptEvent;
import io.gs2.cdk.money2.model.RefundEvent;
import io.gs2.cdk.money2.model.options.RefundHistoryOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RefundHistory {
    private String transactionId;
    private Integer year;
    private Integer month;
    private Integer day;
    private RefundEvent detail;
    private String userId = null;

    public RefundHistory(
        String transactionId,
        Integer year,
        Integer month,
        Integer day,
        RefundEvent detail,
        RefundHistoryOptions options
    ) {
        this.transactionId = transactionId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.detail = detail;
        this.userId = options.userId;
    }
    public RefundHistory(
        String transactionId,
        Integer year,
        Integer month,
        Integer day,
        RefundEvent detail
    ) {
        this.transactionId = transactionId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.detail = detail;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.transactionId != null) {
            properties.put("transactionId", this.transactionId);
        }
        if (this.year != null) {
            properties.put("year", this.year);
        }
        if (this.month != null) {
            properties.put("month", this.month);
        }
        if (this.day != null) {
            properties.put("day", this.day);
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.detail != null) {
            properties.put("detail", this.detail.properties(
            ));
        }

        return properties;
    }
}
