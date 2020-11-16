package com.jyjeong.baseball;

import java.util.Scanner;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    Hint hint = new Hint();

    /**
     * baseball 게임을 실행시키는 메소드
     * @return 재시작여부를 판단하는 메소드 호출
     */
    public boolean run(){
        int[] comNum = computer.computerNumber();
        int[] userNum;
        boolean Game;

        do{
            userNum = user.userNumber();
            Game = hint.hintCheck(hint.hint(comNum,userNum));
        } while(!Game);


        return isContinue();
    }

    /**
     * 게임의 재시작여부를 판단하는 메소드
     * @return true / false
     */
    public boolean isContinue(){
        Scanner scan = new Scanner(System.in);
        boolean check;
        String input;

        do{
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scan.nextLine();
            check = continueCheck(input);
        } while (!check);

        return input.equals("1");
    }

    private boolean continueCheck(String input){
        return input.equals("1") || input.equals("2");
    }
}
