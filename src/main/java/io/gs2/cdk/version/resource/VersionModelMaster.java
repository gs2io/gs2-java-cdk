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

package io.gs2.cdk.version.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.version.ref.*;
import io.gs2.cdk.version.model.*;

import java.util.*;
import java.util.stream.*;


public class VersionModelMaster extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String description;
    public String metadata;
    public Version warningVersion;
    public Version errorVersion;
    public String scope;
    public Version currentVersion;
    public Boolean needSignature;
    public String signatureKeyId;

    public VersionModelMaster(
            Stack stack,
            String namespaceName,
            String name,
            Version warningVersion,
            Version errorVersion,
            String scope,
            Version currentVersion,
            Boolean needSignature,
            String signatureKeyId
    ) {
        super("Version_VersionModelMaster_" + name);

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.name = name;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
        this.scope = scope;
        this.currentVersion = currentVersion;
        this.needSignature = needSignature;
        this.signatureKeyId = signatureKeyId;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Version::VersionModelMaster";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
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
        if (this.warningVersion != null) {
            properties.put("WarningVersion", this.warningVersion.properties());
        }
        if (this.errorVersion != null) {
            properties.put("ErrorVersion", this.errorVersion.properties());
        }
        if (this.scope != null) {
            properties.put("Scope", this.scope.toString());
        }
        if (this.currentVersion != null) {
            properties.put("CurrentVersion", this.currentVersion.properties());
        }
        if (this.needSignature != null) {
            properties.put("NeedSignature", this.needSignature);
        }
        if (this.signatureKeyId != null) {
            properties.put("SignatureKeyId", this.signatureKeyId);
        }
        return properties;
    }

    public VersionModelMasterRef ref(
            String namespaceName
    ) {
        return new VersionModelMasterRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrVersionModelId() {
        return new GetAttr(
            "Item.VersionModelId"
        );
    }
}
