package baseball.enums;

import java.util.HashSet;
import java.util.Set;

public enum ApplicationOption {
    RESTART("1"),
    END("2");

    String value;

    ApplicationOption(String value) {
        this.value = value;
    }

    public static boolean containsValue(String value) {
        Set<String> valueSet = new HashSet<>();
        for (ApplicationOption option : values()) {
            valueSet.add(option.value);
        }
        return valueSet.contains(value);
    }

    public String getValue() {
        return value;
    }
}
