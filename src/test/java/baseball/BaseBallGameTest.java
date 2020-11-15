package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 앞으로 게임 로직 내에 생성되는 메서드에 대한 입력 및 검증을 하기 위한 테스트 클래스
 */
public class BaseBallGameTest {

    /* 게임 로직에 필요한 상수 정의 */
    private static final Integer BASE_BALL_CNT = 3;
    private static final Integer BASE_BALL_MIN_POINT = 1;
    private static final Integer BASE_BALL_MAX_POINT = 9;

    private BaseBallGame baseBallGame;

    @BeforeEach
    public void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    @DisplayName("[COMPUTER TURN] 생성된 숫자가 1부터 9까지의 값인지 확인")
    public void validComTurnIsNumberOneToNine() {
        List<Integer> actual = baseBallGame.comTurn();
        assertThat(isNumberOneBetweenNine(actual)).isTrue();
    }

    /* 컴퓨터가 생성한 값의 범위를 판단하는 메서드 */
    private boolean isNumberOneBetweenNine(List<Integer> actual) {
        for(Integer item : actual) {
            /* 1 ~ 9 범위의 값이 아닌경우 false 리턴 */
            if(!(BASE_BALL_MIN_POINT <= item && BASE_BALL_MAX_POINT >= item)) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("[COMPUTER TURN] 생성된 숫자의 개수가 3인지 확인")
    public void validComTurnIsNumberLength() {
        List<Integer> actual = baseBallGame.comTurn();
        assertThat(actual.size()).isEqualTo(BASE_BALL_CNT);
    }
}
