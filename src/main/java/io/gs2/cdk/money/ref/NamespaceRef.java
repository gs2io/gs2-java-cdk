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
package io.gs2.cdk.money.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.money.stampSheet.DepositByUserId;
import io.gs2.cdk.money.stampSheet.RevertRecordReceipt;
import io.gs2.cdk.money.stampSheet.WithdrawByUserId;
import io.gs2.cdk.money.stampSheet.RecordReceipt;
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

    public DepositByUserId deposit(
        Integer slot,
        Float price,
        Integer count,
        String userId
    ) {
        return (new DepositByUserId(
            this.namespaceName,
            slot,
            price,
            count,
            userId
        ));
    }


    public DepositByUserId deposit(
        Integer slot,
        Float price,
        Integer count
    ) {
        return (new DepositByUserId(
            this.namespaceName,
            slot,
            price,
            count,
            "#{userId}"
        ));
    }

    public RevertRecordReceipt revertRecordReceipt(
        String receipt,
        String userId
    ) {
        return (new RevertRecordReceipt(
            this.namespaceName,
            receipt,
            userId
        ));
    }


    public RevertRecordReceipt revertRecordReceipt(
        String receipt
    ) {
        return (new RevertRecordReceipt(
            this.namespaceName,
            receipt,
            "#{userId}"
        ));
    }

    public WithdrawByUserId withdraw(
        Integer slot,
        Integer count,
        Boolean paidOnly,
        String userId
    ) {
        return (new WithdrawByUserId(
            this.namespaceName,
            slot,
            count,
            paidOnly,
            userId
        ));
    }


    public WithdrawByUserId withdraw(
        Integer slot,
        Integer count,
        Boolean paidOnly
    ) {
        return (new WithdrawByUserId(
            this.namespaceName,
            slot,
            count,
            paidOnly,
            "#{userId}"
        ));
    }

    public RecordReceipt recordReceipt(
        String contentsId,
        String receipt,
        String userId
    ) {
        return (new RecordReceipt(
            this.namespaceName,
            contentsId,
            receipt,
            userId
        ));
    }


    public RecordReceipt recordReceipt(
        String contentsId,
        String receipt
    ) {
        return (new RecordReceipt(
            this.namespaceName,
            contentsId,
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
                "money",
                this.namespaceName
            )
        )).str(
        );
    }
}
