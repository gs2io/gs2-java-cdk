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
package io.gs2.cdk.jobQueue.model;
import io.gs2.cdk.jobQueue.model.options.JobResultBodyOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class JobResultBody {
    private Integer tryNumber;
    private Integer statusCode;
    private String result;

    public JobResultBody(
        Integer tryNumber,
        Integer statusCode,
        String result,
        JobResultBodyOptions options
    ) {
        this.tryNumber = tryNumber;
        this.statusCode = statusCode;
        this.result = result;
    }
    public JobResultBody(
        Integer tryNumber,
        Integer statusCode,
        String result
    ) {
        this.tryNumber = tryNumber;
        this.statusCode = statusCode;
        this.result = result;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.tryNumber != null) {
            properties.put("tryNumber", this.tryNumber);
        }
        if (this.statusCode != null) {
            properties.put("statusCode", this.statusCode);
        }
        if (this.result != null) {
            properties.put("result", this.result);
        }

        return properties;
    }
}
