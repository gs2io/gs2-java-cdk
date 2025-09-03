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
package io.gs2.cdk.friend.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.model.TransactionSetting;
import io.gs2.cdk.core.model.ScriptSetting;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.friend.ref.NamespaceRef;

import io.gs2.cdk.friend.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private TransactionSetting transactionSetting = null;
    private ScriptSetting followScript = null;
    private ScriptSetting unfollowScript = null;
    private ScriptSetting sendRequestScript = null;
    private ScriptSetting cancelRequestScript = null;
    private ScriptSetting acceptRequestScript = null;
    private ScriptSetting rejectRequestScript = null;
    private ScriptSetting deleteFriendScript = null;
    private ScriptSetting updateProfileScript = null;
    private NotificationSetting followNotification = null;
    private NotificationSetting receiveRequestNotification = null;
    private NotificationSetting cancelRequestNotification = null;
    private NotificationSetting acceptRequestNotification = null;
    private NotificationSetting rejectRequestNotification = null;
    private NotificationSetting deleteFriendNotification = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Friend_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.transactionSetting = options.transactionSetting;
        this.followScript = options.followScript;
        this.unfollowScript = options.unfollowScript;
        this.sendRequestScript = options.sendRequestScript;
        this.cancelRequestScript = options.cancelRequestScript;
        this.acceptRequestScript = options.acceptRequestScript;
        this.rejectRequestScript = options.rejectRequestScript;
        this.deleteFriendScript = options.deleteFriendScript;
        this.updateProfileScript = options.updateProfileScript;
        this.followNotification = options.followNotification;
        this.receiveRequestNotification = options.receiveRequestNotification;
        this.cancelRequestNotification = options.cancelRequestNotification;
        this.acceptRequestNotification = options.acceptRequestNotification;
        this.rejectRequestNotification = options.rejectRequestNotification;
        this.deleteFriendNotification = options.deleteFriendNotification;
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
            "Friend_Namespace_" + name
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
        return "GS2::Friend::Namespace";
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
        if (this.followScript != null) {
            properties.put("FollowScript", this.followScript.properties(
            ));
        }
        if (this.unfollowScript != null) {
            properties.put("UnfollowScript", this.unfollowScript.properties(
            ));
        }
        if (this.sendRequestScript != null) {
            properties.put("SendRequestScript", this.sendRequestScript.properties(
            ));
        }
        if (this.cancelRequestScript != null) {
            properties.put("CancelRequestScript", this.cancelRequestScript.properties(
            ));
        }
        if (this.acceptRequestScript != null) {
            properties.put("AcceptRequestScript", this.acceptRequestScript.properties(
            ));
        }
        if (this.rejectRequestScript != null) {
            properties.put("RejectRequestScript", this.rejectRequestScript.properties(
            ));
        }
        if (this.deleteFriendScript != null) {
            properties.put("DeleteFriendScript", this.deleteFriendScript.properties(
            ));
        }
        if (this.updateProfileScript != null) {
            properties.put("UpdateProfileScript", this.updateProfileScript.properties(
            ));
        }
        if (this.followNotification != null) {
            properties.put("FollowNotification", this.followNotification.properties(
            ));
        }
        if (this.receiveRequestNotification != null) {
            properties.put("ReceiveRequestNotification", this.receiveRequestNotification.properties(
            ));
        }
        if (this.cancelRequestNotification != null) {
            properties.put("CancelRequestNotification", this.cancelRequestNotification.properties(
            ));
        }
        if (this.acceptRequestNotification != null) {
            properties.put("AcceptRequestNotification", this.acceptRequestNotification.properties(
            ));
        }
        if (this.rejectRequestNotification != null) {
            properties.put("RejectRequestNotification", this.rejectRequestNotification.properties(
            ));
        }
        if (this.deleteFriendNotification != null) {
            properties.put("DeleteFriendNotification", this.deleteFriendNotification.properties(
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
}
