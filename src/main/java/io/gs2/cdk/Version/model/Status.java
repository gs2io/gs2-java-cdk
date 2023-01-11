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
import io.gs2.cdk.version.model.VersionModel;
import io.gs2.cdk.version.model.options.StatusOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Status {
    private VersionModel versionModel;
    private Version currentVersion = null;

    public Status(
        VersionModel versionModel,
        StatusOptions options
    ) {
        this.versionModel = versionModel;
        this.currentVersion = options.currentVersion;
    }
    public Status(
        VersionModel versionModel
    ) {
        this.versionModel = versionModel;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.versionModel != null) {
            properties.put("versionModel", this.versionModel.properties(
            ));
        }
        if (this.currentVersion != null) {
            properties.put("currentVersion", this.currentVersion.properties(
            ));
        }

        return properties;
    }
}
