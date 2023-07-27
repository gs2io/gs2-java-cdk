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

public class WaitTask implements ITask {
    String name;
    List<Result> results = new ArrayList<>();
    List<Event> events = new ArrayList<>();

    public WaitTask(
            String name
    ) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITask transition(Event event) {
        event.fromTaskName = this.name;
        this.events.add(event);
        return this;
    }

    @Override
    public Event[] getEvents() {
        return events.toArray(new Event[0]);
    }

    public WaitTask result(
            String resultName,
            Map<IVariable, String> emitEventArgumentVariableNames,
            String nextTaskName
    ) {
        this.results.add(
                new Result(
                        resultName,
                        resultName,
                        emitEventArgumentVariableNames
                )
        );
        IVariable[] eventArguments = emitEventArgumentVariableNames.keySet().stream().collect(Collectors.toList()).toArray(new IVariable[0]);
        this.transition(new Event(resultName, eventArguments, nextTaskName));
        return this;
    }

    public String gsl() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("WaitTask %s {%n", this.name));

        for (Event event : this.events) {
            String argumentsPart = Arrays.stream(event.arguments)
                    .map(IVariable::gsl)
                    .collect(Collectors.joining(", "));
            output.append(String.format("Event %s(%s);\n", event.name, argumentsPart).indent(2));
        }

        output.append("}\n\n");
        return output.toString();
    }

    public String mermaid() {
        StringBuilder output = new StringBuilder();
        for (Event event : this.events) {
            if (!event.nextTaskName.equals("Error")) {
                output.append(String.format("{stateMachineName}_%s([{%s}]) -->|%s| {stateMachineName}_%s\n",
                        event.fromTaskName, event.fromTaskName, event.name, event.nextTaskName));
            }
        }
        return output.toString();
    }
}
