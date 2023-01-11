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
import io.gs2.cdk.version.model.Version;
import io.gs2.cdk.version.model.options.VersionModelOptions;
import io.gs2.cdk.version.model.options.VersionModelScopeIsPassiveOptions;
import io.gs2.cdk.version.model.options.VersionModelScopeIsActiveOptions;
import io.gs2.cdk.version.model.enums.VersionModelScope;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VersionModel {
    private String name;
    private Version warningVersion;
    private Version errorVersion;
    private VersionModelScope scope;
    private String metadata = null;
    private Version currentVersion = null;
    private Boolean needSignature = null;
    private String signatureKeyId = null;

    public VersionModel(
        String name,
        Version warningVersion,
        Version errorVersion,
        VersionModelScope scope,
        VersionModelOptions options
    ) {
        this.name = name;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
        this.scope = scope;
        this.metadata = options.metadata;
        this.currentVersion = options.currentVersion;
        this.needSignature = options.needSignature;
        this.signatureKeyId = options.signatureKeyId;
    }
    public VersionModel(
        String name,
        Version warningVersion,
        Version errorVersion,
        VersionModelScope scope
    ) {
        this.name = name;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
        this.scope = scope;
    }

    public static VersionModel scopeIsPassive(
        String name,
        Version warningVersion,
        Version errorVersion,
        Boolean needSignature,
        VersionModelScopeIsPassiveOptions options
    ) {
        return (new VersionModel(
            name,
            warningVersion,
            errorVersion,
            VersionModelScope.PASSIVE,
            new VersionModelOptions()
                .withNeedSignature(needSignature)
                .withMetadata(options.metadata)
        ));
    }


    public static VersionModel scopeIsPassive(
        String name,
        Version warningVersion,
        Version errorVersion,
        Boolean needSignature
    ) {
        return (new VersionModel(
            name,
            warningVersion,
            errorVersion,
            VersionModelScope.PASSIVE
        ));
    }

    public static VersionModel scopeIsActive(
        String name,
        Version warningVersion,
        Version errorVersion,
        Version currentVersion,
        VersionModelScopeIsActiveOptions options
    ) {
        return (new VersionModel(
            name,
            warningVersion,
            errorVersion,
            VersionModelScope.ACTIVE,
            new VersionModelOptions()
                .withCurrentVersion(currentVersion)
                .withMetadata(options.metadata)
        ));
    }


    public static VersionModel scopeIsActive(
        String name,
        Version warningVersion,
        Version errorVersion,
        Version currentVersion
    ) {
        return (new VersionModel(
            name,
            warningVersion,
            errorVersion,
            VersionModelScope.ACTIVE
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.warningVersion != null) {
            properties.put("warningVersion", this.warningVersion.properties(
            ));
        }
        if (this.errorVersion != null) {
            properties.put("errorVersion", this.errorVersion.properties(
            ));
        }
        if (this.scope != null) {
            properties.put("scope", this.scope.toString(
            ));
        }
        if (this.currentVersion != null) {
            properties.put("currentVersion", this.currentVersion.properties(
            ));
        }
        if (this.needSignature != null) {
            properties.put("needSignature", this.needSignature);
        }
        if (this.signatureKeyId != null) {
            properties.put("signatureKeyId", this.signatureKeyId);
        }

        return properties;
    }
}
