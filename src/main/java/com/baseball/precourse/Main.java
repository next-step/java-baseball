package com.baseball.precourse;
import java.util.Scanner;

public class PlayBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 : ");

        String userInput = scanner.nextLine();
        System.out.println("Username is: " + userInput);
    }

}
