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

package io.gs2.cdk.version.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.version.resource.*;

import java.util.*;
import java.util.stream.*;

public class TargetVersion {
	public String versionName;
	public Version version;
	public String body;
	public String signature;

    public TargetVersion(
            String versionName,
            Version version
    ) {
        this.versionName = versionName;
        this.version = version;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.versionName != null) {
            properties.put("VersionName", this.versionName);
        }
        if (this.version != null) {
            properties.put("Version", this.version.properties());
        }
        if (this.body != null) {
            properties.put("Body", this.body);
        }
        if (this.signature != null) {
            properties.put("Signature", this.signature);
        }
        return properties;
    }
}
