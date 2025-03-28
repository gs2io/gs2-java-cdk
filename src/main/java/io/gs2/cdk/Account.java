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
package io.gs2.cdk;
import io.gs2.cdk.account.ref.NamespaceRef;
import io.gs2.cdk.account.ref.BanStatusRef;

public class Account {

    public static NamespaceRef namespace(
        String namespaceName
    ) {
        return (new NamespaceRef(
            namespaceName
        ));
    }

    public static BanStatusRef banStatus(
        String name
    ) {
        return (new BanStatusRef(
            name
        ));
    }
}