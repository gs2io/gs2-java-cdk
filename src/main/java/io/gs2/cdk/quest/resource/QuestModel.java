/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.quest.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.quest.ref.*;
import io.gs2.cdk.quest.model.*;

import java.util.*;
import java.util.stream.*;

public class QuestModel {
	public String name;
	public String metadata;
	public List<Contents> contents;
	public String challengePeriodEventId;
	public List<AcquireAction> firstCompleteAcquireActions;
	public List<ConsumeAction> consumeActions;
	public List<AcquireAction> failedAcquireActions;
	public List<String> premiseQuestNames;

    public QuestModel(
            String name,
            List<Contents> contents
    ) {
        this.name = name;
        this.contents = contents;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.contents != null) {
            properties.put("Contents", this.contents.stream().map(Contents::properties).collect(Collectors.toList()));
        }
        if (this.challengePeriodEventId != null) {
            properties.put("ChallengePeriodEventId", this.challengePeriodEventId);
        }
        if (this.firstCompleteAcquireActions != null) {
            properties.put("FirstCompleteAcquireActions", this.firstCompleteAcquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.consumeActions != null) {
            properties.put("ConsumeActions", this.consumeActions.stream().map(ConsumeAction::properties).collect(Collectors.toList()));
        }
        if (this.failedAcquireActions != null) {
            properties.put("FailedAcquireActions", this.failedAcquireActions.stream().map(AcquireAction::properties).collect(Collectors.toList()));
        }
        if (this.premiseQuestNames != null) {
            properties.put("PremiseQuestNames", this.premiseQuestNames);
        }
        return properties;
    }

    public QuestModelRef ref(
            String namespaceName,
            String questGroupName
    ) {
        return new QuestModelRef(
            namespaceName,
            questGroupName,
            this.name
        );
    }
}
