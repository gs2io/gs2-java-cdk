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

public class ErrorTask implements ITask {
    String name;
    IVariable[] arguments;

    public ErrorTask(String name) {
        this.name = name;
        this.arguments = new IVariable[]{
                new StringType("reason"),
        };
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITask transition(Event event) {
        return this;
    }

    @Override
    public Event[] getEvents() {
        return new Event[0];
    }

    public String gsl() {
        return String.format("ErrorTask %s(string reason);\n\n", this.name);
    }

    public String mermaid() {
        return "";
    }
}
