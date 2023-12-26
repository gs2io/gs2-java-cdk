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
package io.gs2.cdk.grade.model;
import io.gs2.cdk.grade.model.DefaultGradeModel;
import io.gs2.cdk.grade.model.GradeEntryModel;
import io.gs2.cdk.grade.model.AcquireActionRate;
import io.gs2.cdk.grade.model.options.GradeModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GradeModel {
    private String name;
    private String experienceModelId;
    private List<GradeEntryModel> gradeEntries;
    private String metadata = null;
    private List<DefaultGradeModel> defaultGrades = null;
    private List<AcquireActionRate> acquireActionRates = null;

    public GradeModel(
        String name,
        String experienceModelId,
        List<GradeEntryModel> gradeEntries,
        GradeModelOptions options
    ) {
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.gradeEntries = gradeEntries;
        this.metadata = options.metadata;
        this.defaultGrades = options.defaultGrades;
        this.acquireActionRates = options.acquireActionRates;
    }
    public GradeModel(
        String name,
        String experienceModelId,
        List<GradeEntryModel> gradeEntries
    ) {
        this.name = name;
        this.experienceModelId = experienceModelId;
        this.gradeEntries = gradeEntries;
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
        if (this.defaultGrades != null) {
            properties.put("defaultGrades", this.defaultGrades.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.experienceModelId != null) {
            properties.put("experienceModelId", this.experienceModelId);
        }
        if (this.gradeEntries != null) {
            properties.put("gradeEntries", this.gradeEntries.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.acquireActionRates != null) {
            properties.put("acquireActionRates", this.acquireActionRates.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
