import java.util.*;

public class BaseBallGame {

    private Map<String,Object> map = new HashMap<>();
    private BaseBallDTO dto = new BaseBallDTO();
    private BaseBallValidation validation = new BaseBallValidation();

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
            clientKeyInput(sc);
        }
    }

    private void clientKeyInput(Scanner sc){
        dto.setInputNumber(sc.next());
        setInputNumberToArray();
        if(!validation.validationChk(dto)){
            doGuess(sc);
        }
    }

    private void setInputNumberToArray(){
        List<String> inputNumbers = new ArrayList<>();
        for(char inputNumber:dto.getInputNumber().toCharArray()){
            inputNumbers.add(String.valueOf(inputNumber));
        }
        dto.setInputNumbers(inputNumbers);
    }

    private void doGuess(Scanner sc){
        ((GuessNumber)map.get("guessNumber")).guessNumber(dto);
        int success = ((BaseBallOutput)map.get("baseBallOutput")).resultOfAtack(dto);
        if(success==CODE.FAIL.value){
            resetBallCount();
        }
        reGameComment(success,sc);
    }

    public void resetBallCount(){
        dto.setCountOfBall(0);
        dto.setCountOfStrike(0);
    }

    private void reGameComment(int success, Scanner sc){
        String retryCode = "0";
        if(success==CODE.SUCCESS.value){
            dto = new BaseBallDTO();
            reGameChk(sc);
        }
    }

    private void reGameChk(Scanner sc){
        String inputText = "";
        while(!validation.restartValidationChk(inputText)){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inputText = sc.next();
        }
        reGameOrExit(inputText);
    }

    private void reGameOrExit(String str){
        if("1".equals(str)){
            gameInit();
        }
        if("2".equals(str)){
           System.exit(0);
        }
    }

    public static void main(String []args) {
        BaseBallGame newGame = new BaseBallGame();
        newGame.gameStart();
    }

}