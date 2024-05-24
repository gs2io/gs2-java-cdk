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
import io.gs2.cdk.buff.model.BuffTargetGrn;
import io.gs2.cdk.buff.model.options.BuffTargetActionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BuffTargetAction {
    private String targetActionName;
    private String targetFieldName;
    private List<BuffTargetGrn> conditionGrns;
    private Float rate;

    public BuffTargetAction(
        String targetActionName,
        String targetFieldName,
        List<BuffTargetGrn> conditionGrns,
        Float rate,
        BuffTargetActionOptions options
    ) {
        this.targetActionName = targetActionName;
        this.targetFieldName = targetFieldName;
        this.conditionGrns = conditionGrns;
        this.rate = rate;
    }
    public BuffTargetAction(
        String targetActionName,
        String targetFieldName,
        List<BuffTargetGrn> conditionGrns,
        Float rate
    ) {
        this.targetActionName = targetActionName;
        this.targetFieldName = targetFieldName;
        this.conditionGrns = conditionGrns;
        this.rate = rate;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.targetActionName != null) {
            properties.put("targetActionName", this.targetActionName.toString(
            ));
        }
        if (this.targetFieldName != null) {
            properties.put("targetFieldName", this.targetFieldName);
        }
        if (this.conditionGrns != null) {
            properties.put("conditionGrns", this.conditionGrns.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.rate != null) {
            properties.put("rate", this.rate);
        }

        return properties;
    }
}
