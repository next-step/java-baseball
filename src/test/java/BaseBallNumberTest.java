import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vo.BaseBallNumber;
import vo.CompareResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static vo.BaseBallNumber.BASEBALL_NUMBER_SIZE;

class BaseBallNumberTest {

    @Test
    @DisplayName("숫자 생성 사이즈 제한 테스트")
    void createBaseBallNumberSizeTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        //then
        assertThatThrownBy(() -> new BaseBallNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(String.format("숫자야구게임의 생성 숫자는 %d개만 가능합니다.",
                        BASEBALL_NUMBER_SIZE));
    }

    @Test
    @DisplayName("숫자 생성 중복 테스트")
    void createBaseBallNumberDuplicateTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        //then
        assertThatThrownBy(() -> new BaseBallNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("숫자야구게임의 생성 숫자는 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:4:2:0", "1:2:3:3:0", "4:2:1:1:1", "4:5:6:0:0", "2:3:7:0:2"}, delimiter = ':')
    @DisplayName("입력 숫자 정답 비교 테스트")
    void compareBaseBallNumberTest(int input1, int input2, int input3, int strikeCnt, int ballCnt) {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseBallNumber baseBallNumber = new BaseBallNumber(numbers);

        //when
        List<Integer> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        CompareResult compareResult = baseBallNumber.compare(inputs);

        //then
        assertThat(compareResult.getStrikeCnt()).isEqualTo(strikeCnt);
        assertThat(compareResult.getBallCnt()).isEqualTo(ballCnt);
    }

    @Test
    @DisplayName("입력 숫자 정답 비교 사이즈 초과 에러 테스트")
    void compareBaseBallNumberSizeErrorTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseBallNumber baseBallNumber = new BaseBallNumber(numbers);

        //when
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        inputs.add(3);
        inputs.add(4);

        //then
        assertThatThrownBy(() -> baseBallNumber.compare(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(String.format("숫자야구게임의 입력 숫자는 %d개만 가능합니다.",
                        BASEBALL_NUMBER_SIZE));
    }

    @Test
    @DisplayName("입력 숫자 정답 비교 중복 에러 테스트")
    void compareBaseBallNumberDuplicateErrorTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseBallNumber baseBallNumber = new BaseBallNumber(numbers);

        //when
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(3);
        inputs.add(3);

        //then
        assertThatThrownBy(() -> baseBallNumber.compare(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("숫자야구게임의 입력 숫자는 중복될 수 없습니다.");
    }
}
