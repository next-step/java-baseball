import java.util.*;

public class BaseBallGame {

    private Map<String,Object> map = new HashMap<>();
    private BaseBallDTO dto = new BaseBallDTO();

    public void gameInit(){
        map.put("enemyNumberGenerator",new EnemyNumberGenerator());
        map.put("guessNumber",new GuessNumber());
        map.put("baseBallOutput",new BaseBallOutput());
        ((EnemyNumberGenerator)map.get("enemyNumberGenerator")).generateNumber(dto);
    }

    public void gameStart(){
        gameInit();
        while(true){
            System.out.print("입력:");
            Scanner sc = new Scanner(System.in);
            clientKeyInput(dto,sc);
            doGuess(dto,sc);
        }
    }

    private void doGuess(BaseBallDTO dto,Scanner sc){
        ((GuessNumber)map.get("guessNumber")).guessNumber(dto);
        int success = ((BaseBallOutput)map.get("baseBallOutput")).resultOfAtack(dto);
        if(success==CODE.FAIL.getValue()){
            dto.setCountOfBall(0);
            dto.setCountOfStrike(0);
        }
        reGameComment(success,sc);
    }

    private void reGameComment(int success, Scanner sc){
        int retryCode = 0;
        if(success==CODE.SUCCESS.getValue()){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            retryCode = sc.nextInt();
        }
        reGameOrExit(retryCode);
    }

    private void reGameOrExit(int retryCode){
        if(retryCode==1){
            dto = new BaseBallDTO();
            gameInit();
        }
        if(retryCode==2){
            System.exit(0);
        }
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