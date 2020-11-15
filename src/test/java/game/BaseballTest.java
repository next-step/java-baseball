package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    void setBaseball() {
        baseball = new Baseball();
    }

    @Test
    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 Set 자료구조에 담아서 사이즈를 비교해본다.")
    void prepareComputerNumbers_ShouldReturnNoDuplicateNumbers() {
        int[] computerNumbers = baseball.prepareComputerNumbers();
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < computerNumbers.length; i++) {
            numbers.add(computerNumbers[i]);
        }

        assertEquals(computerNumbers.length, numbers.size());
    }

    @Test
    @DisplayName("게임 플레이어가 입력한 텍스트가 숫자로만 구성되어있는지와 숫자 갯수가 적합한지 테스트")
    void checkInputNumbers_IsNumberAndSuitableCount() {
        String inputNumber = "a3p";
        assertFalse(baseball.checkInputNumbers(inputNumber));

        inputNumber = "1234";
        assertFalse(baseball.checkInputNumbers(inputNumber));

        inputNumber = "123";
        assertTrue(baseball.checkInputNumbers(inputNumber));
    }

    @Test
    @DisplayName("스트라이크와 볼을 적합하게 판단하는지 테스트")
    void baseballJudgment_ShouldReturnSuitableCount() {
        int[] computerNumbers = new int[] {1, 2, 3};
        int[] userNumbers = new int[] {4, 2, 1};

        BaseballJudgment baseballJudgment = baseball.baseballJudgment(computerNumbers, userNumbers);
        assertEquals(baseballJudgment.getStrikeCount(), 1);
        assertEquals(baseballJudgment.getBallCount(), 1);

        userNumbers = new int[] {2, 3, 1};
        baseballJudgment = baseball.baseballJudgment(computerNumbers, userNumbers);
        assertEquals(baseballJudgment.getStrikeCount(), 0);
        assertEquals(baseballJudgment.getBallCount(), 3);

        userNumbers = new int[] {5, 6, 7};
        baseballJudgment = baseball.baseballJudgment(computerNumbers, userNumbers);
        assertEquals(baseballJudgment.getStrikeCount(), 0);
        assertEquals(baseballJudgment.getBallCount(), 0);

        userNumbers = new int[] {1, 2, 3};
        baseballJudgment = baseball.baseballJudgment(computerNumbers, userNumbers);
        assertEquals(baseballJudgment.getStrikeCount(), 3);
        assertEquals(baseballJudgment.getBallCount(), 0);
    }
    
}
