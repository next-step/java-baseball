package baseball;


import baseball.convert.BaseBallNumberConvert;
import baseball.generate.BaseBallNumberGenerator;
import baseball.match.BaseBallInningPlay;
import baseball.output.BaseBallInningOutput;
import baseball.validate.BaseBallThreeNumberValidate;

public class Main {
    public static void main(String[] args) {
        BaseBall baseball = new BaseBall(
                new BaseBallNumberGenerator(),
                new BaseBallInningPlay(),
                new BaseBallNumberConvert(),
                new BaseBallThreeNumberValidate(),
                new BaseBallInningOutput());
        baseball.start();
    }
}
