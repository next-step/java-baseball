package com.wootechcamp.precourse.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    private Scanner scan;

    BaseBallGame(){
        scan = new Scanner(System.in);
    }

    public void gameStart() {
        System.out.println("start!");

        while (true){

            int answer = getAnswer();
            System.out.println("random :" + answer);

            getInputNumber();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int onOff = scan.nextInt();
            if(onOff == 2) {
                break;
            }
        }
    }

    public int getInputNumber(){
        System.out.print("숫자를 입력해 주세요 : ");

        int input = -1;
        while (true) {
            if(!scan.hasNextInt()){
                scan.next();
                System.out.print("숫자가 아닙니다. \n재 선택 : ");
                continue;
            }

            input = scan.nextInt();
            if(!isThreeDigit(input)){
                System.out.print("세자리 숫자를 입력해주세요. \n재 선택 : ");
                continue;
            }

            if(!isDifferentDigit(input)){
                System.out.print("각 자리수가 다른 세자리 숫자를 입력하세요. \n재 선택 : ");
                continue;
            }

            return input;
        }
    }

    public boolean isThreeDigit(int input){
        if(input >= 100 && input < 1000){
            return true;
        }
        return false;
    }

    public boolean isDifferentDigit(int input){
        int first = input / 100;
        int second = (input - (first * 100) )/ 10;
        int third = input - (first * 100) - (second * 10);

        if(first != second && second != third && first != third){
            return true;
        }

        return false;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        while(true){
            int result = random.nextInt(10);

            if(result != 0){
                return result;
            }
        }
    }

    public int getAnswer(){
        int first = generateRandomNumber();

        int second = -1;
        while(true){
            second = generateRandomNumber();
            if(first != second){
                break;
            }
        }

        int third = -1;
        while(true){
            third = generateRandomNumber();
            if(first != third && second != third){
                break;
            }
        }

        int result = first * 100 + second * 10 + third;

        return result;
    }

}
