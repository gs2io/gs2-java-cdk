/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.chat.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.chat.resource.*;

import java.util.*;
import java.util.stream.*;

public class NotificationType {
	public Integer category;
	public Boolean enableTransferMobilePushNotification;

    public NotificationType(
            Integer category,
            Boolean enableTransferMobilePushNotification
    ) {
        this.category = category;
        this.enableTransferMobilePushNotification = enableTransferMobilePushNotification;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.category != null) {
            properties.put("Category", this.category);
        }
        if (this.enableTransferMobilePushNotification != null) {
            properties.put("EnableTransferMobilePushNotification", this.enableTransferMobilePushNotification);
        }
        return properties;
    }
}
