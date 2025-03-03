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

package io.gs2.cdk.money2.model.enums;


public enum SubscribeTransactionStatusDetail {
    ACTIVE_ACTIVE,
    ACTIVE_CONVERTED_FROM_TRIAL,
    ACTIVE_IN_TRIAL,
    ACTIVE_IN_INTRO_OFFER,
    GRACE_CANCELED,
    GRACE_GRACE_PERIOD,
    GRACE_ON_HOLD,
    INACTIVE_EXPIRED,
    INACTIVE_REVOKED;

    public String toString() {
        switch (this) {
            case ACTIVE_ACTIVE:
                return "active@active";
            case ACTIVE_CONVERTED_FROM_TRIAL:
                return "active@converted_from_trial";
            case ACTIVE_IN_TRIAL:
                return "active@in_trial";
            case ACTIVE_IN_INTRO_OFFER:
                return "active@in_intro_offer";
            case GRACE_CANCELED:
                return "grace@canceled";
            case GRACE_GRACE_PERIOD:
                return "grace@grace_period";
            case GRACE_ON_HOLD:
                return "grace@on_hold";
            case INACTIVE_EXPIRED:
                return "inactive@expired";
            case INACTIVE_REVOKED:
                return "inactive@revoked";
        }
        return "unknown";
    }
}
