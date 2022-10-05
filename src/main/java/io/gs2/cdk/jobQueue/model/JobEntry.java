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

package io.gs2.cdk.jobQueue.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.jobQueue.resource.*;

import java.util.*;
import java.util.stream.*;

public class JobEntry {
	public String scriptId;
	public String args;
	public Integer maxTryCount;

    public JobEntry(
            String scriptId,
            String args,
            Integer maxTryCount
    ) {
        this.scriptId = scriptId;
        this.args = args;
        this.maxTryCount = maxTryCount;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.scriptId != null) {
            properties.put("ScriptId", this.scriptId);
        }
        if (this.args != null) {
            properties.put("Args", this.args);
        }
        if (this.maxTryCount != null) {
            properties.put("MaxTryCount", this.maxTryCount);
        }
        return properties;
    }
}
