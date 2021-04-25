package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTests {

    private static String bets;
    private static short ballCount;
    private static short strikeCount;

    @DisplayName("1부터 9까지 서로 다른 3자리 숫자를 출력")
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void 타격_추출(int bettingCount) {
        bets = "";
        bets = betting(bettingCount);

        System.out.println(bets);

        assertThat(bets).matches(Pattern.compile("[1-9]\\d\\d")); // 1부터 9까지 3자리 숫자인지 확인
        assertThat(checkDuplicatedCharacters()).isTrue(); // 중복문자 체크
    }

    /**
     * 타격(랜덤번호) 추출
     *
     * @param pitchingCount
     * @return 1부터 9까지 서로 다른 3자리 숫자를 출력
     */
    private String betting(int pitchingCount) {
        while (bets.length() < pitchingCount) {
            String random = String.valueOf(Math.round(Math.random() * 8 + 1));

            if (!bets.contains(random)) {
                bets += random;
                return betting(pitchingCount);
            }
        }

        return bets;
    }

    /**
     * 중복문자 체크
     *
     * @return 중복여부 반환
     */
    private static boolean checkDuplicatedCharacters() {
        boolean hasDuplicated = true;

        for (int j = bets.length() - 1; j > 0; j--) {
            int foundIndex = bets.substring(0, j).indexOf(bets.charAt(j));

            if (foundIndex > -1) {
                hasDuplicated = false;
                break;
            }
        }

        return hasDuplicated;
    }

    @DisplayName("게임결과 - 1스트라이크 1볼 결과")
    @ParameterizedTest
    @CsvSource(value = "123", delimiter = ':')
    public void 게임_1스트라이크1볼(String pitches) {
        BaseballTests.bets = "134";
        ballCount = 0; // 볼 카운트 초기화
        strikeCount = 0; // 스트라이크 카운트 초기화
        judge(pitches, BaseballTests.bets); // 투구

        String resultMessage = String.format("Ball: %d, Strike: %d", ballCount, strikeCount);
        System.out.println(resultMessage);

        assertThat(ballCount).isEqualTo((short) 1);
        assertThat(strikeCount).isEqualTo((short) 1);
    }

    @DisplayName("게임결과 - 3스트라이크 결과")
    @ParameterizedTest
    @CsvSource(value = "123", delimiter = ':')
    public void 게임_3스트라이크결과(String pitches) {
        String bets = "123";
        ballCount = 0; // 볼 카운트 초기화
        strikeCount = 0; // 스트라이크 카운트 초기화
        judge(pitches, bets); // 투구

        String resultMessage = String.format("Ball: %d, Strike: %d", ballCount, strikeCount);
        System.out.println(resultMessage);

        assertThat(strikeCount).isEqualTo((short) pitches.length());
    }

    /**
     * 심판 판단
     *
     * @param pitches
     * @param bets
     */
    private static void judge(String pitches, String bets) {
        for (int i = pitches.length() - 1; i >= 0; i--) {
            if (isStrikeZone(pitches, bets, i)) { // 스트라이크 판단
                strikeCount++;
                continue;
            }

            if (isBallZone(pitches, bets, i)) { // 볼 판단
                ballCount++;
            }
        }
    }

    /**
     * 스트라이크 판단
     *
     * @param pitches
     * @param bets
     * @param i
     * @return
     */
    private static boolean isStrikeZone(String pitches, String bets, int i) {
        return pitches.charAt(i) == bets.charAt(i);
    }

    /**
     * 볼인지 판단
     *
     * @param pitches
     * @param bets
     * @param i
     */
    private static boolean isBallZone(String pitches, String bets, int i) {
        for (int j = 0; j < bets.length(); j++) {
            if (pitches.charAt(i) == bets.charAt(j)) {
                return true;
            }
        }

        return false;
    }

}
