public enum Log {
    REQUEST_ANSWER("숫자를 입력해주세요 : "),

    STRIKE("%d 스트라이크 "),
    BALL("%d 볼"),
    NOTHING("낫싱"),

    SUCCESS("%d 개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ASK_RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요."),
    ;

    private final String message;

    Log(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    }

    public void println() {
        System.out.println(message);
    }

    public void printFormat(int count) {
        System.out.printf(message, count);
    }

    /**
     * 스트라이크 또는 볼 출력
     * count 가 0 인 경우엔 출력하면 안되므로 printFormat 메소드랑 분리
     *
     * @param count     갯수
     */
    public void printCount(int count) {
        if (count == 0) {
            return;
        }

        System.out.printf(message, count);
    }

    /**
     * 결과값을 기반으로 성공 | 낫싱 | 스트라이크 | 볼 출력
     *
     * @param result    플레이어 값과 정답을 비교한 결과
     */
    public static void printResult(Result result) {
        if (result.isNothing()) {
            Log.NOTHING.println();
            return;
        }

        printResultCount(result);

        if (result.isSuccess()) {
            int strikeCount = result.getStrikeCount();
            Log.SUCCESS.printFormat(strikeCount);
        }
    }

    private static void printResultCount(Result result) {
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        Log.STRIKE.printCount(strikeCount);
        Log.BALL.printCount(ballCount);
        System.out.println();
    }
}