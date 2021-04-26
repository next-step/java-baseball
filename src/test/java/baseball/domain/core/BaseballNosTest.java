package baseball.domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.core.BaseballNos.formPlayerInputString;
import static baseball.domain.core.BaseballNosException.ERROR_MSG_DUPLICATE_BASEBALLNOS;
import static baseball.domain.core.BaseballNosException.ERROR_MSG_NOTCORRECT_BASEBALLNOS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구 게임 숫자 목록 테스트")
class BaseballNosTest {

    @DisplayName("컴퓨터에서 랜덤하게 3개의 야구 게임 숫자가 나오는지 확인")
    @RepeatedTest(10)
    void generate() {
        assertThat(BaseballNos.formComputer().size())
        .isEqualTo(BaseballNos.MAX_BASEBALL_LIST_SIZE);
    }

    @DisplayName("사용자 등록한 야구게임 정보가 오류 문자가 있거나 3개 이상인지 확인")
    @ParameterizedTest
    @ValueSource(strings={
            "1-2", "2a@", "1111", "4", "abc", "abcddee"
    })
    void isCorrectBaseballNos(String baseballNos) {
        assertThatThrownBy(()-> formPlayerInputString(baseballNos))
                .isInstanceOf(BaseballNosException.class)
                .hasMessage(ERROR_MSG_NOTCORRECT_BASEBALLNOS)
        ;
    }

    @DisplayName("중복된 숮자가 존재하는 확인")
    @ParameterizedTest
    @ValueSource(strings={
            "122", "111", "333", "999"
    })
    void isDuplicateBaseballNos(String baseballNos) {
        assertThatThrownBy(()-> formPlayerInputString(baseballNos))
                .isInstanceOf(BaseballNosException.class)
                .hasMessage(ERROR_MSG_DUPLICATE_BASEBALLNOS)
        ;
    }

    void assertThatComputerCompareToPlayer(String computerNos, String playerNos, int strike, int ball){
        BaseballNos computer = formPlayerInputString(computerNos);
        BaseballNos player = formPlayerInputString(playerNos);

        BaseballResult result = new BaseballResult(strike, ball);
        assertThat(computer.compareTo(player))
                .isEqualTo(result);
        assertThat(player.compareTo(computer))
                .isEqualTo(result);
    }
    @DisplayName("같은수가 같은 자리면 스트라이크, 다른 자리면 볼, 같은수가 없으면 낫싱")
    @Test
    void computerCompareToPlayer() {
        assertThatComputerCompareToPlayer("425", "123", 1, 0);
        assertThatComputerCompareToPlayer("425", "456", 1, 1);
        assertThatComputerCompareToPlayer("425", "789", 0, 0);
        assertThatComputerCompareToPlayer("425", "425", 3, 0);
    }
}