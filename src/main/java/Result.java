public class Result {
    private int strikeCounts;
    private int ballCounts;

    Result(int s, int b) {
        this.strikeCounts = s;
        this.ballCounts = b;
    }

    public void print() {
        int counts = 0;
        if (strikeCounts > 0) {
            System.out.print(strikeCounts + " 스트라이크 ");
            counts++;
        }
        if (ballCounts > 0) {
            System.out.print(ballCounts + "볼");
            counts++;
        }
        if (counts == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
    public boolean equals(Result o) {
        return strikeCounts == o.strikeCounts && ballCounts == o.ballCounts;
    }
}
