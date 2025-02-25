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

package io.gs2.cdk.buff.model.enums;


public enum BuffTargetActionTargetActionName {
    GS2_EXPERIENCE_ADD_EXPERIENCE_BY_USER_ID,
    GS2_EXPERIENCE_SUB_EXPERIENCE,
    GS2_EXPERIENCE_SUB_EXPERIENCE_BY_USER_ID,
    GS2_INVENTORY_ACQUIRE_BIG_ITEM_BY_USER_ID,
    GS2_INVENTORY_ACQUIRE_ITEM_SET_BY_USER_ID,
    GS2_INVENTORY_ACQUIRE_SIMPLE_ITEMS_BY_USER_ID,
    GS2_INVENTORY_CONSUME_BIG_ITEM,
    GS2_INVENTORY_CONSUME_BIG_ITEM_BY_USER_ID,
    GS2_INVENTORY_CONSUME_ITEM_SET,
    GS2_INVENTORY_CONSUME_ITEM_SET_BY_USER_ID,
    GS2_INVENTORY_CONSUME_SIMPLE_ITEMS,
    GS2_INVENTORY_CONSUME_SIMPLE_ITEMS_BY_USER_ID,
    GS2_LIMIT_COUNT_UP,
    GS2_LIMIT_COUNT_UP_BY_USER_ID,
    GS2_MONEY2_DEPOSIT_BY_USER_ID,
    GS2_MONEY2_WITHDRAW,
    GS2_MONEY2_WITHDRAW_BY_USER_ID,
    GS2_MONEY_DEPOSIT_BY_USER_ID,
    GS2_MONEY_WITHDRAW,
    GS2_MONEY_WITHDRAW_BY_USER_ID,
    GS2_STAMINA_CONSUME_STAMINA,
    GS2_STAMINA_CONSUME_STAMINA_BY_USER_ID,
    GS2_STAMINA_RECOVER_STAMINA_BY_USER_ID;

    public String toString() {
        switch (this) {
            case GS2_EXPERIENCE_ADD_EXPERIENCE_BY_USER_ID:
                return "Gs2Experience:AddExperienceByUserId";
            case GS2_EXPERIENCE_SUB_EXPERIENCE:
                return "Gs2Experience:SubExperience";
            case GS2_EXPERIENCE_SUB_EXPERIENCE_BY_USER_ID:
                return "Gs2Experience:SubExperienceByUserId";
            case GS2_INVENTORY_ACQUIRE_BIG_ITEM_BY_USER_ID:
                return "Gs2Inventory:AcquireBigItemByUserId";
            case GS2_INVENTORY_ACQUIRE_ITEM_SET_BY_USER_ID:
                return "Gs2Inventory:AcquireItemSetByUserId";
            case GS2_INVENTORY_ACQUIRE_SIMPLE_ITEMS_BY_USER_ID:
                return "Gs2Inventory:AcquireSimpleItemsByUserId";
            case GS2_INVENTORY_CONSUME_BIG_ITEM:
                return "Gs2Inventory:ConsumeBigItem";
            case GS2_INVENTORY_CONSUME_BIG_ITEM_BY_USER_ID:
                return "Gs2Inventory:ConsumeBigItemByUserId";
            case GS2_INVENTORY_CONSUME_ITEM_SET:
                return "Gs2Inventory:ConsumeItemSet";
            case GS2_INVENTORY_CONSUME_ITEM_SET_BY_USER_ID:
                return "Gs2Inventory:ConsumeItemSetByUserId";
            case GS2_INVENTORY_CONSUME_SIMPLE_ITEMS:
                return "Gs2Inventory:ConsumeSimpleItems";
            case GS2_INVENTORY_CONSUME_SIMPLE_ITEMS_BY_USER_ID:
                return "Gs2Inventory:ConsumeSimpleItemsByUserId";
            case GS2_LIMIT_COUNT_UP:
                return "Gs2Limit:CountUp";
            case GS2_LIMIT_COUNT_UP_BY_USER_ID:
                return "Gs2Limit:CountUpByUserId";
            case GS2_MONEY2_DEPOSIT_BY_USER_ID:
                return "Gs2Money2:DepositByUserId";
            case GS2_MONEY2_WITHDRAW:
                return "Gs2Money2:Withdraw";
            case GS2_MONEY2_WITHDRAW_BY_USER_ID:
                return "Gs2Money2:WithdrawByUserId";
            case GS2_MONEY_DEPOSIT_BY_USER_ID:
                return "Gs2Money:DepositByUserId";
            case GS2_MONEY_WITHDRAW:
                return "Gs2Money:Withdraw";
            case GS2_MONEY_WITHDRAW_BY_USER_ID:
                return "Gs2Money:WithdrawByUserId";
            case GS2_STAMINA_CONSUME_STAMINA:
                return "Gs2Stamina:ConsumeStamina";
            case GS2_STAMINA_CONSUME_STAMINA_BY_USER_ID:
                return "Gs2Stamina:ConsumeStaminaByUserId";
            case GS2_STAMINA_RECOVER_STAMINA_BY_USER_ID:
                return "Gs2Stamina:RecoverStaminaByUserId";
        }
        return "unknown";
    }
}
