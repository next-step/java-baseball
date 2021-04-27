import static game.GameConstant.*;

import game.GameMachine;
import game.GameResultStatus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init();

        boolean isExit = false;
        while (!isExit) {
            isExit = runGame(gameMachine);
        }
    }

    /**
     * 게임 실행
     * @param gameMachine 게임머신
     * @return 전체 종료 플래그
     */
    private static boolean runGame(GameMachine gameMachine) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(INFO_INPUT_NUMBER);
            String[] input = sc.nextLine().split(DELIMITER);
            gameMachine.isValid(input);

            int[] result = gameMachine.check(input);
            System.out.println(gameMachine.print(result));
            return checkResult(gameMachine, result);

        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    
    /**
     * 결과 확인 
     * @param gameMachine 게임머신
     * @param result 결과
     * @return 비교 결과
     */
    private static boolean checkResult(GameMachine gameMachine, int[] result) {
        if (result[GameResultStatus.STRIKE.getIndex()] == ANSWER) {
            System.out.println(INFO_ANSWER_RESULT);
            return reGame(gameMachine);
        }
        return false;
    }

    /**
     * 게임 재시작, 종료 설정
     * @param gameMachine 게임머신
     * @return 게임 재시작 플래그
     */
    private static boolean reGame(GameMachine gameMachine) {
        Scanner sc = new Scanner(System.in);
        int option = NONE;

        while (option == NONE) {
            System.out.println(INFO_QUESTION_RESTART);
            option = selectOption(sc.nextLine());
        }

        if (option == RESTART) {
            gameMachine.init();
        }

        return option == EXIT;
    }

    /**
     * 옵션 선택 검사
     * @param input 사용자 입력
     * @return 옵션 선택 결과
     */
    private static int selectOption(String input) {
        String regExp = "^[1-2]";
        if (input.matches(regExp)) {
            return Integer.parseInt(input);
        }
        return NONE;
    }
}
