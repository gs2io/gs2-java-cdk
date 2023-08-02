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
package io.gs2.cdk.realtime.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.realtime.ref.RoomRef;

import io.gs2.cdk.realtime.model.options.RoomOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Room extends CdkResource {
    private Stack stack;
    private String ownerId;
    private String namespaceName;
    private String name;
    private String ipAddress = null;
    private Integer port = null;
    private String encryptionKey = null;

    public Room(
        Stack stack,
        String ownerId,
        String namespaceName,
        String name,
        RoomOptions options
    ) {
        super(
            "Realtime_Room_" + name
        );

        this.stack = stack;
        this.ownerId = ownerId;
        this.namespaceName = namespaceName;
        this.name = name;
        this.ipAddress = options.ipAddress;
        this.port = options.port;
        this.encryptionKey = options.encryptionKey;
        stack.addResource(
            this
        );
    }

    public Room(
        Stack stack,
        String ownerId,
        String namespaceName,
        String name
    ) {
        super(
            "Realtime_Room_" + name
        );

        this.stack = stack;
        this.ownerId = ownerId;
        this.namespaceName = namespaceName;
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
        return "GS2::Realtime::Room";
    }

    public Map<String, Object> properties(
    ) {
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
    ) {
        return (new RoomRef(
            this.namespaceName,
            this.name
        ));
    }

    public GetAttr getAttrRoomId(
    ) {
        return (new GetAttr(
            this,
            "Item.RoomId",
            null
        ));
    }
}
