import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PlayBaseballUtil {
    /*
    [기능 설명]
    - checkNumber 받아 숫자 중 동일한 숫자가 있는지 확인한다.
    [변수 설명]
    - checkNumber : 동일성을 체크하는 대상 숫자
    [결과 값]
    - resultIdentify : 숫자의 동일성 여부(true : 동일, false : 동일하지 않음)
    */
    public boolean checkNumberIdentify(Integer checkNumber){
        boolean resultIdentify = false;

        if (checkNumber == null || checkNumber <= 9){
            return false;
        } else {
            String tempNum = null;
            char tempChar = ' ';
            List<String> numStrList = new ArrayList<>();

            tempNum = checkNumber.toString();

            for (int i =0; i < tempNum.length(); i++){
                tempChar = tempNum.charAt(i);
                numStrList.add(String.valueOf(tempChar));
            }

            for(int i =0; i< numStrList.size(); i++){
                //get first object to compare to
                String diff_a = numStrList.get(i);

                for (int j = i+1; j < numStrList.size(); j++) {
                    String diff_b = numStrList.get(j);

                    if(diff_a.equals(diff_b) == true){
                        return true;
                    }

                }
            }
        }

        return resultIdentify;
    }

    /*
    [기능 설명]
    - digitNumber : 램덤 숫자 생성 자리수
    [변수 설명]
    -  resultNumger : 서로다른 램덤 숫자
    [결과 값]
    - digitNumber 받아 해당 자리수 만큼 램던 숫자를 생성한다. 단 숫자는 서로 달라야 한다.
    */
    public Integer getRandomNumber(Integer digitNumber){
        Integer randNumber = null, tempNum = null;
        String tempNumStr = "";
        Random randomNum = new Random();

        if (digitNumber == 0) {
            return null;
        }

        do {
            for (int i=0; i < digitNumber; i++){
                tempNum = randomNum.nextInt(9) +1;
                tempNumStr += tempNum.toString();
            }

            randNumber = Integer.parseInt(tempNumStr);
            tempNumStr = "";
        } while (checkNumberIdentify(randNumber) == true);


        return randNumber;
    }

    /*
    [기능 설명]
     - strikeNumber : getRandomNumber 함수의 결과 값
     - targetNumber : strikeNumber 비교할 대상
    [변수 설명]
    -  List<Integer> resultList: (스트라이크 수, 볼 수)
    [결과 값]
    - targetNumber 받아 strikeNumber와 동일성 여부를 체크하여 "기본 및 정책 - 판정기준"에 따라 결과 값을 표출한다.
    */
    public List<Integer> getBattingResult(Integer targetNumber, Integer strikeNumber){
        List<Integer> resultList = null;
        Integer ballCnt = 0, strikeCnt=0;

        if (targetNumber == null || strikeNumber  == null) {
            return null;
        }

        char tempChar = ' ';
        String toStringTargetNumber  = targetNumber.toString();
        String toStringStrikeNumber = strikeNumber.toString();

        if(toStringTargetNumber.length() != toStringStrikeNumber.length()){
            return null;
        }

        List<String> targetStrList = new ArrayList<>();
        List<String> StrikeStrList = new ArrayList<>();
        resultList = new ArrayList<>();

        for (int i =0; i < toStringTargetNumber.length(); i++){
            tempChar = toStringTargetNumber.charAt(i);
            targetStrList.add(String.valueOf(tempChar));

            tempChar = toStringStrikeNumber.charAt(i);
            StrikeStrList.add(String.valueOf(tempChar));
        }

        for(int i =0; i < targetStrList.size(); i++){
            String targetStr = targetStrList.get(i);

            for(int j =0; j < StrikeStrList.size(); j++){
                String strikeStr = StrikeStrList.get(j);
                if(targetStr.equals(strikeStr) == true){
                    if(i==j){
                        strikeCnt++;
                    }else {
                        ballCnt++;
                    }
                }
            }
        }

        resultList.add(strikeCnt);
        resultList.add(ballCnt);

        return resultList;
    }
}
