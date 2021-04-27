package baseball.view;

import baseball.domain.PitchingResultStatus;
import baseball.domain.dto.BaseballResultResponse;

import java.util.Map;
import java.util.Objects;

public class BaseballResultView implements ResultView {
    private static final ResultView instance = new BaseballResultView();

    public static final String ALERT_ALL_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ALERT_ALL_NOTHING = "낫싱";
    public static final String FORMAT = "%d %s ";
    public static final int DEFAULT_VALUE = 0;
    public static final String EMPTY_STR = "";

    private final StringBuilder sb;

    private BaseballResultView() {
        sb = new StringBuilder();
    }

    public static ResultView getInstance() {
        return instance;
    }

    @Override
    public void showPitchingResult(BaseballResultResponse response) {
        Map<PitchingResultStatus, Integer> pitchingResultMap = response.getPitchingResult();

        appendPitchingResult(pitchingResultMap);
        appendAllMatchedResult(response);

        System.out.print(sb);
        clearConsole();
    }

    private void appendPitchingResult(Map<PitchingResultStatus, Integer> pitchingResultMap) {
        for (PitchingResultStatus status : PitchingResultStatus.values()) {
            int count = pitchingResultMap.getOrDefault(status, DEFAULT_VALUE);
            appendPitchStatusAndCount(status, count);
        }
        if (!Objects.equals(sb.toString(), EMPTY_STR)) {
            appendSeparator();
        }
    }

    private void appendSeparator() {
        sb.append(System.lineSeparator());
    }


    private void appendAllMatchedResult(BaseballResultResponse response) {
        if (response.isAllStrike()) {
            sb.append(ALERT_ALL_STRIKE);
        }
        if (response.isNothing()) {
            sb.append(ALERT_ALL_NOTHING);
        }
        appendSeparator();
    }

    private void clearConsole() {
        sb.replace(0, sb.length(), EMPTY_STR);
    }

    private void appendPitchStatusAndCount(PitchingResultStatus status, int count) {
        if (checkPossibleAppend(status, count)) {
            String format = String.format(FORMAT, count, status.name());
            sb.append(format);
        }
    }

    private boolean checkPossibleAppend(PitchingResultStatus status, int count) {
        return !Objects.equals(status, PitchingResultStatus.NOTHING) && count > 0;
    }
}
