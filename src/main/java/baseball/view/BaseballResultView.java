package baseball.view;

import baseball.domain.PitchingResultStatus;
import baseball.domain.dto.BaseballResultResponse;

import java.util.Map;
import java.util.Objects;

public class BaseballResultView implements ResultView {
    private static final ResultView instance = new BaseballResultView();

    public static final String ALERT_ALL_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String FORMAT = "%d %s ";
    public static final int DEFAULT_VALUE = 0;
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

        for (PitchingResultStatus status : PitchingResultStatus.values()) {
            int count = pitchingResultMap.getOrDefault(status, DEFAULT_VALUE);
            appendPitchStatusAndCount(status, count);
        }
        sb.append(System.lineSeparator());

        if (response.isAllStrike()) {
            sb.append(ALERT_ALL_STRIKE).append(System.lineSeparator());
        }

        System.out.println(sb);
        clearConsole();
    }

    private void clearConsole() {
        sb.replace(0, sb.length() - 1, "");
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
