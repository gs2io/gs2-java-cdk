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
package io.gs2.cdk.guild.model.options;
import io.gs2.cdk.guild.model.RoleModel;
import io.gs2.cdk.guild.model.enums.GuildJoinPolicy;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GuildOptions {
    public Integer attribute1;
    public Integer attribute2;
    public Integer attribute3;
    public Integer attribute4;
    public Integer attribute5;
    public List<RoleModel> customRoles;
    public String guildMemberDefaultRole;
    public String timeOffsetToken;
    
    public GuildOptions withAttribute1(
        Integer attribute1
    ) {
        this.attribute1 = attribute1;
        return this;
    }
    
    public GuildOptions withAttribute2(
        Integer attribute2
    ) {
        this.attribute2 = attribute2;
        return this;
    }
    
    public GuildOptions withAttribute3(
        Integer attribute3
    ) {
        this.attribute3 = attribute3;
        return this;
    }
    
    public GuildOptions withAttribute4(
        Integer attribute4
    ) {
        this.attribute4 = attribute4;
        return this;
    }
    
    public GuildOptions withAttribute5(
        Integer attribute5
    ) {
        this.attribute5 = attribute5;
        return this;
    }
    
    public GuildOptions withCustomRoles(
        List<RoleModel> customRoles
    ) {
        this.customRoles = customRoles;
        return this;
    }
    
    public GuildOptions withGuildMemberDefaultRole(
        String guildMemberDefaultRole
    ) {
        this.guildMemberDefaultRole = guildMemberDefaultRole;
        return this;
    }
    
    public GuildOptions withTimeOffsetToken(
        String timeOffsetToken
    ) {
        this.timeOffsetToken = timeOffsetToken;
        return this;
    }
}

