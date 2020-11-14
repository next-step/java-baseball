package domain;

public class Check {
    private int st;
    private int ball;
    private String[] com;
    private String[] me;

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

    public Check invoke() {
        String[] com_nan_st = com;
        String[] me_nan_st = me;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (result(com_nan_st[i], me_nan_st[j], i, j)) break;
            }
        }
        return this;
    }

    private boolean result(String s, String anObject, int i, int j) {
        if(s.equals(anObject)){
            if(i == j){
                st += 1;
                return true;
            }else if(i != j){
                ball += 1;
            }
        }
        return false;
    }
}
