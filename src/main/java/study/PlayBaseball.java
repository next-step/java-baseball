package study;

import java.util.*;

public class PlayBaseball {


    private Integer[] computerPlayerNumbers;
    private int[] userPlayerNumbers;
    private int strike;
    private int ball;
    private StringBuffer hint;

    /**
     * 1-1.컴퓨터 임의 숫자 세팅 기능
     */
    public void setComputerPlayerNumbers() {
        Random randNum = new Random();
        Set<Integer> randomNumbers = new LinkedHashSet<Integer>();

        while (randomNumbers.size() < 3) {
            randomNumbers.add(randNum.nextInt(9)+1);
        }
        this.computerPlayerNumbers = randomNumbers.toArray(new Integer[randomNumbers.size()]);
    }

    /**
     * 1-2.사용자 값 입력 기능 예외 처리
     */
    public  void setUserNumbers(){
        try{
            setUserNumbersImpl();
        }catch(InputMismatchException e){
            setUserNumbers(); //입력 값 오류 발생 시 사용자 입력 기능 재수행
        }
    }
    /**
     * 1-2-1.사용자  입력 기능
     */
    public void setUserNumbersImpl(){
        //사용자 값 입력 시, 데이터 초기화
        Scanner scan = new Scanner(System.in);
        resetData();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int input = scan.nextInt();

            if (inputValidationSize(input)) { // 입력 받은 3자리수 정수인지 확인
                continue;
            }
            userPlayerNumbers = inputToUserPlayNumbers(input);
            if(inputValidationZeroAndDupe(userPlayerNumbers)){
                continue;
            }
            break;
        }
    }

    /**
     *1-2-2. 입력 값 초기
     */
    public void resetData(){
        strike = 0;
        ball = 0;
        userPlayerNumbers = new int[3];
    }

    /**
     * 1-2-3.사용자 입력 값을 배열 저장 기능
     * @param input
     * @return
     */
    public int[] inputToUserPlayNumbers(int input){
        userPlayerNumbers[0] = input / 100;
        userPlayerNumbers[1] = (input % 100) / 10;
        userPlayerNumbers[2] = input % 10;
        return userPlayerNumbers;
    }

    /**
     * 1-2-4.사용자 입력 값 정수 확인 기능
     * @param input
     * @return
     */
    public boolean inputValidationSize(int input){
        // 입력 받은 3자리수 정수인지 확인
        if (input < 100 || input > 999) {
            System.out.println("숫자 3자리를 입력해주세요.");
            return true;
        }

        return false;
    }

    /**
     * 1-2-5.
     * 입력 값 0 또는 중복 값 체크 기능
     * @param userPlayerNumbers
     * @return
     */
    public boolean inputValidationZeroAndDupe(int[] userPlayerNumbers){

        // 정수가 중복된 수를 사용할 수 없다
        if (userPlayerNumbers[0] == userPlayerNumbers[1] || userPlayerNumbers[1] == userPlayerNumbers[2] || userPlayerNumbers[2] == userPlayerNumbers[0]) {
            System.out.println("중복된 수는 사용할 수 없습니다.");
            return true;
        }
        // 0은 사용할 수 없다.
        if (userPlayerNumbers[0] == 0 || userPlayerNumbers[1] == 0 || userPlayerNumbers[2] == 0) {
            System.out.println("0은 사용할 수 없는 숫자입니다.");
            return true;
        }
        return false;
    }

    /**
     * 2-1~2.스트라이크, 볼 확인 기능
     * @param i
     */
    public void checkScore(int i){

        for(int j = 0; j<computerPlayerNumbers.length; j++){
            if(userPlayerNumbers[i] == computerPlayerNumbers[j] && i==j){
                strike++;
            }
            if(userPlayerNumbers[i] == computerPlayerNumbers[j] && i!=j){
                ball++;
            }
        }
    }
    /**
     * 2-3.게임 힌트 확인 기능
     */
    public void getHint(){
        hint = new StringBuffer();

        hint.append((strike > 0) ? String.valueOf(strike) + "스트라이크 " : "");
        hint.append((ball > 0) ? String.valueOf(ball)+"볼 " : "");
        hint.append((strike == 0 && ball ==0) ? "낫싱":  "");

        System.out.println(hint.toString());

    }
    /**
     * 3.게임 종료(3스트라이크) 확인 기능
     * @return
     */
    boolean isEnd() {
        if (strike == 3)
            return true;// 메소드는 return을 만나면 종료
        return false;
    }


    /**
     * 게임 시작 기능
     */
    public void startPlayBaseball(){
        //컴퓨터 숫자 생성
        setComputerPlayerNumbers();

        while (true){
            //사용자 숫자 입력
            setUserNumbers();
            //스트라이크, 볼 확인
            for(int i=0;i<userPlayerNumbers.length; i++){
                checkScore(i);
            }

            //힌트 가져오기
            getHint();

            //종료여부 확인
            if(isEnd()){
                isExit();
            }

        }
    }

    /**
     * 게임 종료 기능
     */
    public void isExit(){
        Scanner scan = new Scanner(System.in);
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char isRestart = scan.next().charAt(0);


        if(isRestart == '2'){
            System.exit(0);
        }
        startPlayBaseball();
    }

    public static void main(final String[] args) {
        PlayBaseball playbaseball = new PlayBaseball();
        playbaseball.startPlayBaseball();

    }
}



