package task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    @DisplayName("컴퓨터 숫자 자동 생성 빈 객체 및 사이즈 체크")
    void createComputerDataCheck() {
        baseball.computerNumberInput();
        assertThat(baseball.computer).isNotEmpty().hasSize(3);
    }

    @Test
    @DisplayName("유저 컬렉션 빈 객체 및 사이즈 체크")
    void createUserDataCheck() {
        while (baseball.user.size() < baseball.COLLECTION_MAXIMUM_LENGTH)
            baseball.user.add(baseball.random.nextInt(10)+1);

        assertThat(baseball.user).isNotEmpty().hasSize(3);
    }
}