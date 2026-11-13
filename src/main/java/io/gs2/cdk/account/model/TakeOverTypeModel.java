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
package io.gs2.cdk.account.model;
import io.gs2.cdk.account.model.ScopeValue;
import io.gs2.cdk.account.model.OpenIdConnectSetting;
import io.gs2.cdk.account.model.IssuedCodeSetting;
import io.gs2.cdk.account.model.options.TakeOverTypeModelOptions;
import io.gs2.cdk.account.model.options.TakeOverTypeModelTakeOverMethodIsOpenIdConnectOptions;
import io.gs2.cdk.account.model.options.TakeOverTypeModelTakeOverMethodIsIssuedCodeOptions;
import io.gs2.cdk.account.model.enums.TakeOverTypeModelTakeOverMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TakeOverTypeModel {
    private Integer type;
    private TakeOverTypeModelTakeOverMethod takeOverMethod;
    private String metadata = null;
    private OpenIdConnectSetting openIdConnectSetting = null;
    private IssuedCodeSetting issuedCodeSetting = null;

    public TakeOverTypeModel(
        Integer type,
        TakeOverTypeModelTakeOverMethod takeOverMethod,
        TakeOverTypeModelOptions options
    ) {
        this.type = type;
        this.takeOverMethod = takeOverMethod;
        this.metadata = options.metadata;
        this.openIdConnectSetting = options.openIdConnectSetting;
        this.issuedCodeSetting = options.issuedCodeSetting;
    }
    public TakeOverTypeModel(
        Integer type,
        TakeOverTypeModelTakeOverMethod takeOverMethod
    ) {
        this.type = type;
        this.takeOverMethod = takeOverMethod;
    }

    public static TakeOverTypeModel takeOverMethodIsOpenIdConnect(
        Integer type,
        OpenIdConnectSetting openIdConnectSetting,
        TakeOverTypeModelTakeOverMethodIsOpenIdConnectOptions options
    ) {
        return (new TakeOverTypeModel(
            type,
            TakeOverTypeModelTakeOverMethod.OPEN_ID_CONNECT,
            new TakeOverTypeModelOptions()
                .withOpenIdConnectSetting(openIdConnectSetting)
                .withMetadata(options.metadata)
        ));
    }


    public static TakeOverTypeModel takeOverMethodIsOpenIdConnect(
        Integer type,
        OpenIdConnectSetting openIdConnectSetting
    ) {
        return (new TakeOverTypeModel(
            type,
            TakeOverTypeModelTakeOverMethod.OPEN_ID_CONNECT
        ));
    }

    public static TakeOverTypeModel takeOverMethodIsIssuedCode(
        Integer type,
        IssuedCodeSetting issuedCodeSetting,
        TakeOverTypeModelTakeOverMethodIsIssuedCodeOptions options
    ) {
        return (new TakeOverTypeModel(
            type,
            TakeOverTypeModelTakeOverMethod.ISSUED_CODE,
            new TakeOverTypeModelOptions()
                .withIssuedCodeSetting(issuedCodeSetting)
                .withMetadata(options.metadata)
        ));
    }


    public static TakeOverTypeModel takeOverMethodIsIssuedCode(
        Integer type,
        IssuedCodeSetting issuedCodeSetting
    ) {
        return (new TakeOverTypeModel(
            type,
            TakeOverTypeModelTakeOverMethod.ISSUED_CODE
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.type != null) {
            properties.put("type", this.type);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.takeOverMethod != null) {
            properties.put("takeOverMethod", this.takeOverMethod.toString(
            ));
        }
        if (this.openIdConnectSetting != null) {
            properties.put("openIdConnectSetting", this.openIdConnectSetting.properties(
            ));
        }
        if (this.issuedCodeSetting != null) {
            properties.put("issuedCodeSetting", this.issuedCodeSetting.properties(
            ));
        }

        return properties;
    }
}
