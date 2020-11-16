package view;

import model.domain.Record;

public class OutputView {
    private static final int ZERO = 0;
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE_MESSAGE = " 스트라이크 ";
    private static final String BALL_MESSAGE = " 볼 ";
    private static final String NOT_THING_MESSAGE = " 낫싱 ";

    private OutputView() {
    }

    public static void printRecord(Record record) {
        System.out.println(recordToString(record));
    }

    private static String recordToString(Record record) {
        StringBuilder recordString = new StringBuilder();

        if (record.isWin()) {
            recordString.append(END_MESSAGE);
        }

        if (record.isNotThing()) {
            recordString.append(NOT_THING_MESSAGE);
        }

        if (record.getStrikeCount() > ZERO) {
            recordString.append(record.getStrikeCount()).append(STRIKE_MESSAGE);
        }

        if (record.getBallCount() > ZERO) {
            recordString.append(record.getBallCount()).append(BALL_MESSAGE);
        }

        return recordString.toString();
    }
}
