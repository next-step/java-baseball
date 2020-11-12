package domain;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임에서 사용되는 숫자
 **/
public class BaseballNumber {
    private int value;

    public BaseballNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
