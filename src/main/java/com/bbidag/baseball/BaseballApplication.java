package com.bbidag.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args){
        boolean isContinueGame = true;
        while(isContinueGame){
            Computer computer = new Computer(new Random(System.currentTimeMillis()));
            Referee referee = new Referee(computer);
            referee.generateRandomNumberOfComputer();
            playGame(referee);
            isContinueGame = inputContinueOrNot();
        }
    }

    public static void playGame(Referee referee){
        boolean isNotEnd = true;
        while(isNotEnd){
            referee.setStrikeCount(0);
            referee.setBallCount(0);
            referee.calculateStrikeBall(inputThreeDigits());
            printStrikeBallOrNothing(referee);
            isNotEnd = !referee.isWinGame();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printStrikeBallOrNothing(Referee referee){
        if(referee.getStrikeCount() > 0){
            System.out.print(referee.getStrikeCount() + "스트라이크 ");
        }
        if(referee.getBallCount() > 0){
            System.out.print(referee.getBallCount() + "볼");
        }
        if(referee.isNothing()){
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static int[] inputThreeDigits(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        String[] args = scan.nextLine().split("");
        int[] numbers = new int[3];
        int idx = 0;
        for(String numStr : args){
            numbers[idx++] = Integer.parseInt(numStr);
        }
        return numbers;
    }

    public static boolean inputContinueOrNot(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String exitStr = scan.nextLine();
        int exitFlag = Integer.parseInt(exitStr);
        return exitFlag == 1 ? true : false;
    }

}
