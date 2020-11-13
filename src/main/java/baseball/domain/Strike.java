package baseball.domain;

public class Strike {

    private final int strike;

    private Strike(int strike){

        if(strike < 0 || strike > 3){
            throw new IllegalArgumentException();
        }
        this.strike = strike;
    }
}
