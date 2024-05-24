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
package io.gs2.cdk.exchange.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.exchange.ref.RateModelRef;
import io.gs2.cdk.exchange.ref.IncrementalRateModelRef;
import io.gs2.cdk.exchange.stampSheet.ExchangeByUserId;
import io.gs2.cdk.core.model.Config;
import io.gs2.cdk.exchange.stampSheet.IncrementalExchangeByUserId;
import io.gs2.cdk.exchange.stampSheet.UnlockIncrementalExchangeByUserId;
import io.gs2.cdk.exchange.stampSheet.CreateAwaitByUserId;
import io.gs2.cdk.exchange.stampSheet.SkipByUserId;
import io.gs2.cdk.exchange.stampSheet.DeleteAwaitByUserId;
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

    public RateModelRef rateModel(
        String rateName
    ) {
        return (new RateModelRef(
            this.namespaceName,
            rateName
        ));
    }

    public IncrementalRateModelRef incrementalRateModel(
        String rateName
    ) {
        return (new IncrementalRateModelRef(
            this.namespaceName,
            rateName
        ));
    }

    public ExchangeByUserId exchange(
        String rateName,
        Integer count,
        List<Config> config,
        String userId
    ) {
        return (new ExchangeByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            userId
        ));
    }


    public ExchangeByUserId exchange(
        String rateName,
        Integer count,
        List<Config> config
    ) {
        return (new ExchangeByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            "#{userId}"
        ));
    }

    public IncrementalExchangeByUserId incrementalExchange(
        String rateName,
        Integer count,
        List<Config> config,
        String userId
    ) {
        return (new IncrementalExchangeByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            userId
        ));
    }


    public IncrementalExchangeByUserId incrementalExchange(
        String rateName,
        Integer count,
        List<Config> config
    ) {
        return (new IncrementalExchangeByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            "#{userId}"
        ));
    }

    public UnlockIncrementalExchangeByUserId unlockIncrementalExchange(
        String rateName,
        String lockTransactionId,
        String userId
    ) {
        return (new UnlockIncrementalExchangeByUserId(
            this.namespaceName,
            rateName,
            lockTransactionId,
            userId
        ));
    }


    public UnlockIncrementalExchangeByUserId unlockIncrementalExchange(
        String rateName,
        String lockTransactionId
    ) {
        return (new UnlockIncrementalExchangeByUserId(
            this.namespaceName,
            rateName,
            lockTransactionId,
            "#{userId}"
        ));
    }

    public CreateAwaitByUserId createAwait(
        String rateName,
        Integer count,
        List<Config> config,
        String userId
    ) {
        return (new CreateAwaitByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            userId
        ));
    }


    public CreateAwaitByUserId createAwait(
        String rateName,
        Integer count,
        List<Config> config
    ) {
        return (new CreateAwaitByUserId(
            this.namespaceName,
            rateName,
            count,
            config,
            "#{userId}"
        ));
    }

    public SkipByUserId skip(
        String awaitName,
        String skipType,
        Integer minutes,
        Float rate,
        String userId
    ) {
        return (new SkipByUserId(
            this.namespaceName,
            awaitName,
            skipType,
            minutes,
            rate,
            userId
        ));
    }


    public SkipByUserId skip(
        String awaitName,
        String skipType,
        Integer minutes,
        Float rate
    ) {
        return (new SkipByUserId(
            this.namespaceName,
            awaitName,
            skipType,
            minutes,
            rate,
            "#{userId}"
        ));
    }

    public DeleteAwaitByUserId deleteAwait(
        String awaitName,
        String userId
    ) {
        return (new DeleteAwaitByUserId(
            this.namespaceName,
            awaitName,
            userId
        ));
    }


    public DeleteAwaitByUserId deleteAwait(
        String awaitName
    ) {
        return (new DeleteAwaitByUserId(
            this.namespaceName,
            awaitName,
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
                "exchange",
                this.namespaceName
            )
        )).str(
        );
    }
}
