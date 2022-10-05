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

package io.gs2.cdk.matchmaking.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.matchmaking.resource.*;

import java.util.*;
import java.util.stream.*;

public class Ballot {
	public String userId;
	public String ratingName;
	public String gatheringName;
	public Integer numberOfPlayer;

    public Ballot(
            String userId,
            String ratingName,
            String gatheringName,
            Integer numberOfPlayer
    ) {
        this.userId = userId;
        this.ratingName = ratingName;
        this.gatheringName = gatheringName;
        this.numberOfPlayer = numberOfPlayer;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.ratingName != null) {
            properties.put("RatingName", this.ratingName);
        }
        if (this.gatheringName != null) {
            properties.put("GatheringName", this.gatheringName);
        }
        if (this.numberOfPlayer != null) {
            properties.put("NumberOfPlayer", this.numberOfPlayer);
        }
        return properties;
    }
}
