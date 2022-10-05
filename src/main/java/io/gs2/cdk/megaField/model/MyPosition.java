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

public class MyPosition {
	public Position position;
	public Vector vector;
	public Float r;

    public MyPosition(
            Position position,
            Vector vector,
            Float r
    ) {
        this.position = position;
        this.vector = vector;
        this.r = r;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.position != null) {
            properties.put("Position", this.position.properties());
        }
        if (this.vector != null) {
            properties.put("Vector", this.vector.properties());
        }
        if (this.r != null) {
            properties.put("R", this.r);
        }
        return properties;
    }
}
