package baseballgame;

public class StrikeChecker {
    public Integer check(RandomNumber random, InputNumber input) {
        int result = 0;
        if(random.firstNumber.equals(input.firstNumber)) result ++;
        if(random.secondNumber.equals(input.secondNumber)) result ++;
        if(random.thirdNumber.equals(input.thirdNumber)) result ++;

        return result;
    }
}
