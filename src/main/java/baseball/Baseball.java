package baseball;

import java.util.Scanner;

public class Baseball {
    public String numberInput(){
        System.out.println("숫자를 꼭 3개만 입력해주세요! ex)123  592  230");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println(num);
        String checkNum = numberCheck(num);

        return checkNum;
    }
    public String numberCheck(String num){
        num = num.replaceAll(" " , "");
        num.charAt(0);
        if(num.length() !=3){
            System.out.println("길이는 무적건 3글자만 가능합니다.");
            numberInput();
        }
        for(int i=1; i<=9; i++){
            if( 0> num.charAt(0) && num.charAt(0) >10){
                System.out.println("숫자만 입력해주세요!!!");
                numberInput();
            }
        }
        for(int i=1; i<=9; i++){
            if( 0> num.charAt(1) && num.charAt(1) >10){
                System.out.println("숫자만 입력해주세요!!!");
                numberInput();
            }
        }
        for(int i=1; i<=9; i++){
            if( 0> num.charAt(2) && num.charAt(2) >10){
                System.out.println("숫자만 입력해주세요!!!");
                numberInput();
            }
        }
        return num;
    }
    public String startBaseball( ){
        System.out.println("야구게임 시작!");
        System.out.println("중복된 수가 없는 4자리 정수를 생성중입니다.(1000 ~ 9999)");
        char chc1, chc2, chc3;
        String randomNum="";
        while(true){
            randomNum = (int)(Math.random()*900+100)+"";
            chc1 = randomNum.charAt(0);
            chc2 = randomNum.charAt(1);
            chc3 = randomNum.charAt(2);
            System.out.println(randomNum);
            if (!(chc1==chc2 || chc1==chc3 || chc2==chc3)){
                break;
            }
        }

        return randomNum;
    }
    public void endBaseball(){
        System.out.println("야구게임 끝!");
    }
    public void baseballCheck(String checkNum ,String robotNum3){

    }
    public int playGoing(String robotNum3){

        String checkNum=numberInput();
        baseballCheck(checkNum , robotNum3);



        return 12;
    }
}
