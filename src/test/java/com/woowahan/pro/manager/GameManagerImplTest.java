package com.woowahan.pro.manager;

import com.woowahan.pro.AppConfig;
import com.woowahan.pro.opponent.ComputerOpponent;
import com.woowahan.pro.referee.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GameManagerImplTest {
    private GameManagerImpl gameManager;

    @BeforeEach
    void init() {
        AppConfig config = new AppConfig();
        gameManager = (GameManagerImpl)config.gameManager();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,", "1,'1,2,3'", "2,"})
    @DisplayName("생성된 상대방 랜덤 숫자들 가져오기 검증.")
    void getOpponentNumbers(int status, String opponentNumbers) {
        try {
            //given
            String[] opponentNumbersArray = null;
            if(opponentNumbers != null) {
                opponentNumbersArray = opponentNumbers.split(",");
            }
            Method method = gameManager.getClass().getDeclaredMethod("getOpponentNumbers", GameStatus.class, String[].class);
            method.setAccessible(true);

            //when
            Optional<String[]> returnNumbers = (Optional<String[]>) method.invoke(gameManager, getGameStatus(status), opponentNumbersArray);

            //then
            assertThat(ComputerOpponent.RANDOM_NUMBER_RANGE).contains(returnNumbers.orElseThrow(() -> new NullPointerException("상대방 랜덤 숫자가 생성되지 않았습니다.")));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private GameStatus getGameStatus(int result) {
        if(result == 0) {
            return GameStatus.SUCCESS;
        } else if(result == 1) {
            return GameStatus.FAIL;
        }
        return GameStatus.READY;
    }
}