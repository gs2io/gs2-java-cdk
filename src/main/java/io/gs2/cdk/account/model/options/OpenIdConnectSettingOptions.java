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
package io.gs2.cdk.account.model.options;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class OpenIdConnectSettingOptions {
    public String clientSecret;
    public String appleTeamId;
    public String appleKeyId;
    public String applePrivateKeyPem;
    public String doneEndpointUrl;
    
    public OpenIdConnectSettingOptions withClientSecret(
        String clientSecret
    ) {
        this.clientSecret = clientSecret;
        return this;
    }
    
    public OpenIdConnectSettingOptions withAppleTeamId(
        String appleTeamId
    ) {
        this.appleTeamId = appleTeamId;
        return this;
    }
    
    public OpenIdConnectSettingOptions withAppleKeyId(
        String appleKeyId
    ) {
        this.appleKeyId = appleKeyId;
        return this;
    }
    
    public OpenIdConnectSettingOptions withApplePrivateKeyPem(
        String applePrivateKeyPem
    ) {
        this.applePrivateKeyPem = applePrivateKeyPem;
        return this;
    }
    
    public OpenIdConnectSettingOptions withDoneEndpointUrl(
        String doneEndpointUrl
    ) {
        this.doneEndpointUrl = doneEndpointUrl;
        return this;
    }
}

