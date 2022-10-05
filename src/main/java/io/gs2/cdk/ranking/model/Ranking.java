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

package io.gs2.cdk.ranking.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.ranking.resource.*;

import java.util.*;
import java.util.stream.*;

public class Ranking {
	public Long rank;
	public Long index;
	public String userId;
	public Long score;
	public String metadata;
	public Long createdAt;

    public Ranking(
            Long rank,
            Long index,
            String userId,
            Long score,
            Long createdAt
    ) {
        this.rank = rank;
        this.index = index;
        this.userId = userId;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.rank != null) {
            properties.put("Rank", this.rank);
        }
        if (this.index != null) {
            properties.put("Index", this.index);
        }
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.score != null) {
            properties.put("Score", this.score);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.createdAt != null) {
            properties.put("CreatedAt", this.createdAt);
        }
        return properties;
    }
}
