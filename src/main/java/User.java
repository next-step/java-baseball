import java.util.Scanner;

public class User {
    public int nextTurn() {
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        int turn = scanner.nextInt();

        while (!check.validationCheck(turn)) {
            System.out.println("다시 입력해주세요 : ");
            turn = scanner.nextInt();
        }
        return turn;
    }
}
