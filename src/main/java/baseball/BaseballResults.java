package baseball;

import java.util.EnumMap;
import java.util.Map;

public class BaseballResults {
    private Map<Pitching, Integer> result;

    public BaseballResults() {
        this.result = new EnumMap<>(Pitching.class);
    }

    public void addResult(Pitching pitching) {
        result.put(pitching, result.getOrDefault(pitching, 0) + 1);
    }

    public boolean isAnswer() {
        return getCount(Pitching.STRIKE) == BaseballConstants.BASEBALL_NUMBER_SIZE;
    }

    public Integer getCount(Pitching pitching) {
        return result.getOrDefault(pitching, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isAllNothing()) {
            return sb.append(Pitching.NOTHING).toString();
        }

        for (Pitching pitching : Pitching.values()) {
            sb.append(getStringBy(pitching));
        }
        return sb.toString().trim();
    }

    private boolean isAllNothing() {
        return result.getOrDefault(Pitching.NOTHING, 0) == BaseballConstants.BASEBALL_NUMBER_SIZE
                ? true : false;
    }

    private String getStringBy(Pitching pitching) {
        if (pitching.equals(Pitching.NOTHING)) {
            return "";
        }

        Integer count = result.getOrDefault(pitching, 0);
        if (count == 0) {
            return "";
        }

        return String.format("%d%s ", count, pitching);
    }
}
