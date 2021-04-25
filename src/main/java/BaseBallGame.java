import java.util.*;

public class BaseBallGame {

    private Map<String,Object> map = new HashMap<>();

    public BaseBallDTO gameInit(){
        BaseBallDTO dto = new BaseBallDTO();
        map.put("enemyNumberGenerator",new EnemyNumberGenerator());
        map.put("guessNumber",new GuessNumber());
        map.put("baseBallOutput",new BaseBallOutput());
        ((EnemyNumberGenerator)map.get("enemyNumberGenerator")).generateNumber(dto);
        return dto;
    }

    public void gameStart(){
        BaseBallDTO dto = gameInit();
        while(true){
            System.out.print("입력:");
            Scanner sc = new Scanner(System.in);
            clientKeyInput(dto,sc);
            doGuess(dto,sc);
        }
    }

    private void doGuess(BaseBallDTO dto,Scanner sc){
        ((GuessNumber)map.get("guessNumber")).guessNumber(dto);
        ((BaseBallOutput)map.get("baseBallOutput")).resultOfAtack(dto);
        dto.setCountOfBall(0);
        dto.setCountOfStrike(0);
    }

    private void clientKeyInput(BaseBallDTO dto,Scanner sc){
        dto.setInputNumber(sc.next());
        setInputNumberToArray(dto);
    }

    private void setInputNumberToArray(BaseBallDTO dto){
        List<String> inputNumbers = new ArrayList<>();
        for(char inputNumber:dto.getInputNumber().toCharArray()){
            inputNumbers.add(String.valueOf(inputNumber));
        }
        dto.setInputNumbers(inputNumbers);
    }

    public static void main(String []args) {
        BaseBallGame newGame = new BaseBallGame();
        newGame.gameStart();
    }

}