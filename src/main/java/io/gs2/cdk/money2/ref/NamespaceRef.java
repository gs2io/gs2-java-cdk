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
package io.gs2.cdk.money2.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.money2.ref.DailyTransactionHistoryRef;
import io.gs2.cdk.money2.ref.StoreContentModelRef;
import io.gs2.cdk.money2.ref.UnusedBalanceRef;
import io.gs2.cdk.money2.stampSheet.DepositByUserId;
import io.gs2.cdk.money2.model.DepositTransaction;
import io.gs2.cdk.money2.stampSheet.WithdrawByUserId;
import io.gs2.cdk.money2.stampSheet.VerifyReceiptByUserId;
import io.gs2.cdk.money2.model.Receipt;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceRef {
    private String namespaceName;

    public NamespaceRef(
        String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public StoreContentModelRef storeContentModel(
        String contentName
    ) {
        return (new StoreContentModelRef(
            this.namespaceName,
            contentName
        ));
    }

    public DepositByUserId deposit(
        Integer slot,
        List<DepositTransaction> depositTransactions,
        String userId
    ) {
        return (new DepositByUserId(
            this.namespaceName,
            slot,
            depositTransactions,
            userId
        ));
    }


    public DepositByUserId deposit(
        Integer slot,
        List<DepositTransaction> depositTransactions
    ) {
        return (new DepositByUserId(
            this.namespaceName,
            slot,
            depositTransactions,
            "#{userId}"
        ));
    }

    public WithdrawByUserId withdraw(
        Integer slot,
        Integer withdrawCount,
        Boolean paidOnly,
        String userId
    ) {
        return (new WithdrawByUserId(
            this.namespaceName,
            slot,
            withdrawCount,
            paidOnly,
            userId
        ));
    }


    public WithdrawByUserId withdraw(
        Integer slot,
        Integer withdrawCount,
        Boolean paidOnly
    ) {
        return (new WithdrawByUserId(
            this.namespaceName,
            slot,
            withdrawCount,
            paidOnly,
            "#{userId}"
        ));
    }

    public VerifyReceiptByUserId verifyReceipt(
        String contentName,
        Receipt receipt,
        String userId
    ) {
        return (new VerifyReceiptByUserId(
            this.namespaceName,
            contentName,
            receipt,
            userId
        ));
    }


    public VerifyReceiptByUserId verifyReceipt(
        String contentName,
        Receipt receipt
    ) {
        return (new VerifyReceiptByUserId(
            this.namespaceName,
            contentName,
            receipt,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "money2",
                this.namespaceName
            )
        )).str(
        );
    }
}
