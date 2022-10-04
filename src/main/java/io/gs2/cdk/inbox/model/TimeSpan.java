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

package io.gs2.cdk.inbox.model;

import io.gs2.cdk.core.model.*;

import java.util.*;
import java.util.stream.*;

public class TimeSpan {
	public Integer days;
	public Integer hours;
	public Integer minutes;

    public TimeSpan(
            Integer days,
            Integer hours,
            Integer minutes
    ) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.days != null) {
            properties.put("Days", this.days);
        }
        if (this.hours != null) {
            properties.put("Hours", this.hours);
        }
        if (this.minutes != null) {
            properties.put("Minutes", this.minutes);
        }
        return properties;
    }
}
