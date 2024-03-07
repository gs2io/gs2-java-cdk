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
package io.gs2.cdk.seasonRating.model;
import io.gs2.cdk.seasonRating.model.options.TierModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TierModel {
    private Integer raiseRankBonus;
    private Integer entryFee;
    private Integer minimumChangePoint;
    private Integer maximumChangePoint;
    private String metadata = null;

    public TierModel(
        Integer raiseRankBonus,
        Integer entryFee,
        Integer minimumChangePoint,
        Integer maximumChangePoint,
        TierModelOptions options
    ) {
        this.raiseRankBonus = raiseRankBonus;
        this.entryFee = entryFee;
        this.minimumChangePoint = minimumChangePoint;
        this.maximumChangePoint = maximumChangePoint;
        this.metadata = options.metadata;
    }
    public TierModel(
        Integer raiseRankBonus,
        Integer entryFee,
        Integer minimumChangePoint,
        Integer maximumChangePoint
    ) {
        this.raiseRankBonus = raiseRankBonus;
        this.entryFee = entryFee;
        this.minimumChangePoint = minimumChangePoint;
        this.maximumChangePoint = maximumChangePoint;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.raiseRankBonus != null) {
            properties.put("raiseRankBonus", this.raiseRankBonus);
        }
        if (this.entryFee != null) {
            properties.put("entryFee", this.entryFee);
        }
        if (this.minimumChangePoint != null) {
            properties.put("minimumChangePoint", this.minimumChangePoint);
        }
        if (this.maximumChangePoint != null) {
            properties.put("maximumChangePoint", this.maximumChangePoint);
        }

        return properties;
    }
}
