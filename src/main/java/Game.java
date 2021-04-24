import java.util.Scanner;

public class Game {
    private static Scanner scanner;

    private static boolean isValidInput(int input) {
        if ((input < 100) || (input > 999)) return false;
        if (input % 10 == 0) return false;
        if (input % 100 < 10) return false;

        return true;
    }

    private static int[] createPlayerNumbers(int input) {
        int[] playerList = new int[3];
        playerList[0] = input % 10;
        playerList[1] = (input / 10) % 10;
        playerList[2] = (input / 100) % 10;

        return playerList;
    }

    private static int[] getPlayerList() {
        System.out.println("숫자를 입력해주세요 : ");
        int input = scanner.nextInt();

        while (!isValidInput(input)) {
            System.out.println("숫자를 입력해주세요 : ");
            input = scanner.nextInt();
        }

        return createPlayerNumbers(input);
    }

    private static void play() {
        Dealer dealer = new Dealer();
        Judge judge = new Judge();

        while (!Rule.doesWin(judge)) {
            int[] playerList = getPlayerList();
            judge = Rule.judge(dealer.getList(), playerList);
            System.out.println(judge.toString());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean askQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = scanner.nextInt();

        return (answer == 2);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean doQuit = false;

        while (!doQuit) {
            play();
            doQuit = askQuit();
        }
    }
}
