package domain;

public class Pitching {

    private int pitchingSequence;
    private int pitchingNumber;

    private Pitching() {
    }

    private Pitching(int pitchingSequence, int pitchingNumber) {
        this.pitchingSequence = pitchingSequence;
        this.pitchingNumber = pitchingNumber;
    }

    public static Pitching create(int pitchingSequence, int pitchingNumber) {
        return new Pitching(pitchingSequence, pitchingNumber);
    }

    public int pitching() {
        return pitchingNumber;
    }

    public int pitchingSequence() {
        return pitchingSequence;
    }
}
