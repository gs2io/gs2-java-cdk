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
package io.gs2.cdk.experience.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.experience.ref.NamespaceRef;
import io.gs2.cdk.experience.model.CurrentMasterData;
import io.gs2.cdk.experience.model.ExperienceModel;

import io.gs2.cdk.experience.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private String rankCapScriptId = null;
    private ScriptSetting changeExperienceScript = null;
    private ScriptSetting changeRankScript = null;
    private ScriptSetting changeRankCapScript = null;
    private String overflowExperienceScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Experience_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.rankCapScriptId = options.rankCapScriptId;
        this.changeExperienceScript = options.changeExperienceScript;
        this.changeRankScript = options.changeRankScript;
        this.changeRankCapScript = options.changeRankCapScript;
        this.overflowExperienceScript = options.overflowExperienceScript;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name
    ) {
        super(
            "Experience_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
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
        return "GS2::Experience::Namespace";
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
        if (this.rankCapScriptId != null) {
            properties.put("RankCapScriptId", this.rankCapScriptId);
        }
        if (this.changeExperienceScript != null) {
            properties.put("ChangeExperienceScript", this.changeExperienceScript.properties(
            ));
        }
        if (this.changeRankScript != null) {
            properties.put("ChangeRankScript", this.changeRankScript.properties(
            ));
        }
        if (this.changeRankCapScript != null) {
            properties.put("ChangeRankCapScript", this.changeRankCapScript.properties(
            ));
        }
        if (this.overflowExperienceScript != null) {
            properties.put("OverflowExperienceScript", this.overflowExperienceScript);
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
            this,
            "Item.NamespaceId",
            null
        ));
    }

    public Namespace masterData(
        List<ExperienceModel> experienceModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            experienceModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
