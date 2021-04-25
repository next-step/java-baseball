import java.util.Scanner;

public class BaseballGameView {

    private final Scanner scanner = new Scanner(System.in);

    //숫자 입력
    public String getUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");

        return scanner.next();
    }

}
