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
import io.gs2.cdk.stateMachine.model.ChangeStateEvent;
import io.gs2.cdk.stateMachine.model.EmitEvent;
import io.gs2.cdk.stateMachine.model.options.EventOptions;
import io.gs2.cdk.stateMachine.model.options.EventEventTypeIsChangeStateOptions;
import io.gs2.cdk.stateMachine.model.options.EventEventTypeIsEmitOptions;
import io.gs2.cdk.stateMachine.model.enums.EventEventType;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Event {
    private EventEventType eventType;
    private ChangeStateEvent changeStateEvent = null;
    private EmitEvent emitEvent = null;

    public Event(
        EventEventType eventType,
        EventOptions options
    ) {
        this.eventType = eventType;
        this.changeStateEvent = options.changeStateEvent;
        this.emitEvent = options.emitEvent;
    }
    public Event(
        EventEventType eventType
    ) {
        this.eventType = eventType;
    }

    public static Event eventTypeIsChangeState(
        ChangeStateEvent changeStateEvent,
        EventEventTypeIsChangeStateOptions options
    ) {
        return (new Event(
            EventEventType.CHANGE_STATE,
            new EventOptions()
                .withChangeStateEvent(changeStateEvent)
        ));
    }


    public static Event eventTypeIsChangeState(
        ChangeStateEvent changeStateEvent
    ) {
        return (new Event(
            EventEventType.CHANGE_STATE
        ));
    }

    public static Event eventTypeIsEmit(
        EmitEvent emitEvent,
        EventEventTypeIsEmitOptions options
    ) {
        return (new Event(
            EventEventType.EMIT,
            new EventOptions()
                .withEmitEvent(emitEvent)
        ));
    }


    public static Event eventTypeIsEmit(
        EmitEvent emitEvent
    ) {
        return (new Event(
            EventEventType.EMIT
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.eventType != null) {
            properties.put("eventType", this.eventType.toString(
            ));
        }
        if (this.changeStateEvent != null) {
            properties.put("changeStateEvent", this.changeStateEvent.properties(
            ));
        }
        if (this.emitEvent != null) {
            properties.put("emitEvent", this.emitEvent.properties(
            ));
        }

        return properties;
    }
}
