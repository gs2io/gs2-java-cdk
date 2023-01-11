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
package io.gs2.cdk.friend.model.options;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public ScriptSetting followScript;
    public ScriptSetting unfollowScript;
    public ScriptSetting sendRequestScript;
    public ScriptSetting cancelRequestScript;
    public ScriptSetting acceptRequestScript;
    public ScriptSetting rejectRequestScript;
    public ScriptSetting deleteFriendScript;
    public ScriptSetting updateProfileScript;
    public NotificationSetting followNotification;
    public NotificationSetting receiveRequestNotification;
    public NotificationSetting acceptRequestNotification;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withFollowScript(
        ScriptSetting followScript
    ) {
        this.followScript = followScript;
        return this;
    }
    
    public NamespaceOptions withUnfollowScript(
        ScriptSetting unfollowScript
    ) {
        this.unfollowScript = unfollowScript;
        return this;
    }
    
    public NamespaceOptions withSendRequestScript(
        ScriptSetting sendRequestScript
    ) {
        this.sendRequestScript = sendRequestScript;
        return this;
    }
    
    public NamespaceOptions withCancelRequestScript(
        ScriptSetting cancelRequestScript
    ) {
        this.cancelRequestScript = cancelRequestScript;
        return this;
    }
    
    public NamespaceOptions withAcceptRequestScript(
        ScriptSetting acceptRequestScript
    ) {
        this.acceptRequestScript = acceptRequestScript;
        return this;
    }
    
    public NamespaceOptions withRejectRequestScript(
        ScriptSetting rejectRequestScript
    ) {
        this.rejectRequestScript = rejectRequestScript;
        return this;
    }
    
    public NamespaceOptions withDeleteFriendScript(
        ScriptSetting deleteFriendScript
    ) {
        this.deleteFriendScript = deleteFriendScript;
        return this;
    }
    
    public NamespaceOptions withUpdateProfileScript(
        ScriptSetting updateProfileScript
    ) {
        this.updateProfileScript = updateProfileScript;
        return this;
    }
    
    public NamespaceOptions withFollowNotification(
        NotificationSetting followNotification
    ) {
        this.followNotification = followNotification;
        return this;
    }
    
    public NamespaceOptions withReceiveRequestNotification(
        NotificationSetting receiveRequestNotification
    ) {
        this.receiveRequestNotification = receiveRequestNotification;
        return this;
    }
    
    public NamespaceOptions withAcceptRequestNotification(
        NotificationSetting acceptRequestNotification
    ) {
        this.acceptRequestNotification = acceptRequestNotification;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

