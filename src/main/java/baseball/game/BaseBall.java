package baseball.game;

public class BaseBall {

    private final String result;

    public BaseBall(String result) {
        this.result = result;
    }
    
    public boolean play(String inputValue) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == inputValue.charAt(i)){
                strike++;
            } else if (result.equals(inputValue.charAt(i)+"")) {
                ball++;
            }
        }

        return strike >= 3;
    }
}
