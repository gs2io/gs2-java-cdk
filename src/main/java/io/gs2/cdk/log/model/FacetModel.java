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
package io.gs2.cdk.log.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.log.ref.FacetModelRef;
import io.gs2.cdk.log.model.enums.FacetModelType;

import io.gs2.cdk.log.model.options.FacetModelOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class FacetModel extends CdkResource {
    private Stack stack;
    private String namespaceName;
    private String field;
    private FacetModelType type;
    private String displayName;
    private Integer order = null;

    public FacetModel(
        Stack stack,
        String namespaceName,
        String field,
        FacetModelType type,
        String displayName,
        FacetModelOptions options
    ) {
        super(
            "Log_FacetModel_" + field
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.field = field;
        this.type = type;
        this.displayName = displayName;
        this.order = options.order;
        stack.addResource(
            this
        );
    }

    public FacetModel(
        Stack stack,
        String namespaceName,
        String field,
        FacetModelType type,
        String displayName
    ) {
        super(
            "Log_FacetModel_" + field
        );

        this.stack = stack;
        this.namespaceName = namespaceName;
        this.field = field;
        this.type = type;
        this.displayName = displayName;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "field";
    }

    public String resourceType(
    ) {
        return "GS2::Log::FacetModel";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (this.field != null) {
            properties.put("Field", this.field);
        }
        if (this.type != null) {
            properties.put("Type", this.type);
        }
        if (this.displayName != null) {
            properties.put("DisplayName", this.displayName);
        }
        if (this.order != null) {
            properties.put("Order", this.order);
        }

        return properties;
    }

    public FacetModelRef ref(
    ) {
        return (new FacetModelRef(
            this.namespaceName,
            this.field
        ));
    }

    public GetAttr getAttrFacetModelId(
    ) {
        return (new GetAttr(
            this,
            "Item.FacetModelId",
            null
        ));
    }
}
