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
package io.gs2.cdk.realtime.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.realtime.model.TransactionSettingV2;
import io.gs2.cdk.realtime.model.SyncSetting;
import io.gs2.cdk.realtime.model.StateMachineSetting;
import io.gs2.cdk.realtime.model.ParticipantSetting;
import io.gs2.cdk.realtime.model.MobileNotificationMessage;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;
import io.gs2.cdk.realtime.model.enums.NamespaceServerType;
import io.gs2.cdk.realtime.model.enums.NamespaceServerSpec;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceServerTypeIsStateMachineOptions {
    public String description;
    public TransactionSetting transactionSetting;
    public TransactionSettingV2 transactionSettingV2;
    public SyncSetting syncSetting;
    public ParticipantSetting participantSetting;
    public NotificationSetting createNotification;
    public LogSetting logSetting;
    public Long revision;
    
    public NamespaceServerTypeIsStateMachineOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withTransactionSetting(
        TransactionSetting transactionSetting
    ) {
        this.transactionSetting = transactionSetting;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withTransactionSettingV2(
        TransactionSettingV2 transactionSettingV2
    ) {
        this.transactionSettingV2 = transactionSettingV2;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withSyncSetting(
        SyncSetting syncSetting
    ) {
        this.syncSetting = syncSetting;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withParticipantSetting(
        ParticipantSetting participantSetting
    ) {
        this.participantSetting = participantSetting;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withCreateNotification(
        NotificationSetting createNotification
    ) {
        this.createNotification = createNotification;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
    
    public NamespaceServerTypeIsStateMachineOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}
