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
import io.gs2.cdk.grade.model.options.GradeEntryModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GradeEntryModel {
    private Long rankCapValue;
    private String propertyIdRegex;
    private String gradeUpPropertyIdRegex;
    private String metadata = null;

    public GradeEntryModel(
        Long rankCapValue,
        String propertyIdRegex,
        String gradeUpPropertyIdRegex,
        GradeEntryModelOptions options
    ) {
        this.rankCapValue = rankCapValue;
        this.propertyIdRegex = propertyIdRegex;
        this.gradeUpPropertyIdRegex = gradeUpPropertyIdRegex;
        this.metadata = options.metadata;
    }
    public GradeEntryModel(
        Long rankCapValue,
        String propertyIdRegex,
        String gradeUpPropertyIdRegex
    ) {
        this.rankCapValue = rankCapValue;
        this.propertyIdRegex = propertyIdRegex;
        this.gradeUpPropertyIdRegex = gradeUpPropertyIdRegex;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.rankCapValue != null) {
            properties.put("rankCapValue", this.rankCapValue);
        }
        if (this.propertyIdRegex != null) {
            properties.put("propertyIdRegex", this.propertyIdRegex);
        }
        if (this.gradeUpPropertyIdRegex != null) {
            properties.put("gradeUpPropertyIdRegex", this.gradeUpPropertyIdRegex);
        }

        return properties;
    }
}
