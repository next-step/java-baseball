package com.baseball.game.type;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("스윙 결과 테스트")
class SwingTest {
    private Pitcher pitcherBox;
    private Batter batterBox;

    @BeforeEach
    void init(){
        pitcherBox = Pitcher.create();
    }

    @Test
    @DisplayName("스윙 결과 : 1스트라이크 1볼 1낫씽")
    void checkVariousResult() {
        //given
        Batter tempBat = Batter.create(284);
        pitcherBox.setNumberBox(tempBat.getNumberBox());
        batterBox = Batter.create(258);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @Test
    @DisplayName("스윙 결과 : 1볼 2낫씽")
    void checkSwingResult() {
        //given
        Batter tempBat = Batter.create(214);
        pitcherBox.setNumberBox(tempBat.getNumberBox());
        batterBox = Batter.create(458);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.NOTHING);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.NOTHING);
    }

    @Test
    @DisplayName("스윙 결과 : 3 볼")
    void checkThreeBall() {
        //given
        Batter tempBat = Batter.create(421);
        pitcherBox.setNumberBox(tempBat.getNumberBox());
        batterBox = Batter.create(214);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.BALL);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.BALL);
    }

    @Test
    @DisplayName("스윙 결과 : 3 스트라이크")
    void checkThreeStrike() {
        //given
        Batter tempBat = Batter.create(214);
        pitcherBox.setNumberBox(tempBat.getNumberBox());
        batterBox = Batter.create(214);

        //when && then
        assertThat(Swing.swingResult(pitcherBox, batterBox, 0)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 1)).isEqualTo(Swing.STRIKE);
        assertThat(Swing.swingResult(pitcherBox, batterBox, 2)).isEqualTo(Swing.STRIKE);
    }
}