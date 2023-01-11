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
package io.gs2.cdk.experience.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.experience.ref.ExperienceModelRef;
import io.gs2.cdk.experience.stampSheet.AddExperienceByUserId;
import io.gs2.cdk.experience.stampSheet.AddRankCapByUserId;
import io.gs2.cdk.experience.stampSheet.SetRankCapByUserId;
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

    public ExperienceModelRef experienceModel(
        String experienceName
    ) {
        return (new ExperienceModelRef(
            this.namespaceName,
            experienceName
        ));
    }

    public AddExperienceByUserId addExperience(
        String experienceName,
        String propertyId,
        Long experienceValue,
        String userId
    ) {
        return (new AddExperienceByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            experienceValue,
            userId
        ));
    }


    public AddExperienceByUserId addExperience(
        String experienceName,
        String propertyId,
        Long experienceValue
    ) {
        return (new AddExperienceByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            experienceValue,
            "#{userId}"
        ));
    }

    public AddRankCapByUserId addRankCap(
        String experienceName,
        String propertyId,
        Long rankCapValue,
        String userId
    ) {
        return (new AddRankCapByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            rankCapValue,
            userId
        ));
    }


    public AddRankCapByUserId addRankCap(
        String experienceName,
        String propertyId,
        Long rankCapValue
    ) {
        return (new AddRankCapByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            rankCapValue,
            "#{userId}"
        ));
    }

    public SetRankCapByUserId setRankCap(
        String experienceName,
        String propertyId,
        Long rankCapValue,
        String userId
    ) {
        return (new SetRankCapByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            rankCapValue,
            userId
        ));
    }


    public SetRankCapByUserId setRankCap(
        String experienceName,
        String propertyId,
        Long rankCapValue
    ) {
        return (new SetRankCapByUserId(
            this.namespaceName,
            experienceName,
            propertyId,
            rankCapValue,
            "#{userId}"
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
                "experience",
                this.namespaceName
            )
        )).str(
        );
    }
}
