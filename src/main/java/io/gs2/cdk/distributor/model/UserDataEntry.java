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
package io.gs2.cdk.distributor.model;
import io.gs2.cdk.distributor.model.options.UserDataEntryOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UserDataEntry {
    private String service;
    private String namespaceName;
    private String kind;
    private String payload;

    public UserDataEntry(
        String service,
        String namespaceName,
        String kind,
        String payload,
        UserDataEntryOptions options
    ) {
        this.service = service;
        this.namespaceName = namespaceName;
        this.kind = kind;
        this.payload = payload;
    }
    public UserDataEntry(
        String service,
        String namespaceName,
        String kind,
        String payload
    ) {
        this.service = service;
        this.namespaceName = namespaceName;
        this.kind = kind;
        this.payload = payload;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.service != null) {
            properties.put("service", this.service);
        }
        if (this.namespaceName != null) {
            properties.put("namespaceName", this.namespaceName);
        }
        if (this.kind != null) {
            properties.put("kind", this.kind);
        }
        if (this.payload != null) {
            properties.put("payload", this.payload);
        }

        return properties;
    }
}
