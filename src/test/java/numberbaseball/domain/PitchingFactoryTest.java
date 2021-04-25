package numberbaseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PitchingFactoryTest {

  @ValueSource(ints = {3,4,5})
  @ParameterizedTest
  void generateGivenCountPitchingTest(int given) {
    List<Pitching> pitchings = PitchingFactory.generateGivenCountPitching(given);
    assertThat(pitchings.size()).isEqualTo(given);
  }

}
