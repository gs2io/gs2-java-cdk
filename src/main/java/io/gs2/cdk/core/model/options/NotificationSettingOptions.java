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
package io.gs2.cdk.core.model.options;

public class NotificationSettingOptions {
    public String gatewayNamespaceId;
    public Boolean enableTransferMobileNotification;
    public String sound;

    public NotificationSettingOptions withGatewayNamespaceId(
            String gatewayNamespaceId
    ) {
        this.gatewayNamespaceId = gatewayNamespaceId;
        return this;
    }
    
    public NotificationSettingOptions withEnableTransferMobileNotification(
            Boolean enableTransferMobileNotification
    ) {
        this.enableTransferMobileNotification = enableTransferMobileNotification;
        return this;
    }

    public NotificationSettingOptions withSound(
            String sound
    ) {
        this.sound = sound;
        return this;
    }
}
