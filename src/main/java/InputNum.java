import java.util.Scanner;

public class InputNum {

    public String scanNum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scan.next();
    }
}
