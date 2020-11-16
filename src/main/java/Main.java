import app.BaseballGame;
import app.InputValidator;
import app.NumberGenerator;
import app.Score;

import java.util.Scanner;

public class Main {

    private static final String INPUT_VALID_MESSAGE = "입력값은 3자리의 숫자여야 합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 :";
    private static final String CLEAR_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SELECT_GAME_STATUS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    private static BaseballGame baseballGame;
    private static Scanner scanner;

    public static void main(String... args) {
        scanner = new Scanner(System.in);
        baseballGame = new BaseballGame(NumberGenerator.generate());
        boolean gameStatus = true;
        while (gameStatus) {
            System.out.println(INPUT_NUMBER_MESSAGE);
            String input = scanner.next();
            checkInputValue(input);
            Score score = baseballGame.guess(input);
            System.out.println(score.getResultMessage());
            gameStatus = checkGameStatus(score.getStatus());
        }
    }

    /**
     * input 값이 유효한지 체크
     * @param input 사용자 입력값
     */
    private static void checkInputValue(String input) {
        if (!InputValidator.isValid(input)) {
            throw new IllegalArgumentException(INPUT_VALID_MESSAGE);
        }
    }

    /**
     * 게임 상태를 체크하고 클리어한 경우에는 재시작할지 종료할지 입력받음
     * @param status 현재 게임 상태
     * @return boolean
     */
    private static boolean checkGameStatus(boolean status) {
        boolean result = true;
        if (!status) {
            System.out.println(CLEAR_GAME_MESSAGE);
            System.out.println(SELECT_GAME_STATUS);
            result = selectGameStatus(scanner.nextInt());
            baseballGame = new BaseballGame(NumberGenerator.generate());
        }

        return result;
    }

    /**
     * 사용자 입력값 리턴
     * @param value 사용자가 입력한 번호에 따른 boolean value 리턴
     * @return boolean
     */
    private static boolean selectGameStatus(int value) {
        return value == 1 ? true : false;
    }
}
