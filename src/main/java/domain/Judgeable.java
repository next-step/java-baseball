package domain;

public interface Judgeable {

    JudgementCountPair addMatchCount(Numbers answer, Numbers input, JudgementCountPair hint, int index);
}
