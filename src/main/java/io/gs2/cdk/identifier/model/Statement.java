package io.gs2.cdk.identifier.model;

import java.util.*;

public class Statement {

    String effect;
    List<String> actions;

    public static Statement allow(
            List<String> actions
    ) {
        var statement = new Statement();
        statement.effect = "Allow";
        statement.actions = actions;
        return statement;
    }

    public static Statement allowAll() {
        var statement = new Statement();
        statement.effect = "Allow";
        statement.actions = List.of("*");
        return statement;
    }

    public static Statement deny(
            List<String> actions
    ) {
        var statement = new Statement();
        statement.effect = "Deny";
        statement.actions = actions;
        return statement;
    }

    public static Statement denyAll() {
        var statement = new Statement();
        statement.effect = "Deny";
        statement.actions = List.of("*");
        return statement;
    }

    public Statement action(String action) {
        this.actions.add(action);
        return this;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("Effect", effect);
                put("Actions", actions);
                put("Resources", List.of("*"));
            }
        };
    }
}
