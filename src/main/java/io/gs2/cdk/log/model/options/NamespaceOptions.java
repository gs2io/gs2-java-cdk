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
package io.gs2.cdk.log.model.options;

import io.gs2.cdk.log.model.enums.NamespaceType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class NamespaceOptions {
    public String description;
    public NamespaceType type;
    public String gcpCredentialJson;
    public String bigQueryDatasetName;
    public Integer logExpireDays;
    public String awsRegion;
    public String awsAccessKeyId;
    public String awsSecretAccessKey;
    public String firehoseStreamName;
    
    public NamespaceOptions withDescription(
        String description
    ) {
        this.description = description;
        return this;
    }
    
    public NamespaceOptions withType(
        NamespaceType type
    ) {
        this.type = type;
        return this;
    }
    
    public NamespaceOptions withGcpCredentialJson(
        String gcpCredentialJson
    ) {
        this.gcpCredentialJson = gcpCredentialJson;
        return this;
    }
    
    public NamespaceOptions withBigQueryDatasetName(
        String bigQueryDatasetName
    ) {
        this.bigQueryDatasetName = bigQueryDatasetName;
        return this;
    }
    
    public NamespaceOptions withLogExpireDays(
        Integer logExpireDays
    ) {
        this.logExpireDays = logExpireDays;
        return this;
    }
    
    public NamespaceOptions withAwsRegion(
        String awsRegion
    ) {
        this.awsRegion = awsRegion;
        return this;
    }
    
    public NamespaceOptions withAwsAccessKeyId(
        String awsAccessKeyId
    ) {
        this.awsAccessKeyId = awsAccessKeyId;
        return this;
    }
    
    public NamespaceOptions withAwsSecretAccessKey(
        String awsSecretAccessKey
    ) {
        this.awsSecretAccessKey = awsSecretAccessKey;
        return this;
    }
    
    public NamespaceOptions withFirehoseStreamName(
        String firehoseStreamName
    ) {
        this.firehoseStreamName = firehoseStreamName;
        return this;
    }
}
