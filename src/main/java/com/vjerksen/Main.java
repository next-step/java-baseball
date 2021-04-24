package com.vjerksen;

public class Main {

    public static void main(String[] args) {
        Number number = new Number();

        String targetNum = number.getRandomNumber();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = number.getInputNumber();


    }
}
