package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Record {
    STRIKE("%d 스트라이크", 2),
    BALL("%d 볼", 1),
    NOTHING("낫싱", 0);

    private final String record;
    private final int matchpoint;

    Record(String record, int matchpoint) {
        this.record = record;
        this.matchpoint = matchpoint;
    }

    public static Record findRecord(int matchPoint) {
        List<Record> result = new ArrayList<>();

        for (Record record : values()) {
            result.add(record.find(matchPoint));
        }
        Collections.sort(result);
        return result.get(0);
    }

    private Record find(int matchPoint) {
        if (this.matchpoint == matchPoint) {
            return this;
        }
        return NOTHING;
    }

    public String getRecordMessage() {
        return record;
    }
}
