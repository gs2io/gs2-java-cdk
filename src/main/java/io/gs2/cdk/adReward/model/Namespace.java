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
package io.gs2.cdk.adReward.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.adReward.model.AdMob;
import io.gs2.cdk.adReward.model.UnityAd;
import io.gs2.cdk.core.model.NotificationSetting;
import io.gs2.cdk.core.model.LogSetting;

import io.gs2.cdk.adReward.ref.NamespaceRef;

import io.gs2.cdk.adReward.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private NotificationSetting changePointNotification;
    private AdMob admob = null;
    private UnityAd unityAd = null;
    private String description = null;
    private LogSetting logSetting = null;

    public Namespace(
        Stack stack,
        String name,
        NotificationSetting changePointNotification,
        NamespaceOptions options
    ) {
        super(
            "AdReward_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.changePointNotification = changePointNotification;
        this.admob = options.admob;
        this.unityAd = options.unityAd;
        this.description = options.description;
        this.logSetting = options.logSetting;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name,
        NotificationSetting changePointNotification
    ) {
        super(
            "AdReward_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.changePointNotification = changePointNotification;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::AdReward::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.admob != null) {
            properties.put("Admob", this.admob.properties(
            ));
        }
        if (this.unityAd != null) {
            properties.put("UnityAd", this.unityAd.properties(
            ));
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.changePointNotification != null) {
            properties.put("ChangePointNotification", this.changePointNotification.properties(
            ));
        }
        if (this.logSetting != null) {
            properties.put("LogSetting", this.logSetting.properties(
            ));
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            this,
            "Item.NamespaceId",
            null
        ));
    }
}
