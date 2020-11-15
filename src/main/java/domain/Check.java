package domain;

public class Check {
    // 스트라이크
    private int st;
    // 볼
    private int ball;
    // 컴퓨터의 문자열
    private String[] com;
    // 사용자의 문자열
    private String[] me;
    // 분류가 끝났는지 체크
    private Boolean ch;

    public Check(int st, int ball, String com, String me) {
        this.st = st;
        this.ball = ball;
        this.com = com.split("");
        this.me = me.split("");
    }

    public int getSt() {
        return st;
    }

    public int getBall() {
        return ball;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String[] getCom() {
        return com;
    }

    public void setCom(String[] com) {
        this.com = com;
    }

    public String[] getMe() {
        return me;
    }

    public void setMe(String[] me) {
        this.me = me;
    }

    public Boolean getCh() {
        return ch;
    }

    public void setCh(Boolean ch) {
        this.ch = ch;
    }
}
