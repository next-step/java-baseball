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
        ((GuessNumber)map.get("guessNumber")).doGuessNumber(dto);
        int success = ((BaseBallOutput)map.get("baseBallOutput")).resultOfAttack(dto);
        if(success==CODE.FAIL.value){
            resetBallCount();
        }
        reGameChk(success,sc);
    }

    public void resetBallCount(){
        dto.setCountOfBall(0);
        dto.setCountOfStrike(0);
    }

    private void reGameChk(int success, Scanner sc){
        if(success==CODE.SUCCESS.value){
            dto = new BaseBallDTO();
            reGameComment(sc);
        }
    }

    private void reGameComment(Scanner sc){
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
        gameExit(str);
    }
    private void gameExit(String str){
        if("2".equals(str)){
           System.exit(0);
        }
    }

    public static void main(String []args) {
        BaseBallGame newGame = new BaseBallGame();
        newGame.gameInit();
        newGame.gameStart();
    }

}