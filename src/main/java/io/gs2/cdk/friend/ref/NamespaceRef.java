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
package io.gs2.cdk.friend.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.friend.stampSheet.UpdateProfileByUserId;
import io.gs2.cdk.friend.stampSheet.VerifyFollowByUserId;
import io.gs2.cdk.friend.stampSheet.VerifyFriendByUserId;
import io.gs2.cdk.friend.stampSheet.VerifyFriendCountByUserId;
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

    public UpdateProfileByUserId updateProfile(
        String publicProfile,
        String followerProfile,
        String friendProfile,
        String userId
    ) {
        return (new UpdateProfileByUserId(
            this.namespaceName,
            publicProfile,
            followerProfile,
            friendProfile,
            userId
        ));
    }


    public UpdateProfileByUserId updateProfile(
        String publicProfile,
        String followerProfile,
        String friendProfile
    ) {
        return (new UpdateProfileByUserId(
            this.namespaceName,
            publicProfile,
            followerProfile,
            friendProfile,
            "#{userId}"
        ));
    }

    public VerifyFollowByUserId verifyFollow(
        String targetUserId,
        String verifyType,
        String userId
    ) {
        return (new VerifyFollowByUserId(
            this.namespaceName,
            targetUserId,
            verifyType,
            userId
        ));
    }


    public VerifyFollowByUserId verifyFollow(
        String targetUserId,
        String verifyType
    ) {
        return (new VerifyFollowByUserId(
            this.namespaceName,
            targetUserId,
            verifyType,
            "#{userId}"
        ));
    }

    public VerifyFriendByUserId verifyFriend(
        String targetUserId,
        String verifyType,
        String userId
    ) {
        return (new VerifyFriendByUserId(
            this.namespaceName,
            targetUserId,
            verifyType,
            userId
        ));
    }


    public VerifyFriendByUserId verifyFriend(
        String targetUserId,
        String verifyType
    ) {
        return (new VerifyFriendByUserId(
            this.namespaceName,
            targetUserId,
            verifyType,
            "#{userId}"
        ));
    }

    public VerifyFriendCountByUserId verifyFriendCount(
        String verifyType,
        Integer count,
        String userId
    ) {
        return (new VerifyFriendCountByUserId(
            this.namespaceName,
            verifyType,
            count,
            userId
        ));
    }


    public VerifyFriendCountByUserId verifyFriendCount(
        String verifyType,
        Integer count
    ) {
        return (new VerifyFriendCountByUserId(
            this.namespaceName,
            verifyType,
            count,
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
                "friend",
                this.namespaceName
            )
        )).str(
        );
    }
}
