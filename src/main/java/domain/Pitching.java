package domain;

public class Pitching {

    private int pitchingSequence;
    private int pitchingNumber;

    public Pitching(int pitchingSequence, int pitchingNumber) {
        this.pitchingSequence = pitchingSequence;
        this.pitchingNumber = pitchingNumber;
    }

    public int pitching() {
        return pitchingNumber;
    }

    public int pitchingSequence() {
        return pitchingSequence;
    }
}
