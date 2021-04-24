package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum ProgressType {
    PLAY(1, true),
    STOP(2, false);

    private final int key;
    private final boolean progress;

    private static Map<Integer, ProgressType> progressMap = new HashMap<>();

    static {
        for (ProgressType progressType : ProgressType.values()) {
            progressMap.put(progressType.key, progressType);
        }
    }

    ProgressType(int key, boolean progress) {
        this.key = key;
        this.progress = progress;
    }

    public static ProgressType of(int key) {
        return Optional.ofNullable(progressMap.get(key))
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 입력값입니다."));
    }

    public boolean progress() {
        return this.progress;
    }
}
