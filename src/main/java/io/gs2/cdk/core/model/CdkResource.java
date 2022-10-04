package io.gs2.cdk.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class CdkResource {

    public String resourceName;
    List<String> dependsOn;

    public CdkResource(
            String resourceName
    ) {
        this.resourceName = resourceName;
        this.dependsOn = new ArrayList<>();
    }

    public CdkResource addDependsOn(
            CdkResource resource
    ) {
        this.dependsOn.add(resource.resourceName);
        return this;
    }

    abstract public String resourceType();
    abstract public Map<String, Object> properties();

    public Map<String, Object> template() {
        return new HashMap<>() {
            {
                put("Type", resourceType());
                put("Properties", properties());
                put("DependsOn", dependsOn);
            }
        };
    }
}
