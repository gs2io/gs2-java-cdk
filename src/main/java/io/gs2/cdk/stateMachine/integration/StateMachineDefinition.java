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

import io.gs2.cdk.core.model.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateMachineDefinition {
    public String stateMachineName = "";
    List<StateMachine> stateMachines = new ArrayList<>();

    public void add(
            StateMachine stateMachine
    ) {
        this.stateMachines.add(stateMachine);
    }

    public void entryPointStateMachineName(
            String stateMachineName
    ) {
        this.stateMachineName = stateMachineName;
    }

    public StateMachine stateMachine(
            String name,
            IVariable[] variables
    ) {
        return new StateMachine(this, name, variables);
    }
    public Task scriptTask(
            String name,
            IVariable[] arguments,
            String script
    ) {
        return new Task(name, arguments, script);
    }

    public SubStateMachineTask subStateMachineTask(
            String name,
            String subStateMachineName,
            InParam[] inParams,
            OutParam[] outParams,
            String nextTaskName
    ) {
        SubStateMachineTask task = new SubStateMachineTask(name, subStateMachineName, inParams, outParams);
        task.transition(new Event("Pass",
                Arrays.stream(outParams).map(v -> v.subStateMachineVariable).toArray(IVariable[]::new),
                nextTaskName));
        return task;
    }

    public InParam inParam(
            IVariable currentStateMachineVariable,
            IVariable subStateMachineVariable
    ) {
        return new InParam(currentStateMachineVariable, subStateMachineVariable);
    }

    public OutParam outParam(
            IVariable subStateMachineVariable,
            IVariable currentStateMachineVariable
    ) {
        return new OutParam(subStateMachineVariable, currentStateMachineVariable);
    }

    public WaitTask waitTask(String name) {
        return new WaitTask(name);
    }

    public PassTask passTask(String name) {
        return new PassTask(name);
    }

    public ErrorTask errorTask(String name) {
        return new ErrorTask(name);
    }

    public IntType intType(String name) {
        return new IntType(name);
    }

    public FloatType floatType(String name) {
        return new FloatType(name);
    }

    public BoolType boolType(String name) {
        return new BoolType(name);
    }

    public StringType stringType(String name) {
        return new StringType(name);
    }

    public ArrayType arrayType(String name) {
        return new ArrayType(name);
    }

    public MapType mapType(String name) {
        return new MapType(name);
    }

    public io.gs2.cdk.script.model.Script[] appendScripts(
            Stack stack,
            io.gs2.cdk.script.model.Namespace scriptNamespace
    ) {
        List<io.gs2.cdk.script.model.Script> scripts = new ArrayList<>();
        for (StateMachine stateMachine : this.stateMachines) {
            for (Script script : stateMachine.scripts()) {
                var deployScript = new io.gs2.cdk.script.model.Script(
                        stack,
                        scriptNamespace.getName(),
                        script.name,
                        script.payload.trim()
                );
                deployScript.addDependsOn(scriptNamespace);
                scripts.add(deployScript);
            }
        }
        return scripts.toArray(new io.gs2.cdk.script.model.Script[0]);
    }

    public String gsl() {
        StringBuilder output = new StringBuilder();
        for (StateMachine stateMachine : this.stateMachines) {
            output.append(stateMachine.gsl()).append("\n");
        }
        return output.toString();
    }

    public String mermaid() {
        StringBuilder output = new StringBuilder("flowchart TD\n");

        output.append(String.format("Start ----> %s_{%s}\n",
                this.stateMachines.get(0).name, this.stateMachines.get(0).entryPointValue).indent(2));
        output.append(String.format("%s_Pass ----> Exit\n",
                this.stateMachines.get(0).name).indent(2));

        for (StateMachine stateMachine : this.stateMachines) {
            output.append(stateMachine.mermaid().indent(2)).append("\n");
        }

        for (StateMachine stateMachine : this.stateMachines) {
            output = new StringBuilder(output.toString().replace(
                    "{" + stateMachine.name + "_entryPoint}", stateMachine.entryPointValue));
        }

        return output.toString();
    }
}
