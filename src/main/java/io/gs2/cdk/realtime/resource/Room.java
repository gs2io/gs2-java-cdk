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

package io.gs2.cdk.realtime.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.realtime.ref.*;
import io.gs2.cdk.realtime.model.*;

import java.util.*;
import java.util.stream.*;


public class Room extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String namespaceName;
    public String name;
    public String ipAddress;
    public Integer port;
    public String encryptionKey;

    public Room(
            Stack stack,
            String ownerId,
            String namespaceName,
            String name
    ) {
        super("Realtime_Room_" + name);

        this.stack = stack;
        this.ownerId = ownerId;
        this.namespaceName = namespaceName;
        this.name = name;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Realtime::Room";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.ownerId != null) {
            properties.put("OwnerId", this.ownerId);
        }
        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.ipAddress != null) {
            properties.put("IpAddress", this.ipAddress);
        }
        if (this.port != null) {
            properties.put("Port", this.port);
        }
        if (this.encryptionKey != null) {
            properties.put("EncryptionKey", this.encryptionKey);
        }
        return properties;
    }

    public RoomRef ref(
            String namespaceName
    ) {
        return new RoomRef(
            namespaceName,
            this.name
        );
    }

    public GetAttr getAttrRoomId() {
        return new GetAttr(
            "Item.RoomId"
        );
    }
}
