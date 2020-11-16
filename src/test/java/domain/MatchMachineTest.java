package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class MatchMachineTest {
    private MatchMachine matchMachine;

    @BeforeEach
    void setup() {
        Set<BaseballNumber> computerNumbers = new LinkedHashSet<>();
        computerNumbers.add(new BaseballNumber(new Order(0), 4));
        computerNumbers.add(new BaseballNumber(new Order(1), 9));
        computerNumbers.add(new BaseballNumber(new Order(2), 1));
        matchMachine = new MatchMachine(computerNumbers);
    }

    @DisplayName("서로 다른 3자리 수를 비교하여 예상한 결과값이 나오는지 확인.")
    @Test
    void compare() {
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(4, 0);
        numbers.put(3, 1);
        numbers.put(9, 2);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);

        ResultGame resultGame = matchMachine.compare(baseballNumbers);

        assertThat(resultGame.count(Score.STRIKE)).isEqualTo(1);
        assertThat(resultGame.count(Score.BALL)).isEqualTo(1);
        assertThat(resultGame.count(Score.NOTHING)).isEqualTo(1);
    }
}
