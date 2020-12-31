import java.util.*;

public class BaseBallGame {

    static private Scanner sc;
    static private final int MAX_LENGTH=3;

    public void runBaseBallGame(){

        sc=new Scanner(System.in);
        while (isStart()) {
            startGame();
        }
        System.out.println("게임을 종료합니다.");
    }

    public void startGame(){

        String botAnswer=generateAnswer();
        while(!checkClear(botAnswer));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public boolean checkClear(String botAnswer){

        String userAnswer=getUserAnswer();
        BallCount ballCount=getBallCount(botAnswer,userAnswer);
        if(ballCount.getStrike()==MAX_LENGTH){
            return true;
        }
        System.out.println(ballCount.toString());
        return false;
    }

    public BallCount getBallCount(String botAnswer,String userAnswer){

        int ball=0;
        int strike=0;
        for(int i=0; i<MAX_LENGTH; i++){
            strike+=checkSame(botAnswer.charAt(i),userAnswer.charAt(i));
            ball+=countBall(botAnswer.charAt(i),userAnswer,i);
        }
        return new BallCount(strike,ball);
    }

    public int countBall(char botChar, String userAnswer, int passIndex){

        if(botChar==userAnswer.charAt(0)&&passIndex!=0){
            return 1;
        }
        if(botChar==userAnswer.charAt(1)&&passIndex!=1){
            return 1;
        }
        if(botChar==userAnswer.charAt(2)&&passIndex!=2){
            return 1;
        }
        return 0;
    }

    public int checkSame(char botChar,char userChar){

        if(botChar==userChar){
            return 1;
        }
        return 0;
    }

    public String getUserAnswer(){

        System.out.print("숫자를 입력해주세요:");
        String userAnswer=sc.nextLine();
        while (!validateUserAnswer(userAnswer)) {
            System.out.print("숫자를 입력해주세요:");
            userAnswer=sc.nextLine();
        }
        return userAnswer;
    }

    public boolean validateUserAnswer(String userAnswer){

        if(validateMaxLength(userAnswer) && validateStringToInteger(userAnswer)
                && validateDuplicate(userAnswer) && validateZero(userAnswer)){
            return true;
        }
        System.out.println("잘못된 입력입니다.");
        return false;

    }

    public boolean validateMaxLength(String userAnswer){

        if(userAnswer.length()==MAX_LENGTH){
            return true;
        }
        return false;
    }
    public boolean validateZero(String userAnswer){

        if(userAnswer.charAt(0)=='0'){
            return false;
        }
        if(userAnswer.charAt(1)=='0'){
            return false;
        }
        if(userAnswer.charAt(2)=='0'){
            return false;
        }
        return true;
    }

    public boolean validateStringToInteger(String userAnswer){

        try {
            return Integer.parseInt(userAnswer)>=1;
        }catch (Exception e){
            return false;
        }
    }

    public boolean validateDuplicate(String userAnswer){

        HashSet<Character> set=new HashSet<>();
        int index=0;
        while (index<userAnswer.length()&&set.add(userAnswer.charAt(index))) {
            index+=1;
        }
        if(index==userAnswer.length()){
            return true;
        }
        return false;
    }

    public String generateAnswer(){

        HashSet<Integer> set=new HashSet<Integer>();
        Random random=new Random();
        while (set.size()<MAX_LENGTH) {
            set.add(random.nextInt(9)+1);
        }
        List<Integer> list=new ArrayList<>(set);
        Collections.shuffle(list);
        return listToString(list);
    }

    public String listToString(List list){

        String answer="";
        for(int i=0; i<list.size(); i++){
            answer+=String.valueOf(list.get(i));
        }
        return answer;
    }


    public boolean isStart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String startInput=sc.nextLine();
        while (!validateStartInput(startInput)) {
            startInput=sc.nextLine();
        }

        return checkStartInput(startInput);
    }

    public boolean validateStartInput(String startInput){

        if(startInput.equals("1")||startInput.equals("2")){
            return true;
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    public boolean checkStartInput(String startInput){

        if(startInput.equals("1")){
            return true;
        }
        return false;
    }

}



