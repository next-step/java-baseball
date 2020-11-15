package service;

import domain.Check;
import domain.Com;

import java.util.Random;
import java.util.Scanner;

public class BaseServiceImpl implements BaseService{
    public boolean resultCheck(int st, int ball) {
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

    public boolean playChoice(String ch) {
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

    public String getUserNum() {
        Scanner scanner = new Scanner(System.in);
        String me_nan;
        String[] me_nan_st;
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

    // 컴퓨터의 서로 다른 난수 계산
    public Com comNan() {
        Integer integer = 0;
        Integer integer1 = 0;
        Integer integer2 = 0;
        Random rn = new Random();;
        while(!((integer2 / 100) != integer1 | (integer2 / 100) != integer | (integer1 / 10) != integer)){
            integer = 1 * (rn.nextInt(9) + 1);
            integer1 = 10 * (rn.nextInt(9) + 1);
            integer2 = 100 * (rn.nextInt(9) + 1);
        }
        return new Com(integer, integer1,integer2);
    }

    // 컴퓨터와 사용자의 결과 도출
    public Check resultPrint(Check check) {
        String[] com_nan_st = check.getCom();
        String[] me_nan_st = check.getMe();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (result(check, com_nan_st[i], me_nan_st[j], i, j).getCh()) break;
            }
        }
        return check;
    }

    // 결과 계산
    public Check result(Check check, String s, String anObject, int i, int j) {
        if(s.equals(anObject)){
            if(i == j){
                check.setSt(check.getSt()+1);
                check.setCh(true);
                return check;
            }else if(i != j){
                check.setBall(check.getBall()+1);
            }
        }
        check.setCh(false);
        return check;
    }
}
