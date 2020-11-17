package edu.example.numberbaseball.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("`Player`를 상대할 `Computer`에 대한 테스트")
class ComputerTest {
    private static final int VALID_BALL_SIZE_FOR_INNING = 3;

    private final Computer computer = new Computer();

    @DisplayName("`Computer`는 랜던하게 생성된 3개 `Ball`을 가진 `Inning`으로 생성된다.")
    @Test
    void createValidComputer() {
        List<Integer> computerBallNumberList = computer.getBallNumberList();
        int computerBallNumberListSize = computerBallNumberList.size();

        assertEquals(VALID_BALL_SIZE_FOR_INNING, computerBallNumberListSize);
    }

    @DisplayName("`Computer`를 리셋하면 `Inning`의 정보는 새롭게 셋팅된다.")
    @Test
    void reset() {
        List<Integer> firstComputerBallNumberList = computer.getBallNumberList();
        int firstComputerBallNumberListSize = firstComputerBallNumberList.size();

        computer.reset();

        List<Integer> secondComputerBallNumberList = computer.getBallNumberList();
        int secondComputerBallNumberListSize = secondComputerBallNumberList.size();

        assertEquals(secondComputerBallNumberListSize, firstComputerBallNumberListSize);
        assertFalse(firstComputerBallNumberList.containsAll(secondComputerBallNumberList));
    }
}
