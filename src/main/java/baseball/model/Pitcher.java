package baseball.model;

import baseball.util.Util;

public class Pitcher {

    private final String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private final String INVALID_INPUT_VALUES_ALERT_MESSAGE = "잘못된 입력입니다.";

    private short maxPitchingCount; // 최대 투구수
    private String pitches; // 투구결과

    public Pitcher(short maxPitchingCount) {
        this.maxPitchingCount = maxPitchingCount;
    }

    /**
     * 투구
     */
    public void pitching() {
        pitches = Util.input(NUMBER_INPUT_REQUEST_MESSAGE); // 사용자 입력

        if (isInvalidInputValues()) {
            System.out.println(INVALID_INPUT_VALUES_ALERT_MESSAGE);
            pitching();
        }
    }

    /**
     * 입력한 문자 유효성 검사
     *
     * @return
     */
    private boolean isInvalidInputValues() {
        return pitches.length() > maxPitchingCount || !pitches.matches("[1-9]\\d\\d") || !checkDuplicatedCharacters();
    }

    /**
     * 중복문자 체크
     *
     * @return 중복여부 반환
     */
    private boolean checkDuplicatedCharacters() {
        boolean hasDuplicated = true;

        for (int j = pitches.length() - 1; j > 0; j--) {
            int foundIndex = pitches.substring(0, j).indexOf(pitches.charAt(j));

            if (foundIndex > -1) {
                hasDuplicated = false;
                break;
            }
        }

        return hasDuplicated;
    }

    /**
     * 투구결과 반환
     *
     * @return
     */
    public String getPitches() {
        return pitches;
    }

}
