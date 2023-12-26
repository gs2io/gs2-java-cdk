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
package io.gs2.cdk.grade.model;
import io.gs2.cdk.grade.model.options.AcquireActionRateOptions;
import io.gs2.cdk.grade.model.options.AcquireActionRateModeIsDoubleOptions;
import io.gs2.cdk.grade.model.options.AcquireActionRateModeIsBigOptions;
import io.gs2.cdk.grade.model.enums.AcquireActionRateMode;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AcquireActionRate {
    private String name;
    private AcquireActionRateMode mode;
    private List<Double> rates = null;
    private List<String> bigRates = null;

    public AcquireActionRate(
        String name,
        AcquireActionRateMode mode,
        AcquireActionRateOptions options
    ) {
        this.name = name;
        this.mode = mode;
        this.rates = options.rates;
        this.bigRates = options.bigRates;
    }
    public AcquireActionRate(
        String name,
        AcquireActionRateMode mode
    ) {
        this.name = name;
        this.mode = mode;
    }

    public static AcquireActionRate modeIsDouble(
        String name,
        List<Double> rates,
        AcquireActionRateModeIsDoubleOptions options
    ) {
        return (new AcquireActionRate(
            name,
            AcquireActionRateMode.DOUBLE,
            new AcquireActionRateOptions()
                .withRates(rates)
        ));
    }


    public static AcquireActionRate modeIsDouble(
        String name,
        List<Double> rates
    ) {
        return (new AcquireActionRate(
            name,
            AcquireActionRateMode.DOUBLE
        ));
    }

    public static AcquireActionRate modeIsBig(
        String name,
        List<String> bigRates,
        AcquireActionRateModeIsBigOptions options
    ) {
        return (new AcquireActionRate(
            name,
            AcquireActionRateMode.BIG,
            new AcquireActionRateOptions()
                .withBigRates(bigRates)
        ));
    }


    public static AcquireActionRate modeIsBig(
        String name,
        List<String> bigRates
    ) {
        return (new AcquireActionRate(
            name,
            AcquireActionRateMode.BIG
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.mode != null) {
            properties.put("mode", this.mode.toString(
            ));
        }
        if (this.rates != null) {
            properties.put("rates", this.rates);
        }
        if (this.bigRates != null) {
            properties.put("bigRates", this.bigRates);
        }

        return properties;
    }
}
