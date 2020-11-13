package com.coderhglee.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class GameNumberGroupsTest {

    public class GameNumberGroups {
        int MESSAGE_ALLOW_LENGTH_MAX = 3;
        private List<GameNumber> gameNumbers;

        public GameNumberGroups(List<GameNumber> gameNumbers) throws ExceedAllowLengthException {
            if (gameNumbers.size() != MESSAGE_ALLOW_LENGTH_MAX) {
                throw new ExceedAllowLengthException();
            }
            this.gameNumbers = gameNumbers;
        }

        private class ExceedAllowLengthException extends Throwable {
        }
    }


    @DisplayName("게임의 숫자는 3개를 입력 해야 한다")
    @Test
    void shouldGameNumberLengthEqualsThree() {
        assertThatThrownBy(() -> {
            List<GameNumber> gameNumberList = new ArrayList<>();
            gameNumberList.add(GameNumber.EIGHT);
            gameNumberList.add(GameNumber.FIVE);
            new GameNumberGroups(gameNumberList);
        }).isInstanceOf(GameNumberGroups.ExceedAllowLengthException.class);
    }


}
