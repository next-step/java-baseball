package baseball;

import java.util.Scanner;

public class BaseBall {
    Scanner sc = new Scanner(System.in);
    static int comNum1, comNum2, comNum3, userNum1, userNum2, userNum3;
    static String userNum;

    public static void main(String[] args){
        System.out.println("Hello World!");
    }

    public int setNumTest(){
        while ( (setNum() == 0) || (zeroCheck() == 0));
        return comNum1*100 + comNum2*10 + comNum3;
    }

    private int setNum(){
        comNum1 = (int)(Math.random()*10);
        comNum2 = (int)(Math.random()*10);
        comNum3 = (int)(Math.random()*10);

        if (comNum1 != comNum2 && comNum2 != comNum3 && comNum3 != comNum1) {
            return 1;
        }
        return 0;
    }

    private int zeroCheck() {
        return comNum1 != 0 && comNum2 != 0 && comNum3 != 0 ? 1 : 0;
    }

    private void inputNum(){
        System.out.print("세자리 숫자를 입력해주세요 : ");
        userNum = sc.next();
        if (userNum.length() != 3){
            inputNum();
            return;
        }
        userNum1 = Character.getNumericValue(userNum.charAt(0));
        userNum2 = Character.getNumericValue(userNum.charAt(1));
        userNum3= Character.getNumericValue(userNum.charAt(2));
    }
}
