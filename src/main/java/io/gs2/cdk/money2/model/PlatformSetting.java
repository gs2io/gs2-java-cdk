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
import io.gs2.cdk.money2.model.AppleAppStoreSetting;
import io.gs2.cdk.money2.model.GooglePlaySetting;
import io.gs2.cdk.money2.model.FakeSetting;
import io.gs2.cdk.money2.model.options.PlatformSettingOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PlatformSetting {
    private AppleAppStoreSetting appleAppStore = null;
    private GooglePlaySetting googlePlay = null;
    private FakeSetting fake = null;

    public PlatformSetting(
        PlatformSettingOptions options
    ) {
        this.appleAppStore = options.appleAppStore;
        this.googlePlay = options.googlePlay;
        this.fake = options.fake;
    }
    public PlatformSetting(
    ) {
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.appleAppStore != null) {
            properties.put("appleAppStore", this.appleAppStore.properties(
            ));
        }
        if (this.googlePlay != null) {
            properties.put("googlePlay", this.googlePlay.properties(
            ));
        }
        if (this.fake != null) {
            properties.put("fake", this.fake.properties(
            ));
        }

        return properties;
    }
}
