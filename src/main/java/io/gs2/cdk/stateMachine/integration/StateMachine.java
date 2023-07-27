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

public class StateMachine {
    String name;
    IVariable[] variables;
    List<ITask> tasks = new ArrayList<>();
    String entryPointValue;
    StateMachineDefinition stateMachineDefinition;

    public StateMachine(
            StateMachineDefinition stateMachineDefinition,
            String name,
            IVariable[] variables
    ) {
        this.stateMachineDefinition = stateMachineDefinition;
        this.name = name;
        this.variables = variables;
        stateMachineDefinition.add(this);
    }

    public StateMachine task(ITask... args) {
        this.tasks.addAll(List.of(args));
        return this;
    }

    public StateMachine entryPoint(String taskName) {
        this.entryPointValue = taskName;
        return this;
    }

    public List<Script> scripts() {
        List<Script> scripts = new ArrayList<>();
        for (ITask task : this.tasks) {
            if (task instanceof Task) {
                Script script = ((Task) task).scriptPayload();
                script.name = this.name + "_" + script.name;
                scripts.add(script);
            }
        }
        return scripts;
    }

    public String gsl() {
        StringBuilder output = new StringBuilder(String.format("StateMachine %s {%n", this.name));

        if (this.variables != null && this.variables.length > 0) {
            StringBuilder variablesPart = new StringBuilder("Variables {\n");
            for (IVariable variable : this.variables) {
                variablesPart.append(String.format("%s;\n", variable.gsl()).indent(2));
            }
            variablesPart.append("}\n\n");
            output.append(variablesPart.toString());
        }

        if (this.entryPointValue != null) {
            output.append(String.format("EntryPoint %s;\n\n", this.entryPointValue).indent(2));
        }

        for (ITask task : this.tasks) {
            output.append(task.gsl().indent(2));
        }

        for (ITask task : this.tasks) {
            for (Event event : task.getEvents()) {
                output.append(event.gsl().indent(2));
            }
        }

        output.append("}\n");
        String result = output.toString().replace("{stateMachineName}", this.name);

        return result;
    }

    public String mermaid() {
        StringBuilder output = new StringBuilder(String.format("subgraph %s%n", this.name));
        for (ITask task : this.tasks) {
            output.append(task.mermaid().indent(2)).append("\n");
        }
        output.append("end\n");

        for (ITask task : this.tasks) {
            if (task instanceof SubStateMachineTask) {
                output.append("\n");
                output.append(String.format("{stateMachineName}_%s --> %s_{%s_entryPoint}\n",
                        ((SubStateMachineTask) task).name,
                        ((SubStateMachineTask) task).subStateMachineName,
                        ((SubStateMachineTask) task).subStateMachineName
                ));
                output.append(String.format("%s_Pass -->|Pass| {stateMachineName}_%s\n",
                        ((SubStateMachineTask) task).subStateMachineName,
                        ((SubStateMachineTask) task).events.get(0).nextTaskName
                ));
            }
            if (task instanceof WaitTask) {
                output.append("\n");
                output.append(String.format("Player ----->|Interaction| {stateMachineName}_%s\n",
                        ((WaitTask) task).name
                ));
            }
        }

        return output.toString().replace("{stateMachineName}", this.name);
    }
}
