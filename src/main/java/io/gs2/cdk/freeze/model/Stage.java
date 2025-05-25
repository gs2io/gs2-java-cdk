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
package io.gs2.cdk.freeze.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.freeze.ref.StageRef;
import io.gs2.cdk.freeze.model.enums.StageStatus;

import io.gs2.cdk.freeze.model.options.StageOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Stage extends CdkResource {
    private Stack stack;
    private String ownerId;
    private String name;
    private Integer sortNumber;
    private String sourceStageName = null;

    public Stage(
        Stack stack,
        String ownerId,
        String name,
        Integer sortNumber,
        StageOptions options
    ) {
        super(
            "Freeze_Stage_" + name
        );

        this.stack = stack;
        this.ownerId = ownerId;
        this.name = name;
        this.sortNumber = sortNumber;
        this.sourceStageName = options.sourceStageName;
        stack.addResource(
            this
        );
    }

    public Stage(
        Stack stack,
        String ownerId,
        String name,
        Integer sortNumber
    ) {
        super(
            "Freeze_Stage_" + name
        );

        this.stack = stack;
        this.ownerId = ownerId;
        this.name = name;
        this.sortNumber = sortNumber;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Freeze::Stage";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.ownerId != null) {
            properties.put("OwnerId", this.ownerId);
        }
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.sourceStageName != null) {
            properties.put("SourceStageName", this.sourceStageName);
        }
        if (this.sortNumber != null) {
            properties.put("SortNumber", this.sortNumber);
        }

        return properties;
    }

    public StageRef ref(
    ) {
        return (new StageRef(
            this.name
        ));
    }

    public GetAttr getAttrStageId(
    ) {
        return (new GetAttr(
            this,
            "Item.StageId",
            null
        ));
    }
}
