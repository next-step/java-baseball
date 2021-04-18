import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    private Integer random, userInput;
    private String answer;

    public GameLogic(Integer random, Integer userInput) {
        this.random = random;
        this.userInput = userInput;
    }

    public String gameLogic(){
        Integer strike = 0;
        Integer ball = 0;

        List<Integer> randomList = new ArrayList<>();
        List<Integer> userInputList = new ArrayList<>();

        randomList.add(random/100 );
        randomList.add((random - (randomList.get(0)*100)) / 10);
        randomList.add(random - (randomList.get(0)*100 + randomList.get(1)*10));

        userInputList.add(userInput/100 );
        userInputList.add((userInput - (userInputList.get(0)*100)) / 10);
        userInputList.add(userInput - (userInputList.get(0)*100 + userInputList.get(1)*10));

        if(randomList.contains(userInputList.get(0))){
            if(randomList.get(0) == userInputList.get(0)){
                strike += 1;
            }
            else{
                ball += 1;
            }
        }
        if(randomList.contains(userInputList.get(1))){
            if(randomList.get(1) == userInputList.get(1)){
                strike += 1;
            }
            else{
                ball += 1;
            }
        }
        if(randomList.contains(userInputList.get(2))){
            if(randomList.get(2) == userInputList.get(2)){
                strike += 1;
            }
            else{
                ball += 1;
            }
        }

        if(strike == 0 && ball == 0){
            answer = "낫싱";
        }
        else {
            if(strike == 0 && ball != 0){
                answer = ball+"볼";
            }
            else if(strike != 0 && ball == 0){
                answer = strike+"스트라이크";
            }
            else {
                answer = ball+"볼 "+strike+"스트라이크";
            }
        }

        return answer;
    }


    public String getAnswer() {
        return gameLogic();
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    public void setUserInput(Integer userInput) {
        this.userInput = userInput;
    }


}
