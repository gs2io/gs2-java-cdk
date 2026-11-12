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
import io.gs2.cdk.account.model.options.AccountDeletionSettingOptions;
import io.gs2.cdk.account.model.enums.AccountDeletionSettingLoginDuringGracePeriod;
import io.gs2.cdk.account.model.enums.AccountDeletionSettingCleanUserDataScope;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDeletionSetting {
    private Integer gracePeriodMinutes;
    private AccountDeletionSettingLoginDuringGracePeriod loginDuringGracePeriod;
    private AccountDeletionSettingCleanUserDataScope cleanUserDataScope;

    public AccountDeletionSetting(
        Integer gracePeriodMinutes,
        AccountDeletionSettingLoginDuringGracePeriod loginDuringGracePeriod,
        AccountDeletionSettingCleanUserDataScope cleanUserDataScope,
        AccountDeletionSettingOptions options
    ) {
        this.gracePeriodMinutes = gracePeriodMinutes;
        this.loginDuringGracePeriod = loginDuringGracePeriod;
        this.cleanUserDataScope = cleanUserDataScope;
    }
    public AccountDeletionSetting(
        Integer gracePeriodMinutes,
        AccountDeletionSettingLoginDuringGracePeriod loginDuringGracePeriod,
        AccountDeletionSettingCleanUserDataScope cleanUserDataScope
    ) {
        this.gracePeriodMinutes = gracePeriodMinutes;
        this.loginDuringGracePeriod = loginDuringGracePeriod;
        this.cleanUserDataScope = cleanUserDataScope;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.gracePeriodMinutes != null) {
            properties.put("gracePeriodMinutes", this.gracePeriodMinutes);
        }
        if (this.loginDuringGracePeriod != null) {
            properties.put("loginDuringGracePeriod", this.loginDuringGracePeriod.toString(
            ));
        }
        if (this.cleanUserDataScope != null) {
            properties.put("cleanUserDataScope", this.cleanUserDataScope.toString(
            ));
        }

        return properties;
    }
}
