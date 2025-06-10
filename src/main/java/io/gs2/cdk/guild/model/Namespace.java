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
package io.gs2.cdk.guild.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.guild.ref.NamespaceRef;
import io.gs2.cdk.guild.model.CurrentMasterData;
import io.gs2.cdk.guild.model.GuildModel;

import io.gs2.cdk.guild.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private NotificationSetting changeNotification = null;
    private NotificationSetting joinNotification = null;
    private NotificationSetting leaveNotification = null;
    private NotificationSetting changeMemberNotification = null;
    private NotificationSetting receiveRequestNotification = null;
    private NotificationSetting removeRequestNotification = null;
    private ScriptSetting createGuildScript = null;
    private ScriptSetting updateGuildScript = null;
    private ScriptSetting joinGuildScript = null;
    private ScriptSetting leaveGuildScript = null;
    private ScriptSetting changeRoleScript = null;
    private ScriptSetting deleteGuildScript = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Guild_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.changeNotification = options.changeNotification;
        this.joinNotification = options.joinNotification;
        this.leaveNotification = options.leaveNotification;
        this.changeMemberNotification = options.changeMemberNotification;
        this.receiveRequestNotification = options.receiveRequestNotification;
        this.removeRequestNotification = options.removeRequestNotification;
        this.createGuildScript = options.createGuildScript;
        this.updateGuildScript = options.updateGuildScript;
        this.joinGuildScript = options.joinGuildScript;
        this.leaveGuildScript = options.leaveGuildScript;
        this.changeRoleScript = options.changeRoleScript;
        this.deleteGuildScript = options.deleteGuildScript;
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
            "Guild_Namespace_" + name
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
        return "GS2::Guild::Namespace";
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
        if (this.changeNotification != null) {
            properties.put("ChangeNotification", this.changeNotification.properties(
            ));
        }
        if (this.joinNotification != null) {
            properties.put("JoinNotification", this.joinNotification.properties(
            ));
        }
        if (this.leaveNotification != null) {
            properties.put("LeaveNotification", this.leaveNotification.properties(
            ));
        }
        if (this.changeMemberNotification != null) {
            properties.put("ChangeMemberNotification", this.changeMemberNotification.properties(
            ));
        }
        if (this.receiveRequestNotification != null) {
            properties.put("ReceiveRequestNotification", this.receiveRequestNotification.properties(
            ));
        }
        if (this.removeRequestNotification != null) {
            properties.put("RemoveRequestNotification", this.removeRequestNotification.properties(
            ));
        }
        if (this.createGuildScript != null) {
            properties.put("CreateGuildScript", this.createGuildScript.properties(
            ));
        }
        if (this.updateGuildScript != null) {
            properties.put("UpdateGuildScript", this.updateGuildScript.properties(
            ));
        }
        if (this.joinGuildScript != null) {
            properties.put("JoinGuildScript", this.joinGuildScript.properties(
            ));
        }
        if (this.leaveGuildScript != null) {
            properties.put("LeaveGuildScript", this.leaveGuildScript.properties(
            ));
        }
        if (this.changeRoleScript != null) {
            properties.put("ChangeRoleScript", this.changeRoleScript.properties(
            ));
        }
        if (this.deleteGuildScript != null) {
            properties.put("DeleteGuildScript", this.deleteGuildScript.properties(
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
        List<GuildModel> guildModels
    ) {
        (new CurrentMasterData(
            this.stack,
            this.name,
            guildModels
        )).addDependsOn(
            this
        );
        return this;
    }
}
