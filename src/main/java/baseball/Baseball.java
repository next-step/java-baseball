package baseball;

import java.util.Scanner;

public class Baseball {
    public int numberInput(){
        System.out.println("숫자를 꼭 3개만 입력해주세요! ex)123  592  230");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println(num);
        numberCheck(num);

        return 1;
    }
    public String numberCheck(String num){
        num.indexOf(0);

        System.out.println("체크 완료");
        return "OK";
    }
    public void startBaseball(){
        try{
            System.out.println("야구게임 시작!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void endBaseball(){
        System.out.println("야구게임 끝!");
    }
    public int playGoing(){
        numberInput();



        return 12;
    }
}
