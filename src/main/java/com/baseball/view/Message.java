package com.baseball.view;

import com.baseball.domain.judgement.Judgement;

public class Message {

    public static void showInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void showJudgementMessage(Judgement judgement) {
        StringBuffer sb = new StringBuffer();
        if (judgement.getStrike() > 0) {
            sb.append(judgement.getStrike() + " 스트라이크 ");
        }
        if (judgement.getStrike() == 3) {
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
        if (judgement.getBall() > 0) {
            sb.append(judgement.getBall() + " 볼 ");
        }
        if (judgement.isNothing()) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }

    public static void selectGameOption() {
        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
    }
}
