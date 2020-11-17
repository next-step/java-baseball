package com.baseballgame.view;

import java.util.Map;
import java.util.Scanner;

public class BaseballGameView implements GameView{
    private Scanner sacnner;

    @Override
    public String initGame() {
        System.out.print("숫자를 입력해주세요. :");
        sacnner = new Scanner(System.in);
        String inputNumber = sacnner.nextLine();
        return inputNumber;
    }

    @Override
    public int exitGame() {
        String exitCode;
        do {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. :");
            sacnner = new Scanner(System.in);
            exitCode = sacnner.nextLine();
        } while (!("1".equals(exitCode) || "2".equals(exitCode)));
        return Integer.parseInt(exitCode);
    }

    @Override
    public String resultMessage(Map<String, Object> resultMap) {
        String massage = "";
        if(Integer.parseInt(resultMap.get("Strike").toString()) > 0) {
            massage += Integer.parseInt(resultMap.get("Strike").toString()) + " 스트라이크 ";
        }
        if(Integer.parseInt(resultMap.get("Ball").toString()) > 0) {
            massage += Integer.parseInt(resultMap.get("Ball").toString()) + " 볼 ";
        }
        return massage;
    }

}
