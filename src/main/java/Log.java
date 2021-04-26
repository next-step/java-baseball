public enum Log {
    REQUEST_ANSWER("숫자를 입력해주세요 : "),
    INVALID_ANSWER_SIZE("숫자의 크기가 일치하지 않습니다.\n%d 자리의 숫자를 입력해주세요\n"),
    INPUT_ERROR("입력 오류 발생"),

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
}