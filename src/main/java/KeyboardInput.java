import java.util.Scanner;

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
