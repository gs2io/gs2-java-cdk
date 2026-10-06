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
package io.gs2.cdk.enhance.model;
import io.gs2.cdk.enhance.model.options.UnleashIndividualMaterialSettingOptions;
import io.gs2.cdk.enhance.model.options.UnleashIndividualMaterialSettingGradeConditionIsAnyOptions;
import io.gs2.cdk.enhance.model.options.UnleashIndividualMaterialSettingGradeConditionIsSameAsTargetOptions;
import io.gs2.cdk.enhance.model.options.UnleashIndividualMaterialSettingGradeConditionIsEqualOptions;
import io.gs2.cdk.enhance.model.enums.UnleashIndividualMaterialSettingMatchType;
import io.gs2.cdk.enhance.model.enums.UnleashIndividualMaterialSettingGradeCondition;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class UnleashIndividualMaterialSetting {
    private UnleashIndividualMaterialSettingMatchType matchType;
    private UnleashIndividualMaterialSettingGradeCondition gradeCondition;
    private Integer count;
    private Long gradeValue = null;

    public UnleashIndividualMaterialSetting(
        UnleashIndividualMaterialSettingMatchType matchType,
        UnleashIndividualMaterialSettingGradeCondition gradeCondition,
        Integer count,
        UnleashIndividualMaterialSettingOptions options
    ) {
        this.matchType = matchType;
        this.gradeCondition = gradeCondition;
        this.count = count;
        this.gradeValue = options.gradeValue;
    }
    public UnleashIndividualMaterialSetting(
        UnleashIndividualMaterialSettingMatchType matchType,
        UnleashIndividualMaterialSettingGradeCondition gradeCondition,
        Integer count
    ) {
        this.matchType = matchType;
        this.gradeCondition = gradeCondition;
        this.count = count;
    }

    public static UnleashIndividualMaterialSetting gradeConditionIsAny(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count,
        UnleashIndividualMaterialSettingGradeConditionIsAnyOptions options
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.ANY,
            count,
            new UnleashIndividualMaterialSettingOptions()
        ));
    }


    public static UnleashIndividualMaterialSetting gradeConditionIsAny(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.ANY,
            count
        ));
    }

    public static UnleashIndividualMaterialSetting gradeConditionIsSameAsTarget(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count,
        UnleashIndividualMaterialSettingGradeConditionIsSameAsTargetOptions options
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.SAME_AS_TARGET,
            count,
            new UnleashIndividualMaterialSettingOptions()
        ));
    }


    public static UnleashIndividualMaterialSetting gradeConditionIsSameAsTarget(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.SAME_AS_TARGET,
            count
        ));
    }

    public static UnleashIndividualMaterialSetting gradeConditionIsEqual(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count,
        Long gradeValue,
        UnleashIndividualMaterialSettingGradeConditionIsEqualOptions options
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.EQUAL,
            count,
            new UnleashIndividualMaterialSettingOptions()
                .withGradeValue(gradeValue)
        ));
    }


    public static UnleashIndividualMaterialSetting gradeConditionIsEqual(
        UnleashIndividualMaterialSettingMatchType matchType,
        Integer count,
        Long gradeValue
    ) {
        return (new UnleashIndividualMaterialSetting(
            matchType,
            UnleashIndividualMaterialSettingGradeCondition.EQUAL,
            count
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.matchType != null) {
            properties.put("matchType", this.matchType.toString(
            ));
        }
        if (this.gradeCondition != null) {
            properties.put("gradeCondition", this.gradeCondition.toString(
            ));
        }
        if (this.gradeValue != null) {
            properties.put("gradeValue", this.gradeValue);
        }
        if (this.count != null) {
            properties.put("count", this.count);
        }

        return properties;
    }
}
