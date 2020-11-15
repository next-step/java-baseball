package baseball;

import java.util.List;
import java.util.Scanner;

/**
 * 숫자 야구 게임 로직 클래스
 */
public class BaseBallGame {
    /**
     * [Game Logic] 게임 로직 startGame()
     *  1. 컴퓨터 턴: comTurn()
     *  2. 사용자 턴: userTurn()
     *  3. 재게임 선택 여부: questionGame()
     */
    public void startGame(Scanner sc) {
        do {
            /* 컴퓨터 턴 */
            List<Integer> comBall = comTurn();

            /* 사용자 턴 */
            userTurn(sc, comBall);

            /* 게임 재시작 여부 확인 */
        } while(isReGame(sc));
    }

    /**
     * [COMPUTER] 1 ~ 9까지 서로 다른 3개의 숫자를 생성하는 메서드
     *  1. 1 ~ 9까지 범위 숫자를 생성
     *  2. 서로 다른 숫자를 생성
     *  3. 총 3개의 숫자를 저장
     * @return 생성된 숫자를 LinkedList 변환하여 반환
     */
    private List<Integer> comTurn() {
        return null;
    }

    /**
     * [PLAYER] 게임 플레이어
     *  1. 게임 플레이어는 컴퓨터가 생각하는 1 ~ 9까지 3개의 숫자를 입력
     *  2. 컴퓨터가 생성한 3개의 숫자와 게임 플레이어가 만든 3개의 숫자를 비교
     *  3. 게임 플레이어가 입력한 값이 컴퓨터가 입력한 값과 순서와 3개의 숫자가 모두 같은 경우 3 Strike 로 반복 종료
     *
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @param comBall 컴퓨터가 생성한 1 ~ 9까지 서로 다른 3개의 숫자
     */
    private void userTurn(Scanner sc, List<Integer> comBall) {

    }


    /**
     * [Game Logic] 한 회의 게임이 종료된 후, 재게임 또는 게임종료 여부를 입력 요청하는 메서드
     *  1. 사용자의
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @return 게임 Rule에 따라 재게임: 1 입력 시 true, 게임 종료: 2 입력 시: false
     */
    private boolean isReGame(Scanner sc) {
        return true;
    }
}
