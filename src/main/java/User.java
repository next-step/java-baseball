import java.util.Scanner;

public class User {
    public static int nextTurn() {
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        int turn = scanner.nextInt();

        while (!check.validationCheck(turn)) {
            System.out.print("다시 입력해주세요 : ");
            turn = scanner.nextInt();
        }
        return turn;
    }
    public static int selectMenu() {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();

        while (select < 1 || select > 2) {
            System.out.print("다시 입력해주세요 : ");
            select = scanner.nextInt();
        }
        return select;
    }
}
