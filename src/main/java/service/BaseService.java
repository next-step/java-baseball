package service;

import java.util.Scanner;

public class BaseService {
    public static boolean resultCheck(int st, int ball) {
        if(st + ball == 0)
            System.out.println("낫씽");
        else if(ball != 0 & st == 0)
            System.out.println(ball +"볼");
        else if(ball == 0 & st != 0)
            System.out.println(st +"스트라이크");
        else if(st == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        else if(ball != 0 & st != 0)
            System.out.println(st +"스트라이크 " + ball +"볼");

        if(st != 3){
            return true;
        }
        return false;
    }

    public static boolean playChoice(String ch) {
        if(ch.equals("1"))
            System.out.println(ch);
        else if(ch.equals("2")) {
            System.out.println(ch);
            return true;
        }else{
            System.out.println("잘못 입력하셨습니다.");
        }
        return false;
    }

    public static String getUserNum() {
        Scanner scanner = new Scanner(System.in);
        String[] me_nan_st;
        String me_nan;
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            me_nan = scanner.next();
            System.out.println("ME : " + me_nan);
            me_nan_st = me_nan.split("");
            if(me_nan_st[0].equals(me_nan_st[1]) | me_nan_st[1].equals(me_nan_st[2]) | me_nan_st[2].equals(me_nan_st[0])){
                System.out.println("서로 다른 숫자를 입력해주세요.");
                continue;
            }else if(me_nan_st.length != 3){
                System.out.println("다시 입력하세요.");
                continue;
            }
            break;
        }
        return me_nan;
    }
}
