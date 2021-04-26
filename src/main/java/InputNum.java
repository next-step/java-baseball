import java.util.Scanner;

public class InputNum {
    private static final Integer NUM_SIZE = 3;

    public String scanNum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scan.next();
    }

    public static Boolean checkNumSize(String num){
        if(num.length() != NUM_SIZE){
            return false;
        }
        return true;
    }

}
