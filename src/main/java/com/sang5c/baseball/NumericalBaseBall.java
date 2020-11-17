package com.sang5c.baseball;

import java.util.*;

public class NumericalBaseBall {

    public static void main(String[] args) {
        while (true) {
            // 서로 다른 1~9 랜덤 숫자 세개 출력 -> 입력받았다고 생각하기.
            // Random random = new Random();

            // String computer = scanner.nextLine();
            String computer = "146";
            Numbers question = Numbers.of(computer);
            System.out.println("question : " + question);

            startUserInteraction(question);
            String userContinueInput = getInputToContinue();
            if ("exit".equalsIgnoreCase(userContinueInput)) {
                break;
            }
        }
    }

    private static String getInputToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계속하려면 엔터, 그만하려면 exit 입력");
        return scanner.nextLine();
    }

    private static void startUserInteraction(Numbers question) {
        Count count;
        do {
            String userInput = getUserNumbersInput();
            Numbers userNumbers = Numbers.of(userInput);

            count = question.compare(userNumbers);
            printCount(count);
        } while (!count.isThreeStrike());
    }

    private static String getUserNumbersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    private static void printCount(Count count) {
        if (count.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        printStrikeCount(count);
        printBallCount(count);
        System.out.println();
    }

    private static void printBallCount(Count count) {
        if (count.getBallCount() != 0) {
            System.out.print(count.getBallCount() + "볼");
        }
    }

    private static void printStrikeCount(Count count) {
        if (count.getStrikeCount() != 0) {
            System.out.print(count.getStrikeCount() + " 스트라이크 ");
        }
    }

    private static Set<String> generateNumbersOfString(String str) {
        String[] split = str.split("");
        Set<String> set = new LinkedHashSet<>(Arrays.asList(split.clone()));
        if (set.size() != 3) {
            throw new IllegalArgumentException("check input");
        }
        return set;
    }

    private static int generateRandomNumber(Random random) {
        return random.nextInt(9) + 1;
    }

}
