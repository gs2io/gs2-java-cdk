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
package io.gs2.cdk.guild.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public TransactionSetting transactionSetting;
    public NotificationSetting changeNotification;
    public NotificationSetting joinNotification;
    public NotificationSetting leaveNotification;
    public NotificationSetting changeMemberNotification;
    public Boolean changeMemberNotificationIgnoreChangeMetadata;
    public NotificationSetting receiveRequestNotification;
    public NotificationSetting removeRequestNotification;
    public ScriptSetting createGuildScript;
    public ScriptSetting updateGuildScript;
    public ScriptSetting joinGuildScript;
    public ScriptSetting receiveJoinRequestScript;
    public ScriptSetting leaveGuildScript;
    public ScriptSetting changeRoleScript;
    public ScriptSetting deleteGuildScript;
    public LogSetting logSetting;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withTransactionSetting(
        TransactionSetting transactionSetting
    ) {
        this.transactionSetting = transactionSetting;
        return this;
    }
    
    public NamespaceOptions withChangeNotification(
        NotificationSetting changeNotification
    ) {
        this.changeNotification = changeNotification;
        return this;
    }
    
    public NamespaceOptions withJoinNotification(
        NotificationSetting joinNotification
    ) {
        this.joinNotification = joinNotification;
        return this;
    }
    
    public NamespaceOptions withLeaveNotification(
        NotificationSetting leaveNotification
    ) {
        this.leaveNotification = leaveNotification;
        return this;
    }
    
    public NamespaceOptions withChangeMemberNotification(
        NotificationSetting changeMemberNotification
    ) {
        this.changeMemberNotification = changeMemberNotification;
        return this;
    }
    
    public NamespaceOptions withChangeMemberNotificationIgnoreChangeMetadata(
        Boolean changeMemberNotificationIgnoreChangeMetadata
    ) {
        this.changeMemberNotificationIgnoreChangeMetadata = changeMemberNotificationIgnoreChangeMetadata;
        return this;
    }
    
    public NamespaceOptions withReceiveRequestNotification(
        NotificationSetting receiveRequestNotification
    ) {
        this.receiveRequestNotification = receiveRequestNotification;
        return this;
    }
    
    public NamespaceOptions withRemoveRequestNotification(
        NotificationSetting removeRequestNotification
    ) {
        this.removeRequestNotification = removeRequestNotification;
        return this;
    }
    
    public NamespaceOptions withCreateGuildScript(
        ScriptSetting createGuildScript
    ) {
        this.createGuildScript = createGuildScript;
        return this;
    }
    
    public NamespaceOptions withUpdateGuildScript(
        ScriptSetting updateGuildScript
    ) {
        this.updateGuildScript = updateGuildScript;
        return this;
    }
    
    public NamespaceOptions withJoinGuildScript(
        ScriptSetting joinGuildScript
    ) {
        this.joinGuildScript = joinGuildScript;
        return this;
    }
    
    public NamespaceOptions withReceiveJoinRequestScript(
        ScriptSetting receiveJoinRequestScript
    ) {
        this.receiveJoinRequestScript = receiveJoinRequestScript;
        return this;
    }
    
    public NamespaceOptions withLeaveGuildScript(
        ScriptSetting leaveGuildScript
    ) {
        this.leaveGuildScript = leaveGuildScript;
        return this;
    }
    
    public NamespaceOptions withChangeRoleScript(
        ScriptSetting changeRoleScript
    ) {
        this.changeRoleScript = changeRoleScript;
        return this;
    }
    
    public NamespaceOptions withDeleteGuildScript(
        ScriptSetting deleteGuildScript
    ) {
        this.deleteGuildScript = deleteGuildScript;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

