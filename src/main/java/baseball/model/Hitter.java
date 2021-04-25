package baseball.model;

public class Hitter {

    private String bets;

    public Hitter() {
        bets = "";
    }

    /**
     * 타격(랜덤번호) 추출
     *
     * @param bettingCount
     * @return 1부터 9까지 서로 다른 3자리 숫자를 출력
     */
    public String betting(int bettingCount) {
        while (bets.length() < bettingCount) {
            String random = String.valueOf(Math.round(Math.random() * 8 + 1));

            if (!bets.contains(random)) {
                bets += random;
                return betting(bettingCount);
            }
        }

        return bets;
    }

    /**
     * 타격결과 반환
     *
     * @return
     */
    public String getBets() {
        return bets;
    }

}
