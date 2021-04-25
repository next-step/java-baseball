package numberbaseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static numberbaseball.domain.Count.NOTHING;
import static org.assertj.core.api.Assertions.assertThat;

class CountTest {

  @DisplayName("Boolean이 true면 STRIKE, false면 BALL 반환")
  @CsvSource(value = {"true:STRIKE", "false:BALL"}, delimiter = ':')
  @ParameterizedTest
  void testRetrieveMatchCountScore(Boolean matchStatus, Count count) {
    assertThat(Count.retrieveMatchCountScore(matchStatus)).isEqualTo(count);
  }

  @DisplayName("Boolean이 null로 들어오면 NOTHING 반환")
  @NullSource
  @ParameterizedTest
  void testNullParameterRetrieveMatchCountScore(Boolean matchStatus) {
    assertThat(Count.retrieveMatchCountScore(matchStatus)).isEqualTo(NOTHING);
  }

}
