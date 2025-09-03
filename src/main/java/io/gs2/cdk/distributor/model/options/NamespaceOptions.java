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
package io.gs2.cdk.distributor.model.options;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public TransactionSetting transactionSetting;
    public String assumeUserId;
    public NotificationSetting autoRunStampSheetNotification;
    public NotificationSetting autoRunTransactionNotification;
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
    
    public NamespaceOptions withAssumeUserId(
        String assumeUserId
    ) {
        this.assumeUserId = assumeUserId;
        return this;
    }
    
    public NamespaceOptions withAutoRunStampSheetNotification(
        NotificationSetting autoRunStampSheetNotification
    ) {
        this.autoRunStampSheetNotification = autoRunStampSheetNotification;
        return this;
    }
    
    public NamespaceOptions withAutoRunTransactionNotification(
        NotificationSetting autoRunTransactionNotification
    ) {
        this.autoRunTransactionNotification = autoRunTransactionNotification;
        return this;
    }
    
    public NamespaceOptions withLogSetting(
        LogSetting logSetting
    ) {
        this.logSetting = logSetting;
        return this;
    }
}

