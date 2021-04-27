import java.util.Scanner;

public class Player {

    private String answer;
    private final Scanner scanner = new Scanner(System.in);

    public String submitAnswer() {
        answer = scanner.nextLine();
        return answer;
    }
}
