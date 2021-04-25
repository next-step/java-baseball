package baseball;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class BaseballResults {
    private Map<Pitching, Integer> result;

    public BaseballResults() {
        this.result = new EnumMap<>(Pitching.class);
    }

    public void addResult(Pitching pitching) {
        result.put(pitching, result.getOrDefault(pitching, 0) + 1);
    }

    public Integer getCount(Pitching pitching) {
        return result.getOrDefault(pitching, 0);
    }

    public boolean isAnswer() {
        return getCount(Pitching.STRIKE) == BaseballConstants.BASEBALL_NUMBER_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pitching pitching : Pitching.values()) {
            sb.append(getStringBy(pitching));
        }
        return sb.toString().trim();
    }

    private String getStringBy(Pitching pitching) {
        Integer count = result.get(pitching);

        if (Objects.isNull(count)) {
            return "";
        }

        return String.format("%d%s ", count, pitching.toString());
    }
}
