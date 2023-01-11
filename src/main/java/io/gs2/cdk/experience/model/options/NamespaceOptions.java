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
package io.gs2.cdk.experience.model.options;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public String experienceCapScriptId;
    public ScriptSetting changeExperienceScript;
    public ScriptSetting changeRankScript;
    public ScriptSetting changeRankCapScript;
    public ScriptSetting overflowExperienceScript;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withExperienceCapScriptId(
        String experienceCapScriptId
    ) {
        this.experienceCapScriptId = experienceCapScriptId;
        return this;
    }
    
    public NamespaceOptions withChangeExperienceScript(
        ScriptSetting changeExperienceScript
    ) {
        this.changeExperienceScript = changeExperienceScript;
        return this;
    }
    
    public NamespaceOptions withChangeRankScript(
        ScriptSetting changeRankScript
    ) {
        this.changeRankScript = changeRankScript;
        return this;
    }
    
    public NamespaceOptions withChangeRankCapScript(
        ScriptSetting changeRankCapScript
    ) {
        this.changeRankCapScript = changeRankCapScript;
        return this;
    }
    
    public NamespaceOptions withOverflowExperienceScript(
        ScriptSetting overflowExperienceScript
    ) {
        this.overflowExperienceScript = overflowExperienceScript;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

