package io.gs2.cdk.identifier.model;

import java.util.*;
import java.util.stream.Collectors;

public class Policy {

    String version = "2016-04-01";
    List<Statement> statements;

    public  Policy(
            List<Statement> statements
    ) {
        this.statements = statements;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("Version", version);
                put("Statements", statements.stream().map(Statement::properties).collect(Collectors.toList()));
            }
        };
    }

}
