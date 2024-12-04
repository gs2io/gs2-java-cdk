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
package io.gs2.cdk.exchange.model;
import io.gs2.cdk.exchange.model.options.LogRateOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class LogRate {
    private Double base;
    private List<Double> logs;

    public LogRate(
        Double base,
        List<Double> logs,
        LogRateOptions options
    ) {
        this.base = base;
        this.logs = logs;
    }
    public LogRate(
        Double base,
        List<Double> logs
    ) {
        this.base = base;
        this.logs = logs;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.base != null) {
            properties.put("base", this.base);
        }
        if (this.logs != null) {
            properties.put("logs", this.logs);
        }

        return properties;
    }
}
