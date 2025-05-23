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
package io.gs2.cdk.version.model.options;
import io.gs2.cdk.version.model.Version;
import io.gs2.cdk.version.model.ScheduleVersion;
import io.gs2.cdk.version.model.enums.VersionModelScope;
import io.gs2.cdk.version.model.enums.VersionModelType;
import io.gs2.cdk.version.model.enums.VersionModelApproveRequirement;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VersionModelOptions {
    public String metadata;
    public Version currentVersion;
    public Version warningVersion;
    public Version errorVersion;
    public List<ScheduleVersion> scheduleVersions;
    public Boolean needSignature;
    public String signatureKeyId;
    public VersionModelApproveRequirement approveRequirement;
    
    public VersionModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public VersionModelOptions withCurrentVersion(
        Version currentVersion
    ) {
        this.currentVersion = currentVersion;
        return this;
    }
    
    public VersionModelOptions withWarningVersion(
        Version warningVersion
    ) {
        this.warningVersion = warningVersion;
        return this;
    }
    
    public VersionModelOptions withErrorVersion(
        Version errorVersion
    ) {
        this.errorVersion = errorVersion;
        return this;
    }
    
    public VersionModelOptions withScheduleVersions(
        List<ScheduleVersion> scheduleVersions
    ) {
        this.scheduleVersions = scheduleVersions;
        return this;
    }
    
    public VersionModelOptions withNeedSignature(
        Boolean needSignature
    ) {
        this.needSignature = needSignature;
        return this;
    }
    
    public VersionModelOptions withSignatureKeyId(
        String signatureKeyId
    ) {
        this.signatureKeyId = signatureKeyId;
        return this;
    }
    
    public VersionModelOptions withApproveRequirement(
        VersionModelApproveRequirement approveRequirement
    ) {
        this.approveRequirement = approveRequirement;
        return this;
    }
}

