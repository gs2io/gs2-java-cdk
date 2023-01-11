package io.gs2.cdk.core.func;

import io.gs2.cdk.core.model.*;

public class GetAttr implements Func {

    String key;

    public GetAttr(
            CdkResource resource,
            String path,
            String key
    ) {
        if (key != null) {
            this.key = key;
        } else {
            this.key = resource.resourceName + "." + path;
        }
    }

    public String str() {
        return "!GetAttr " + this.key;
    }

    public static GetAttr region() {
        return new GetAttr(
                null,
                null,
                "Gs2::Region"
        );
    }

    public static GetAttr ownerId() {
        return new GetAttr(
                null,
                null,
                "Gs2::OwnerId"
        );
    }
}
