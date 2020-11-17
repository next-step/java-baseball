package baseball.enums;

import java.util.HashSet;
import java.util.Set;

/**
 * 야구 게임 어플리케이션 종료 옵션들을 의미한다.
 *
 * @author  Yonggu Han
 */
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
