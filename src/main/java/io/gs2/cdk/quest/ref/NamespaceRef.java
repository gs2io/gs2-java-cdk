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

package io.gs2.cdk.quest.ref;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.quest.model.*;
import io.gs2.cdk.quest.stampSheet.*;

import java.util.*;
import java.util.stream.*;


public class NamespaceRef {
    public String namespaceName;

    public NamespaceRef(
            String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public CurrentQuestMasterRef currentQuestMaster(
    ) {
        return new CurrentQuestMasterRef(
            this.namespaceName
        );
    }

    public QuestGroupModelRef questGroupModel(
            String questGroupName
    ) {
        return new QuestGroupModelRef(
            this.namespaceName,
            questGroupName
        );
    }

    public QuestGroupModelMasterRef questGroupModelMaster(
            String questGroupName
    ) {
        return new QuestGroupModelMasterRef(
            this.namespaceName,
            questGroupName
        );
    }

    public CreateProgressByUserId createProgress(
            String questModelId,
            Boolean force,
            List<Config> config
    ) {
        return new CreateProgressByUserId(
            this.namespaceName,
            "#{userId}",
            questModelId,
            force,
            config
        );
    }

    public DeleteProgressByUserId deleteProgress(
    ) {
        return new DeleteProgressByUserId(
            this.namespaceName,
            "#{userId}"
        );
    }

    public String grn() {
        return new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region().str(),
                GetAttr.ownerId().str(),
                "quest",
                this.namespaceName
            )
        ).str();
    }
}
