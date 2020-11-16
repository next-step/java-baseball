package com.baseball.game.type;

import com.baseball.game.service.NumberBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스윙 결과 테스트")
class SwingTest {
    private NumberBox pitcherBox;
    private NumberBox batterBox;

    @BeforeEach
    void init() {

    }

    @Test
    @DisplayName("스윙 결과 : 1스트라이크 1볼 1낫씽")
    void checkVariousResult() {
        //given
        pitcherBox = NumberBox.generate(284);
        batterBox = NumberBox.generate(258);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @Test
    @DisplayName("스윙 결과 : 1볼 2낫씽")
    void checkSwingResult() {
        //given
        pitcherBox = NumberBox.generate(214);
        batterBox = NumberBox.generate(458);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.NOTHING);
    }

    @Test
    @DisplayName("스윙 결과 : 3 볼")
    void checkThreeBall() {
        //given
        pitcherBox = NumberBox.generate(421);
        batterBox = NumberBox.generate(214);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @Test
    @DisplayName("스윙 결과 : 3 스트라이크")
    void checkThreeStrike() {
        //given
        pitcherBox = NumberBox.generate(214);
        batterBox = NumberBox.generate(214);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.STRIKE);
    }
}