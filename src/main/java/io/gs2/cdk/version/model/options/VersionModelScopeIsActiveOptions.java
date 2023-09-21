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

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VersionModelScopeIsActiveOptions {
    public String metadata;
    public List<ScheduleVersion> scheduleVersions;
    
    public VersionModelScopeIsActiveOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public VersionModelScopeIsActiveOptions withScheduleVersions(
        List<ScheduleVersion> scheduleVersions
    ) {
        this.scheduleVersions = scheduleVersions;
        return this;
    }
}
