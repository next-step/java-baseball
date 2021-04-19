package baseball;

import java.util.Scanner;

public class Baseball {
        int strike = 0;
        int ball = 0;
        int count=0;
    boolean resulet=true;
    public String numberInput(){
        System.out.println("숫자를 꼭 3개만 입력해주세요! ex)123  592  230");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String checkNum = numberCheck(num);

        return checkNum;
    }
    public String numberCheck(String num){
        boolean isNumeric = false;
        num = num.replaceAll(" " , "");
        if(num.length() !=3){
            System.out.println("길이는 무적건 3글자만 가능합니다.");
            numberInput();
        }
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                isNumeric = true;
            }
        }
        if(isNumeric){
            System.out.println("숫자만 입력해주세요");
            return numberInput();
        }else{
            return num;
        }
    }
    public String startBaseball( ){
        System.out.println("야구게임 시작!");
        System.out.println("중복된 수가 없는 3자리 정수를 생성중입니다.(100 ~ 999)");
        char chc1, chc2, chc3;
        String randomNum="";
        while(true){
            randomNum = (int)(Math.random()*900+100)+"";
            chc1 = randomNum.charAt(0);
            chc2 = randomNum.charAt(1);
            chc3 = randomNum.charAt(2);
            if (!(chc1==chc2 || chc1==chc3 || chc2==chc3)){
                break;
            }
        }

        return randomNum;
    }
    public void endBaseball(){
        System.out.println("게임을 새로 시작할려면 1, 종료하실려면 2를 입력해주세요");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println(num);
        System.out.println("++++++++++++++++");
        if(num.equals("1")){
            resulet=true;
            playGoing();
        }else{
            System.out.println("야구게임 끝!");
        }
    }
    public void baseballCheck(String checkNum ,String robotNum){
        int playNum1 =checkNum.charAt(0);
        int playNum2 =checkNum.charAt(1);
        int playNum3 =checkNum.charAt(2);
        int[] playNum = {playNum1 , playNum2,playNum3};

        int robotNum1 =robotNum.charAt(0);
        int robotNum2 =robotNum.charAt(1);
        int robotNum3 =robotNum.charAt(2);
        int[] com = {robotNum1 , robotNum2,robotNum3};
        for (int i=0; i<com.length; i++){
            for (int j=0; j<playNum.length; j++) {
                strikeBallUp(i , j ,playNum[i] ,com[j]);
            }
        }
        count++;
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임종료");
            resulet = false;
            count=0;
        }else if(strike ==0 && ball ==0){
            System.out.println( "낫싱");
        }else {
            System.out.println(strike + "스트라이크  " + ball + "볼" + "   횟수"+ count+ "번");
        }
        strike=0;
        ball=0;

    }
    public void strikeBallUp(int i , int j ,int playnum , int robotNum){
        if (playnum == robotNum && i == j){
            strike++;
        } else if (playnum == robotNum && i != j){
            ball++;
        }
    }
    public void playGoing(){
        String robotNum3 = startBaseball();
        while(resulet){
            String checkNum=numberInput();
            baseballCheck(checkNum , robotNum3);
        }
        endBaseball();
    }
}
