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
package io.gs2.cdk.log.model.options;
import io.gs2.cdk.log.model.enums.NamespaceType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceTypeIsFirehoseOptions {
    public String description;
    public String status;
    public Long revision;
    
    public NamespaceTypeIsFirehoseOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceTypeIsFirehoseOptions withStatus(
        String status
    ) {
        this.status = status;
        return this;
    }
    
    public NamespaceTypeIsFirehoseOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}
