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
import io.gs2.cdk.stateMachine.model.options.EmitEventOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class EmitEvent {
    private String event;
    private String parameters;
    private Long timestamp;

    public EmitEvent(
        String event,
        String parameters,
        Long timestamp,
        EmitEventOptions options
    ) {
        this.event = event;
        this.parameters = parameters;
        this.timestamp = timestamp;
    }
    public EmitEvent(
        String event,
        String parameters,
        Long timestamp
    ) {
        this.event = event;
        this.parameters = parameters;
        this.timestamp = timestamp;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.event != null) {
            properties.put("event", this.event);
        }
        if (this.parameters != null) {
            properties.put("parameters", this.parameters);
        }
        if (this.timestamp != null) {
            properties.put("timestamp", this.timestamp);
        }

        return properties;
    }
}
