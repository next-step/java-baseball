package numberbaseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum CountScore {

  STRIKE(true),
  BALL(false),
  NOTHING(null);

  private static final Map<Boolean, CountScore> VALUES_MAP;

  static {
    VALUES_MAP = new HashMap<>();
    for(CountScore current : values()) {
      VALUES_MAP.put(current.matchStatus, current);
    }
  }

  private final Boolean matchStatus;

  CountScore(Boolean matchStatus) {
    this.matchStatus = matchStatus;
  }

  public static CountScore retrieveMatchCountScore(Boolean matchStatus) {
    return Optional.ofNullable(VALUES_MAP.get(matchStatus))
                    .orElse(NOTHING);
  }
}
