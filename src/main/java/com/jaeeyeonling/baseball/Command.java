package com.jaeeyeonling.baseball;

public enum Command {

    START(1),
    END(2);

    private final int value;

    Command(final int value) {
        this.value = value;
    }

    public static boolean isStart(final int rawCommand) {
        return START.value == rawCommand;
    }

    public static boolean isEnd(final int rawCommand) {
        return END.value == rawCommand;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
