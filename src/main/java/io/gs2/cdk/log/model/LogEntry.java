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
import io.gs2.cdk.log.model.options.LogEntryOptions;
import io.gs2.cdk.log.model.enums.LogEntryStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LogEntry {
    private Long timestamp;
    private LogEntryStatus status;
    private Long duration;
    private String line;
    private List<Label> labels = null;

    public LogEntry(
        Long timestamp,
        LogEntryStatus status,
        Long duration,
        String line,
        LogEntryOptions options
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.duration = duration;
        this.line = line;
        this.labels = options.labels;
    }
    public LogEntry(
        Long timestamp,
        LogEntryStatus status,
        Long duration,
        String line
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.duration = duration;
        this.line = line;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.timestamp != null) {
            properties.put("timestamp", this.timestamp);
        }
        if (this.status != null) {
            properties.put("status", this.status.toString(
            ));
        }
        if (this.duration != null) {
            properties.put("duration", this.duration);
        }
        if (this.line != null) {
            properties.put("line", this.line);
        }
        if (this.labels != null) {
            properties.put("labels", this.labels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
