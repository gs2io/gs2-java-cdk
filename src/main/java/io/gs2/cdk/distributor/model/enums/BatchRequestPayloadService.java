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

package io.gs2.cdk.distributor.model.enums;


public enum BatchRequestPayloadService {
    ACCOUNT,
    AD_REWARD,
    AUTH,
    BUFF,
    CHAT,
    DATASTORE,
    DEPLOY,
    DICTIONARY,
    DISTRIBUTOR,
    ENCHANT,
    ENHANCE,
    EXCHANGE,
    EXPERIENCE,
    FORMATION,
    FRIEND,
    GATEWAY,
    GRADE,
    GUARD,
    GUILD,
    IDENTIFIER,
    IDLE,
    INBOX,
    INVENTORY,
    JOB_QUEUE,
    KEY,
    LIMIT,
    LOCK,
    LOG,
    LOGIN_REWARD,
    LOTTERY,
    MATCHMAKING,
    MEGA_FIELD,
    MISSION,
    MONEY,
    MONEY2,
    NEWS,
    QUEST,
    RANKING,
    RANKING2,
    REALTIME,
    SCHEDULE,
    SCRIPT,
    SEASON_RATING,
    SERIAL_KEY,
    SHOWCASE,
    SKILL_TREE,
    STAMINA,
    STATE_MACHINE,
    VERSION;

    public String toString() {
        switch (this) {
            case ACCOUNT:
                return "account";
            case AD_REWARD:
                return "adReward";
            case AUTH:
                return "auth";
            case BUFF:
                return "buff";
            case CHAT:
                return "chat";
            case DATASTORE:
                return "datastore";
            case DEPLOY:
                return "deploy";
            case DICTIONARY:
                return "dictionary";
            case DISTRIBUTOR:
                return "distributor";
            case ENCHANT:
                return "enchant";
            case ENHANCE:
                return "enhance";
            case EXCHANGE:
                return "exchange";
            case EXPERIENCE:
                return "experience";
            case FORMATION:
                return "formation";
            case FRIEND:
                return "friend";
            case GATEWAY:
                return "gateway";
            case GRADE:
                return "grade";
            case GUARD:
                return "guard";
            case GUILD:
                return "guild";
            case IDENTIFIER:
                return "identifier";
            case IDLE:
                return "idle";
            case INBOX:
                return "inbox";
            case INVENTORY:
                return "inventory";
            case JOB_QUEUE:
                return "jobQueue";
            case KEY:
                return "key";
            case LIMIT:
                return "limit";
            case LOCK:
                return "lock";
            case LOG:
                return "log";
            case LOGIN_REWARD:
                return "loginReward";
            case LOTTERY:
                return "lottery";
            case MATCHMAKING:
                return "matchmaking";
            case MEGA_FIELD:
                return "megaField";
            case MISSION:
                return "mission";
            case MONEY:
                return "money";
            case MONEY2:
                return "money2";
            case NEWS:
                return "news";
            case QUEST:
                return "quest";
            case RANKING:
                return "ranking";
            case RANKING2:
                return "ranking2";
            case REALTIME:
                return "realtime";
            case SCHEDULE:
                return "schedule";
            case SCRIPT:
                return "script";
            case SEASON_RATING:
                return "seasonRating";
            case SERIAL_KEY:
                return "serialKey";
            case SHOWCASE:
                return "showcase";
            case SKILL_TREE:
                return "skillTree";
            case STAMINA:
                return "stamina";
            case STATE_MACHINE:
                return "stateMachine";
            case VERSION:
                return "version";
        }
        return "unknown";
    }
}
