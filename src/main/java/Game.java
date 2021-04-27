import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        final Computer computer = new Computer();
        computer.initializeNewNumbers();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String answer = scanner.nextLine();
            try {
                HintResult hintResult = computer.generateResult(answer);
                System.out.println(hintResult.getResultMessage());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
