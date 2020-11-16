package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 앞으로 게임 로직 내에 생성되는 메서드에 대한 입력 및 검증을 하기 위한 테스트 클래스
 */
public class BaseBallGameTest {

    /* 게임 로직에 필요한 상수 정의 */
    private static final Integer BASE_BALL_CNT = 3;

    private BaseBallGame baseBallGame;

    @BeforeEach
    public void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @Test
    @DisplayName("[COMPUTER TURN] 생성된 숫자의 개수가 3인지 확인")
    public void validComTurnIsNumberLength() {
        List<Integer> actual = baseBallGame.getComBalls();
        assertThat(actual.size()).isEqualTo(BASE_BALL_CNT);
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값의 길이가 3인지 확인")
    public void validUserTurnIsValidLength(){
        Scanner sc = new Scanner("123");
        assertThat(baseBallGame.isUserInputValidLength(sc.nextLine())).isTrue();
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값의 길이가 3이아닌 값에 대한 처리")
    public void validUserTurnIsValidLengthException(){
        Scanner sc = new Scanner("13");
        assertThat(baseBallGame.isUserInputValidLength(sc.nextLine())).isFalse();
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값을 정수형 배열로 변환이 가능한지 확인")
    public void validUserTurnCastStringToInt() {
        Scanner sc = new Scanner("123");
        int[] expected = new int[]{1,2,3};
        int[] userInputNumbers = baseBallGame.castStringToInt(sc.nextLine());
        assertThat(userInputNumbers).contains(1);
        assertThat(userInputNumbers).contains(2);
        assertThat(userInputNumbers).contains(3);
        assertThat(userInputNumbers).containsExactly(expected);
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값이 숫자로 변환이 되는지 확인")
    public void validUserTurnCastStringToInteger() {
        Scanner sc = new Scanner("123");
        assertThat(baseBallGame.isInteger(sc.nextLine())).isTrue();
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값이 숫자로 변환시 예외")
    public void validUserTurnCastStringToIntegerException() {
        String userInput = "12a";
        assertThatThrownBy(() -> Integer.parseInt(userInput))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("[USER TURN] 게임 플레이어가 입력한 값이 유효성 검사를 통과 후 정수형 배열로 정상 반환 확인")
    public void validUserTurnSelectBall() {
        Scanner sc = new Scanner("123");
        int[] userInputNums = baseBallGame.selectBalls(sc);
        int[] expected = {1,2,3};
        assertThat(userInputNums).containsExactly(expected);
    }

    @Test
    @DisplayName("[COMPARE] 3 스트라이크 테스트")
    public void returnStrikeComBallToUserBall() {
        int strikeCnt = 3;
        int ballCnt = 0;
        assertThat(baseBallGame.printMatches(strikeCnt, ballCnt)).isFalse();
    }

    @Test
    @DisplayName("[COMPARE] 볼 테스트")
    public void printBallAndNothingComBallToUserBall() {
        int strikeCnt = 0;
        int ballCnt = 3;
        assertThat(baseBallGame.printMatches(strikeCnt, ballCnt)).isTrue();
    }
    @Test
    @DisplayName("[COMPARE] 낫싱 테스트")
    public void printNothingAndNothingComBallToUserBall() {
        int strikeCnt = 0;
        int ballCnt = 0;
        assertThat(baseBallGame.printMatches(strikeCnt, ballCnt)).isTrue();
    }

    @Test
    @DisplayName("[COMPARE] 컴퓨터와 게임플레이어가 입력한 값을 비교하여 3스트라이크 테스트")
    public void compareComBallToUserBall() {
        List<Integer> comBallList = baseBallGame.getComBalls();
        StringBuilder comBall = new StringBuilder();
        for(Integer item : comBallList) {
            comBall.append(item);
        }
        Scanner sc = new Scanner(comBall.toString());
        int [] userActual = baseBallGame.selectBalls(sc);

        assertThat(baseBallGame.isMatches(userActual, comBallList)).isFalse();
    }

    @Test
    @DisplayName("[ReGAME] 재게임 여부 확인")
    public void reGameValueYn() {
        String userInput = "1";
        assertThat(baseBallGame.isReGameRangeInValue(userInput)).isTrue();
        userInput = "2";
        assertThat(baseBallGame.isReGameRangeInValue(userInput)).isTrue();
    }
}
