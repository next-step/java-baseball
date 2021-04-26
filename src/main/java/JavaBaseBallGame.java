import java.util.*;

public class JavaBaseBallGame {

    private static Scanner scanner = new Scanner(System.in);
    private final int THE_NUMBER_OF_NUM = 3;


    /**
     * 세자리 숫자를 구하는데 중복되거나 3자리가 넘으면 예외처리를 통하여 숫자를 구한다.
     * @return num
     */
    private int getNumberOfThree() {
        int num = scanner.nextInt();

        if(num > 999) {
            System.out.println("just only input 3 numbers");
            return getNumberOfThree();
        }
        List<String> list = convertStringToInt(num);
        Set<String> set = new HashSet<>(list);

        if(set.size() != list.size()){
            System.out.println("duplicated number!! please reinput number");
            return getNumberOfThree();
        }

        return num;
    }

    /**
     * 세자리 숫자인지 체크하기 위하여 각각의 수를 list로 치환한다.
     * @param num
     * @return list
     */
    private List<String> convertStringToInt(int num) {
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
    private StrikeBall getHintMap(int gameNum, int num) {
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
    private int getStrike(String x, String n) {
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
    private int getBall(List<String> xString, String n, int index) {
        if(index != xString.indexOf(n) && xString.indexOf(n) >= 0)
            return 1;
        return 0;
    }

    /**
     * 임의의 세자리 숫자 구하는 method
     * @return 임의의 세자리 숫자
     */
    private int createRandomNumber() {
        Random rn = new Random();
        Set<Integer> sSet = new HashSet<>();
        while(sSet.size() < THE_NUMBER_OF_NUM){
            sSet.add(rn.nextInt(9) + 1);
        }
        System.out.println(sSet);
        int result = getRealNumber(sSet);
        System.out.println(result);
        return result;

    }

    private int getRealNumber(Set<Integer> sSet) {
        List<Integer> list = new ArrayList<>(sSet);
        Collections.reverse(list);
        int result = list.get(0);
        for (int i=1;i <list.size(); i++){
            result += list.get(i) * Math.pow(10,i);
        }

        return result;

    }


}
