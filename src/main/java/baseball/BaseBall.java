package baseball;

import java.util.Scanner;

public class BaseBall {
    Scanner sc = new Scanner(System.in);
    static int comNum1, comNum2, comNum3, userNum1, userNum2, userNum3;
    static String userNum;
    boolean stop, roundStop;

    void start(){
        stop = false;
        roundStop = false;

        while ( (setNum() == 0) || (zeroCheck() == 0));

        while(!roundStop){
            inputNum();
            check();
        }

    }

    int setNumTest(){
        while ( (setNum() == 0) || (zeroCheck() == 0));
        return comNum1*100 + comNum2*10 + comNum3;
    }

    int setNum(){
        comNum1 = (int)(Math.random()*10);
        comNum2 = (int)(Math.random()*10);
        comNum3 = (int)(Math.random()*10);

        if (comNum1 != comNum2 && comNum2 != comNum3 && comNum3 != comNum1) {
            return 1;
        }
        return 0;
    }

    int zeroCheck() {
        return comNum1 != 0 && comNum2 != 0 && comNum3 != 0 ? 1 : 0;
    }

    void inputNum(){
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

    private void check(){
        int strikeNum = 0;
        strikeNum += checkStrike(userNum1, comNum1);
        strikeNum += checkStrike(userNum2, comNum2);
        strikeNum += checkStrike(userNum3, comNum3);

        int ballNum = 0;
        ballNum += checkBall(userNum1, comNum2, comNum3);
        ballNum += checkBall(userNum2, comNum1, comNum3);
        ballNum += checkBall(userNum3, comNum1, comNum2);

        hint(strikeNum, ballNum);
    }

    int checkStrike(int user, int com){
        if (user == com){
            return 1;
        }
        return 0;
    }

    int checkBall(int user, int com1, int com2){
        if (user == com1 || user == com2){
            return 1;
        }
        return 0;
    }

    void hint(int strike, int ball){
        if (strike == 3){
            System.out.println(strike + " strike");
            success();
            return;
        }
        if (strike != 0 || ball != 0){
            System.out.println(strike + " strike " + ball + " ball");
            return;
        }
        System.out.println("Nothing");
    }

    void success(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임종료");
        roundStop = true;

        newGame();
    }

    void newGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int cont = sc.nextInt();

        if (cont == 1) return;
        if (cont == 2){
            stop = true;
            return;
        }
        newGame();
    }
}
