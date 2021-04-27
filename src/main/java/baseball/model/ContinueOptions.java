package baseball.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum ContinueOptions {

    CONTINUE("1"),
    STOP("2"),
    UNKNOW(null);

    private String option;

    private ContinueOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }

    private static Map<String, ContinueOptions> cache;
    static {
        cache = new HashMap<>();

        for (ContinueOptions optionEnum : ContinueOptions.values()) {
            cache.put(optionEnum.getOption(), optionEnum);
        }
    }

    /**
     * option 스트링 값으로 이늄값 조회.
     * @param option option 스트링 값.
     * @return ContinueOptions 이늄.
     */
    public static ContinueOptions getOptionEnum(String option) {
        return Optional.ofNullable(cache.get(option)).orElse(UNKNOW);
    }
}
