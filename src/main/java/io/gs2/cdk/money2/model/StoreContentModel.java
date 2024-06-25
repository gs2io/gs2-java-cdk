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
import io.gs2.cdk.money2.model.AppleAppStoreContent;
import io.gs2.cdk.money2.model.GooglePlayContent;
import io.gs2.cdk.money2.model.options.StoreContentModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StoreContentModel {
    private String name;
    private String metadata = null;
    private AppleAppStoreContent appleAppStore = null;
    private GooglePlayContent googlePlay = null;

    public StoreContentModel(
        String name,
        StoreContentModelOptions options
    ) {
        this.name = name;
        this.metadata = options.metadata;
        this.appleAppStore = options.appleAppStore;
        this.googlePlay = options.googlePlay;
    }
    public StoreContentModel(
        String name
    ) {
        this.name = name;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.appleAppStore != null) {
            properties.put("appleAppStore", this.appleAppStore.properties(
            ));
        }
        if (this.googlePlay != null) {
            properties.put("googlePlay", this.googlePlay.properties(
            ));
        }

        return properties;
    }
}
