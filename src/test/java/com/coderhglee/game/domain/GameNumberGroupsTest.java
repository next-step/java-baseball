package com.coderhglee.game.domain;

import com.coderhglee.game.exception.ExceedAllowLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class GameNumberGroupsTest {

    @DisplayName("게임의 숫자는 3개를 입력 해야 한다")
    @Test
    void shouldGameNumberLengthEqualsThree() {
        assertThatThrownBy(() -> {
            List<GameNumber> gameNumberList = new ArrayList<>();
            gameNumberList.add(GameNumber.EIGHT);
            gameNumberList.add(GameNumber.FIVE);
            new GameNumberGroups(gameNumberList);
        }).isInstanceOf(ExceedAllowLengthException.class);
    }


    @DisplayName("숫자 객체의 리스트끼리 모두 같은지 비교한다.")
    @Test
    void isSameAllNumberList() throws ExceedAllowLengthException {

        List<GameNumber> gameNumberList = new ArrayList<>();
        gameNumberList.add(GameNumber.EIGHT);
        gameNumberList.add(GameNumber.FIVE);
        gameNumberList.add(GameNumber.FIVE);
        GameNumberGroups groups1 = new GameNumberGroups(gameNumberList);
        GameNumberGroups groups2 = new GameNumberGroups(gameNumberList);

        assertThat(groups1.isContains(groups2)).isTrue();
    }

    @DisplayName("게임 숫자 그룹 두개를 해시코드를 비교한 결과가 메시지와 맞는지 판단한다.")
    @ParameterizedTest
    @MethodSource("gameNumberGroupsEqualToExactedResult")
    void expectedResultFromTwoGameNumberGroupsCompare(GameNumberGroups first, GameNumberGroups second, GameGroupsCompareResult expectedResult) {
        assertThat(GameNumberGroupsHelper.compareEachGameGroup(first, second).hashCode()).isEqualTo(expectedResult.hashCode());
    }

    public static Stream<Arguments> gameNumberGroupsEqualToExactedResult() throws ExceedAllowLengthException {
        return Stream.of(
                Arguments.of(new GameNumberGroups(getGameNumbers("123")),
                        new GameNumberGroups(getGameNumbers("123")), new GameGroupsCompareResult(0,3)),
                Arguments.of(new GameNumberGroups(getGameNumbers("456")),
                        new GameNumberGroups(getGameNumbers("123")), new GameGroupsCompareResult(0,0)),
                Arguments.of(new GameNumberGroups(getGameNumbers("175")),
                        new GameNumberGroups(getGameNumbers("875")), new GameGroupsCompareResult(0,2)),
                Arguments.of(new GameNumberGroups(getGameNumbers("156")),
                        new GameNumberGroups(getGameNumbers("652")), new GameGroupsCompareResult(1,1))
        );
    }

    private static List<GameNumber> getGameNumbers(String number) {
        List GameNumbersList = new ArrayList();
        for (String numberStr : number.split("")) {
            GameNumbersList.add(GameNumber.gameNumberMap.get(Integer.parseInt(numberStr)));
        }
        return GameNumbersList;
    }


}
