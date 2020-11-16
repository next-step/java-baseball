package com.netxstep.baseball;

import com.netxstep.baseball.domain.Result;

import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {

        System.out.println("야구 게임" + "\n" + "3자리의 정수를 입력해주세요. (10회 입력 가능)");

        Scanner sc = new Scanner(System.in);
        String inputValue = null;

        BaseBall baseBall = new BaseBall();
        baseBall.generateAnswer();

        while (baseBall.getInputList().size() != 10) {

            System.out.print("\n" + String.format("[%s] 사용자 입력: ", baseBall.getInputList().size() + 1));

            inputValue = sc.nextLine();

            try {
                baseBall.inputAnswer(inputValue);

                Result result = baseBall.check();
                System.out.println(baseBall.print(result));

                if (result.getStrike() == 3) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("메시지: " + e.getMessage());
            }
        }

        System.out.println("\n");

        if (baseBall.getInputList().size() == 10 && baseBall.check().getStrike() != 3) {
            System.out.println(String.format("게임 횟수가 초과되었습니다. (정답: %s)", baseBall.getAnswer()));
        }

        System.out.println("게임이 종료되었습니다.");
    }
}
