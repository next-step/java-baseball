package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("Player 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {123, 345, 456, 974, 675})
    void 정상_생성_테스트(int number){
        Player player = new Player(number);
        BaseballNumberBundle expectedBaseballNumberBundle = new BaseballNumberBundle(number);
        assertThat(player.getBaseballNumberBundle()).isEqualTo(expectedBaseballNumberBundle);
    }

    @DisplayName("Player 비정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1223, 340, 434, 97, 5})
    void 비정상_생성_테스트(int number){
        assertThatThrownBy(() -> {
            Player player = new Player(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}