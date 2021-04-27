import java.util.*;

public class JavaBaseballGame {

    private static Scanner scanner = new Scanner(System.in);
    private final int THE_NUMBER_OF_NUM = 3;

    public static void main(String[] args){
        JavaBaseballGame javaBaseballGame = new JavaBaseballGame();
        boolean flag = true;
        while(flag){

            int x = javaBaseballGame.createRandomNumber();
            System.out.println("숫자를 입력해주세요 : ");
            javaBaseballGame.startGame(x);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            flag = javaBaseballGame.isGame();
        }
    }


    /**
     * 세자리 숫자를 구하는데 중복되거나 3자리가 넘으면 예외처리를 통하여 숫자를 구한다.
     * @return num
     */
    public int getNumberOfThree() {
        int num = scanner.nextInt();

        if(num > 999) {
            System.out.println("3개의 숫자만 입력이 가능합니다. 다시 입력해주세요");
            return getNumberOfThree();
        }

        if(num < 100){
            System.out.println("3개의 숫자만 입력이 가능합니다. 다시 입력해주세요");
            return getNumberOfThree();
        }
        List<String> list = convertStringToInt(num);
        Set<String> set = new HashSet<>(list);

        if(set.size() != list.size()){
            System.out.println("중복되는 수는 안됩니다. 다시 입력해주세요");
            return getNumberOfThree();
        }

        return num;
    }

    /**
     * 세자리 숫자인지 체크하기 위하여 각각의 수를 list로 치환한다.
     * @param num
     * @return list
     */
    public List<String> convertStringToInt(int num) {
        String numString = Integer.toString(num);
        List<String> resultList = new ArrayList<>();
        for(int i = 0; i < numString.length(); i++){
            resultList.add(Character.toString(numString.charAt(i)));
        }

        return resultList;

    }

    /**
     * 임의의 세자리 숫자와 입력한 숫자를 비교하는 method
     * @param gameNum
     * @param num
     * @return
     */
    public StrikeBall getHintMap(int gameNum, int num) {
        if( gameNum == num){
            return new StrikeBall(THE_NUMBER_OF_NUM, 0);
        }
        List<String> xString = convertStringToInt(gameNum);
        List<String> numString = convertStringToInt(num);
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < xString.size(); i++ ){
            strike += getStrike(xString.get(i), numString.get(i));
            ball += getBall(xString, numString.get(i),i);
        }

        return new StrikeBall(strike,ball);

    }

    /**
     * 스트라이크 체크 method
     * @param x
     * @param n
     * @return
     */
    public int getStrike(String x, String n) {
        if(x.equalsIgnoreCase(n))
            return 1;
        return 0;
    }

    /**
     * 볼 체크 method
     * @param xString
     * @param n
     * @param index
     * @return
     */
    public int getBall(List<String> xString, String n, int index) {
        if(index != xString.indexOf(n) && xString.indexOf(n) >= 0)
            return 1;
        return 0;
    }

    /**
     * 임의의 세자리 숫자 구하는 method
     * @return 임의의 세자리 숫자
     */
    public int createRandomNumber() {
        Random rn = new Random();
        Set<Integer> sSet = new HashSet<>();
        while(sSet.size() < THE_NUMBER_OF_NUM){
            sSet.add(rn.nextInt(9) + 1);
        }

        int result = getRealNumber(sSet);
        System.out.println("정답 : " + result);
        return result;

    }

    public int getRealNumber(Set<Integer> sSet) {
        List<Integer> list = new ArrayList<>(sSet);
        Collections.reverse(list);
        int result = list.get(0);
        for (int i=1;i <list.size(); i++){
            result += list.get(i) * Math.pow(10,i);
        }

        return result;

    }


    public boolean isGame() {
        int gameButton = scanner.nextInt();
        if (gameButton == 1) {
            return true;
        }

        return false;
    }

    public void startGame(int x){
        boolean flag = true;
        while(flag){
            int num = getNumberOfThree();

            System.out.println(printSentence(x,num));
            flag = isFinishGame(x, num);
        }
    }

    public String printSentence(int x, int num) {
        StrikeBall strikeBall = getHintMap(x, num);
        if(strikeBall.getBall() == 0 && strikeBall.getStrike() == THE_NUMBER_OF_NUM) {
            return "3 스트라이크";

        }

        return strikeBall.getStrike() + "스트라이크 " + strikeBall.getBall() + "볼";
    }

    public boolean isFinishGame(int x, int num) {
        StrikeBall strikeBall = getHintMap(x, num);
        if(strikeBall.getBall() == 0 && strikeBall.getStrike() == THE_NUMBER_OF_NUM) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!. 게임 종료");
            return false;
        }

        return true;
    }


}
