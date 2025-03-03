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
import io.gs2.cdk.money2.model.AppleAppStoreVerifyReceiptEvent;
import io.gs2.cdk.money2.model.GooglePlayVerifyReceiptEvent;
import io.gs2.cdk.money2.model.options.RefundEventOptions;
import io.gs2.cdk.money2.model.enums.RefundEventPlatform;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RefundEvent {
    private String contentName;
    private RefundEventPlatform platform;
    private AppleAppStoreVerifyReceiptEvent appleAppStoreRefundEvent = null;
    private GooglePlayVerifyReceiptEvent googlePlayRefundEvent = null;

    public RefundEvent(
        String contentName,
        RefundEventPlatform platform,
        RefundEventOptions options
    ) {
        this.contentName = contentName;
        this.platform = platform;
        this.appleAppStoreRefundEvent = options.appleAppStoreRefundEvent;
        this.googlePlayRefundEvent = options.googlePlayRefundEvent;
    }
    public RefundEvent(
        String contentName,
        RefundEventPlatform platform
    ) {
        this.contentName = contentName;
        this.platform = platform;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.contentName != null) {
            properties.put("contentName", this.contentName);
        }
        if (this.platform != null) {
            properties.put("platform", this.platform.toString(
            ));
        }
        if (this.appleAppStoreRefundEvent != null) {
            properties.put("appleAppStoreRefundEvent", this.appleAppStoreRefundEvent.properties(
            ));
        }
        if (this.googlePlayRefundEvent != null) {
            properties.put("googlePlayRefundEvent", this.googlePlayRefundEvent.properties(
            ));
        }

        return properties;
    }
}
