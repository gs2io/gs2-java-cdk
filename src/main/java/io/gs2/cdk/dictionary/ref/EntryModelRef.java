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
package io.gs2.cdk.dictionary.ref;

import io.gs2.cdk.core.func.GetAttr;
import io.gs2.cdk.core.func.Join;
import io.gs2.cdk.dictionary.stampSheet.AddEntriesByUserId;
import io.gs2.cdk.dictionary.stampSheet.DeleteEntriesByUserId;
import io.gs2.cdk.dictionary.stampSheet.VerifyEntryByUserId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntryModelRef {
    private String namespaceName;
    private String entryModelName;

    public EntryModelRef(
        String namespaceName,
        String entryModelName
    ) {
        this.namespaceName = namespaceName;
        this.entryModelName = entryModelName;
    }

    public AddEntriesByUserId addEntries(
        List<String> entryModelNames,
        String userId
    ) {
        return (new AddEntriesByUserId(
            this.namespaceName,
            entryModelNames,
            userId
        ));
    }


    public AddEntriesByUserId addEntries(
        List<String> entryModelNames
    ) {
        return (new AddEntriesByUserId(
            this.namespaceName,
            entryModelNames,
            "#{userId}"
        ));
    }

    public DeleteEntriesByUserId deleteEntries(
        List<String> entryModelNames,
        String userId
    ) {
        return (new DeleteEntriesByUserId(
            this.namespaceName,
            entryModelNames,
            userId
        ));
    }


    public DeleteEntriesByUserId deleteEntries(
        List<String> entryModelNames
    ) {
        return (new DeleteEntriesByUserId(
            this.namespaceName,
            entryModelNames,
            "#{userId}"
        ));
    }

    public VerifyEntryByUserId verifyEntry(
        String verifyType,
        String userId
    ) {
        return (new VerifyEntryByUserId(
            this.namespaceName,
            this.entryModelName,
            verifyType,
            userId
        ));
    }


    public VerifyEntryByUserId verifyEntry(
        String verifyType
    ) {
        return (new VerifyEntryByUserId(
            this.namespaceName,
            this.entryModelName,
            verifyType,
            "#{userId}"
        ));
    }

    public String grn(
    ) {
        return (new Join(
            ":",
            Arrays.asList(
                "grn",
                "gs2",
                GetAttr.region(
                ).str(
                ),
                GetAttr.ownerId(
                ).str(
                ),
                "dictionary",
                this.namespaceName,
                "model",
                this.entryModelName
            )
        )).str(
        );
    }
}
