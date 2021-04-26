package baseball.baseballgamemachine;

import baseball.opponent.Opponent;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static baseball.opponent.Opponent.*;

/**
 * 야구 게임을 주도하는 객체
 * 게임이 시작되면 상대(컴퓨터)에게 임의의 수를 정하도록 요청
 * 사용자에게 UI를 제공하여 게임을 진행
 *
 * @author 김민
 */
public class BaseballGameMachine {

    private final Opponent opponent;
    private final Scanner scanner = new Scanner(System.in);

    public BaseballGameMachine(Opponent opponent) {
        this.opponent = opponent;
    }

    /**
     * 게임을 시작하는 메서드
     * 상대에게 정답을 생성하라는 메시지 전송
     */
    public void startGame() {
        opponent.createAnswer();

        while (true) {
            compareInputAnswer();
        }
    }

    /**
     * 사용자에게 답을 입력받아 상대에게 비교하도록 메시지 전송
     */
    private void compareInputAnswer() {
        try {
            System.out.print("숫자를 입력해 주세요 : ");
            int answer = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}