import java.util.Scanner;

public class BaseballView {

    private final Scanner scanner = new Scanner(System.in);

    public String viewInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

}
