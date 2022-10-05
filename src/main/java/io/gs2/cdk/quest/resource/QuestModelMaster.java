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

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.quest.ref.*;
import io.gs2.cdk.quest.model.*;

import java.util.*;
import java.util.stream.*;


public class QuestModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String questGroupName;
    public String name;
    public String description;
    public String metadata;
    public List<Contents> contents;
    public String challengePeriodEventId;
    public List<AcquireAction> firstCompleteAcquireActions;
    public List<ConsumeAction> consumeActions;
    public List<AcquireAction> failedAcquireActions;
    public List<String> premiseQuestNames;

    public QuestModelMaster(
            Stack stack,
            String namespaceName,
            String questGroupName,
            String name,
            List<Contents> contents
    ) {
        super("Quest_QuestModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.questGroupName = questGroupName;
        this.name = name;
        this.contents = contents;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Quest::QuestModelMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.questGroupName != null) {
            properties.put("QuestGroupName", this.questGroupName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
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

    public QuestModelMasterRef ref(
            String namespaceName,
            String questGroupName
    ) {
        return new QuestModelMasterRef(
            namespaceName,
            questGroupName,
            this.name
        );
    }

    public GetAttr getAttrQuestModelId() {
        return new GetAttr(
            "Item.QuestModelId"
        );
    }
}
