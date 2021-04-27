import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNum {
    private static final Integer NUM_SIZE = 3;

    public String scanNum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scan.next();
    }

    public static Boolean checkNumSize(String num){
        if(num.length() != NUM_SIZE){ return false;}
        return true;
    }

    public static Boolean checkOneToNine(String num){
        Pattern pattern = Pattern.compile("(^[1-9]*$)");
        Matcher matcher = pattern.matcher(num);
        return matcher.find();
    }

    public static Boolean checkDuplicateNum(String num){
        String[] numList = num.split("");
        Set<?> numSet = new HashSet<>(Arrays.asList(numList));

        if(numSet.size() < 3){ return true; }
        return false;
    }

}
