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
import io.gs2.cdk.log.model.Label;
import io.gs2.cdk.log.model.LogEntry;
import io.gs2.cdk.log.model.options.TraceOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Trace {
    private Boolean truncated;
    private List<LogEntry> spans = null;

    public Trace(
        Boolean truncated,
        TraceOptions options
    ) {
        this.truncated = truncated;
        this.spans = options.spans;
    }
    public Trace(
        Boolean truncated
    ) {
        this.truncated = truncated;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.spans != null) {
            properties.put("spans", this.spans.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.truncated != null) {
            properties.put("truncated", this.truncated);
        }

        return properties;
    }
}
