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
package io.gs2.cdk.version.model.options;
import io.gs2.cdk.version.model.Version;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TargetVersionOptions {
    public String body;
    public String signature;
    public Version version;
    
    public TargetVersionOptions withBody(
        String body
    ) {
        this.body = body;
        return this;
    }
    
    public TargetVersionOptions withSignature(
        String signature
    ) {
        this.signature = signature;
        return this;
    }
    
    public TargetVersionOptions withVersion(
        Version version
    ) {
        this.version = version;
        return this;
    }
}

