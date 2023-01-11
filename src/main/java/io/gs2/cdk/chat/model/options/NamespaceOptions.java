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
package io.gs2.cdk.chat.model.options;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public ScriptSetting postMessageScript;
    public ScriptSetting createRoomScript;
    public ScriptSetting deleteRoomScript;
    public ScriptSetting subscribeRoomScript;
    public ScriptSetting unsubscribeRoomScript;
    public NotificationSetting postNotification;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withPostMessageScript(
        ScriptSetting postMessageScript
    ) {
        this.postMessageScript = postMessageScript;
        return this;
    }
    
    public NamespaceOptions withCreateRoomScript(
        ScriptSetting createRoomScript
    ) {
        this.createRoomScript = createRoomScript;
        return this;
    }
    
    public NamespaceOptions withDeleteRoomScript(
        ScriptSetting deleteRoomScript
    ) {
        this.deleteRoomScript = deleteRoomScript;
        return this;
    }
    
    public NamespaceOptions withSubscribeRoomScript(
        ScriptSetting subscribeRoomScript
    ) {
        this.subscribeRoomScript = subscribeRoomScript;
        return this;
    }
    
    public NamespaceOptions withUnsubscribeRoomScript(
        ScriptSetting unsubscribeRoomScript
    ) {
        this.unsubscribeRoomScript = unsubscribeRoomScript;
        return this;
    }
    
    public NamespaceOptions withPostNotification(
        NotificationSetting postNotification
    ) {
        this.postNotification = postNotification;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

