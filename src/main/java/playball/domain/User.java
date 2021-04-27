package playball.domain;

public class User {

    private final Balls balls;

    private User(Balls balls) {
        this.balls = balls;
    }

    public static User of(Balls balls) {
        return new User(balls);
    }

    public Balls getBalls() {
        return balls;
    }
}
