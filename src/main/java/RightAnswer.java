public class RightAnswer {
    enum Status {
        WRONG, CORRECT
    }

    private final String number;
    private Status status;

    public RightAnswer(String number) {
        this.number = number;
        this.status = Status.WRONG;
    }

    public String getNumber() {
        return number;
    }

    public void setCorrect() {
        status = Status.CORRECT;
    }

    public boolean isCorrect() {
        return status == Status.CORRECT;
    }
}
