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
package io.gs2.cdk.account.model;
import io.gs2.cdk.account.model.options.BanStatusOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BanStatus {
    private String reason;
    private Long releaseTimestamp;

    public BanStatus(
        String reason,
        Long releaseTimestamp,
        BanStatusOptions options
    ) {
        this.reason = reason;
        this.releaseTimestamp = releaseTimestamp;
    }
    public BanStatus(
        String reason,
        Long releaseTimestamp
    ) {
        this.reason = reason;
        this.releaseTimestamp = releaseTimestamp;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.reason != null) {
            properties.put("reason", this.reason);
        }
        if (this.releaseTimestamp != null) {
            properties.put("releaseTimestamp", this.releaseTimestamp);
        }

        return properties;
    }
}
