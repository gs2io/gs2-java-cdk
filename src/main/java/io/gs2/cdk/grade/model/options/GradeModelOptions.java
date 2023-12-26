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
package io.gs2.cdk.grade.model.options;
import io.gs2.cdk.grade.model.DefaultGradeModel;
import io.gs2.cdk.grade.model.GradeEntryModel;
import io.gs2.cdk.grade.model.AcquireActionRate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GradeModelOptions {
    public String metadata;
    public List<DefaultGradeModel> defaultGrades;
    public List<AcquireActionRate> acquireActionRates;
    
    public GradeModelOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public GradeModelOptions withDefaultGrades(
        List<DefaultGradeModel> defaultGrades
    ) {
        this.defaultGrades = defaultGrades;
        return this;
    }
    
    public GradeModelOptions withAcquireActionRates(
        List<AcquireActionRate> acquireActionRates
    ) {
        this.acquireActionRates = acquireActionRates;
        return this;
    }
}

