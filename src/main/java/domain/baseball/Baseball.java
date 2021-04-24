package domain.baseball;

import java.util.Objects;

public class Baseball {

    // Random으로 생성되는 값은 1~9
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final Long baseballValue;

    public Baseball(Long baseballValue) {
        //validation
        validateNumberValue(baseballValue);
        this.baseballValue = baseballValue;
    }

    // 플레이어가 입력한 값을 Validation 한다.
    public static void validateNumberValue(Long baseballNumber){
        if(!(MIN_VALUE <= baseballNumber && MAX_VALUE >= baseballNumber)){
            throw new IllegalArgumentException(String.format("야구 게임의 입력 숫자는 %d 에서 %d 까지를 입력해주세요.",MIN_VALUE,MAX_VALUE));
        }
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }

    public static Baseball valueOf(Long baseballNumber){
        return new Baseball(baseballNumber);
    }

    @Override
    public String toString(){
        return Long.toString(baseballValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Baseball baseball = (Baseball)obj;
        return baseballValue.equals(baseball.baseballValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballValue);
    }
}

