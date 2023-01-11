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
package io.gs2.cdk.quest.model.options;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.quest.model.Contents;
import io.gs2.cdk.core.model.ConsumeAction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class QuestModelOptions {
    public String metadata;
    public String challengePeriodEventId;
    public List<AcquireAction> firstCompleteAcquireActions;
    public List<ConsumeAction> consumeActions;
    public List<AcquireAction> failedAcquireActions;
    public List<String> premiseQuestNames;
    
    public QuestModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public QuestModelOptions withChallengePeriodEventId(
        String challengePeriodEventId
    ) {
        this.challengePeriodEventId = challengePeriodEventId;
        return this;
    }
    
    public QuestModelOptions withFirstCompleteAcquireActions(
        List<AcquireAction> firstCompleteAcquireActions
    ) {
        this.firstCompleteAcquireActions = firstCompleteAcquireActions;
        return this;
    }
    
    public QuestModelOptions withConsumeActions(
        List<ConsumeAction> consumeActions
    ) {
        this.consumeActions = consumeActions;
        return this;
    }
    
    public QuestModelOptions withFailedAcquireActions(
        List<AcquireAction> failedAcquireActions
    ) {
        this.failedAcquireActions = failedAcquireActions;
        return this;
    }
    
    public QuestModelOptions withPremiseQuestNames(
        List<String> premiseQuestNames
    ) {
        this.premiseQuestNames = premiseQuestNames;
        return this;
    }
}

