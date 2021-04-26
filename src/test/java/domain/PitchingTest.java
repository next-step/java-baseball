package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PitchingTest {

    @DisplayName("Pitching 객체 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:7", "3:3"}, delimiter = ':')
    void createPitchingObject(int sequence, int pitchingNumber) {
        Pitching pitching = Pitching.create(sequence, pitchingNumber);
        assertThat(sequence).isEqualTo(pitching.pitchingSequence());
        assertThat(pitchingNumber).isEqualTo(pitching.pitching());
    }
}
