package dev.cobi.logics;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cobi.domains.PlayNumber;
import dev.cobi.domains.ResultScore;
import dev.cobi.view.BaseballGameView;

/**
 * @author cobiyu
 */
@ExtendWith(MockitoExtension.class)
class BaseballGameTest {
    @Spy
    private Referee referee;
    @Mock
    private BaseballGameView baseballGameView;
    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @Spy
    @InjectMocks
    private BaseballGame baseballGame;

    @Test
    @DisplayName("getResultScoreBy에 정답이 전달될경우 반환된 ResultScore의 isCorrect()는 true")
    public void getResultScoreCorrect(){
        String answer = "123";
        String inputNumber = "123";

        ResultScore resultScoreBy = baseballGame.getResultScoreBy(new PlayNumber(answer), new PlayNumber(inputNumber));

        assertTrue(resultScoreBy.isCorrect());

    }

    @Test
    @DisplayName("getResultScoreBy에 오답이 전달될경우 반환된 ResultScore의 isCorrect()는 true")
    public void getResultScoreIncorrect(){
        String answer = "123";
        String inputNumber = "456";

        ResultScore resultScoreBy = baseballGame.getResultScoreBy(new PlayNumber(answer), new PlayNumber(inputNumber));

        assertFalse(resultScoreBy.isCorrect());
    }

    @Test
    @DisplayName("3자리 이상의 수가 입력될 경우 exception")
    public void moreThanThreeInput(){
        String longNumber = "45612";

        when(randomNumberGenerator.getRandomNumberByLength(anyInt())).thenReturn(longNumber);

        assertThrows(IllegalArgumentException.class, () -> baseballGame.play());
    }

    @Test
    @DisplayName("오답 2회, 정답, 새로시작 X : baseballGame.getResultScoreBy() 3번 호출")
    public void getResultScoreByCalledThreeTimes(){
        String answer = "123";
        String invalidInputNumber = "284";


        when(randomNumberGenerator.getRandomNumberByLength(anyInt())).thenReturn(answer);
        when(baseballGameView.inputPlayNumber())
                .thenReturn(invalidInputNumber)
                .thenReturn(invalidInputNumber)
                .thenReturn(answer);
        when(baseballGameView.isRestart()).thenReturn(false);

        baseballGame.play();

        Mockito.verify(baseballGame, times(3)).getResultScoreBy(any(), any());
        Mockito.verify(baseballGame, times(1)).play();
    }

    @Test
    @DisplayName("오답 1회, 정답, 새로시작 O, 오답 2회 정답 : baseballGame.getResultScoreBy() 5번 호출")
    public void getResultScoreByCalledFiveTimes(){
        String answer = "123";
        String invalidInputNumber = "456";


        when(randomNumberGenerator.getRandomNumberByLength(anyInt())).thenReturn(answer);
        when(baseballGameView.inputPlayNumber())
                .thenReturn(invalidInputNumber)
                .thenReturn(answer)
                .thenReturn(invalidInputNumber)
                .thenReturn(invalidInputNumber)
                .thenReturn(answer);
        when(baseballGameView.isRestart())
                .thenReturn(true)
                .thenReturn(false);

        baseballGame.play();

        Mockito.verify(baseballGame, times(5)).getResultScoreBy(any(), any());
        Mockito.verify(baseballGame, times(2)).play();
    }
}
