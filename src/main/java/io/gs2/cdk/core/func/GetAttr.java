package io.gs2.cdk.core.func;

import io.gs2.cdk.core.model.*;

public class GetAttr implements Func {

    String key;

    public GetAttr(
            CdkResource resource,
            String path
    ) {
        this.key = resource.resourceName + "." + path;
    }

    public GetAttr(
            String key
    ) {
        this.key = key;
    }

    public String str() {
        return "!GetAttr " + this.key;
    }

    public static GetAttr region() {
        return new GetAttr(
                "Gs2::Region"
        );
    }

    public static GetAttr ownerId() {
        return new GetAttr(
                "Gs2::OwnerId"
        );
    }
}
