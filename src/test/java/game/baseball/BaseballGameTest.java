package game.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @Test
    @DisplayName("3가지 각기 다른수를 가진 리스트를 만들어 게임시작")
    public void makeQuiz(){
        BaseballGame baseballGame = new BaseballGame();
        ArrayList<Integer> list = baseballGame.makeQuiz();

        assertThat(list.size()).isEqualTo(3);
    }

    static Stream<Arguments> provideArgumentsForCompareQuizAndInput() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(9);
        return Stream.of(
                Arguments.of(list, "379", true),
                Arguments.of(list, "397", false),
                Arguments.of(list, "123", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCompareQuizAndInput")
    @DisplayName("생성된 퀴즈 리스트와 입력받은 문자의 비교")
    public void compareQuizAndInput(ArrayList<Integer> quizList,String input,boolean expected) {
        BaseballGame baseballGame = new BaseballGame();
        boolean correctAnswer = baseballGame.compareQuizAndInput(quizList,input);
        assertThat(correctAnswer).isEqualTo(expected);
    }

    static Stream<Arguments> provideArgumentsForCheckStrike() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(9);
        return Stream.of(
                Arguments.of(list, "3", 0, 1),
                Arguments.of(list, "7", 1, 1),
                Arguments.of(list, "9", 2, 1),
                Arguments.of(list, "7", 0, 0),
                Arguments.of(list, "9", 1, 0),
                Arguments.of(list, "3", 2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCheckStrike")
    @DisplayName("생성된 퀴즈 리스트와 입력받은 특정 순서의 수를 비교하여 스트라이크 체크")
    public void checkStrike(ArrayList<Integer> quizList,String target,int targetOrder,int expected){
        BaseballGame baseballGame = new BaseballGame();
        int strikeCnt = baseballGame.checkStrike(quizList,target,targetOrder);
        assertThat(strikeCnt).isEqualTo(expected);
    }
    static Stream<Arguments> provideArgumentsForCheckBall() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(9);
        return Stream.of(
                Arguments.of(list, "3", 0, 0),
                Arguments.of(list, "7", 1, 0),
                Arguments.of(list, "9", 2, 0),
                Arguments.of(list, "7", 0, 1),
                Arguments.of(list, "9", 1, 1),
                Arguments.of(list, "3", 2, 1)
        );
    }
    @ParameterizedTest
    @MethodSource("provideArgumentsForCheckBall")
    @DisplayName("생성된 퀴즈 리스트와 입력받은 특정 순서의 수를 비교하여 볼 체크")
    public void checkBall(ArrayList<Integer> quizList,String target,int targetOrder,int expected){
        BaseballGame baseballGame = new BaseballGame();
        int ballCnt = baseballGame.checkBall(quizList,target,targetOrder);
        assertThat(ballCnt).isEqualTo(expected);
    }
    static Stream<Arguments> provideArgumentsForPrintCompareResult() {
        return Stream.of(
                Arguments.of(0, 0, "낫싱"),
                Arguments.of(1, 0, "1 스트라이크 "),
                Arguments.of(2, 1, "2 스트라이크 1 볼 "),
                Arguments.of(0, 2, "2 볼 ")
        );
    }
    @ParameterizedTest
    @MethodSource("provideArgumentsForPrintCompareResult")
    @DisplayName("생성된 퀴즈 리스트와 입력받은 특정 순서의 수를 비교하여 볼 체크")
    public void printResult(int strikeCount,int ballCount,String expected){
        BaseballGame baseballGame = new BaseballGame();
        String result = baseballGame.printResult(strikeCount,ballCount);
        assertThat(result).isEqualTo(expected);
    }
}
