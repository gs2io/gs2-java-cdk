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
import io.gs2.cdk.guild.model.ReceiveMemberRequest;
import io.gs2.cdk.guild.model.options.InboxOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Inbox {
    private String guildName;
    private List<String> fromUserIds = null;
    private List<ReceiveMemberRequest> receiveMemberRequests = null;
    private Long revision = null;

    public Inbox(
        String guildName,
        InboxOptions options
    ) {
        this.guildName = guildName;
        this.fromUserIds = options.fromUserIds;
        this.receiveMemberRequests = options.receiveMemberRequests;
        this.revision = options.revision;
    }
    public Inbox(
        String guildName
    ) {
        this.guildName = guildName;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.guildName != null) {
            properties.put("guildName", this.guildName);
        }
        if (this.fromUserIds != null) {
            properties.put("fromUserIds", this.fromUserIds);
        }
        if (this.receiveMemberRequests != null) {
            properties.put("receiveMemberRequests", this.receiveMemberRequests.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
