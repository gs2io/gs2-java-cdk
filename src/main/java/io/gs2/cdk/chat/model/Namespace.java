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
package io.gs2.cdk.chat.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.chat.ref.NamespaceRef;
import io.gs2.cdk.chat.model.CurrentMasterData;
import io.gs2.cdk.chat.model.CategoryModel;

import io.gs2.cdk.chat.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private Boolean allowCreateRoom = null;
    private Integer messageLifeTimeDays = null;
    private ScriptSetting postMessageScript = null;
    private ScriptSetting createRoomScript = null;
    private ScriptSetting deleteRoomScript = null;
    private ScriptSetting subscribeRoomScript = null;
    private ScriptSetting unsubscribeRoomScript = null;
    private NotificationSetting postNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Chat_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.allowCreateRoom = options.allowCreateRoom;
        this.messageLifeTimeDays = options.messageLifeTimeDays;
        this.postMessageScript = options.postMessageScript;
        this.createRoomScript = options.createRoomScript;
        this.deleteRoomScript = options.deleteRoomScript;
        this.subscribeRoomScript = options.subscribeRoomScript;
        this.unsubscribeRoomScript = options.unsubscribeRoomScript;
        this.postNotification = options.postNotification;
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
            "Chat_Namespace_" + name
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
        return "GS2::Chat::Namespace";
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
        if (this.transactionSetting != null) {
            properties.put("TransactionSetting", this.transactionSetting.properties(
            ));
        }
        if (this.allowCreateRoom != null) {
            properties.put("AllowCreateRoom", this.allowCreateRoom);
        }
        if (this.messageLifeTimeDays != null) {
            properties.put("MessageLifeTimeDays", this.messageLifeTimeDays);
        }
        if (this.postMessageScript != null) {
            properties.put("PostMessageScript", this.postMessageScript.properties(
            ));
        }
        if (this.createRoomScript != null) {
            properties.put("CreateRoomScript", this.createRoomScript.properties(
            ));
        }
        if (this.deleteRoomScript != null) {
            properties.put("DeleteRoomScript", this.deleteRoomScript.properties(
            ));
        }
        if (this.subscribeRoomScript != null) {
            properties.put("SubscribeRoomScript", this.subscribeRoomScript.properties(
            ));
        }
        if (this.unsubscribeRoomScript != null) {
            properties.put("UnsubscribeRoomScript", this.unsubscribeRoomScript.properties(
            ));
        }
        if (this.postNotification != null) {
            properties.put("PostNotification", this.postNotification.properties(
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
        List<CategoryModel> categoryModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            categoryModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
