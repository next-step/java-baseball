package baseball;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballUtil {


    /*
        랜덤 숫자 생성 기능.
     */
    public static void setRandomNumber(List<Integer> numbers) {
        int MIN = 1;
        int MAX = 10;
        int random = ThreadLocalRandom.current().nextInt(MIN, MAX);

        if (!numbers.contains(random)) {
            numbers.add(random);
        }
    }

    /*
        스캐너 기능.
     */
    public static String getScannerStr(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /*
        메시지 출력 기능.
     */
    public static void outMessageN(String str){
        System.out.println(str);
    }

    /*
        메시지 출력 기능.
     */
    public static void outMessage(String str){
        System.out.println(str);
    }


    public static void NotValidMsg(boolean flag, String str){
        if(!flag)
            outMessageN(str);
    }

    /*
       같으면 return 1 , 아니면 return 0
    */
    public static int getEqual(int com, int cust){
        return com == cust ? 1 : 0;
    }

    /*
        두 인덱스가 같지 않을때 값 비교
     */
    public static int getNotEqualIdxTwoParams(int idx, int idx2, int com, int cust){
        if(idx != idx2 ){
            return BaseballUtil.getEqual(com, cust);
        }
        return 0;
    }
}
