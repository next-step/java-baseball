/**
 * 숫자야구게임 심판 유틸리티 클래스.
 * - 판정을 한다.
 * - TODO: 판정 결과를 말한다(인간의 말로 변환한다).
 */
public final class Judge {

    /**
     * 숫자야구게임 판정 메서드. 두개의 int[3] 배열을 받아서 각 자리의 원소가 일치하는 경우 스트라이크, 자리는 다르지만 같은 수인
     * 경우 볼의 카운트를 올려서 그 결과를 int[2]{스트라이크수, 볼수}로 반환한다.
     *
     * @param numbers1 int[3] 배열, 각 정수는 1~9의 수이다.
     * @param numbers2 int[3] 배열, 각 정수는 1~9의 수이다.
     * @return int[2]인 배열, 판정 결과를 담은 것으로 [0]은 스트라이크 수, [1]은 볼의 수이다.
     */
    public static int[] judge(int[] numbers1, int[] numbers2) {
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

    private Judge() {}
}
