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
package io.gs2.cdk.buff.model;
import io.gs2.cdk.buff.model.options.BuffTargetGrnOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BuffTargetGrn {
    private String targetModelName;
    private String targetGrn;

    public BuffTargetGrn(
        String targetModelName,
        String targetGrn,
        BuffTargetGrnOptions options
    ) {
        this.targetModelName = targetModelName;
        this.targetGrn = targetGrn;
    }
    public BuffTargetGrn(
        String targetModelName,
        String targetGrn
    ) {
        this.targetModelName = targetModelName;
        this.targetGrn = targetGrn;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.targetModelName != null) {
            properties.put("targetModelName", this.targetModelName);
        }
        if (this.targetGrn != null) {
            properties.put("targetGrn", this.targetGrn);
        }

        return properties;
    }
}
