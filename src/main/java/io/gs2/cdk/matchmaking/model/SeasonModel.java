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
import io.gs2.cdk.matchmaking.model.options.SeasonModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonModel {
    private String name;
    private Integer maximumParticipants;
    private String challengePeriodEventId;
    private String metadata = null;
    private String experienceModelId = null;

    public SeasonModel(
        String name,
        Integer maximumParticipants,
        String challengePeriodEventId,
        SeasonModelOptions options
    ) {
        this.name = name;
        this.maximumParticipants = maximumParticipants;
        this.challengePeriodEventId = challengePeriodEventId;
        this.metadata = options.metadata;
        this.experienceModelId = options.experienceModelId;
    }
    public SeasonModel(
        String name,
        Integer maximumParticipants,
        String challengePeriodEventId
    ) {
        this.name = name;
        this.maximumParticipants = maximumParticipants;
        this.challengePeriodEventId = challengePeriodEventId;
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
        if (this.maximumParticipants != null) {
            properties.put("maximumParticipants", this.maximumParticipants);
        }
        if (this.experienceModelId != null) {
            properties.put("experienceModelId", this.experienceModelId);
        }
        if (this.challengePeriodEventId != null) {
            properties.put("challengePeriodEventId", this.challengePeriodEventId);
        }

        return properties;
    }
}
