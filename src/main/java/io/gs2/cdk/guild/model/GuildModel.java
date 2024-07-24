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
import io.gs2.cdk.guild.model.RoleModel;
import io.gs2.cdk.guild.model.options.GuildModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GuildModel {
    private String name;
    private Integer defaultMaximumMemberCount;
    private Integer maximumMemberCount;
    private Integer inactivityPeriodDays;
    private List<RoleModel> roles;
    private String guildMasterRole;
    private String guildMemberDefaultRole;
    private Integer rejoinCoolTimeMinutes;
    private String metadata = null;

    public GuildModel(
        String name,
        Integer defaultMaximumMemberCount,
        Integer maximumMemberCount,
        Integer inactivityPeriodDays,
        List<RoleModel> roles,
        String guildMasterRole,
        String guildMemberDefaultRole,
        Integer rejoinCoolTimeMinutes,
        GuildModelOptions options
    ) {
        this.name = name;
        this.defaultMaximumMemberCount = defaultMaximumMemberCount;
        this.maximumMemberCount = maximumMemberCount;
        this.inactivityPeriodDays = inactivityPeriodDays;
        this.roles = roles;
        this.guildMasterRole = guildMasterRole;
        this.guildMemberDefaultRole = guildMemberDefaultRole;
        this.rejoinCoolTimeMinutes = rejoinCoolTimeMinutes;
        this.metadata = options.metadata;
    }
    public GuildModel(
        String name,
        Integer defaultMaximumMemberCount,
        Integer maximumMemberCount,
        Integer inactivityPeriodDays,
        List<RoleModel> roles,
        String guildMasterRole,
        String guildMemberDefaultRole,
        Integer rejoinCoolTimeMinutes
    ) {
        this.name = name;
        this.defaultMaximumMemberCount = defaultMaximumMemberCount;
        this.maximumMemberCount = maximumMemberCount;
        this.inactivityPeriodDays = inactivityPeriodDays;
        this.roles = roles;
        this.guildMasterRole = guildMasterRole;
        this.guildMemberDefaultRole = guildMemberDefaultRole;
        this.rejoinCoolTimeMinutes = rejoinCoolTimeMinutes;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.defaultMaximumMemberCount != null) {
            properties.put("defaultMaximumMemberCount", this.defaultMaximumMemberCount);
        }
        if (this.maximumMemberCount != null) {
            properties.put("maximumMemberCount", this.maximumMemberCount);
        }
        if (this.inactivityPeriodDays != null) {
            properties.put("inactivityPeriodDays", this.inactivityPeriodDays);
        }
        if (this.roles != null) {
            properties.put("roles", this.roles.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.guildMasterRole != null) {
            properties.put("guildMasterRole", this.guildMasterRole);
        }
        if (this.guildMemberDefaultRole != null) {
            properties.put("guildMemberDefaultRole", this.guildMemberDefaultRole);
        }
        if (this.rejoinCoolTimeMinutes != null) {
            properties.put("rejoinCoolTimeMinutes", this.rejoinCoolTimeMinutes);
        }

        return properties;
    }
}
