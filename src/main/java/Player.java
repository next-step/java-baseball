
public class Player {
    enum Status {
        READY, PLAYING, ANSWER_CORRECTLY, EXIT
    }

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private Status status;

    public Player() {
        this.status = Status.READY;
    }

    public boolean isReady() {
        return status == Status.READY;
    }

    public boolean playing() {
        return status == Status.PLAYING;
    }

    public boolean notSelected() {
        return status == Status.ANSWER_CORRECTLY;
    }

    public void play() {
        status = Status.PLAYING;
    }

    public void changeStatusIfSuccess(Result result) {
        if (result.isSuccess()) {
            status = Status.ANSWER_CORRECTLY;
        }
    }

    public void restartOrExit(String choice) {
        if (RESTART.equals(choice)) {
            status = Status.READY;
        }

        if (EXIT.equals(choice)) {
            status = Status.EXIT;
        }
    }
}
