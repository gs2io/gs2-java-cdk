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
import io.gs2.cdk.lottery.model.options.LotteryModelOptions;
import io.gs2.cdk.lottery.model.options.LotteryModelMethodIsPrizeTableOptions;
import io.gs2.cdk.lottery.model.options.LotteryModelMethodIsScriptOptions;
import io.gs2.cdk.lottery.model.enums.LotteryModelMode;
import io.gs2.cdk.lottery.model.enums.LotteryModelMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryModel {
    private String name;
    private LotteryModelMode mode;
    private LotteryModelMethod method;
    private String metadata = null;
    private String prizeTableName = null;
    private String choicePrizeTableScriptId = null;

    public LotteryModel(
        String name,
        LotteryModelMode mode,
        LotteryModelMethod method,
        LotteryModelOptions options
    ) {
        this.name = name;
        this.mode = mode;
        this.method = method;
        this.metadata = options.metadata;
        this.prizeTableName = options.prizeTableName;
        this.choicePrizeTableScriptId = options.choicePrizeTableScriptId;
    }
    public LotteryModel(
        String name,
        LotteryModelMode mode,
        LotteryModelMethod method
    ) {
        this.name = name;
        this.mode = mode;
        this.method = method;
    }

    public static LotteryModel methodIsPrizeTable(
        String name,
        LotteryModelMode mode,
        LotteryModelMethodIsPrizeTableOptions options
    ) {
        return (new LotteryModel(
            name,
            mode,
            LotteryModelMethod.PRIZE_TABLE,
            new LotteryModelOptions()
                .withMetadata(options.metadata)
        ));
    }


    public static LotteryModel methodIsPrizeTable(
        String name,
        LotteryModelMode mode
    ) {
        return (new LotteryModel(
            name,
            mode,
            LotteryModelMethod.PRIZE_TABLE
        ));
    }

    public static LotteryModel methodIsScript(
        String name,
        LotteryModelMode mode,
        LotteryModelMethodIsScriptOptions options
    ) {
        return (new LotteryModel(
            name,
            mode,
            LotteryModelMethod.SCRIPT,
            new LotteryModelOptions()
                .withMetadata(options.metadata)
        ));
    }


    public static LotteryModel methodIsScript(
        String name,
        LotteryModelMode mode
    ) {
        return (new LotteryModel(
            name,
            mode,
            LotteryModelMethod.SCRIPT
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.mode != null) {
            properties.put("mode", this.mode.toString(
            ));
        }
        if (this.method != null) {
            properties.put("method", this.method.toString(
            ));
        }
        if (this.prizeTableName != null) {
            properties.put("prizeTableName", this.prizeTableName);
        }
        if (this.choicePrizeTableScriptId != null) {
            properties.put("choicePrizeTableScriptId", this.choicePrizeTableScriptId);
        }

        return properties;
    }
}
