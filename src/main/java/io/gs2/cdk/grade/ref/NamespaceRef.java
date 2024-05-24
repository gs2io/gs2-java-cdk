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
package io.gs2.cdk.grade.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.grade.ref.GradeModelRef;
import io.gs2.cdk.grade.stampSheet.AddGradeByUserId;
import io.gs2.cdk.grade.stampSheet.ApplyRankCapByUserId;
import io.gs2.cdk.grade.stampSheet.MultiplyAcquireActionsByUserId;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.grade.stampSheet.SubGradeByUserId;
import io.gs2.cdk.grade.stampSheet.VerifyGradeByUserId;
import io.gs2.cdk.grade.stampSheet.VerifyGradeUpMaterialByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceRef {
    private String namespaceName;

    public NamespaceRef(
        String namespaceName
    ) {
        this.namespaceName = namespaceName;
    }

    public GradeModelRef gradeModel(
        String gradeName
    ) {
        return (new GradeModelRef(
            this.namespaceName,
            gradeName
        ));
    }

    public AddGradeByUserId addGrade(
        String gradeName,
        String propertyId,
        Long gradeValue,
        String userId
    ) {
        return (new AddGradeByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            gradeValue,
            userId
        ));
    }


    public AddGradeByUserId addGrade(
        String gradeName,
        String propertyId,
        Long gradeValue
    ) {
        return (new AddGradeByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            gradeValue,
            "#{userId}"
        ));
    }

    public ApplyRankCapByUserId applyRankCap(
        String gradeName,
        String propertyId,
        String userId
    ) {
        return (new ApplyRankCapByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            userId
        ));
    }


    public ApplyRankCapByUserId applyRankCap(
        String gradeName,
        String propertyId
    ) {
        return (new ApplyRankCapByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            "#{userId}"
        ));
    }

    public MultiplyAcquireActionsByUserId multiplyAcquireActions(
        String gradeName,
        String propertyId,
        String rateName,
        List<AcquireAction> acquireActions,
        String userId
    ) {
        return (new MultiplyAcquireActionsByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            rateName,
            acquireActions,
            userId
        ));
    }


    public MultiplyAcquireActionsByUserId multiplyAcquireActions(
        String gradeName,
        String propertyId,
        String rateName,
        List<AcquireAction> acquireActions
    ) {
        return (new MultiplyAcquireActionsByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            rateName,
            acquireActions,
            "#{userId}"
        ));
    }

    public SubGradeByUserId subGrade(
        String gradeName,
        String propertyId,
        Long gradeValue,
        String userId
    ) {
        return (new SubGradeByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            gradeValue,
            userId
        ));
    }


    public SubGradeByUserId subGrade(
        String gradeName,
        String propertyId,
        Long gradeValue
    ) {
        return (new SubGradeByUserId(
            this.namespaceName,
            gradeName,
            propertyId,
            gradeValue,
            "#{userId}"
        ));
    }

    public VerifyGradeByUserId verifyGrade(
        String gradeName,
        String verifyType,
        String propertyId,
        Long gradeValue,
        Boolean multiplyValueSpecifyingQuantity,
        String userId
    ) {
        return (new VerifyGradeByUserId(
            this.namespaceName,
            gradeName,
            verifyType,
            propertyId,
            gradeValue,
            multiplyValueSpecifyingQuantity,
            userId
        ));
    }


    public VerifyGradeByUserId verifyGrade(
        String gradeName,
        String verifyType,
        String propertyId,
        Long gradeValue,
        Boolean multiplyValueSpecifyingQuantity
    ) {
        return (new VerifyGradeByUserId(
            this.namespaceName,
            gradeName,
            verifyType,
            propertyId,
            gradeValue,
            multiplyValueSpecifyingQuantity,
            "#{userId}"
        ));
    }

    public VerifyGradeUpMaterialByUserId verifyGradeUpMaterial(
        String gradeName,
        String verifyType,
        String propertyId,
        String materialPropertyId,
        String userId
    ) {
        return (new VerifyGradeUpMaterialByUserId(
            this.namespaceName,
            gradeName,
            verifyType,
            propertyId,
            materialPropertyId,
            userId
        ));
    }


    public VerifyGradeUpMaterialByUserId verifyGradeUpMaterial(
        String gradeName,
        String verifyType,
        String propertyId,
        String materialPropertyId
    ) {
        return (new VerifyGradeUpMaterialByUserId(
            this.namespaceName,
            gradeName,
            verifyType,
            propertyId,
            materialPropertyId,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "grade",
                this.namespaceName
            )
        )).str(
        );
    }
}
