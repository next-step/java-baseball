package com.baseball.game.service;

import com.baseball.game.exception.BaseBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("숫자 생성 테스트")
class NumberBoxTest {

    @RepeatedTest(value=1_000, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("투수 - NumberBox에 존재하지 않는 수를 생성한다")
    void createDistinctNumber(){
        // given
        List<Integer> list = Arrays.asList(1,2);
        NumberBox numberBox = new NumberBox();
        numberBox.setNumberBox(list);

        //when
        int distinctNumber = numberBox.getDistinctValue();

        // then
        assertTrue(distinctNumber > 2 && distinctNumber < 10);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "462:462", "578:578"}, delimiter = ':')
    @DisplayName("타자 - 입력한 값 및 위치(index)대로 numberBox가 생성된다. ")
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        NumberBox box = NumberBox.generate(Integer.parseInt(input));
        assertEquals(expected, box.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1234})
    @DisplayName("타자 - 0~1000 범위를 벗어난 숫자는 생성이 실패한다.")
    public void throwOutOfRange(int numbers){
        assertThatThrownBy(() -> {
                NumberBox.generate(numbers);
            })
            .isInstanceOf(BaseBallException.class)
            .hasMessageContaining("0 ~ 1,000 사이의 숫자만 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(ints = {122, 334, 555, 991})
    @DisplayName("타자 - 중복된 숫자가 입력되는 경우 생성이 실패한다.")
    public void throwParseInteger(int numbers){
        assertThatThrownBy(() -> {
            NumberBox.generate(numbers);
            })
            .isInstanceOf(BaseBallException.class)
            .hasMessageContaining("1~9까지 서로 다른 3자리 숫자로 입력해 주세요");
    }
}