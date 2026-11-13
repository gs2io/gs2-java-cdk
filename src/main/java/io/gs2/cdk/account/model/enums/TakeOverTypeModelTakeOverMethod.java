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

package io.gs2.cdk.account.model.enums;


public enum TakeOverTypeModelTakeOverMethod {
    OPEN_ID_CONNECT,
    ISSUED_CODE;

    public String toString() {
        switch (this) {
            case OPEN_ID_CONNECT:
                return "openIdConnect";
            case ISSUED_CODE:
                return "issuedCode";
        }
        return "unknown";
    }
}
