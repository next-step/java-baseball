package com.bbidag.baseball;

import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args){
    }

    public void printStrikeBallOrNothing(Referee referee){
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

    public int[] inputThreeDigits(){
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

    public boolean inputExitOrNot(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String exitStr = scan.nextLine();
        int exitFlag = Integer.parseInt(exitStr);
        if(exitFlag == 1){
            return false;
        }
        if(exitFlag == 2){
            return true;
        }
        return false;
    }

}
