package numberbaseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Count {

  STRIKE(true, "스트라이크"),
  BALL(false, "볼"),
  NOTHING(null, "낫싱");

  private static final Map<Boolean, Count> VALUES_MAP;

  static {
    VALUES_MAP = new HashMap<>();
    for(Count current : values()) {
      VALUES_MAP.put(current.matchStatus, current);
    }
  }

  private final Boolean matchStatus;
  private final String korName;

  Count(Boolean matchStatus, String korName) {
    this.matchStatus = matchStatus;
    this.korName = korName;
  }

  public static Count retrieveMatchCountScore(Boolean matchStatus) {
    return Optional.ofNullable(VALUES_MAP.get(matchStatus))
                    .orElse(NOTHING);
  }

  public String getKorName() {
    return korName;
  }
}
