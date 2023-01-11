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
import io.gs2.cdk.version.model.options.SignTargetVersionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SignTargetVersion {
    private String region;
    private String ownerId;
    private String namespaceName;
    private String versionName;
    private Version version;

    public SignTargetVersion(
        String region,
        String ownerId,
        String namespaceName,
        String versionName,
        Version version,
        SignTargetVersionOptions options
    ) {
        this.region = region;
        this.ownerId = ownerId;
        this.namespaceName = namespaceName;
        this.versionName = versionName;
        this.version = version;
    }
    public SignTargetVersion(
        String region,
        String ownerId,
        String namespaceName,
        String versionName,
        Version version
    ) {
        this.region = region;
        this.ownerId = ownerId;
        this.namespaceName = namespaceName;
        this.versionName = versionName;
        this.version = version;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.region != null) {
            properties.put("region", this.region);
        }
        if (this.ownerId != null) {
            properties.put("ownerId", this.ownerId);
        }
        if (this.namespaceName != null) {
            properties.put("namespaceName", this.namespaceName);
        }
        if (this.versionName != null) {
            properties.put("versionName", this.versionName);
        }
        if (this.version != null) {
            properties.put("version", this.version.properties(
            ));
        }

        return properties;
    }
}
