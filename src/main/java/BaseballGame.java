import java.util.HashMap;
import java.util.Scanner;

public class BaseballGame {
    private Scanner scn = new Scanner(System.in);
    private int LEN = 3;

    public static void main(String[] args) {
        int regame = 1;
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startBaseball();

    }
    public BaseballGame() {
    }

    /**
     * startBaseball
     * 게임 시작 메소드
     * 첫 실행후 게임을 실행하며, 한 게임이 종료된 후엔 게임의 재시작, 종료 여부를 입력받아 처리한다.
     * @return 게임 종료 여부
     */
    public int startBaseball() {
        int regame_flag = 1;

        while (regame_flag != 2) {
            playOneGame(regame_flag); //한 게임을 실행하는 메소드
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            regame_flag = scn.nextInt();
        }

        return regame_flag;
    }
    /**
     * playOneGame
     * 한 게임을 실행하는 메소드
     * 3스트라이트가 나올 때까지 게임을 진행하며, 3스트라이크가 나오면 완료한다.
     * @param start_flag 게임 완료 여부
     */
    public void playOneGame(int start_flag){
        HashMap<Integer, Integer> target_numbers = null, inputed_numbers = null;
        String inputs;
        boolean res = false;
        int strike=0, ball=0;

        if(start_flag!=1){
            return;
        }

        target_numbers = this.initTargetNumbers(); //getRandomNumber을 반복하여 타겟 숫자 HashMap을 생성하는 메소드

        while(!res){
            System.out.print("숫자를 입력해주세요: ");
            inputs = scn.next();
            inputed_numbers = convertStringToNumbers(inputs); //입력받은 String을 각 자리값과 인덱스를 갖는 HashMap으로 변환하는 메소드

            //res = checkNumbers(target_numbers, inputed_numbers); //경기의 종료 여부를 판별하는 메소드
        }
    }
    /**
     * initTargetNumbers
     * getRandomNumber를 반복하여 타겟 숫자 HashMap을 생성
     * 중복되지 않는 난수를 추출하였으므로, 타겟 HashMap은 size 3 을 갖는다.
     * @return 타겟 숫자 HashMap
     */
    public HashMap<Integer, Integer> initTargetNumbers() {
        HashMap<Integer, Integer> res = new HashMap<>();
        int temp_number = 0;
        for (int i = 0; i < LEN; i++) {
            temp_number = getRandomNumber(res); //한자릿수 난수 추출
            res.put(temp_number, i);
        }
        System.out.println("타겟 숫자 : " + res);
        return res;
    }
    /**
     * getRandomNumber
     * 한 자릿수 난수 추출
     * 중복되는 숫자가 나올 경우, 재귀를 통해 다시 추출하도록 한다.
     * @param res 기존에 추출한 랜덤 숫자 HashMap
     * @return 한자리 난수
     */
    public int getRandomNumber(HashMap<Integer, Integer> res) {
        int rand_number = (int)(Math.random()*9+1);
        if(res.get(rand_number)!=null){
            rand_number = this.getRandomNumber(res);
        }
        return rand_number;
    }
    /**
     * convertStringToNumbers
     * 입력받은 String을 각 자리값과 인덱스를 갖는 HashMap으로 변환
     * 입력받은 숫자의 길이, 중복 여부는 해당 메소드에서 판별하지 않는다.
     * @param str 입력받은 숫자
     * @return res 자리값을 키, 인덱스를 값으로 갖는 HashMap
     */
    public HashMap<Integer, Integer> convertStringToNumbers(String str){
        HashMap<Integer, Integer> res = new HashMap<>();
        str = str.trim();
        for(int i = 0; i<str.length(); i++){
            res.put(str.charAt(i)-'0', i);
        }

        return res;
    }
}
