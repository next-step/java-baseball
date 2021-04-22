import nextstep.baseball.service.RandomBoxService;
import nextstep.baseball.service.RandomBoxServiceImpl;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private RandomBoxService randomBoxService;

    @Test
    public void nothing(){

    }

    @BeforeEach
    public void setRandomBoxService(){
        randomBoxService = new RandomBoxServiceImpl();
    }

    @Test
    @DisplayName("player1와 상대방(com) 값이 같을경우")
    public void samePlayersNumber(){
        List<Integer> player1Number = new ArrayList<>();
        List<Integer> player2Number = randomBoxService.createRandomNumber();
        player1Number.addAll(player2Number);

        assertThat(Arrays.equals(player1Number.toArray(), player2Number.toArray())).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"strike","ball","nothing"})
    @DisplayName("player1과 상대방(com) 값이 다를경우")
    public void differentPlayersNumber(String str){
        List<Integer> player1Number = randomBoxService.createRandomNumber();
        List<Integer> player2Number = randomBoxService.createRandomNumber();
        List<String> result = new ArrayList<>();

        for(int i=0;i<player1Number.size();i++){
            result.add(checkStrikeBall(i,player1Number.get(i),player2Number));
        }

        assertThat(result).anyMatch(i->i.equals(str));
    }

    @Test
    @DisplayName("게임 결과 표시")
    public void gameResult(String str){
        List<Integer> player1Number = randomBoxService.createRandomNumber();
        List<Integer> player2Number = randomBoxService.createRandomNumber();
        Map<String, Integer> result = getGameResult(player1Number, player2Number);

        String strike = result.get("strike") != null ? result.get("strike") + " 스트라이크" : "";
        String ball = result.get("ball") != null ? result.get("ball") + " 볼" : "";

        System.out.println(strike + " " + ball);

        assertThat(result.size()).isEqualTo(3);
    }

    private Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < player1Number.size(); i++) {
            result.computeIfPresent(checkStrikeBall(i, player1Number.get(i), player2Number), (String key, Integer value) -> ++value);
            result.putIfAbsent(checkStrikeBall(i, player1Number.get(i), player2Number), 1);
        }
        return result;
    }

    private String checkStrikeBall(int idx, int num, List<Integer> computer){
        if(computer.get(idx) == num){
            return "strike";
        }

        if(computer.contains(num)){
            return "ball";
        }

        return "nothing";
    }
}
