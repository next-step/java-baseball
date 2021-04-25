package numbaseball;

import java.util.*;

public class Play {

    /**
     * 3자리 난수를 지닌 ArrayList를 생성 한다.
     * @return arrPlayNumber
     */
    public static ArrayList<Integer> createNumber() {
        ArrayList<Integer> arrPlayNumber = new ArrayList<Integer>();

        int nRandNumber = 1;
        while (arrPlayNumber.size() < 3) {
            nRandNumber = (int) Math.floor((Math.random() * 9) + 1);    //1-9 범위의 난수 생성
            addNumber(arrPlayNumber, nRandNumber);
        }
        return arrPlayNumber;
    }

    /**
     * 난수 arrayList에 난수를 추가한다.
     * @param arrPlayNumber : 난수 arrayList
     * @param nRandNumber   : 추가할 난수
     * @return
     */
    public static ArrayList<Integer> addNumber(ArrayList<Integer> arrPlayNumber, int nRandNumber) {
        boolean containYn = arrPlayNumber.contains(nRandNumber);
        if ( !containYn ) {
            //arrayList에 포함 되지 않은 난수일 경우 add
            arrPlayNumber.add(nRandNumber);
        }
        return arrPlayNumber;
    }


}
