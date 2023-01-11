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
package io.gs2.cdk.inbox.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public Boolean isAutomaticDeletingEnabled;
    public TransactionSetting transactionSetting;
    public ScriptSetting receiveMessageScript;
    public ScriptSetting readMessageScript;
    public ScriptSetting deleteMessageScript;
    public NotificationSetting receiveNotification;
    public LogSetting logSetting;
    public String queueNamespaceId;
    public String keyId;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withIsAutomaticDeletingEnabled(
        Boolean isAutomaticDeletingEnabled
    ) {
        this.isAutomaticDeletingEnabled = isAutomaticDeletingEnabled;
        return this;
    }
    
    public NamespaceOptions withTransactionSetting(
        TransactionSetting transactionSetting
    ) {
        this.transactionSetting = transactionSetting;
        return this;
    }
    
    public NamespaceOptions withReceiveMessageScript(
        ScriptSetting receiveMessageScript
    ) {
        this.receiveMessageScript = receiveMessageScript;
        return this;
    }
    
    public NamespaceOptions withReadMessageScript(
        ScriptSetting readMessageScript
    ) {
        this.readMessageScript = readMessageScript;
        return this;
    }
    
    public NamespaceOptions withDeleteMessageScript(
        ScriptSetting deleteMessageScript
    ) {
        this.deleteMessageScript = deleteMessageScript;
        return this;
    }
    
    public NamespaceOptions withReceiveNotification(
        NotificationSetting receiveNotification
    ) {
        this.receiveNotification = receiveNotification;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
    
    public NamespaceOptions withQueueNamespaceId(
        String queueNamespaceId
    ) {
        this.queueNamespaceId = queueNamespaceId;
        return this;
    }
    
    public NamespaceOptions withKeyId(
        String keyId
    ) {
        this.keyId = keyId;
        return this;
    }
}

