/**
 * 숫자야구게임 심판 유틸리티 클래스.
 * - 판정을 한다.
 * - 판정을 말한다.
 */
final class Judge {

    static final String STRIKE_OUT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    static final String NOTHING = "낫싱";
    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";
    static final String EMPTY = "";

    private Judge() {}

    /**
     * 숫자야구게임 판정 메서드. 두개의 int[3] 배열을 받아서 각 자리의 원소가 일치하는 경우 스트라이크, 자리는 다르지만 같은 수인
     * 경우 볼의 카운트를 올려서 그 결과를 int[2]{스트라이크수, 볼수}로 반환한다.
     *
     * @param numbers1 int[3] 배열, 각 정수는 1~9의 수이다.
     * @param numbers2 int[3] 배열, 각 정수는 1~9의 수이다.
     * @return int[2]인 배열, 판정 결과를 담은 것으로 [0]은 스트라이크 수, [1]은 볼의 수이다.
     */
    static int[] judge(int[] numbers1, int[] numbers2) {
        final int[] result = {0, 0};
        // 스트라이크 수 카운트
        result[0] += numbers1[0] == numbers2[0] ? 1 : 0;
        result[0] += numbers1[1] == numbers2[1] ? 1 : 0;
        result[0] += numbers1[2] == numbers2[2] ? 1 : 0;
        // 볼 수 카운트
        result[1] += numbers1[0] == numbers2[1] ? 1 : 0;
        result[1] += numbers1[0] == numbers2[2] ? 1 : 0;
        result[1] += numbers1[1] == numbers2[0] ? 1 : 0;
        result[1] += numbers1[1] == numbers2[2] ? 1 : 0;
        result[1] += numbers1[2] == numbers2[0] ? 1 : 0;
        result[1] += numbers1[2] == numbers2[1] ? 1 : 0;
        return result;
    }

    /**
     * 심판이 판정을 말하다. 판정결과 숫자 배열을 사용자에게 보여줄 문자열로 변환한다.
     *
     * @param judge 판정결과 정수 배열. [0]번째 원소는 스트라이크 수, [1]번째 원소는 볼의 수이다.
     * @return 판정결과 문자열
     */
    static String speak(int[] judge) {
        if (judge[0] == 3) {
            return STRIKE_OUT;
        }
        if (judge[0] == 0 && judge[1] == 0) {
            return NOTHING;
        }
        return (judge[0] == 0 ? EMPTY : judge[0] + STRIKE) + (judge[1] == 0 ? EMPTY : judge[1] + BALL);
    }
}
