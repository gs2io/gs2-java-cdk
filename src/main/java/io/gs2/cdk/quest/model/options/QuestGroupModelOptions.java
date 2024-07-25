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
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.quest.model.QuestModel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class QuestGroupModelOptions {
    public String metadata;
    public List<QuestModel> quests;
    public String challengePeriodEventId;
    
    public QuestGroupModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public QuestGroupModelOptions withQuests(
        List<QuestModel> quests
    ) {
        this.quests = quests;
        return this;
    }
    
    public QuestGroupModelOptions withChallengePeriodEventId(
        String challengePeriodEventId
    ) {
        this.challengePeriodEventId = challengePeriodEventId;
        return this;
    }
}

