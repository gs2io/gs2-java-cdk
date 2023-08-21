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
package io.gs2.cdk.news.model;
import io.gs2.cdk.news.model.options.ProgressOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Progress {
    private String uploadToken;
    private Integer generated;
    private Integer patternCount;
    private Long revision = null;

    public Progress(
        String uploadToken,
        Integer generated,
        Integer patternCount,
        ProgressOptions options
    ) {
        this.uploadToken = uploadToken;
        this.generated = generated;
        this.patternCount = patternCount;
        this.revision = options.revision;
    }
    public Progress(
        String uploadToken,
        Integer generated,
        Integer patternCount
    ) {
        this.uploadToken = uploadToken;
        this.generated = generated;
        this.patternCount = patternCount;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.uploadToken != null) {
            properties.put("uploadToken", this.uploadToken);
        }
        if (this.generated != null) {
            properties.put("generated", this.generated);
        }
        if (this.patternCount != null) {
            properties.put("patternCount", this.patternCount);
        }

        return properties;
    }
}
