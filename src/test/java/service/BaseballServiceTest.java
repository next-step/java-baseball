package service;

import domain.baseball.Baseball;
import domain.baseball.BaseballGroup;
import domain.player.Computer;
import domain.player.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BaseballServiceTest {


    @ParameterizedTest
    @CsvSource(value = {"123|123", "428|428", "379|379", "274|274"}, delimiter = '|')
    void baseball_matching_count_test_gameOver(String userInput , String ComputerInput){
        User user = new User(new BaseballGroup(userInput));
        Computer computer = new Computer(new BaseballGroup(ComputerInput));
        BaseballService.isSetInfo();

        for(int i =0; i<user.getBaseballList().size(); i++){
            Baseball userInputBaseball = user.getBaseballList().get(i);
            Baseball computerRandomBaseball = computer.getBaseballList().get(i);
            BaseballService.isCountingGameResult(userInputBaseball,computerRandomBaseball,computer.getBaseballList());
        }

        assertThat(BaseballService.getStrike()).isEqualTo(BaseballGroup.getRandomLength());
    }

    @ParameterizedTest
    @CsvSource(value = {"123|345", "428|256", "379|912", "345|512"}, delimiter = '|')
    void baseball_matching_count_test_one_ball(String userInput , String ComputerInput){

        User user = new User(new BaseballGroup(userInput));
        Computer computer = new Computer(new BaseballGroup(ComputerInput));
        BaseballService.isSetInfo();

        for(int i =0; i<user.getBaseballList().size(); i++){
            Baseball userInputBaseball = user.getBaseballList().get(i);
            Baseball computerRandomBaseball = computer.getBaseballList().get(i);
            BaseballService.isCountingGameResult(userInputBaseball,computerRandomBaseball,computer.getBaseballList());
        }

        assertThat(BaseballService.getBall()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"123|453", "428|526", "379|129", "345|125"}, delimiter = '|')
    void baseball_matching_count_test_one_strike(String userInput , String ComputerInput){

        User user = new User(new BaseballGroup(userInput));
        Computer computer = new Computer(new BaseballGroup(ComputerInput));
        BaseballService.isSetInfo();

        for(int i =0; i<user.getBaseballList().size(); i++){
            Baseball userInputBaseball = user.getBaseballList().get(i);
            Baseball computerRandomBaseball = computer.getBaseballList().get(i);
            BaseballService.isCountingGameResult(userInputBaseball,computerRandomBaseball,computer.getBaseballList());
        }

        assertThat(BaseballService.getStrike()).isEqualTo(1);
    }


}
