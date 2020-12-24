public class Result {
    public int strikeCounts;
    public int ballCounts;

    Result(int s, int b) {
        this.strikeCounts = s;
        this.ballCounts = b;
    }

    public boolean equals(Result o) {
        return strikeCounts == o.strikeCounts && ballCounts == o.ballCounts;
    }
}
