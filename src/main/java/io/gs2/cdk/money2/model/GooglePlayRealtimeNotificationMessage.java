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
import io.gs2.cdk.money2.model.options.GooglePlayRealtimeNotificationMessageOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GooglePlayRealtimeNotificationMessage {
    private String data;
    private String messageId;
    private String publishTime;

    public GooglePlayRealtimeNotificationMessage(
        String data,
        String messageId,
        String publishTime,
        GooglePlayRealtimeNotificationMessageOptions options
    ) {
        this.data = data;
        this.messageId = messageId;
        this.publishTime = publishTime;
    }
    public GooglePlayRealtimeNotificationMessage(
        String data,
        String messageId,
        String publishTime
    ) {
        this.data = data;
        this.messageId = messageId;
        this.publishTime = publishTime;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.data != null) {
            properties.put("data", this.data);
        }
        if (this.messageId != null) {
            properties.put("messageId", this.messageId);
        }
        if (this.publishTime != null) {
            properties.put("publishTime", this.publishTime);
        }

        return properties;
    }
}
