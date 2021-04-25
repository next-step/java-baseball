package com.github.momentjin.ui;

import com.github.momentjin.model.BaseballNumberMatchResult;

public class BaseballGameResultPrinter {

    public void printResult(BaseballNumberMatchResult result) {

        if (result.hasError()) {
            System.out.println(result.getErrorMessage());
            return;
        }

        if (result.isMatch()) {
            System.out.println("정답입니다!");
            return;
        }

        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(result.getStrikeCount() + "S " + result.getBallCount() + "B");
    }
}
