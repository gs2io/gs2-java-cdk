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
package io.gs2.cdk.script.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.script.stampSheet.InvokeScript;
import io.gs2.cdk.script.model.RandomStatus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptRef {
    private String namespaceName;
    private String scriptName;

    public ScriptRef(
        String namespaceName,
        String scriptName
    ) {
        this.namespaceName = namespaceName;
        this.scriptName = scriptName;
    }

    public InvokeScript invokeScript(
        String scriptId,
        String args,
        RandomStatus randomStatus,
        Boolean forceUseDistributor,
        String userId
    ) {
        return (new InvokeScript(
            scriptId,
            args,
            randomStatus,
            forceUseDistributor,
            userId
        ));
    }


    public InvokeScript invokeScript(
        String scriptId,
        String args,
        RandomStatus randomStatus,
        Boolean forceUseDistributor
    ) {
        return (new InvokeScript(
            scriptId,
            args,
            randomStatus,
            forceUseDistributor,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "script",
                this.namespaceName,
                "script",
                this.scriptName
            )
        )).str(
        );
    }
}
