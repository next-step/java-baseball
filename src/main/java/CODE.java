public enum CODE {
    STRIKE(1),
    BALL(2),
    ZERO(0),
    SUCCESS(1),
    FAIL(0);
    int value;

    CODE(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
