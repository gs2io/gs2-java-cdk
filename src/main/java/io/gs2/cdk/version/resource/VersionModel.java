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

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.version.ref.*;
import io.gs2.cdk.version.model.*;

import java.util.*;
import java.util.stream.*;

public class VersionModel {

    public enum Scope {
        PASSIVE,
        ACTIVE;

        public String toString() {
            switch (this) {
                case PASSIVE:
                    return "passive";
                case ACTIVE:
                    return "active";
            }
            return "unknown";
        }
    }
	public String name;
	public String metadata;
	public Version warningVersion;
	public Version errorVersion;
	public Scope scope;
	public Version currentVersion;
	public Boolean needSignature;
	public String signatureKeyId;

    public VersionModel(
            String name,
            Version warningVersion,
            Version errorVersion,
            Scope scope
    ) {
        this.name = name;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
        this.scope = scope;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
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

    public VersionModelRef ref(
            String namespaceName
    ) {
        return new VersionModelRef(
            namespaceName,
            this.name
        );
    }
}
