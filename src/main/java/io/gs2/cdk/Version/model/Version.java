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
package io.gs2.cdk.version.model;
import io.gs2.cdk.version.model.options.VersionOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Version {
    private Integer major;
    private Integer minor;
    private Integer micro;

    public Version(
        Integer major,
        Integer minor,
        Integer micro,
        VersionOptions options
    ) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }
    public Version(
        Integer major,
        Integer minor,
        Integer micro
    ) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.major != null) {
            properties.put("major", this.major);
        }
        if (this.minor != null) {
            properties.put("minor", this.minor);
        }
        if (this.micro != null) {
            properties.put("micro", this.micro);
        }

        return properties;
    }
}
