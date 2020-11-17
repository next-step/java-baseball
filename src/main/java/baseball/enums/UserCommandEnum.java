package baseball.enums;

public enum UserCommandEnum {

    COMMAND_RESTART("1"),
    COMMAND_END("2")
    ;

    private final String value;

    UserCommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(String value) {
        return getValue().equals(value);
    }

    public static boolean contains(String value) {
        boolean isContain = false;
        for (UserCommandEnum userCommandEnum : UserCommandEnum.values()) {
            isContain|=userCommandEnum.equals(value);
        }
        return isContain;
    }
}
