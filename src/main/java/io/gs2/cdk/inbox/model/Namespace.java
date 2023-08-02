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
package io.gs2.cdk.inbox.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.inbox.ref.NamespaceRef;
import io.gs2.cdk.inbox.model.CurrentMasterData;
import io.gs2.cdk.inbox.model.GlobalMessage;

import io.gs2.cdk.inbox.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private Boolean isAutomaticDeletingEnabled = null;
    private TransactionSetting transactionSetting = null;
    private ScriptSetting receiveMessageScript = null;
    private ScriptSetting readMessageScript = null;
    private ScriptSetting deleteMessageScript = null;
    private NotificationSetting receiveNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Inbox_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.isAutomaticDeletingEnabled = options.isAutomaticDeletingEnabled;
        this.transactionSetting = options.transactionSetting;
        this.receiveMessageScript = options.receiveMessageScript;
        this.readMessageScript = options.readMessageScript;
        this.deleteMessageScript = options.deleteMessageScript;
        this.receiveNotification = options.receiveNotification;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name
    ) {
        super(
            "Inbox_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Inbox::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.isAutomaticDeletingEnabled != null) {
            properties.put("IsAutomaticDeletingEnabled", this.isAutomaticDeletingEnabled);
        }
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.receiveMessageScript != null) {
            properties.put("ReceiveMessageScript", this.receiveMessageScript.properties(
            ));
        }
        if (this.readMessageScript != null) {
            properties.put("ReadMessageScript", this.readMessageScript.properties(
            ));
        }
        if (this.deleteMessageScript != null) {
            properties.put("DeleteMessageScript", this.deleteMessageScript.properties(
            ));
        }
        if (this.receiveNotification != null) {
            properties.put("ReceiveNotification", this.receiveNotification.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            this,
            "Item.NamespaceId",
            null
        ));
    }

    public Namespace masterData(
        List<GlobalMessage> globalMessages
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            globalMessages
        )).addDependsOn(
            this
        );
        return this;
    }
}
