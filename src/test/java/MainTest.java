import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    @DisplayName("Test Baseball Random Number")
    void TEST_getRandomNumStr() {
        String randomNumStr = Main.getRandomNumStr();
        StringBuilder baseballNum = new StringBuilder();
        Set baseballNumSet = new HashSet();

        for (int i = 0; i < randomNumStr.length(); i++) {
            int num = randomNumStr.charAt(i) - '0';
            baseballNumSet.add(num);
            baseballNum.append(num);
            assertThat(num).isGreaterThan(0);
        }

        for (int i = 0; i < randomNumStr.length(); i++) {
            int num = randomNumStr.charAt(i) - '0';
            assertThat(baseballNumSet).containsOnlyOnce(num);
        }
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount() {

        String userBaseballStr = "123";
        String commRandomNum = "123";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount2() {

        String userBaseballStr = "123";
        String commRandomNum = "124";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("Test Baseball Strike Number")
    void TEST_getStrikeCount3() {

        String userBaseballStr = "123";
        String commRandomNum = "543";

        // Check Strike
        int strikeCount = Main.getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + " 스트라이크");

        assertThat(strikeCount).isEqualTo(1);
    }
}
