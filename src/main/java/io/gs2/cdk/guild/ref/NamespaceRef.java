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
 *
 * deny overwrite
 */
package io.gs2.cdk.guild.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.guild.ref.GuildModelRef;
import io.gs2.cdk.guild.ref.GuildRef;
import io.gs2.cdk.guild.stampSheet.IncreaseMaximumCurrentMaximumMemberCountByGuildName;
import io.gs2.cdk.guild.stampSheet.SetMaximumCurrentMaximumMemberCountByGuildName;
import io.gs2.cdk.guild.stampSheet.DecreaseMaximumCurrentMaximumMemberCountByGuildName;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceRef {
    private String namespaceName;

    public NamespaceRef(
        String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public GuildModelRef guildModel(
        String guildModelName
    ) {
        return (new GuildModelRef(
            this.namespaceName,
            guildModelName
        ));
    }

    public IncreaseMaximumCurrentMaximumMemberCountByGuildName increaseMaximumCurrentMaximumMemberCount(
        String guildModelName,
        String guildName,
        Integer value
    ) {
        return (new IncreaseMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            guildModelName,
            guildName,
            value
        ));
    }


    public SetMaximumCurrentMaximumMemberCountByGuildName setMaximumCurrentMaximumMemberCount(
        String guildName,
        String guildModelName,
        Integer value
    ) {
        return (new SetMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            guildName,
            guildModelName,
            value
        ));
    }


    public DecreaseMaximumCurrentMaximumMemberCountByGuildName decreaseMaximumCurrentMaximumMemberCount(
        String guildModelName,
        String guildName,
        Integer value
    ) {
        return (new DecreaseMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            guildModelName,
            guildName,
            value
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "guild",
                this.namespaceName
            )
        )).str(
        );
    }
}
