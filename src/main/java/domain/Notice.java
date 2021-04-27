package domain;

public enum Notice {
    START_BETTING("숫자를 입력해주세요 : "),
    NOTICE_WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ASK_CONTINUE_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private String description;

    Notice(String description) {
        this.description = description;
    }

    public void print() {
        System.out.print(description);
    }
}
