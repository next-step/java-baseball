package baseball;


public class StartMain {

//        baseball.startBaseball();
//
//        baseball.playGoing();
//
//        baseball.endBaseball();
    public static void main(String[] args) {

        System.out.println("메인시작");
        new Baseball().startBaseball();
        new Baseball().playGoing();
        new Baseball().endBaseball();

    }

}