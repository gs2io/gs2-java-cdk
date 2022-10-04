package io.gs2.cdk.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stack {

    List<CdkResource> resources;
    Map<String, String> outputs;

    public Stack() {
        resources = new ArrayList<>();
        outputs = new HashMap<>();
    }

    public void addResource(
            CdkResource resource
    ) {
        resources.add(resource);
    }

    public void output(
            String name,
            String path
    ) {
        outputs.put(name, path);
    }

    public Map<String, Object> template() {
        var templateResources = new HashMap<String, Object>();
        for (var resource : resources) {
            templateResources.put(resource.resourceName, resource.template());
        }
        return new HashMap<>() {
            {
                put("GS2TemplateFormatVersion", "2019-05-01");
                put("Resources", templateResources);
                put("Outputs", outputs);
            }
        };
    }

    public String yaml() throws JsonProcessingException {
        var mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        return mapper.writeValueAsString(this.template()).replaceAll("\"!(.*) (.*)\"", "!$1 $2");
    }

}
