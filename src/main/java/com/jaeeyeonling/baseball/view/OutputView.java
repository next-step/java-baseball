package com.jaeeyeonling.baseball.view;

import com.jaeeyeonling.baseball.Command;
import com.jaeeyeonling.baseball.ball.Balls;
import com.jaeeyeonling.baseball.referee.Judge;
import com.jaeeyeonling.baseball.referee.JudgeReport;

import java.io.PrintStream;

public final class OutputView implements AutoCloseable {

    private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENDING_MESSAGE = Balls.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료 ";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 " + Command.START + ", 종료하려면 " +
            Command.END + "를 입력하세요.";
    private static final String STRIKE = " 스트라이크 ";
    private static final String BALL = " 볼 ";
    private static final String NOTHING = " 낫싱 ";

    private final PrintStream out;

    private OutputView(final PrintStream out) {
        this.out = out;
    }

    public static OutputView ofSystem() {
        return of(System.out);
    }

    public static OutputView of(final PrintStream out) {
        return new OutputView(out);
    }

    public void printInputBalls() {
        print(INPUT_BALLS_MESSAGE);
    }

    public void printEnding() {
        println(ENDING_MESSAGE);
    }

    public void printRetry() {
        println(RETRY_MESSAGE);
    }

    public void println(final JudgeReport report) {
        final var builder = new StringBuilder();
        if (report.hasStrike()) {
            builder.append(report.getCount(Judge.STRIKE))
                    .append(STRIKE);
        }
        if (report.hasBall()) {
            builder.append(report.getCount(Judge.BALL))
                    .append(BALL);
        }
        if (report.isNothing()) {
            builder.append(NOTHING);
        }

        println(builder);
    }

    public void println(final Object value) {
        out.println(value);
    }

    public void print(final Object value) {
        out.print(value);
    }

    @Override
    public void close() {
        out.close();
    }
}
