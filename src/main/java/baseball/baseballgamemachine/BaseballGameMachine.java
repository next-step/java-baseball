package baseball.baseballgamemachine;

import baseball.opponent.Opponent;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;
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
            Map<ResultType, Integer> compareResult = compareInputAnswer();
            printResult(compareResult);
        }
    }

    /**
     * 사용자에게 답을 입력받아 상대에게 비교하도록 메시지 전송
     *
     * @return 상대에게 전달받은 결과
     */
    private Map<ResultType, Integer> compareInputAnswer() {
        try {
            System.out.print("숫자를 입력해 주세요 : ");
            int answer = scanner.nextInt();
            return opponent.compare(answer);
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 비교 결과를 사용자에게 출력
     *
     * @param compareResult 비교 결과
     */
    private void printResult(Map<ResultType, Integer> compareResult) {
        if (Objects.isNull(compareResult))
            return;

        compareResult.forEach((key, value) -> System.out.printf("%s%s ", Objects.nonNull(value) ? value : "", key.getDesc()));
        System.out.println();

        if (opponent.isAnswer(compareResult)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            receiveInputWhetherOrNotToRestart();
        }
    }

    /**
     * 게임 재시작 여부 입력 요청
     */
    private void receiveInputWhetherOrNotToRestart() {
        int inputValue;
        try {
            inputValue = scanner.nextInt();
            validateInputValue(inputValue);
        } catch (InputMismatchException | IllegalArgumentException e) {
            emptyScanner(e);
            System.out.println("재시작하려면 1, 종료하려면 2를 입력해 주세요.");
            receiveInputWhetherOrNotToRestart();
            return;
        }

        restartOrExit(inputValue);
    }

    /**
     * 입력받은 값이 1 또는 2인지 검사
     *
     * @param inputValue 사용자 입력 값
     */
    private void validateInputValue(int inputValue) {
        if (inputValue != 1 && inputValue != 2)
            throw new IllegalArgumentException();
    }

    /**
     * 입력 받은 값이 int 형 타입이 아닐 경우 scanner에 있는 값을 비워줌
     * @param e 입력받을 때 발생한 예외 타입
     */
    private void emptyScanner(Exception e) {
        if (e instanceof InputMismatchException)
            scanner.next();
    }

    /**
     * 사용자가 입력한 값을 확인해서 게임 재시작 또는 종료
     *
     * @param inputValue 입력 받은 값
     */
    private void restartOrExit(int inputValue) {
        if (inputValue == 1)
            startGame();
        else if (inputValue == 2)
            exitGame();
    }

    /**
     * 게임 종료
     */
    private void exitGame() {
        System.exit(0);
    }


}