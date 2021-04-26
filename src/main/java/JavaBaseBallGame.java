import java.util.*;

public class JavaBaseBallGame {

    private static Scanner scanner = new Scanner(System.in);


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
}
