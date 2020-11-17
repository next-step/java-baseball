package baseball.domain;

/**
 * 야구 게임에서 상대방을 의미한다.
 * 상대방은 정답을 생성하기 위해 숫자를 선택하고, 힌트를 제공한다.
 *
 * @author  Yonggu Han
 */
public interface Adversary {
    Number chooseNumber();
    Hint getHint(Number number);
}
