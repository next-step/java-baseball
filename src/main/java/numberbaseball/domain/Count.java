package numberbaseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Count {

  STRIKE(true),
  BALL(false),
  NOTHING(null);

  private static final Map<Boolean, Count> VALUES_MAP;

  static {
    VALUES_MAP = new HashMap<>();
    for(Count current : values()) {
      VALUES_MAP.put(current.matchStatus, current);
    }
  }

  private final Boolean matchStatus;

  Count(Boolean matchStatus) {
    this.matchStatus = matchStatus;
  }

  public static Count retrieveMatchCountScore(Boolean matchStatus) {
    return Optional.ofNullable(VALUES_MAP.get(matchStatus))
                    .orElse(NOTHING);
  }
}
