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


public enum BuffTargetModelTargetModelName {
    GS2_EXCHANGE_INCREMENTAL_RATE_MODEL,
    GS2_EXCHANGE_RATE_MODEL,
    GS2_EXPERIENCE_EXPERIENCE_MODEL,
    GS2_EXPERIENCE_STATUS,
    GS2_FORMATION_MOLD,
    GS2_IDLE_CATEGORY_MODEL,
    GS2_IDLE_STATUS,
    GS2_INVENTORY_BIG_INVENTORY_MODEL,
    GS2_INVENTORY_BIG_ITEM_MODEL,
    GS2_INVENTORY_INVENTORY,
    GS2_INVENTORY_INVENTORY_MODEL,
    GS2_INVENTORY_ITEM_MODEL,
    GS2_INVENTORY_SIMPLE_INVENTORY_MODEL,
    GS2_INVENTORY_SIMPLE_ITEM_MODEL,
    GS2_LIMIT_COUNTER,
    GS2_LIMIT_LIMIT_MODEL,
    GS2_LOGIN_REWARD_BONUS_MODEL,
    GS2_MISSION_MISSION_TASK_MODEL,
    GS2_MONEY2_WALLET,
    GS2_MONEY_WALLET,
    GS2_QUEST_QUEST_MODEL,
    GS2_SHOWCASE_DISPLAY_ITEM,
    GS2_SHOWCASE_RANDOM_DISPLAY_ITEM_MODEL,
    GS2_SKILL_TREE_NODE_MODEL,
    GS2_STAMINA_STAMINA,
    GS2_STAMINA_STAMINA_MODEL;

    public String toString() {
        switch (this) {
            case GS2_EXCHANGE_INCREMENTAL_RATE_MODEL:
                return "Gs2Exchange:IncrementalRateModel";
            case GS2_EXCHANGE_RATE_MODEL:
                return "Gs2Exchange:RateModel";
            case GS2_EXPERIENCE_EXPERIENCE_MODEL:
                return "Gs2Experience:ExperienceModel";
            case GS2_EXPERIENCE_STATUS:
                return "Gs2Experience:Status";
            case GS2_FORMATION_MOLD:
                return "Gs2Formation:Mold";
            case GS2_IDLE_CATEGORY_MODEL:
                return "Gs2Idle:CategoryModel";
            case GS2_IDLE_STATUS:
                return "Gs2Idle:Status";
            case GS2_INVENTORY_BIG_INVENTORY_MODEL:
                return "Gs2Inventory:BigInventoryModel";
            case GS2_INVENTORY_BIG_ITEM_MODEL:
                return "Gs2Inventory:BigItemModel";
            case GS2_INVENTORY_INVENTORY:
                return "Gs2Inventory:Inventory";
            case GS2_INVENTORY_INVENTORY_MODEL:
                return "Gs2Inventory:InventoryModel";
            case GS2_INVENTORY_ITEM_MODEL:
                return "Gs2Inventory:ItemModel";
            case GS2_INVENTORY_SIMPLE_INVENTORY_MODEL:
                return "Gs2Inventory:SimpleInventoryModel";
            case GS2_INVENTORY_SIMPLE_ITEM_MODEL:
                return "Gs2Inventory:SimpleItemModel";
            case GS2_LIMIT_COUNTER:
                return "Gs2Limit:Counter";
            case GS2_LIMIT_LIMIT_MODEL:
                return "Gs2Limit:LimitModel";
            case GS2_LOGIN_REWARD_BONUS_MODEL:
                return "Gs2LoginReward:BonusModel";
            case GS2_MISSION_MISSION_TASK_MODEL:
                return "Gs2Mission:MissionTaskModel";
            case GS2_MONEY2_WALLET:
                return "Gs2Money2:Wallet";
            case GS2_MONEY_WALLET:
                return "Gs2Money:Wallet";
            case GS2_QUEST_QUEST_MODEL:
                return "Gs2Quest:QuestModel";
            case GS2_SHOWCASE_DISPLAY_ITEM:
                return "Gs2Showcase:DisplayItem";
            case GS2_SHOWCASE_RANDOM_DISPLAY_ITEM_MODEL:
                return "Gs2Showcase:RandomDisplayItemModel";
            case GS2_SKILL_TREE_NODE_MODEL:
                return "Gs2SkillTree:NodeModel";
            case GS2_STAMINA_STAMINA:
                return "Gs2Stamina:Stamina";
            case GS2_STAMINA_STAMINA_MODEL:
                return "Gs2Stamina:StaminaModel";
        }
        return "unknown";
    }
}
