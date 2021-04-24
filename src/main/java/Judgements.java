public enum Judgements {

    STRIKE('S'),
    BALL('B');

    private final char judgement;

    Judgements(char judgement) {
        this.judgement = judgement;
    }

    public char getJudgement() {
        return judgement;
    }
}
