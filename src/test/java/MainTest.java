import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void test() {
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
}
