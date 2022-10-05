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

package io.gs2.cdk.experience.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.experience.ref.*;
import io.gs2.cdk.experience.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String name;
    public String description;
    public String experienceCapScriptId;
    public ScriptSetting changeExperienceScript;
    public ScriptSetting changeRankScript;
    public ScriptSetting changeRankCapScript;
    public ScriptSetting overflowExperienceScript;
    public LogSetting logSetting;

    public Namespace(
            Stack stack,
            String name
    ) {
        super("Experience_Namespace_" + name);

        this.stack = stack;
        this.name = name;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Experience::Namespace";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.experienceCapScriptId != null) {
            properties.put("ExperienceCapScriptId", this.experienceCapScriptId);
        }
        if (this.changeExperienceScript != null) {
            properties.put("ChangeExperienceScript", this.changeExperienceScript.properties());
        }
        if (this.changeRankScript != null) {
            properties.put("ChangeRankScript", this.changeRankScript.properties());
        }
        if (this.changeRankCapScript != null) {
            properties.put("ChangeRankCapScript", this.changeRankCapScript.properties());
        }
        if (this.overflowExperienceScript != null) {
            properties.put("OverflowExperienceScript", this.overflowExperienceScript.properties());
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties());
        }
        return properties;
    }

    public NamespaceRef ref(
    ) {
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }

    public Namespace masterData(
            List<ExperienceModel> experienceModels
    ) {
        new CurrentMasterData(
            this.stack,
            this.name,
            experienceModels
        ).addDependsOn(
            this
        );
        return this;
    }
}
