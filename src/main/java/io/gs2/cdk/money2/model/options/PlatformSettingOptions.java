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
package io.gs2.cdk.money2.model.options;
import io.gs2.cdk.money2.model.AppleAppStoreSetting;
import io.gs2.cdk.money2.model.GooglePlaySetting;
import io.gs2.cdk.money2.model.FakeSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PlatformSettingOptions {
    public AppleAppStoreSetting appleAppStore;
    public GooglePlaySetting googlePlay;
    public FakeSetting fake;
    
    public PlatformSettingOptions withAppleAppStore(
        AppleAppStoreSetting appleAppStore
    ) {
        this.appleAppStore = appleAppStore;
        return this;
    }
    
    public PlatformSettingOptions withGooglePlay(
        GooglePlaySetting googlePlay
    ) {
        this.googlePlay = googlePlay;
        return this;
    }
    
    public PlatformSettingOptions withFake(
        FakeSetting fake
    ) {
        this.fake = fake;
        return this;
    }
}

