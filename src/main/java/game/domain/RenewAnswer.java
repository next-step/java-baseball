package game.domain;

import java.util.Objects;

public class RenewAnswer {

    private int answer = 0;
    private static final int EXIT = 2;
    private static final int RENEW = 1;

    public RenewAnswer(String answer) throws IllegalArgumentException {
        validateAnswer(answer);
        this.answer = Integer.parseInt(answer);
    }

    public RenewAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isExit() {
        return answer == EXIT;
    }

    private void validateAnswer(String answer) throws IllegalArgumentException {
        int input = Integer.parseInt(answer);
        if (input != EXIT && input != RENEW) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RenewAnswer that = (RenewAnswer) o;
        return answer == that.answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}
