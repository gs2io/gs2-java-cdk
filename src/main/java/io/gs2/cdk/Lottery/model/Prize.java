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
package io.gs2.cdk.lottery.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.lottery.model.options.PrizeOptions;
import io.gs2.cdk.lottery.model.options.PrizeTypeIsActionOptions;
import io.gs2.cdk.lottery.model.options.PrizeTypeIsPrizeTableOptions;
import io.gs2.cdk.lottery.model.enums.PrizeType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Prize {
    private String prizeId;
    private PrizeType type;
    private Integer weight;
    private List<AcquireAction> acquireActions = null;
    private Integer drawnLimit = null;
    private String limitFailOverPrizeId = null;
    private String prizeTableName = null;

    public Prize(
        String prizeId,
        PrizeType type,
        Integer weight,
        PrizeOptions options
    ) {
        this.prizeId = prizeId;
        this.type = type;
        this.weight = weight;
        this.acquireActions = options.acquireActions;
        this.drawnLimit = options.drawnLimit;
        this.limitFailOverPrizeId = options.limitFailOverPrizeId;
        this.prizeTableName = options.prizeTableName;
    }
    public Prize(
        String prizeId,
        PrizeType type,
        Integer weight
    ) {
        this.prizeId = prizeId;
        this.type = type;
        this.weight = weight;
    }

    public static Prize typeIsAction(
        String prizeId,
        Integer weight,
        List<AcquireAction> acquireActions,
        PrizeTypeIsActionOptions options
    ) {
        return (new Prize(
            prizeId,
            PrizeType.ACTION,
            weight,
            new PrizeOptions()
                .withAcquireActions(acquireActions)
                .withDrawnLimit(options.drawnLimit)
        ));
    }


    public static Prize typeIsAction(
        String prizeId,
        Integer weight,
        List<AcquireAction> acquireActions
    ) {
        return (new Prize(
            prizeId,
            PrizeType.ACTION,
            weight
        ));
    }

    public static Prize typeIsPrizeTable(
        String prizeId,
        Integer weight,
        String prizeTableName,
        PrizeTypeIsPrizeTableOptions options
    ) {
        return (new Prize(
            prizeId,
            PrizeType.PRIZE_TABLE,
            weight,
            new PrizeOptions()
                .withPrizeTableName(prizeTableName)
                .withDrawnLimit(options.drawnLimit)
        ));
    }


    public static Prize typeIsPrizeTable(
        String prizeId,
        Integer weight,
        String prizeTableName
    ) {
        return (new Prize(
            prizeId,
            PrizeType.PRIZE_TABLE,
            weight
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.prizeId != null) {
            properties.put("prizeId", this.prizeId);
        }
        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.acquireActions != null) {
            properties.put("acquireActions", this.acquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.drawnLimit != null) {
            properties.put("drawnLimit", this.drawnLimit);
        }
        if (this.limitFailOverPrizeId != null) {
            properties.put("limitFailOverPrizeId", this.limitFailOverPrizeId);
        }
        if (this.prizeTableName != null) {
            properties.put("prizeTableName", this.prizeTableName);
        }
        if (this.weight != null) {
            properties.put("weight", this.weight);
        }

        return properties;
    }
}
