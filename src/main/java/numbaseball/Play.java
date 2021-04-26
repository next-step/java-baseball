package numbaseball;


import java.util.*;

public class Play<castArrayList> {

    private static int MIN_RANDOM_NUMBER = 1;
    private static int MAX_RANDOM_NUMBER = 9;
    private static int NUMBER_SIZE = 3;

    private static String VALIDATE_MSG_NUMBER_SIZE = "반드시 3자리 숫자만 입력 가능합니다.. 다시 입력 해주세요.";
    private static String VALIDATE_MSG_DUPLICATION_NUMBER = "중복된 숫자가 존재합니다.. 다시 입력 해주세요.";

    private static Scanner sc = new Scanner(System.in);


    public static ArrayList<Integer> createPlayNumber() {
        ArrayList<Integer> arrPlayNumber = new ArrayList<Integer>();

        int nRandNumber;
        while (arrPlayNumber.size() < NUMBER_SIZE) {
            nRandNumber = (int) Math.floor((Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER);    //1-9 범위의 난수 생성
            addPlayNumber(arrPlayNumber, nRandNumber);
        }
        return arrPlayNumber;
    }

    private static ArrayList<Integer> addPlayNumber(ArrayList<Integer> arrPlayNumber, int nRandNumber) {
        boolean isContain = arrPlayNumber.contains(nRandNumber);
        if (!isContain) {
            //arrayList에 포함 되지 않은 난수일 경우 add
            arrPlayNumber.add(nRandNumber);
        }
        return arrPlayNumber;
    }

    //리턴을 List로 변경..
    public static List<Integer> getInputNumber() {
        try {
            String sInputNumber = sc.next();
            validateInputNumber(sInputNumber);
            return castStrToList(sInputNumber);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return getInputNumber();

        } catch (Exception e) {
            System.out.println(VALIDATE_MSG_NUMBER_SIZE);
            return getInputNumber();

        }
    }

    private static void validateInputNumber(String sInputNumber) {
        validateNumberSize(sInputNumber);
        validateDuplicationNumber(sInputNumber);
    }

    private static void validateNumberSize(String sInputNumber) {
        if (sInputNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(VALIDATE_MSG_NUMBER_SIZE);
        }
    }

    private static void validateDuplicationNumber(String sInputNumber) {
        List<String> tempList = Arrays.asList(sInputNumber.split(""));
        Collections.sort(tempList);
        for (int i=0; i < tempList.size()-1 ;i++){
            compareDupNumber(tempList.get(i), tempList.get(i+1));
        }
    }

    private static void compareDupNumber(String str1, String str2) {
        if ( str1.equals(str2) ){
            throw new IllegalArgumentException(VALIDATE_MSG_DUPLICATION_NUMBER);
        }
    }

    private static List<Integer> castStrToList(String sInputNumber){
        List<Integer> inputNumber = new ArrayList<Integer>();
        String[] arrInputNumber = sInputNumber.split("");
        for(int i=0; i < arrInputNumber.length ; i++){
            inputNumber.add(Integer.parseInt(arrInputNumber[i]));
        }
        return inputNumber;
    }


    public static Map<String,Object> judge(List<Integer> playNumber, List<Integer> inputNumber) {
        int strikeCount = getStrikeCount(playNumber, inputNumber);
        int ballCount = getBallCount(playNumber, inputNumber) - strikeCount;
        Map<String,Object> playResult = new HashMap<String,Object>();
        playResult.put("strike", strikeCount);
        playResult.put("ball", ballCount);
        return playResult;
    }

    private static int getStrikeCount(List<Integer> playNumber, List<Integer> inputNumber) {
        int strikeCount = 0;
        for(int i=0; i < playNumber.size() ;i++){
            strikeCount += compareStrikeNumber(playNumber.get(i), inputNumber.get(i));
        }
        return strikeCount;
    }
    private static int compareStrikeNumber(int playNumber, int inputNumber) {
        if (playNumber == inputNumber) {
            return 1;
        }
        return 0;
    }

    private static int getBallCount(List<Integer> playNumber, List<Integer> inputNumber) {
        int ballCount = 0;
        for(int i=0; i < inputNumber.size() ;i++){
            ballCount += compareBallNumber(playNumber, inputNumber.get(i));
        }
        return ballCount;
    }
    private static int compareBallNumber(List<Integer> listPlayNumber, int inputNumber) {
        if (listPlayNumber.contains(inputNumber)) {
            return 1;
        }
        return 0;
    }

}