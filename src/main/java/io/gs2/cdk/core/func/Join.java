package io.gs2.cdk.core.func;

import java.util.List;

public class Join implements Func {

    String separator;
    List<String> values;

    public Join(
            String separator,
            List<String> values
    ) {
        this.separator = separator;
        this.values = values;
    }

    public String str() {
        return "!Join ['" + this.separator + "', [" + String.join(",", this.values) + "]]";
    }

}
