package baseball.validate;

public class BaseBallThreeNumberValidate implements BaseBallValidate {
    @Override
    public boolean valid(int[] number) {
        if (number.length == 3) {
            return true;
        }

        return false;
    }
}
