package com.example.baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    private static final int MAX_NUMBER = 9;
    private final HashSet<Character> validNumberCharacterSet;

    public BaseballGame() {
        validNumberCharacterSet = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            validNumberCharacterSet.add(Character.forDigit(i, 10));
        }
    }

    public void start() {
        int[] randomNumbers = getRandomNumbers();
        int[] inputNumbers;

        do {
            String inputNumbersString = inputNumbersString();
            inputNumbers = convertNumbersStringToArray(inputNumbersString);
        } while (!compareNumbers(randomNumbers, inputNumbers));

        if ("1".equals(inputContinueMessage()))
            start();
    }

    public int[] getRandomNumbers() {
        Random r = new Random();

        int firstNumber = r.nextInt(MAX_NUMBER) + 1;
        int secondNumber = getSecondRandomNumber(r, firstNumber);
        int thirdNumber = getThirdRandomNumber(r, firstNumber, secondNumber);

        return new int[] {firstNumber, secondNumber, thirdNumber};
    }

    public int getSecondRandomNumber(Random r, int firstNumber) {
        int secondNumber;

        do {
            secondNumber = r.nextInt(MAX_NUMBER) + 1;
        } while (firstNumber == secondNumber);

        return secondNumber;
    }

    public int getThirdRandomNumber(Random r, int firstNumber, int secondNumber) {
        int thirdNumber;

        do {
            thirdNumber = r.nextInt(MAX_NUMBER) + 1;
        } while (firstNumber == thirdNumber || secondNumber == thirdNumber);

        return thirdNumber;
    }

    public String inputNumbersString() {
        String inputNumbers;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");
            inputNumbers = sc.nextLine();
        } while (!isValidInputNumbersString(inputNumbers));

        return inputNumbers;
    }

    public boolean isValidInputNumbersString(String numbersString) {
        return numbersString.length() == 3
                && validNumberCharacterSet.contains(numbersString.charAt(0))
                && validNumberCharacterSet.contains(numbersString.charAt(1))
                && validNumberCharacterSet.contains(numbersString.charAt(2))
                && numbersString.charAt(0) != numbersString.charAt(1)
                && numbersString.charAt(0) != numbersString.charAt(2)
                && numbersString.charAt(1) != numbersString.charAt(2);
    }

    public boolean compareNumbers(int[] randomNumbers, int[] inputNumbers) {
        int strikeCount = checkStrikeCount(randomNumbers, inputNumbers);
        int ballCount = checkBallCount(randomNumbers, inputNumbers);
        System.out.println(getCompareResultMessage(strikeCount, ballCount));

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public int checkStrikeCount(int[] randomNumbers, int[] inputNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            strikeCount += randomNumbers[i] == inputNumbers[i] ? 1 : 0;
        }

        return strikeCount;
    }

    public int checkBallCount(int[] randomNumbers, int[] inputNumbers) {
        int ballCount = 0;

        ballCount += inputNumbers[0] == randomNumbers[1] || inputNumbers[0] == randomNumbers[2] ? 1 : 0;
        ballCount += inputNumbers[1] == randomNumbers[0] || inputNumbers[1] == randomNumbers[2] ? 1 : 0;
        ballCount += inputNumbers[2] == randomNumbers[0] || inputNumbers[2] == randomNumbers[1] ? 1 : 0;

        return ballCount;
    }

    public String getCompareResultMessage(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (strikeCount > 0)
            sb.append(strikeCount).append(" 스트라이크 ");
        if (ballCount > 0)
            sb.append(ballCount).append("볼 ");
        if (strikeCount == 0 && ballCount == 0)
            sb.append("낫싱");

        return sb.toString().trim();
    }

    public int[] convertNumbersStringToArray(String inputNumbersString) {
        int number1 = Integer.parseInt(String.valueOf(inputNumbersString.charAt(0)));
        int number2 = Integer.parseInt(String.valueOf(inputNumbersString.charAt(1)));
        int number3 = Integer.parseInt(String.valueOf(inputNumbersString.charAt(2)));

        return new int[] {number1, number2, number3};
    }

    public String inputContinueMessage() {
        String inputContinueMessage;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputContinueMessage = sc.nextLine();
        } while (!isValidContinueMessage(inputContinueMessage));

        return inputContinueMessage;
    }

    public boolean isValidContinueMessage(String inputContinueMessage) {
        return "1".equals(inputContinueMessage)
                || "2".equals(inputContinueMessage);
    }
}
