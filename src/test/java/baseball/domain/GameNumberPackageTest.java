package baseball.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberPackageTest {
    private static Map<GameNumber, Integer> testPackage = new HashMap<>();
    private static GameNumberPackage gameNumberPackage;

    @BeforeAll
    static void beforeAll() {
        testPackage.put(GameNumber.getInstance(1), 0);
        testPackage.put(GameNumber.getInstance(2), 1);
        testPackage.put(GameNumber.getInstance(3), 2);

        gameNumberPackage = new GameNumberPackage(testPackage);
    }

    @DisplayName("GameNumberPackage 생성 후 Matching 테스트")
    @ParameterizedTest(name = "({index}) {displayName} number={0}, index={1}")
    @CsvSource({"1, 0", "2, 1", "3, 2"})
    void constructor(Integer number, Integer index) {
        GameNumber gameNumber = GameNumber.getInstance(number);

        assertThat(gameNumberPackage.containsGameNumber(gameNumber)).isTrue();
        assertThat(gameNumberPackage.getGameNumberIndex(gameNumber)).isEqualTo(index);
    }

    @DisplayName("GameNumberPackage 생성 후 Matching 실패 테스트")
    @ParameterizedTest(name = "({index}) {displayName} number={0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void constructorForNonMatchingCases(int number) {
        GameNumber gameNumber = GameNumber.getInstance(number);

        assertThat(gameNumberPackage.containsGameNumber(gameNumber)).isFalse();
        assertThat(gameNumberPackage.getGameNumberIndex(gameNumber)).isEqualTo(-1);
    }
}