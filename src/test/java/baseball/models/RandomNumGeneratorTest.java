package baseball.models;

import baseball.configures.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class RandomNumGeneratorTest {

    AppConfig appConfig = new AppConfig();
    RandomNumGenerator randomNumGenerator = appConfig.randomNumGenerator();

    @Test
    @DisplayName("중복 없는 3개의 숫자 생성 성공 테스트")
    void getNoDuplicatedNumber() {
        for (int i = 0; i < 100; ++i) {
            String random = randomNumGenerator.getThreeNumbers();

            assertAll(
                    () -> {
                        Assertions.assertThat(random.charAt(0)).isNotEqualTo(random.charAt(1));
                        Assertions.assertThat(random.charAt(0)).isNotEqualTo(random.charAt(2));
                        Assertions.assertThat(random.charAt(1)).isNotEqualTo(random.charAt(2));
                    });
        }
    }
}