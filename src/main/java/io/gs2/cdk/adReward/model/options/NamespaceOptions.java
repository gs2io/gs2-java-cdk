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
package io.gs2.cdk.adReward.model.options;
import io.gs2.cdk.adReward.model.AdMob;
import io.gs2.cdk.adReward.model.UnityAd;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public AdMob admob;
    public UnityAd unityAd;
    public String description;
    public LogSetting logSetting;
    
    public NamespaceOptions withAdmob(
        AdMob admob
    ) {
        this.admob = admob;
        return this;
    }
    
    public NamespaceOptions withUnityAd(
        UnityAd unityAd
    ) {
        this.unityAd = unityAd;
        return this;
    }
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

