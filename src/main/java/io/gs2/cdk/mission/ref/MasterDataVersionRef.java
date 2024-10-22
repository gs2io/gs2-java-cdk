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
package io.gs2.cdk.mission.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MasterDataVersionRef {
    private String namespaceName;
    private String objectKey;
    private String versionId;

    public MasterDataVersionRef(
        String namespaceName,
        String objectKey,
        String versionId
    ) {
        this.namespaceName = namespaceName;
        this.objectKey = objectKey;
        this.versionId = versionId;
    }
}
