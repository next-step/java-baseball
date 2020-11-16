package com.coderhglee.game.domain;

import com.coderhglee.game.exception.ContainSameNumberException;
import com.coderhglee.game.exception.ExceedAllowLengthException;
import com.coderhglee.game.number.NumberCompareResult;
import com.coderhglee.game.number.NumberGroupsHelper;
import com.coderhglee.game.number.Number;
import com.coderhglee.game.number.NumberGroups;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NumberGroupsTest {

    @DisplayName("게임의 숫자는 3개를 입력 해야 한다")
    @Test
    void shouldGameNumberLengthEqualsThree() {
        assertThatThrownBy(() -> {
            List<Number> numberList = new ArrayList<>();
            numberList.add(Number.EIGHT);
            numberList.add(Number.FIVE);
            new NumberGroups(numberList);
        }).isInstanceOf(ExceedAllowLengthException.class);
    }


    @DisplayName("숫자 객체의 리스트끼리 모두 같은지 비교한다.")
    @Test
    void isSameAllNumberList() throws ExceedAllowLengthException, ContainSameNumberException {

        List<Number> numberList = new ArrayList<>();
        numberList.add(Number.EIGHT);
        numberList.add(Number.FIVE);
        numberList.add(Number.THREE);
        NumberGroups groups1 = new NumberGroups(numberList);
        NumberGroups groups2 = new NumberGroups(numberList);


        assertThat(groups1.getGameNumbers().containsAll(groups2.getGameNumbers())).isTrue();
    }

    private static List<Number> getGameNumbers(String number) {
        List<Number> numbersList = new ArrayList<>();
        for (String numberStr : number.split("")) {
            numbersList.add(Number.gameNumberMap.get(Integer.parseInt(numberStr)));
        }
        return numbersList;
    }

    @DisplayName("게임 숫자 그룹 두개를 해시코드를 비교한 결과가 메시지와 맞는지 판단한다.")
    @ParameterizedTest
    @MethodSource("gameNumberGroupsEqualToExactedResult")
    void expectedResultFromTwoGameNumberGroupsCompare(NumberGroups first, NumberGroups second, NumberCompareResult expectedResult) {
        assertThat(NumberGroupsHelper.compareEachNumber(first, second).hashCode()).isEqualTo(expectedResult.hashCode());
    }
    public static Stream<Arguments> gameNumberGroupsEqualToExactedResult() throws ExceedAllowLengthException, ContainSameNumberException {
        return Stream.of(
                Arguments.of(new NumberGroups(getGameNumbers("123")),
                        new NumberGroups(getGameNumbers("123")), new NumberCompareResult(0,3)),
                Arguments.of(new NumberGroups(getGameNumbers("456")),
                        new NumberGroups(getGameNumbers("123")), new NumberCompareResult(0,0)),
                Arguments.of(new NumberGroups(getGameNumbers("175")),
                        new NumberGroups(getGameNumbers("875")), new NumberCompareResult(0,2)),
                Arguments.of(new NumberGroups(getGameNumbers("156")),
                        new NumberGroups(getGameNumbers("652")), new NumberCompareResult(1,1))
        );
    }


    @DisplayName("연속되는 숫자 객체가 있으면 에러를 발생시킨다.")
    @ValueSource(strings = {"111", "122", "311","499"})
    @ParameterizedTest
    void shouldExpectedExceptionWhenIncludeContinueNumbers(String inputNumber) {
        assertThatThrownBy(() -> new NumberGroups(getGameNumbers(inputNumber))).isInstanceOf(ContainSameNumberException.class);
    }

}
