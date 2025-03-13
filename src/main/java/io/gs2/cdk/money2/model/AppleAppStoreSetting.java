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
package io.gs2.cdk.money2.model;
import io.gs2.cdk.money2.model.options.AppleAppStoreSettingOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AppleAppStoreSetting {
    private String bundleId = null;
    private String sharedSecretKey = null;
    private String issuerId = null;
    private String keyId = null;
    private String privateKeyPem = null;

    public AppleAppStoreSetting(
        AppleAppStoreSettingOptions options
    ) {
        this.bundleId = options.bundleId;
        this.sharedSecretKey = options.sharedSecretKey;
        this.issuerId = options.issuerId;
        this.keyId = options.keyId;
        this.privateKeyPem = options.privateKeyPem;
    }
    public AppleAppStoreSetting(
    ) {
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.bundleId != null) {
            properties.put("bundleId", this.bundleId);
        }
        if (this.sharedSecretKey != null) {
            properties.put("sharedSecretKey", this.sharedSecretKey);
        }
        if (this.issuerId != null) {
            properties.put("issuerId", this.issuerId);
        }
        if (this.keyId != null) {
            properties.put("keyId", this.keyId);
        }
        if (this.privateKeyPem != null) {
            properties.put("privateKeyPem", this.privateKeyPem);
        }

        return properties;
    }
}
