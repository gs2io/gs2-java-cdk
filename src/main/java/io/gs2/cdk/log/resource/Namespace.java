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

package io.gs2.cdk.log.resource;

import io.gs2.cdk.core.func.*;
import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.log.ref.*;
import io.gs2.cdk.log.model.*;

import java.util.*;
import java.util.stream.*;


public class Namespace extends CdkResource {

    public Stack stack;
    public String ownerId;
    public String name;
    public String description;
    public String type;
    public String gcpCredentialJson;
    public String bigQueryDatasetName;
    public Integer logExpireDays;
    public String awsRegion;
    public String awsAccessKeyId;
    public String awsSecretAccessKey;
    public String firehoseStreamName;

    public Namespace(
            Stack stack,
            String name,
            String type,
            String gcpCredentialJson,
            String bigQueryDatasetName,
            Integer logExpireDays,
            String awsRegion,
            String awsAccessKeyId,
            String awsSecretAccessKey,
            String firehoseStreamName
    ) {
        super("Log_Namespace_" + name);

        this.stack = stack;
        this.name = name;
        this.type = type;
        this.gcpCredentialJson = gcpCredentialJson;
        this.bigQueryDatasetName = bigQueryDatasetName;
        this.logExpireDays = logExpireDays;
        this.awsRegion = awsRegion;
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretAccessKey = awsSecretAccessKey;
        this.firehoseStreamName = firehoseStreamName;

        stack.addResource(this);
    }

    public String resourceType() {
        return "GS2::Log::Namespace";
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.name != null) {
            properties.put("Name", this.name);
        }
        if (this.description != null) {
            properties.put("Description", this.description);
        }
        if (this.type != null) {
            properties.put("Type", this.type.toString());
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
        return new NamespaceRef(
            this.name
        );
    }

    public GetAttr getAttrNamespaceId() {
        return new GetAttr(
            "Item.NamespaceId"
        );
    }
}
