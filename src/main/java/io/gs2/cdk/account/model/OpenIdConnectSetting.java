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
package io.gs2.cdk.account.model;
import io.gs2.cdk.account.model.options.OpenIdConnectSettingOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class OpenIdConnectSetting {
    private String configurationPath;
    private String clientId;
    private String clientSecret = null;
    private String appleTeamId = null;
    private String appleKeyId = null;
    private String applePrivateKeyPem = null;
    private String doneEndpointUrl = null;

    public OpenIdConnectSetting(
        String configurationPath,
        String clientId,
        OpenIdConnectSettingOptions options
    ) {
        this.configurationPath = configurationPath;
        this.clientId = clientId;
        this.clientSecret = options.clientSecret;
        this.appleTeamId = options.appleTeamId;
        this.appleKeyId = options.appleKeyId;
        this.applePrivateKeyPem = options.applePrivateKeyPem;
        this.doneEndpointUrl = options.doneEndpointUrl;
    }
    public OpenIdConnectSetting(
        String configurationPath,
        String clientId
    ) {
        this.configurationPath = configurationPath;
        this.clientId = clientId;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.configurationPath != null) {
            properties.put("configurationPath", this.configurationPath);
        }
        if (this.clientId != null) {
            properties.put("clientId", this.clientId);
        }
        if (this.clientSecret != null) {
            properties.put("clientSecret", this.clientSecret);
        }
        if (this.appleTeamId != null) {
            properties.put("appleTeamId", this.appleTeamId);
        }
        if (this.appleKeyId != null) {
            properties.put("appleKeyId", this.appleKeyId);
        }
        if (this.applePrivateKeyPem != null) {
            properties.put("applePrivateKeyPem", this.applePrivateKeyPem);
        }
        if (this.doneEndpointUrl != null) {
            properties.put("doneEndpointUrl", this.doneEndpointUrl);
        }

        return properties;
    }
}
