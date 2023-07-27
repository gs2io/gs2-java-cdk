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
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class SubStateMachineTask implements ITask {
    String name;
    String subStateMachineName;
    InParam[] inParams;
    OutParam[] outParams;
    List<Event> events = new ArrayList<>();

    public SubStateMachineTask(
            String name,
            String subStateMachineName,
            InParam[] inParams,
            OutParam[] outParams
    ) {
        this.name = name;
        this.subStateMachineName = subStateMachineName;
        this.inParams = inParams;
        this.outParams = outParams;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITask transition(Event event) {
        event.fromTaskName = this.name;
        events.add(event);
        return this;
    }

    @Override
    public Event[] getEvents() {
        return events.toArray(new Event[0]);
    }

    public String gsl() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("SubStateMachineTask %s {%n", this.name));
        output.append(String.format("using %s;%n", this.name).indent(2));

        String inParamPart = Arrays.stream(this.inParams)
                .map(inParam -> String.format("%s <- %s", inParam.subStateMachineVariable.getName(), inParam.currentStateMachineVariable.getName()))
                .collect(Collectors.joining(", "));
        output.append(("in (" + inParamPart + ");\n").indent(2));

        String outParamPart = Arrays.stream(this.outParams)
                .map(outParam -> String.format("%s -> %s", outParam.subStateMachineVariable.getName(), outParam.currentStateMachineVariable.getName()))
                .collect(Collectors.joining(", "));
        output.append(("out (" + outParamPart + ");\n").indent(2));

        output.append("}\n\n");
        return output.toString();
    }

    public String mermaid() {
        return String.format("%s_{name}[/{name}/]\n", this.name).replace("{name}", this.name);
    }
}
