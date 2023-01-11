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
package io.gs2.cdk.mission.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.mission.model.MissionGroupModel;
import io.gs2.cdk.mission.model.CounterModel;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentMasterData extends CdkResource {
    private String version= "2019-05-28";
    private String namespaceName;
    private List<MissionGroupModel> missionGroupModels;
    private List<CounterModel> counterModels;

    public CurrentMasterData(
        Stack stack,
        String namespaceName,
        List<MissionGroupModel> missionGroupModels,
        List<CounterModel> counterModels
    ) {
        super(
            "Mission_CurrentMissionMaster_" + namespaceName
        );

        this.namespaceName = namespaceName;
        this.missionGroupModels = missionGroupModels;
        this.counterModels = counterModels;
        stack.addResource(
            this
        );
    }

    public String alternateKeys(
    ) {
        return this.namespaceName;
    }

    public String resourceType(
    ) {
        return "GS2::Mission::CurrentMissionMaster";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();
        var settings = new HashMap<String, Object>();

        settings.put("version", this.version);
        if (this.missionGroupModels != null) {
            settings.put("missionGroupModels", this.missionGroupModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.counterModels != null) {
            settings.put("counterModels", this.counterModels.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        if (this.namespaceName != null) {
            properties.put("NamespaceName", this.namespaceName);
        }
        if (settings != null) {
            properties.put("Settings", settings);
        }

        return properties;
    }
}