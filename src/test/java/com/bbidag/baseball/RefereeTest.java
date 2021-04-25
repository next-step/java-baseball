package com.bbidag.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Referee referee;
    private Computer computer;

    @BeforeEach
    public void setUp(){
        computer = new Computer(new Random(System.currentTimeMillis()));
        referee = new Referee(computer);
    }

    @ParameterizedTest
    @MethodSource("provideStrikeForWinOrNot")
    @DisplayName("3 스트라이크 유무에 따라 승리 여부를 판단 테스트")
    public void isWinOrNot(int strikeCount, boolean isWin){
        referee.setStrikeCount(strikeCount);
        assertThat(referee.isWinGame()).isEqualTo(isWin);
    }

    @ParameterizedTest
    @MethodSource("provideStrikeBallCountForNothing")
    @DisplayName("스트라이크, 볼 수에 따라 낫싱 여부 테스트")
    public void isNothing(int strikeCount, int ballCount, boolean expected){
        referee.setStrikeCount(strikeCount);
        referee.setBallCount(ballCount);
        assertThat(referee.isNothing()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideIndexAndNumberForStrikeCount")
    @DisplayName("스트라이크 수 세기 테스트")
    public void strikeCount(int inputIdx, int inputNumber, int computerNumberIndex, int computerNumber, int expected){
        referee.setStrikeCount(0);
        referee.setStrikeIfEqualBothIndexAndNumber(inputIdx,inputNumber,computerNumberIndex,computerNumber);
        assertThat(referee.getStrikeCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideIndexAndNumberForBallCount")
    @DisplayName("볼 수 세기 테스트")
    public void ballCount(int inputIdx, int inputNumber, int computerNumberIndex, int computerNumber, int expected){
        referee.setBallCount(0);
        referee.setBallIfEqualNumberAndNotEqualIndex(inputIdx,inputNumber,computerNumberIndex,computerNumber);
        assertThat(referee.getBallCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("심판이 초기화 선언한 3자리 수의 랜덤 배열 컴퓨터 생성 테스트")
    public void generateRandomNumberOfComputer(){
        referee.generateRandomNumberOfComputer();
        assertThat(computer.getNumbers().length).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 입력에 대해 컴퓨터의 2번째 자리수에 대한 스트라이크, 카운트 체크 테스트")
    public void setStrikeBallByComputerIndex(){
        computer.setNumbers(new int[]{1,2,3});
        referee.setBallCount(0);
        referee.setStrikeCount(0);
        referee.setStrikeBallEachNumber(1, new int[]{3,2,9});
        assertThat(referee.getStrikeCount()).isEqualTo(1);
        assertThat(referee.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("사용자 입력에 대해 모든 스트라이크, 볼 카운트 테스트")
    public void calculateStrikeBall(){
        computer.setNumbers(new int[]{1,2,3});
        referee.setBallCount(0);
        referee.setStrikeCount(0);
        referee.calculateStrikeBall(new int[]{3,2,1});
        assertThat(referee.getStrikeCount()).isEqualTo(1);
        assertThat(referee.getBallCount()).isEqualTo(2);
    }

    private static Stream<Arguments> provideStrikeForWinOrNot(){
        return Stream.of(
            Arguments.of(3,true), Arguments.of(2,false),
            Arguments.of(1,false), Arguments.of(0,false)
        );
    }

    private static Stream<Arguments> provideStrikeBallCountForNothing(){
        return Stream.of(
            Arguments.of(2,1,false), Arguments.of(0,0,true)
        );
    }

    private static Stream<Arguments> provideIndexAndNumberForStrikeCount(){
        return Stream.of(
                Arguments.of(0,2,1,2,0),
                Arguments.of(1,5,1,5,1)
        );
    }

    private static Stream<Arguments> provideIndexAndNumberForBallCount(){
        return Stream.of(
                Arguments.of(0,2,1,2,1),
                Arguments.of(2,3,2,3,0)
        );
    }

}
