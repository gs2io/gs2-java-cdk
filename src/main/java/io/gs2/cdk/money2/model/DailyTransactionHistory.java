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
import io.gs2.cdk.money2.model.options.DailyTransactionHistoryOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DailyTransactionHistory {
    private Integer year;
    private Integer month;
    private Integer day;
    private String currency;
    private Double depositAmount;
    private Double withdrawAmount;
    private Long issueCount;
    private Long consumeCount;
    private Long revision = null;

    public DailyTransactionHistory(
        Integer year,
        Integer month,
        Integer day,
        String currency,
        Double depositAmount,
        Double withdrawAmount,
        Long issueCount,
        Long consumeCount,
        DailyTransactionHistoryOptions options
    ) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.currency = currency;
        this.depositAmount = depositAmount;
        this.withdrawAmount = withdrawAmount;
        this.issueCount = issueCount;
        this.consumeCount = consumeCount;
        this.revision = options.revision;
    }
    public DailyTransactionHistory(
        Integer year,
        Integer month,
        Integer day,
        String currency,
        Double depositAmount,
        Double withdrawAmount,
        Long issueCount,
        Long consumeCount
    ) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.currency = currency;
        this.depositAmount = depositAmount;
        this.withdrawAmount = withdrawAmount;
        this.issueCount = issueCount;
        this.consumeCount = consumeCount;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.year != null) {
            properties.put("year", this.year);
        }
        if (this.month != null) {
            properties.put("month", this.month);
        }
        if (this.day != null) {
            properties.put("day", this.day);
        }
        if (this.currency != null) {
            properties.put("currency", this.currency);
        }
        if (this.depositAmount != null) {
            properties.put("depositAmount", this.depositAmount);
        }
        if (this.withdrawAmount != null) {
            properties.put("withdrawAmount", this.withdrawAmount);
        }
        if (this.issueCount != null) {
            properties.put("issueCount", this.issueCount);
        }
        if (this.consumeCount != null) {
            properties.put("consumeCount", this.consumeCount);
        }

        return properties;
    }
}
