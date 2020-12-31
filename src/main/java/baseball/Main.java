package baseball;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Baseball baseball = new Baseball();
        while(flag==true){
            baseball.checkScore(baseball.scanNumber());
            baseball.printScore();
            flag = baseball.restartSwitch(baseball.checkRestart());
        }
    }
}
