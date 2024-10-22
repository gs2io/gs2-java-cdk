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
package io.gs2.cdk.guard.model;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelLocationDetectionIsEnableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelLocationDetectionIsDisableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelAnonymousIpDetectionIsEnableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelAnonymousIpDetectionIsDisableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelHostingProviderIpDetectionIsEnableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelHostingProviderIpDetectionIsDisableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelReputationIpDetectionIsEnableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelReputationIpDetectionIsDisableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelIpAddressesDetectionIsEnableOptions;
import io.gs2.cdk.guard.model.options.BlockingPolicyModelIpAddressesDetectionIsDisableOptions;
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

public class BlockingPolicyModel {
    private List<String> passServices;
    private BlockingPolicyModelDefaultRestriction defaultRestriction;
    private BlockingPolicyModelLocationDetection locationDetection;
    private BlockingPolicyModelAnonymousIpDetection anonymousIpDetection;
    private BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection;
    private BlockingPolicyModelReputationIpDetection reputationIpDetection;
    private BlockingPolicyModelIpAddressesDetection ipAddressesDetection;
    private List<String> locations = null;
    private BlockingPolicyModelLocationRestriction locationRestriction = null;
    private BlockingPolicyModelAnonymousIpRestriction anonymousIpRestriction = null;
    private BlockingPolicyModelHostingProviderIpRestriction hostingProviderIpRestriction = null;
    private BlockingPolicyModelReputationIpRestriction reputationIpRestriction = null;
    private List<String> ipAddresses = null;
    private BlockingPolicyModelIpAddressRestriction ipAddressRestriction = null;

    public BlockingPolicyModel(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelOptions options
    ) {
        this.passServices = passServices;
        this.defaultRestriction = defaultRestriction;
        this.locationDetection = locationDetection;
        this.anonymousIpDetection = anonymousIpDetection;
        this.hostingProviderIpDetection = hostingProviderIpDetection;
        this.reputationIpDetection = reputationIpDetection;
        this.ipAddressesDetection = ipAddressesDetection;
        this.locations = options.locations;
        this.locationRestriction = options.locationRestriction;
        this.anonymousIpRestriction = options.anonymousIpRestriction;
        this.hostingProviderIpRestriction = options.hostingProviderIpRestriction;
        this.reputationIpRestriction = options.reputationIpRestriction;
        this.ipAddresses = options.ipAddresses;
        this.ipAddressRestriction = options.ipAddressRestriction;
    }
    public BlockingPolicyModel(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection
    ) {
        this.passServices = passServices;
        this.defaultRestriction = defaultRestriction;
        this.locationDetection = locationDetection;
        this.anonymousIpDetection = anonymousIpDetection;
        this.hostingProviderIpDetection = hostingProviderIpDetection;
        this.reputationIpDetection = reputationIpDetection;
        this.ipAddressesDetection = ipAddressesDetection;
    }

    public static BlockingPolicyModel locationDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        List<String> locations,
        BlockingPolicyModelLocationRestriction locationRestriction,
        BlockingPolicyModelLocationDetectionIsEnableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            BlockingPolicyModelLocationDetection.ENABLE,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withLocations(locations)
                .withLocationRestriction(locationRestriction)
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel locationDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        List<String> locations,
        BlockingPolicyModelLocationRestriction locationRestriction
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            BlockingPolicyModelLocationDetection.ENABLE,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel locationDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelLocationDetectionIsDisableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            BlockingPolicyModelLocationDetection.DISABLE,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel locationDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            BlockingPolicyModelLocationDetection.DISABLE,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel anonymousIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelAnonymousIpRestriction anonymousIpRestriction,
        BlockingPolicyModelAnonymousIpDetectionIsEnableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            BlockingPolicyModelAnonymousIpDetection.ENABLE,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withAnonymousIpRestriction(anonymousIpRestriction)
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel anonymousIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelAnonymousIpRestriction anonymousIpRestriction
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            BlockingPolicyModelAnonymousIpDetection.ENABLE,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel anonymousIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelAnonymousIpDetectionIsDisableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            BlockingPolicyModelAnonymousIpDetection.DISABLE,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel anonymousIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            BlockingPolicyModelAnonymousIpDetection.DISABLE,
            hostingProviderIpDetection,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel hostingProviderIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelHostingProviderIpRestriction hostingProviderIpRestriction,
        BlockingPolicyModelHostingProviderIpDetectionIsEnableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            BlockingPolicyModelHostingProviderIpDetection.ENABLE,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withHostingProviderIpRestriction(hostingProviderIpRestriction)
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel hostingProviderIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelHostingProviderIpRestriction hostingProviderIpRestriction
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            BlockingPolicyModelHostingProviderIpDetection.ENABLE,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel hostingProviderIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelHostingProviderIpDetectionIsDisableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            BlockingPolicyModelHostingProviderIpDetection.DISABLE,
            reputationIpDetection,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel hostingProviderIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            BlockingPolicyModelHostingProviderIpDetection.DISABLE,
            reputationIpDetection,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel reputationIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelReputationIpRestriction reputationIpRestriction,
        BlockingPolicyModelReputationIpDetectionIsEnableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            BlockingPolicyModelReputationIpDetection.ENABLE,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withReputationIpRestriction(reputationIpRestriction)
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel reputationIpDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelReputationIpRestriction reputationIpRestriction
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            BlockingPolicyModelReputationIpDetection.ENABLE,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel reputationIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection,
        BlockingPolicyModelReputationIpDetectionIsDisableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            BlockingPolicyModelReputationIpDetection.DISABLE,
            ipAddressesDetection,
            new BlockingPolicyModelOptions()
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel reputationIpDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelIpAddressesDetection ipAddressesDetection
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            BlockingPolicyModelReputationIpDetection.DISABLE,
            ipAddressesDetection
        ));
    }

    public static BlockingPolicyModel ipAddressesDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressRestriction ipAddressRestriction,
        BlockingPolicyModelIpAddressesDetectionIsEnableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            BlockingPolicyModelIpAddressesDetection.ENABLE,
            new BlockingPolicyModelOptions()
                .withIpAddressRestriction(ipAddressRestriction)
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel ipAddressesDetectionIsEnable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressRestriction ipAddressRestriction
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            BlockingPolicyModelIpAddressesDetection.ENABLE
        ));
    }

    public static BlockingPolicyModel ipAddressesDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection,
        BlockingPolicyModelIpAddressesDetectionIsDisableOptions options
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            BlockingPolicyModelIpAddressesDetection.DISABLE,
            new BlockingPolicyModelOptions()
                .withIpAddresses(options.ipAddresses)
        ));
    }


    public static BlockingPolicyModel ipAddressesDetectionIsDisable(
        List<String> passServices,
        BlockingPolicyModelDefaultRestriction defaultRestriction,
        BlockingPolicyModelLocationDetection locationDetection,
        BlockingPolicyModelAnonymousIpDetection anonymousIpDetection,
        BlockingPolicyModelHostingProviderIpDetection hostingProviderIpDetection,
        BlockingPolicyModelReputationIpDetection reputationIpDetection
    ) {
        return (new BlockingPolicyModel(
            passServices,
            defaultRestriction,
            locationDetection,
            anonymousIpDetection,
            hostingProviderIpDetection,
            reputationIpDetection,
            BlockingPolicyModelIpAddressesDetection.DISABLE
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.passServices != null) {
            properties.put("passServices", this.passServices);
        }
        if (this.defaultRestriction != null) {
            properties.put("defaultRestriction", this.defaultRestriction.toString(
            ));
        }
        if (this.locationDetection != null) {
            properties.put("locationDetection", this.locationDetection.toString(
            ));
        }
        if (this.locations != null) {
            properties.put("locations", this.locations);
        }
        if (this.locationRestriction != null) {
            properties.put("locationRestriction", this.locationRestriction.toString(
            ));
        }
        if (this.anonymousIpDetection != null) {
            properties.put("anonymousIpDetection", this.anonymousIpDetection.toString(
            ));
        }
        if (this.anonymousIpRestriction != null) {
            properties.put("anonymousIpRestriction", this.anonymousIpRestriction.toString(
            ));
        }
        if (this.hostingProviderIpDetection != null) {
            properties.put("hostingProviderIpDetection", this.hostingProviderIpDetection.toString(
            ));
        }
        if (this.hostingProviderIpRestriction != null) {
            properties.put("hostingProviderIpRestriction", this.hostingProviderIpRestriction.toString(
            ));
        }
        if (this.reputationIpDetection != null) {
            properties.put("reputationIpDetection", this.reputationIpDetection.toString(
            ));
        }
        if (this.reputationIpRestriction != null) {
            properties.put("reputationIpRestriction", this.reputationIpRestriction.toString(
            ));
        }
        if (this.ipAddressesDetection != null) {
            properties.put("ipAddressesDetection", this.ipAddressesDetection.toString(
            ));
        }
        if (this.ipAddresses != null) {
            properties.put("ipAddresses", this.ipAddresses);
        }
        if (this.ipAddressRestriction != null) {
            properties.put("ipAddressRestriction", this.ipAddressRestriction.toString(
            ));
        }

        return properties;
    }
}
