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
package io.gs2.cdk.limit.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.limit.ref.LimitModelRef;
import io.gs2.cdk.limit.stampSheet.CountDownByUserId;
import io.gs2.cdk.limit.stampSheet.DeleteCounterByUserId;
import io.gs2.cdk.limit.stampSheet.CountUpByUserId;
import io.gs2.cdk.limit.stampSheet.VerifyCounterByUserId;
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

    public LimitModelRef limitModel(
        String limitName
    ) {
        return (new LimitModelRef(
            this.namespaceName,
            limitName
        ));
    }

    public CountDownByUserId countDown(
        String limitName,
        String counterName,
        Integer countDownValue,
        String userId
    ) {
        return (new CountDownByUserId(
            this.namespaceName,
            limitName,
            counterName,
            countDownValue,
            userId
        ));
    }


    public CountDownByUserId countDown(
        String limitName,
        String counterName,
        Integer countDownValue
    ) {
        return (new CountDownByUserId(
            this.namespaceName,
            limitName,
            counterName,
            countDownValue,
            "#{userId}"
        ));
    }

    public DeleteCounterByUserId deleteCounter(
        String limitName,
        String counterName,
        String userId
    ) {
        return (new DeleteCounterByUserId(
            this.namespaceName,
            limitName,
            counterName,
            userId
        ));
    }


    public DeleteCounterByUserId deleteCounter(
        String limitName,
        String counterName
    ) {
        return (new DeleteCounterByUserId(
            this.namespaceName,
            limitName,
            counterName,
            "#{userId}"
        ));
    }

    public CountUpByUserId countUp(
        String limitName,
        String counterName,
        Integer countUpValue,
        Integer maxValue,
        String userId
    ) {
        return (new CountUpByUserId(
            this.namespaceName,
            limitName,
            counterName,
            countUpValue,
            maxValue,
            userId
        ));
    }


    public CountUpByUserId countUp(
        String limitName,
        String counterName,
        Integer countUpValue,
        Integer maxValue
    ) {
        return (new CountUpByUserId(
            this.namespaceName,
            limitName,
            counterName,
            countUpValue,
            maxValue,
            "#{userId}"
        ));
    }

    public VerifyCounterByUserId verifyCounter(
        String limitName,
        String counterName,
        String verifyType,
        Integer count,
        String userId
    ) {
        return (new VerifyCounterByUserId(
            this.namespaceName,
            limitName,
            counterName,
            verifyType,
            count,
            userId
        ));
    }


    public VerifyCounterByUserId verifyCounter(
        String limitName,
        String counterName,
        String verifyType,
        Integer count
    ) {
        return (new VerifyCounterByUserId(
            this.namespaceName,
            limitName,
            counterName,
            verifyType,
            count,
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
                "limit",
                this.namespaceName
            )
        )).str(
        );
    }
}
