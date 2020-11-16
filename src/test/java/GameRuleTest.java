import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRuleTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void reservedKeyWordTests(String anserKeyword) {
        GameRule rule = new GameRule();
        rule.initAnswer();

        List<String> reservedNumberSet = rule.getReservedNumberSet();

        assertThat(reservedNumberSet.contains(anserKeyword)).isEqualTo(true);
    }
}