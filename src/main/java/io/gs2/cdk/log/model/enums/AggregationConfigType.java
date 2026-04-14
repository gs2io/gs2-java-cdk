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

package io.gs2.cdk.log.model.enums;


public enum AggregationConfigType {
    COUNT,
    UNIQUE,
    SUM,
    AVG,
    MAX,
    MIN,
    P90,
    P95,
    P99;

    public String toString() {
        switch (this) {
            case COUNT:
                return "count";
            case UNIQUE:
                return "unique";
            case SUM:
                return "sum";
            case AVG:
                return "avg";
            case MAX:
                return "max";
            case MIN:
                return "min";
            case P90:
                return "p90";
            case P95:
                return "p95";
            case P99:
                return "p99";
        }
        return "unknown";
    }
}
