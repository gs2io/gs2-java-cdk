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
package io.gs2.cdk.stateMachine.model;
import io.gs2.cdk.stateMachine.model.options.ChangeStateEventOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeStateEvent {
    private String taskName;
    private String hash;
    private Long timestamp;

    public ChangeStateEvent(
        String taskName,
        String hash,
        Long timestamp,
        ChangeStateEventOptions options
    ) {
        this.taskName = taskName;
        this.hash = hash;
        this.timestamp = timestamp;
    }
    public ChangeStateEvent(
        String taskName,
        String hash,
        Long timestamp
    ) {
        this.taskName = taskName;
        this.hash = hash;
        this.timestamp = timestamp;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.taskName != null) {
            properties.put("taskName", this.taskName);
        }
        if (this.hash != null) {
            properties.put("hash", this.hash);
        }
        if (this.timestamp != null) {
            properties.put("timestamp", this.timestamp);
        }

        return properties;
    }
}
