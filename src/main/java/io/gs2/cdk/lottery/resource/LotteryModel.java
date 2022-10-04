/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.lottery.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.lottery.ref.*;
import io.gs2.cdk.lottery.model.*;

import java.util.*;
import java.util.stream.*;

public class LotteryModel {

    public enum Mode {
        NORMAL,
        BOX;

        public String toString() {
            switch (this) {
                case NORMAL:
                    return "normal";
                case BOX:
                    return "box";
            }
            return "unknown";
        }
    }

    public enum Method {
        PRIZE_TABLE,
        SCRIPT;

        public String toString() {
            switch (this) {
                case PRIZE_TABLE:
                    return "prize_table";
                case SCRIPT:
                    return "script";
            }
            return "unknown";
        }
    }
	public String name;
	public String metadata;
	public Mode mode;
	public Method method;
	public String prizeTableName;
	public String choicePrizeTableScriptId;

    public LotteryModel(
            String name,
            Mode mode,
            Method method
    ) {
        this.name = name;
        this.mode = mode;
        this.method = method;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.metadata != null) {
            properties.put("Metadata", this.metadata);
        }
        if (this.mode != null) {
            properties.put("Mode", this.mode.toString());
        }
        if (this.method != null) {
            properties.put("Method", this.method.toString());
        }
        if (this.prizeTableName != null) {
            properties.put("PrizeTableName", this.prizeTableName);
        }
        if (this.choicePrizeTableScriptId != null) {
            properties.put("ChoicePrizeTableScriptId", this.choicePrizeTableScriptId);
        }
        return properties;
    }

    public LotteryModelRef ref(
            String namespaceName
    ) {
        return new LotteryModelRef(
            namespaceName,
            this.name
        );
    }
}
