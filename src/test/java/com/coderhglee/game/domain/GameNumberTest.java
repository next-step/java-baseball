package com.coderhglee.game.domain;

import com.coderhglee.game.number.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameNumberTest {

    @DisplayName("게임 숫자 정의가 제대로 됐는지 체크 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getNumber_ShouldReturnTrueForInts(int value) {
        assertTrue(Arrays.stream(GameNumber.values()).anyMatch(a -> a.getNumberValue() == value));
    }


    @DisplayName("숫자로 메모리 맵에 있는 숫자 객체를 제대로 반환 할 수 있는지 확인 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void Should_baseball_number(int value) {
        assertTrue(Arrays.asList(GameNumber.values()).contains(GameNumber.gameNumberMap.get(value)));
    }

}
