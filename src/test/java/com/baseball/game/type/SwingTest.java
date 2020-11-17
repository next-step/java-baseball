package com.baseball.game.type;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스윙 결과 테스트")
class SwingTest {
    private Pitcher pitcherBox;
    private Batter batterBox;

    @BeforeEach
    void init(){
        pitcherBox = Pitcher.create();
        Batter tempBat = Batter.create(214);
        pitcherBox.setNumberBox(tempBat.getNumberBox());
    }

    @ParameterizedTest
    @ValueSource(ints = {251})
    @DisplayName("스윙 결과 : 1스트라이크 1볼 1낫씽")
    void checkVariousResult(int numbers) {
        //given
        batterBox = Batter.create(numbers);

        //when && then
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @ParameterizedTest
    @ValueSource(ints = {458})
    @DisplayName("스윙 결과 : 1볼 2낫씽")
    void checkBallAndNothing(int numbers) {
        //given
        batterBox = Batter.create(numbers);

        //when && then
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.NOTHING);
    }

    @ParameterizedTest
    @ValueSource(ints = {421})
    @DisplayName("스윙 결과 : 3 볼")
    void checkThreeBall(int numbers) {
        //given
        batterBox = Batter.create(numbers);

        //when && then
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.BALL);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @ParameterizedTest
    @ValueSource(ints = {214})
    @DisplayName("스윙 결과 : 3 스트라이크")
    void checkThreeStrike(int numbers) {
        //given
        batterBox = Batter.create(numbers);

        //when && then
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.findSwingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.STRIKE);
    }
}