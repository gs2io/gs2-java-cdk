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
package io.gs2.cdk.lottery.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.lottery.model.Prize;
import io.gs2.cdk.lottery.model.options.PrizeTableOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeTable {
    private String name;
    private List<Prize> prizes;
    private String metadata = null;

    public PrizeTable(
        String name,
        List<Prize> prizes,
        PrizeTableOptions options
    ) {
        this.name = name;
        this.prizes = prizes;
        this.metadata = options.metadata;
    }
    public PrizeTable(
        String name,
        List<Prize> prizes
    ) {
        this.name = name;
        this.prizes = prizes;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.prizes != null) {
            properties.put("prizes", this.prizes.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
