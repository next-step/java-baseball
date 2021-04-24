import nextstep.baseball.domain.BaseballEnum;
import nextstep.baseball.service.BaseballGameNumberService;
import nextstep.baseball.service.BaseballGameNumberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private BaseballGameNumberService randomBoxService;

    @Test
    public void nothing(){

    }

    @BeforeEach
    public void setRandomBoxService(){
        randomBoxService = new BaseballGameNumberServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    @DisplayName("숫자 입력이 제대로 들어왔는가")
    public void inputUserNumber(String str){
        List<Integer> result = new ArrayList<>();
        final String[] split = str.split("");

        for(String i : split){
            result.add(Integer.parseInt(i));
        }

        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("player1와 상대방(com) 값이 같을경우")
    public void samePlayersNumber(){
        List<Integer> player1Number = new ArrayList<>();
        List<Integer> player2Number = randomBoxService.generateComputerNumber();
        player1Number.addAll(player2Number);

        assertThat(Arrays.equals(player1Number.toArray(), player2Number.toArray())).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"strike","ball","nothing"})
    @DisplayName("player1과 상대방(com) 값이 다를경우")
    public void differentPlayersNumber(String str){
        List<Integer> player1Number = randomBoxService.generateComputerNumber();
        List<Integer> player2Number = randomBoxService.generateComputerNumber();
        List<String> result = new ArrayList<>();

        for(int i=0;i<player1Number.size();i++){
            result.add(checkStrikeBall(i,player1Number.get(i),player2Number));
        }

        assertThat(result).anyMatch(i->i.equals(str));
    }

    @Test
    @DisplayName("게임 결과 표시")
    public void gameResult(){
        List<Integer> player1Number = randomBoxService.generateComputerNumber();
        List<Integer> player2Number = randomBoxService.generateComputerNumber();
        player1Number.add(4);

        Map<String, Integer> result = getGameResult(player1Number, player2Number);


        System.out.println(resultPrint(result));
        assertThat(result.size()).isGreaterThan(0);
    }

    private Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < player1Number.size(); i++) {
            if(i>2){
                continue;
            }
            result.computeIfPresent(checkStrikeBall(i, player1Number.get(i), player2Number), (String key, Integer value) -> ++value);
            result.putIfAbsent(checkStrikeBall(i, player1Number.get(i), player2Number), 1);
        }
        return result;
    }

    private String checkStrikeBall(int idx, int num, List<Integer> computer){
        if(computer.get(idx) == num){
            return BaseballEnum.STRIKE.getCode();
        }

        if(computer.contains(num)){
            return BaseballEnum.BALL.getCode();
        }

        return BaseballEnum.NOTHING.getCode();
    }

    private StringBuffer resultPrint(Map<String, Integer> result){
        StringBuffer stringBuffer = new StringBuffer();

        if(result.get(BaseballEnum.STRIKE.getCode()) != null){
            stringBuffer.append(result.get(BaseballEnum.STRIKE.getCode()));
            stringBuffer.append(BaseballEnum.STRIKE.getName());
        }

        if(result.get(BaseballEnum.BALL.getCode()) != null){
            stringBuffer.append(result.get(BaseballEnum.BALL.getCode()));
            stringBuffer.append(BaseballEnum.BALL.getName());
        }

        if(stringBuffer.length() == 0){
            stringBuffer.append(result.get(BaseballEnum.NOTHING.getCode()));
        }
        return stringBuffer;
    }
}
