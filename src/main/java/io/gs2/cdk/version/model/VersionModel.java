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
import io.gs2.cdk.version.model.ScheduleVersion;
import io.gs2.cdk.version.model.options.VersionModelOptions;
import io.gs2.cdk.version.model.options.VersionModelTypeIsSimpleOptions;
import io.gs2.cdk.version.model.options.VersionModelTypeIsScheduleOptions;
import io.gs2.cdk.version.model.options.VersionModelScopeIsPassiveOptions;
import io.gs2.cdk.version.model.options.VersionModelScopeIsActiveOptions;
import io.gs2.cdk.version.model.enums.VersionModelScope;
import io.gs2.cdk.version.model.enums.VersionModelType;
import io.gs2.cdk.version.model.enums.VersionModelApproveRequirement;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VersionModel {
    private String name;
    private VersionModelScope scope;
    private VersionModelType type;
    private String metadata = null;
    private Version currentVersion = null;
    private Version warningVersion = null;
    private Version errorVersion = null;
    private List<ScheduleVersion> scheduleVersions = null;
    private Boolean needSignature = null;
    private String signatureKeyId = null;
    private VersionModelApproveRequirement approveRequirement = null;

    public VersionModel(
        String name,
        VersionModelScope scope,
        VersionModelType type,
        VersionModelOptions options
    ) {
        this.name = name;
        this.scope = scope;
        this.type = type;
        this.metadata = options.metadata;
        this.currentVersion = options.currentVersion;
        this.warningVersion = options.warningVersion;
        this.errorVersion = options.errorVersion;
        this.scheduleVersions = options.scheduleVersions;
        this.needSignature = options.needSignature;
        this.signatureKeyId = options.signatureKeyId;
        this.approveRequirement = options.approveRequirement;
    }
    public VersionModel(
        String name,
        VersionModelScope scope,
        VersionModelType type
    ) {
        this.name = name;
        this.scope = scope;
        this.type = type;
    }

    public static VersionModel typeIsSimple(
        String name,
        VersionModelScope scope,
        Version warningVersion,
        Version errorVersion,
        VersionModelTypeIsSimpleOptions options
    ) {
        return (new VersionModel(
            name,
            scope,
            VersionModelType.SIMPLE,
            new VersionModelOptions()
                .withWarningVersion(warningVersion)
                .withErrorVersion(errorVersion)
                .withMetadata(options.metadata)
                .withScheduleVersions(options.scheduleVersions)
        ));
    }


    public static VersionModel typeIsSimple(
        String name,
        VersionModelScope scope,
        Version warningVersion,
        Version errorVersion
    ) {
        return (new VersionModel(
            name,
            scope,
            VersionModelType.SIMPLE
        ));
    }

    public static VersionModel typeIsSchedule(
        String name,
        VersionModelScope scope,
        VersionModelTypeIsScheduleOptions options
    ) {
        return (new VersionModel(
            name,
            scope,
            VersionModelType.SCHEDULE,
            new VersionModelOptions()
                .withMetadata(options.metadata)
                .withScheduleVersions(options.scheduleVersions)
        ));
    }


    public static VersionModel typeIsSchedule(
        String name,
        VersionModelScope scope
    ) {
        return (new VersionModel(
            name,
            scope,
            VersionModelType.SCHEDULE
        ));
    }

    public static VersionModel scopeIsPassive(
        String name,
        VersionModelType type,
        Boolean needSignature,
        VersionModelScopeIsPassiveOptions options
    ) {
        return (new VersionModel(
            name,
            VersionModelScope.PASSIVE,
            type,
            new VersionModelOptions()
                .withNeedSignature(needSignature)
                .withMetadata(options.metadata)
                .withScheduleVersions(options.scheduleVersions)
        ));
    }


    public static VersionModel scopeIsPassive(
        String name,
        VersionModelType type,
        Boolean needSignature
    ) {
        return (new VersionModel(
            name,
            VersionModelScope.PASSIVE,
            type
        ));
    }

    public static VersionModel scopeIsActive(
        String name,
        VersionModelType type,
        VersionModelApproveRequirement approveRequirement,
        VersionModelScopeIsActiveOptions options
    ) {
        return (new VersionModel(
            name,
            VersionModelScope.ACTIVE,
            type,
            new VersionModelOptions()
                .withApproveRequirement(approveRequirement)
                .withMetadata(options.metadata)
                .withScheduleVersions(options.scheduleVersions)
        ));
    }


    public static VersionModel scopeIsActive(
        String name,
        VersionModelType type,
        VersionModelApproveRequirement approveRequirement
    ) {
        return (new VersionModel(
            name,
            VersionModelScope.ACTIVE,
            type
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
        if (this.scope != null) {
            properties.put("scope", this.scope.toString(
            ));
        }
        if (this.type != null) {
            properties.put("type", this.type.toString(
            ));
        }
        if (this.currentVersion != null) {
            properties.put("currentVersion", this.currentVersion.properties(
            ));
        }
        if (this.warningVersion != null) {
            properties.put("warningVersion", this.warningVersion.properties(
            ));
        }
        if (this.errorVersion != null) {
            properties.put("errorVersion", this.errorVersion.properties(
            ));
        }
        if (this.scheduleVersions != null) {
            properties.put("scheduleVersions", this.scheduleVersions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.needSignature != null) {
            properties.put("needSignature", this.needSignature);
        }
        if (this.signatureKeyId != null) {
            properties.put("signatureKeyId", this.signatureKeyId);
        }
        if (this.approveRequirement != null) {
            properties.put("approveRequirement", this.approveRequirement.toString(
            ));
        }

        return properties;
    }
}
