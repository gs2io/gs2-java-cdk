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
package io.gs2.cdk.log.model;

import io.gs2.cdk.core.model.CdkResource;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.core.func.GetAttr;

import io.gs2.cdk.log.ref.NamespaceRef;
import io.gs2.cdk.log.model.enums.NamespaceType;

import io.gs2.cdk.log.model.options.NamespaceOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Namespace extends CdkResource {
    private Stack stack;
    private String name;
    private String description = null;
    private NamespaceType type = null;
    private String gcpCredentialJson = null;
    private String bigQueryDatasetName = null;
    private Integer logExpireDays = null;
    private String awsRegion = null;
    private String awsAccessKeyId = null;
    private String awsSecretAccessKey = null;
    private String firehoseStreamName = null;

    public Namespace(
        Stack stack,
        String name,
        NamespaceOptions options
    ) {
        super(
            "Log_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        this.description = options.description;
        this.type = options.type;
        this.gcpCredentialJson = options.gcpCredentialJson;
        this.bigQueryDatasetName = options.bigQueryDatasetName;
        this.logExpireDays = options.logExpireDays;
        this.awsRegion = options.awsRegion;
        this.awsAccessKeyId = options.awsAccessKeyId;
        this.awsSecretAccessKey = options.awsSecretAccessKey;
        this.firehoseStreamName = options.firehoseStreamName;
        stack.addResource(
            this
        );
    }

    public Namespace(
        Stack stack,
        String name
    ) {
        super(
            "Log_Namespace_" + name
        );

        this.stack = stack;
        this.name = name;
        stack.addResource(
            this
        );
    }


    public String alternateKeys(
    ) {
        return "name";
    }

    public String resourceType(
    ) {
        return "GS2::Log::Namespace";
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.type != null) {
            properties.put("Type", this.type);
        }
        if (this.gcpCredentialJson != null) {
            properties.put("GcpCredentialJson", this.gcpCredentialJson);
        }
        if (this.bigQueryDatasetName != null) {
            properties.put("BigQueryDatasetName", this.bigQueryDatasetName);
        }
        if (this.logExpireDays != null) {
            properties.put("LogExpireDays", this.logExpireDays);
        }
        if (this.awsRegion != null) {
            properties.put("AwsRegion", this.awsRegion);
        }
        if (this.awsAccessKeyId != null) {
            properties.put("AwsAccessKeyId", this.awsAccessKeyId);
        }
        if (this.awsSecretAccessKey != null) {
            properties.put("AwsSecretAccessKey", this.awsSecretAccessKey);
        }
        if (this.firehoseStreamName != null) {
            properties.put("FirehoseStreamName", this.firehoseStreamName);
        }

        return properties;
    }

    public NamespaceRef ref(
    ) {
        return (new NamespaceRef(
            this.name
        ));
    }

    public GetAttr getAttrNamespaceId(
    ) {
        return (new GetAttr(
            null,
            null,
            "Item.NamespaceId"
        ));
    }
}
