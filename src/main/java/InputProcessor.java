import java.util.Scanner;

/**
 * 입력 생성z
 */
public class InputProcessor {
    private static Scanner scanner = new Scanner(System.in);
    public static String putNumbers(){
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
