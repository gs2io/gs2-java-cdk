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
package io.gs2.cdk.quest.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.quest.model.Contents;
import io.gs2.cdk.core.model.VerifyAction;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.quest.model.QuestModel;
import io.gs2.cdk.quest.model.options.QuestGroupModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class QuestGroupModel {
    private String name;
    private String metadata = null;
    private List<QuestModel> quests = null;
    private String challengePeriodEventId = null;

    public QuestGroupModel(
        String name,
        QuestGroupModelOptions options
    ) {
        this.name = name;
        this.metadata = options.metadata;
        this.quests = options.quests;
        this.challengePeriodEventId = options.challengePeriodEventId;
    }
    public QuestGroupModel(
        String name
    ) {
        this.name = name;
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
        if (this.quests != null) {
            properties.put("quests", this.quests.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("challengePeriodEventId", this.challengePeriodEventId);
        }

        return properties;
    }
}
