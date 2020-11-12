package com.sang5c.baseball;

import java.util.Random;
import java.util.Scanner;

public class NumericalBaseBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 서로 다른 1~9 랜덤 숫자 세개 출력
            Random random = new Random();

            // 중복제거, 캐싱, 3자리
            StringBuilder questionBuilder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                while (true) {
                    String number = String.valueOf(generateRandomNumber(random));
                    if (questionBuilder.indexOf(number) == -1) {
                        questionBuilder.append(number);
                        break;
                    }
                }
            }
            String question = questionBuilder.toString();
            System.out.println("question : " + question);

            while (true) {
                String userInput = scanner.nextLine();  // 3자리 숫자, 중복
                System.out.println("user input : " + userInput);

                // 카운트가 있어야 한다.
                int ballCount = 0;
                int strikeCount = 0;
                String result = "";
                // 둘다 0일 경우 낫싱을 리턴.

                String[] inputs = userInput.split("");
                for (int i = 0; i < inputs.length; i++) {
                    if (!question.contains(inputs[i])) {
                        continue;
                    }

                    if (question.indexOf(inputs[i]) == i) {
                        strikeCount++;
                        continue;
                    }

                    ballCount++;
                }

                if (ballCount != 0) {
                    result += ballCount + "볼";
                }
                if (strikeCount != 0) {
                    result += strikeCount + "스트라이크";
                }
                System.out.println("result : " + (result.length() != 0 ? result : "낫싱"));
                if (strikeCount == 3) {
                    break;
                }
            }
            System.out.println("계속하려면 엔터, 그만하려면 exit 입력");
            String userContinueInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userContinueInput)) {
                break;
            }
        }


    }

    private static int generateRandomNumber(Random random) {
        return random.nextInt(9) + 1;
    }

}
