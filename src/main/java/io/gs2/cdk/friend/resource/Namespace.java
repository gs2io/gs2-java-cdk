/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.friend.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.friend.ref.*;
import io.gs2.cdk.friend.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String name;
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

    public Namespace(
            Stack stack,
            String name
    ) {
        super("Friend_Namespace_" + name);

        this.stack = stack;
        this.name = name;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Friend::Namespace";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.followScript != null) {
            properties.put("FollowScript", this.followScript.properties());
        }
        if (this.unfollowScript != null) {
            properties.put("UnfollowScript", this.unfollowScript.properties());
        }
        if (this.sendRequestScript != null) {
            properties.put("SendRequestScript", this.sendRequestScript.properties());
        }
        if (this.cancelRequestScript != null) {
            properties.put("CancelRequestScript", this.cancelRequestScript.properties());
        }
        if (this.acceptRequestScript != null) {
            properties.put("AcceptRequestScript", this.acceptRequestScript.properties());
        }
        if (this.rejectRequestScript != null) {
            properties.put("RejectRequestScript", this.rejectRequestScript.properties());
        }
        if (this.deleteFriendScript != null) {
            properties.put("DeleteFriendScript", this.deleteFriendScript.properties());
        }
        if (this.updateProfileScript != null) {
            properties.put("UpdateProfileScript", this.updateProfileScript.properties());
        }
        if (this.followNotification != null) {
            properties.put("FollowNotification", this.followNotification.properties());
        }
        if (this.receiveRequestNotification != null) {
            properties.put("ReceiveRequestNotification", this.receiveRequestNotification.properties());
        }
        if (this.acceptRequestNotification != null) {
            properties.put("AcceptRequestNotification", this.acceptRequestNotification.properties());
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties());
        }
        return properties;
    }

    public NamespaceRef ref(
    ) {
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }
}
