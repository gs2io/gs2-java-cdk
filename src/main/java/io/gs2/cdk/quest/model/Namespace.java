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

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.quest.ref.NamespaceRef;
import io.gs2.cdk.quest.model.CurrentMasterData;
import io.gs2.cdk.quest.model.QuestGroupModel;

import io.gs2.cdk.quest.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private TransactionSetting transactionSetting;
    private String description = null;
    private ScriptSetting startQuestScript = null;
    private ScriptSetting completeQuestScript = null;
    private ScriptSetting failedQuestScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        TransactionSetting transactionSetting,
        NamespaceOptions options
    ) {
        super(
            "Quest_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.transactionSetting = transactionSetting;
        this.description = options.description;
        this.startQuestScript = options.startQuestScript;
        this.completeQuestScript = options.completeQuestScript;
        this.failedQuestScript = options.failedQuestScript;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        TransactionSetting transactionSetting
    ) {
        super(
            "Quest_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.transactionSetting = transactionSetting;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Quest::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.startQuestScript != null) {
            properties.put("StartQuestScript", this.startQuestScript.properties(
            ));
        }
        if (this.completeQuestScript != null) {
            properties.put("CompleteQuestScript", this.completeQuestScript.properties(
            ));
        }
        if (this.failedQuestScript != null) {
            properties.put("FailedQuestScript", this.failedQuestScript.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            null,
            null,
            "Item.NamespaceId"
        ));
    }

    public Namespace masterData(
        List<QuestGroupModel> questGroupModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            questGroupModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
