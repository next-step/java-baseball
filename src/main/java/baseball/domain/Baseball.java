package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    private static final int BASEBALL_SIZE = 3;

    private final List<BaseballNo> baseball;


    private Baseball(List<BaseballNo> baseball) {
        if(baseball.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException();
        }
        this.baseball = baseball;
    }

    public static Baseball of(List<Integer> numbers) {
        List<BaseballNo> baseball = new ArrayList<>();
        for (Integer number : numbers) {
            baseball.add(BaseballNo.of(number));
        }
        return new Baseball(baseball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball1 = (Baseball) o;
        return Objects.equals(baseball, baseball1.baseball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseball);
    }

    @Override
    public String toString() {
        return "Baseball{" +
                "baseball=" + baseball +
                '}';
    }
}
