package baseball.dto;

public class Request {
    private final int number;

    public Request(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
