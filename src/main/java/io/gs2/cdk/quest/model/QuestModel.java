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
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.quest.model.options.QuestModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class QuestModel {
    private String name;
    private List<Contents> contents;
    private String metadata = null;
    private String challengePeriodEventId = null;
    private List<AcquireAction> firstCompleteAcquireActions = null;
    private List<ConsumeAction> consumeActions = null;
    private List<AcquireAction> failedAcquireActions = null;
    private List<String> premiseQuestNames = null;

    public QuestModel(
        String name,
        List<Contents> contents,
        QuestModelOptions options
    ) {
        this.name = name;
        this.contents = contents;
        this.metadata = options.metadata;
        this.challengePeriodEventId = options.challengePeriodEventId;
        this.firstCompleteAcquireActions = options.firstCompleteAcquireActions;
        this.consumeActions = options.consumeActions;
        this.failedAcquireActions = options.failedAcquireActions;
        this.premiseQuestNames = options.premiseQuestNames;
    }
    public QuestModel(
        String name,
        List<Contents> contents
    ) {
        this.name = name;
        this.contents = contents;
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
        if (this.contents != null) {
            properties.put("contents", this.contents.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("challengePeriodEventId", this.challengePeriodEventId);
        }
        if (this.firstCompleteAcquireActions != null) {
            properties.put("firstCompleteAcquireActions", this.firstCompleteAcquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.consumeActions != null) {
            properties.put("consumeActions", this.consumeActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.failedAcquireActions != null) {
            properties.put("failedAcquireActions", this.failedAcquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.premiseQuestNames != null) {
            properties.put("premiseQuestNames", this.premiseQuestNames);
        }

        return properties;
    }
}
