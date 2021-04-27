package com.wootechcamp.precourse.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private List answerList;
    private List inputList;

    private Scanner scan;

    BaseballGame(){
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("start!");

        while (true){

            int answer = getAnswer();
            System.out.println("random :" + answer);

            // 사용자로 부터 값 입력 받음
            int input = getInputNumber();

            // 비교 편의를 위해 int를 List로 변환
            setIntegerToList(answer,input);

            // 정답에 같은 숫자가 있으면 리턴
            List sameNumbers = getSameNumbers();
            int sameNumbersSize = sameNumbers.size();

            // 스트라이크 개수 계산, 존재하는 숫자가 위치까지 같은지 체크
            int strikeNum = getStrikeNum(sameNumbers);

            // 볼 개수 계산
            int ballNum = sameNumbersSize - strikeNum;

            // 결과 출력
            printResult(ballNum, strikeNum);

            // 다음 메뉴 선택
            int menuNum = getMenuNum();
            if(menuNum == 2){
                return;
            }
        }
    }

    public int getMenuNum() {

        int menuNum = -1;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if(!scan.hasNextInt()){
                scan.next();
                System.out.println("숫자가 아닙니다.");
                continue;
            }

            menuNum = scan.nextInt();
            if(isOneOrTwo(menuNum)){
                return menuNum;
            }
        }
    }


    public boolean isOneOrTwo(int input) {
        if(input == 1 || input == 2){
            return true;
        }
        return false;
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

    public void setIntegerToList(int answer, int input){
        String answerStr = Integer.toString(answer);
        String inputStr = Integer.toString(input);

        answerList = new ArrayList();
        inputList = new ArrayList();

        for (int i = 0; i < answerStr.length(); i++) {
            answerList.add(i,answerStr.charAt(i) - '0');
        }

        for (int i = 0; i < inputStr.length(); i++) {
            inputList.add(i, inputStr.charAt(i) - '0');
        }
    }

    public List getSameNumbers() {
        List result = new ArrayList<Integer>();

        for(int i = 0; i < answerList.size(); i++){
            if(inputList.contains(answerList.get(i))){
                result.add(answerList.get(i));
            }
        }

        return result;
    }

    public int getStrikeNum(List sameNumbers) {
        int result = 0;

        for(int i = 0; i < sameNumbers.size(); i++){
            int number = (int)sameNumbers.get(i);

            if(answerList.indexOf(number) == inputList.indexOf(number)){
                result++;
            }
        }

        return result;
    }

    public void printResult(int ballNum, int strikeNum){
        if(ballNum <= 0 && strikeNum <= 0){
            System.out.println("낫싱");
            return;
        }

        StringBuilder result = new StringBuilder();
        if(strikeNum > 0){
            result.append(strikeNum);
            result.append(" 스트라이크");
        }

        if(result.length() > 0 && ballNum > 0){
            result.append(", ");
        }

        if(ballNum > 0){
            result.append(ballNum);
            result.append(" 볼");
        }

        System.out.println(result);
    }
}
