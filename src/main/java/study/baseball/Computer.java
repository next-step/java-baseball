package study.baseball;


import study.common.utils.NumberUtils;

/**
 * <p> 야구 게임 숫자 관련 클래스  </p>
 */
public class Computer {
    private static NumberUtils numberUtils = new NumberUtils();

    /**
     * <p> 범위 안에서 랜덤 함수 반환 메서드 </p>
     *
     * @return int
     */
    public static int generateBaseballNumber() {
        int number = numberUtils.nextInt();

        return number;
    }
}