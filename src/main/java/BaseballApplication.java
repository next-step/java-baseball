import domain.BaseballGame;

import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args) {
        boolean wantToReStart = true;

        while (wantToReStart) {
            BaseballGame.processGame();
            wantToReStart = checkReStart();
        }
    }

    private static boolean checkReStart() {
        Scanner scanner = new Scanner(System.in);
        int userInputOption = 0;

        while (userInputOption < 1 || userInputOption > 2) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInputOption = scanner.nextInt();
        }
        return userInputOption == 1;
    }
}
