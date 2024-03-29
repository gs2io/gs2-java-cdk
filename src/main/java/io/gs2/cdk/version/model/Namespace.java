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
package io.gs2.cdk.version.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.version.ref.NamespaceRef;
import io.gs2.cdk.version.model.CurrentMasterData;
import io.gs2.cdk.version.model.VersionModel;

import io.gs2.cdk.version.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String assumeUserId;
    private String description = null;
    private ScriptSetting acceptVersionScript = null;
    private String checkVersionTriggerScriptId = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        String assumeUserId,
        NamespaceOptions options
    ) {
        super(
            "Version_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.assumeUserId = assumeUserId;
        this.description = options.description;
        this.acceptVersionScript = options.acceptVersionScript;
        this.checkVersionTriggerScriptId = options.checkVersionTriggerScriptId;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        String assumeUserId
    ) {
        super(
            "Version_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.assumeUserId = assumeUserId;
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
        return "GS2::Version::Namespace";
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
        if (this.assumeUserId != null) {
            properties.put("AssumeUserId", this.assumeUserId);
        }
        if (this.acceptVersionScript != null) {
            properties.put("AcceptVersionScript", this.acceptVersionScript.properties(
            ));
        }
        if (this.checkVersionTriggerScriptId != null) {
            properties.put("CheckVersionTriggerScriptId", this.checkVersionTriggerScriptId);
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
        List<VersionModel> versionModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            versionModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
