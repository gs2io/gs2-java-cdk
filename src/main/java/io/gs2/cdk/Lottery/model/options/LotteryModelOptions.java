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
package io.gs2.cdk.lottery.model.options;
import io.gs2.cdk.lottery.model.enums.LotteryModelMode;
import io.gs2.cdk.lottery.model.enums.LotteryModelMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryModelOptions {
    public String metadata;
    public String prizeTableName;
    public String choicePrizeTableScriptId;
    
    public LotteryModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public LotteryModelOptions withPrizeTableName(
        String prizeTableName
    ) {
        this.prizeTableName = prizeTableName;
        return this;
    }
    
    public LotteryModelOptions withChoicePrizeTableScriptId(
        String choicePrizeTableScriptId
    ) {
        this.choicePrizeTableScriptId = choicePrizeTableScriptId;
        return this;
    }
}

