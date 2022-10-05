/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.schedule.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.schedule.ref.*;
import io.gs2.cdk.schedule.model.*;

import java.util.*;
import java.util.stream.*;

public class CurrentMasterData extends CdkResource {

    String version = "2019-03-31";
    public String namespaceName;
    public List<Event> events;

    public CurrentMasterData(
            Stack stack,
            String namespaceName,
            List<Event> events
    ) {
        super("Schedule_CurrentEventMaster_" + namespaceName);

        this.namespaceName = namespaceName;
        this.events = events;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Schedule::CurrentEventMaster";
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("NamespaceName", namespaceName);
                put("Settings", new HashMap<>() {
                    {
                        put("version", version);
                        put("events", events.stream().map(Event::properties).collect(Collectors.toList()));
                    }
                });
            }
        };
    }
}