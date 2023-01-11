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
package io.gs2.cdk.exchange.model.options;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.exchange.model.enums.RateModelTimingType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RateModelTimingTypeIsImmediateOptions {
    public String metadata;
    public List<ConsumeAction> consumeActions;
    public List<ConsumeAction> skipConsumeActions;
    public List<AcquireAction> acquireActions;
    
    public RateModelTimingTypeIsImmediateOptions withMetadata(
        String metadata
    ) {
        this.metadata = metadata;
        return this;
    }
    
    public RateModelTimingTypeIsImmediateOptions withConsumeActions(
        List<ConsumeAction> consumeActions
    ) {
        this.consumeActions = consumeActions;
        return this;
    }
    
    public RateModelTimingTypeIsImmediateOptions withSkipConsumeActions(
        List<ConsumeAction> skipConsumeActions
    ) {
        this.skipConsumeActions = skipConsumeActions;
        return this;
    }
    
    public RateModelTimingTypeIsImmediateOptions withAcquireActions(
        List<AcquireAction> acquireActions
    ) {
        this.acquireActions = acquireActions;
        return this;
    }
}
