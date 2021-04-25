import java.util.Scanner;

/**
 * 입력 생성
 */
public class InputProcessor {
    private static Scanner scanner = new Scanner(System.in);
    public static String putNumbers(){
        return scanner.nextLine();
    }
}
