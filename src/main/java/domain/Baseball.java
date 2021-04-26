package domain;

import java.util.List;

public class Baseball {

  private BaseballNumbers baseballNumbers;

  public Baseball(BaseballNumbers baseballNumbers) {
    this.baseballNumbers = baseballNumbers;
  }

  public Baseball(String inputBaseball, BaseballTokenizer tokenizer) {
    List<Integer> token = tokenizer.tokenize(inputBaseball);
    this.baseballNumbers = BaseballNumbers.from(token);
  }

  public BaseballNumbers getBaseballNumbers() {
    return baseballNumbers;
  }
}
