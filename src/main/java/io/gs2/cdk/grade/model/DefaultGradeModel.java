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
import io.gs2.cdk.grade.model.options.DefaultGradeModelOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultGradeModel {
    private String propertyIdRegex;
    private Long defaultGradeValue;

    public DefaultGradeModel(
        String propertyIdRegex,
        Long defaultGradeValue,
        DefaultGradeModelOptions options
    ) {
        this.propertyIdRegex = propertyIdRegex;
        this.defaultGradeValue = defaultGradeValue;
    }
    public DefaultGradeModel(
        String propertyIdRegex,
        Long defaultGradeValue
    ) {
        this.propertyIdRegex = propertyIdRegex;
        this.defaultGradeValue = defaultGradeValue;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.propertyIdRegex != null) {
            properties.put("propertyIdRegex", this.propertyIdRegex);
        }
        if (this.defaultGradeValue != null) {
            properties.put("defaultGradeValue", this.defaultGradeValue);
        }

        return properties;
    }
}
