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
import io.gs2.cdk.version.model.options.ScheduleVersionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleVersion {
    private Version currentVersion;
    private Version warningVersion;
    private Version errorVersion;
    private String scheduleEventId = null;

    public ScheduleVersion(
        Version currentVersion,
        Version warningVersion,
        Version errorVersion,
        ScheduleVersionOptions options
    ) {
        this.currentVersion = currentVersion;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
        this.scheduleEventId = options.scheduleEventId;
    }
    public ScheduleVersion(
        Version currentVersion,
        Version warningVersion,
        Version errorVersion
    ) {
        this.currentVersion = currentVersion;
        this.warningVersion = warningVersion;
        this.errorVersion = errorVersion;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

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
        if (this.scheduleEventId != null) {
            properties.put("scheduleEventId", this.scheduleEventId);
        }

        return properties;
    }
}
