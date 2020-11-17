package org.dhlee.game.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProgressType {
    START(1),
    EXIT(2);

    private final int code;

    private static final Map<Integer, ProgressType> hashCodeMap = new HashMap<>();

    ProgressType(int code) {
        this.code = code;
    }

    static {
        for(ProgressType progressType: values()) {
            hashCodeMap.put(progressType.code, progressType);
        }
    }

    public static ProgressType getByCode(int code) {
        return hashCodeMap.get(code);
    }
}
