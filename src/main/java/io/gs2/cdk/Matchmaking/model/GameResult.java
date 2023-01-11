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
package io.gs2.cdk.matchmaking.model;
import io.gs2.cdk.matchmaking.model.options.GameResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private Integer rank;
    private String userId;

    public GameResult(
        Integer rank,
        String userId,
        GameResultOptions options
    ) {
        this.rank = rank;
        this.userId = userId;
    }
    public GameResult(
        Integer rank,
        String userId
    ) {
        this.rank = rank;
        this.userId = userId;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.rank != null) {
            properties.put("rank", this.rank);
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }

        return properties;
    }
}
