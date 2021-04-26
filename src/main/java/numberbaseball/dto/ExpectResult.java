package numberbaseball.dto;

import numberbaseball.domain.Count;
import numberbaseball.domain.CountScore;

import java.util.Map;
import java.util.Objects;

public class ExpectResult {

  private static final String MESSAGE_FORMAT = "%d %s";
  private static final String NOTHING_MESSAGE = "낫싱";
  private static final String SPACE = " ";

  private final String message;

  public ExpectResult(CountScore countScore) {
    this.message = buildMessage(countScore);
  }

  private String buildMessage(CountScore countScore) {
    Map<Count, Integer> countAndScore = countScore.getCountAndScore();
    if(countAndScore.isEmpty()) {
      return NOTHING_MESSAGE;
    }
    return formatMessage(countAndScore);
  }

  private String formatMessage(Map<Count, Integer> countAndScore) {
    StringBuilder messageBuilder = new StringBuilder();
    for (Map.Entry<Count, Integer> resultEntry : countAndScore.entrySet()) {
      Count resultKey = resultEntry.getKey();
      Integer resultScore = resultEntry.getValue();
      messageBuilder.append(String.format(MESSAGE_FORMAT, resultScore, resultKey.getKorName()));
      messageBuilder.append(SPACE);
    }
    return messageBuilder.toString();
  }

  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExpectResult that = (ExpectResult) o;
    return message.equals(that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }
}
