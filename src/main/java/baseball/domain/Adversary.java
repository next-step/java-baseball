package baseball.domain;

public interface Adversary {
    Number chooseNumber();
    Hint getHint(Number number);
}
