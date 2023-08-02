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
package io.gs2.cdk.key.model;
import io.gs2.cdk.key.model.options.GitHubApiKeyOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GitHubApiKey {
    private String name;
    private String apiKey;
    private String encryptionKeyName;
    private String description = null;

    public GitHubApiKey(
        String name,
        String apiKey,
        String encryptionKeyName,
        GitHubApiKeyOptions options
    ) {
        this.name = name;
        this.apiKey = apiKey;
        this.encryptionKeyName = encryptionKeyName;
        this.description = options.description;
    }
    public GitHubApiKey(
        String name,
        String apiKey,
        String encryptionKeyName
    ) {
        this.name = name;
        this.apiKey = apiKey;
        this.encryptionKeyName = encryptionKeyName;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.description != null) {
            properties.put("description", this.description);
        }
        if (this.apiKey != null) {
            properties.put("apiKey", this.apiKey);
        }
        if (this.encryptionKeyName != null) {
            properties.put("encryptionKeyName", this.encryptionKeyName);
        }

        return properties;
    }
}
