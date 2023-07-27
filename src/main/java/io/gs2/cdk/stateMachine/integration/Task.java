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
package io.gs2.cdk.stateMachine.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task implements ITask {

    String name;
    IVariable[] arguments;
    String script;

    List<Event> events;
    List<Result> results;

    public Task(
            String name,
            IVariable[] arguments,
            String script
    ) {
        this.name = name;
        this.arguments = arguments;
        this.script = script;

        this.events = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITask transition(
            Event event
    ) {
        event.fromTaskName = name;
        events.add(event);
        return this;
    }

    @Override
    public Event[] getEvents() {
        return events.toArray(new Event[0]);
    }

    public Task result(
            String name,
            Map<IVariable, String> emitEventArgumentVariableNames,
            String nextTaskName
    ) {
        results.add(new Result(
                name,
                name,
                emitEventArgumentVariableNames
        ));
        transition(new Event(
                name,
                emitEventArgumentVariableNames.keySet().toArray(new IVariable[0]),
                nextTaskName
        ));
        return this;
    }

    public Script scriptPayload() {
        var output = script;
        output += "\n\n";
        for (var result : results) {
            output += String.format("if result == '%s' then\n", result.name);
            output += String.format("""
result = {
event='%s',
params={%s},
updatedVariables=args.variables
            """, result.emitEventName, result.emitEventArgumentVariableNames.entrySet().stream().map(v -> String.format("%s=%s", v.getKey().getName(), v.getValue())).collect(Collectors.joining(", "))
            ).indent(2);
            output += "end\n";
        }
        return new Script(
                name,
                output
        );
    }

    @Override
    public String gsl() {
        var output = String.format("Task %s(%s) {\n", name, Arrays.stream(arguments).map(IVariable::gsl).collect(Collectors.joining(", ")));
        for (var event : events) {
            output += String.format("Event %s(%s);\n", event.name, Arrays.stream(event.arguments).map(IVariable::gsl).collect(Collectors.joining(", "))).indent(2);
        }
        output += String.format("Script grn:gs2:{region}:{ownerId}:script:{scriptNamespaceName}:script:{stateMachineName}_%s", name).indent(2);
        output += "}\n\n";
        return output;
    }

    @Override
    public String mermaid() {
        var output = "";
        for(var event : events) {
            if (event.nextTaskName.equals("Error")) continue;
            output += String.format("{stateMachineName}_%s[[%s]] -->|%s| {stateMachineName}_%s\n", event.fromTaskName, event.fromTaskName, event.name, event.nextTaskName);
        }
        return output;
    }
}
