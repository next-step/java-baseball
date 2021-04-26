package service;

import domain.Bettings;
import domain.Strike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "심판 로직 테스트")
class RefereeTest {

    static final Referee REFEREE = new Referee();

    static Stream getBettings(){
        return Stream.of(
                Arguments.of(0, new ArrayList<>(Arrays.asList(4,5,6))),
                Arguments.of(1, new ArrayList<>(Arrays.asList(1,4,2))),
                Arguments.of(2, new ArrayList<>(Arrays.asList(1,2,4))),
                Arguments.of(3, new ArrayList<>(Arrays.asList(1,2,3)))
        );
    }

    @ParameterizedTest
    @MethodSource("getBettings")
    void game(int strikeCount, List<Integer> computerValues) {
        char[] userInputs = {'1', '2', '3'};
        Bettings bettings = new Bettings(userInputs, computerValues);
        Strike strike = REFEREE.compareInputsWithValues(bettings);
        assertTrue(strike.getCount() == strikeCount);
    }
}