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
package io.gs2.cdk.guard.model.options;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelDefaultRestriction;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelLocationDetection;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelLocationRestriction;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelAnonymousIpDetection;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelAnonymousIpRestriction;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelHostingProviderIpDetection;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelHostingProviderIpRestriction;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelReputationIpDetection;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelReputationIpRestriction;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelIpAddressesDetection;
import io.gs2.cdk.guard.model.enums.BlockingPolicyModelIpAddressRestriction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BlockingPolicyModelReputationIpDetectionIsEnableOptions {
    public List<String> ipAddresses;
    
    public BlockingPolicyModelReputationIpDetectionIsEnableOptions withIpAddresses(
        List<String> ipAddresses
    ) {
        this.ipAddresses = ipAddresses;
        return this;
    }
}
