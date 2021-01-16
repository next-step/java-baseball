import java.util.Scanner;

/**
 * 플레이어가 키보드로 입력한 값을 받는다.
 */
public class KeyboardInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInputValue() {
        return scanner.nextLine();
    }

    @Override
    public String getInputValue(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
