package playball.domain;

public class Computer {

    private final Balls balls;

    private Computer(Balls balls) {
        this.balls = balls;
    }

    public static Computer of(Balls balls) {
        return new Computer(balls);
    }

    public Balls getBalls() {
        return balls;
    }
}
