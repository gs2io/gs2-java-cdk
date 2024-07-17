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
package io.gs2.cdk.identifier.model;
import io.gs2.cdk.identifier.model.options.TwoFactorAuthenticationSettingOptions;
import io.gs2.cdk.identifier.model.enums.TwoFactorAuthenticationSettingStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TwoFactorAuthenticationSetting {
    private String authenticationKey;
    private TwoFactorAuthenticationSettingStatus status;

    public TwoFactorAuthenticationSetting(
        String authenticationKey,
        TwoFactorAuthenticationSettingStatus status,
        TwoFactorAuthenticationSettingOptions options
    ) {
        this.authenticationKey = authenticationKey;
        this.status = status;
    }
    public TwoFactorAuthenticationSetting(
        String authenticationKey,
        TwoFactorAuthenticationSettingStatus status
    ) {
        this.authenticationKey = authenticationKey;
        this.status = status;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.authenticationKey != null) {
            properties.put("authenticationKey", this.authenticationKey);
        }
        if (this.status != null) {
            properties.put("status", this.status.toString(
            ));
        }

        return properties;
    }
}
