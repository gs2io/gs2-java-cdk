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

package io.gs2.cdk.megaField.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.megaField.resource.*;

import java.util.*;
import java.util.stream.*;

public class Vector {
	public Float x;
	public Float y;
	public Float z;

    public Vector(
            Float x,
            Float y,
            Float z
    ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.x != null) {
            properties.put("X", this.x);
        }
        if (this.y != null) {
            properties.put("Y", this.y);
        }
        if (this.z != null) {
            properties.put("Z", this.z);
        }
        return properties;
    }
}
