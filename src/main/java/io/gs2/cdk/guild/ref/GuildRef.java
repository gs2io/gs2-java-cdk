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
import io.gs2.cdk.guild.ref.InboxRef;
import io.gs2.cdk.guild.stampSheet.IncreaseMaximumCurrentMaximumMemberCountByGuildName;
import io.gs2.cdk.guild.stampSheet.SetMaximumCurrentMaximumMemberCountByGuildName;
import io.gs2.cdk.guild.stampSheet.DecreaseMaximumCurrentMaximumMemberCountByGuildName;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuildRef {
    private String namespaceName;
    private String guildModelName;
    private String guildName;

    public GuildRef(
        String namespaceName,
        String guildModelName,
        String guildName
    ) {
        this.namespaceName = namespaceName;
        this.guildModelName = guildModelName;
        this.guildName = guildName;
    }

    public IncreaseMaximumCurrentMaximumMemberCountByGuildName increaseMaximumCurrentMaximumMemberCount(
        Integer value
    ) {
        return (new IncreaseMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            this.guildModelName,
            this.guildName,
            value
        ));
    }


    public SetMaximumCurrentMaximumMemberCountByGuildName setMaximumCurrentMaximumMemberCount(
        Integer value
    ) {
        return (new SetMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            this.guildName,
            this.guildModelName,
            value
        ));
    }


    public DecreaseMaximumCurrentMaximumMemberCountByGuildName decreaseMaximumCurrentMaximumMemberCount(
        Integer value
    ) {
        return (new DecreaseMaximumCurrentMaximumMemberCountByGuildName(
            this.namespaceName,
            this.guildModelName,
            this.guildName,
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
                this.namespaceName,
                "guild",
                this.guildModelName,
                this.guildName
            )
        )).str(
        );
    }
}
