package baseball;

import baseball.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallNumberTest {

    @DisplayName("컴퓨터(딜러)가 생성하는 랜덤 3 숫자를 확인한다.")
    @Test
    void randomBallNumberCheck() {
        BallNumber dealersNumber = new BallNumber(new BallNumbersRandomStrategy(new ArrayList<>()));
        assertThat(dealersNumber.getBallNumber().size()).isEqualTo(3);
    }

    //todo:: 직접 입력하는 볼넘버 전략패턴 테스트 입력 UI 를 분리
    @DisplayName("플레이어가 입력하는 3 숫자를 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5,6", "2,3,6", "9,5,6"})
    void playerInputBallNumberCheck(String inputString) {
        List<Integer> ballNumbers = InputView.setBallNumber(inputString);
        assertThat(ballNumbers.size()).isEqualTo(3);
        assertThat(ballNumbers.size()).isEqualTo(3);
    }

}
