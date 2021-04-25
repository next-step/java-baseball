import vo.BaseBallNumber;
import vo.CompareResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

    private final BaseBallGameService baseBallGameService = new BaseBallGameService();

    public void start() {
        System.out.println("숫자야구게임 START!");
        BaseBallNumber baseBallNumber = createRandomBaseBallNumbers();

        Scanner scanner = new Scanner(System.in);
        int tryCnt = 0;
        CompareResult compareResult = new CompareResult();
        while (compareResult.getStrikeCnt() != BaseBallNumber.BASEBALL_NUMBER_SIZE) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = scanner.next();
            List<Integer> inputList = getInputIntegerList(inputStr);

            compareResult = baseBallNumber.compare(inputList);
            compareResult.print();

            tryCnt++;
        }
        System.out.printf("정답!!(시도 횟수 : %d)%n", tryCnt);
    }

    private BaseBallNumber createRandomBaseBallNumbers() {
        BaseBallNumber baseBallNumber = baseBallGameService.createBaseBallNumber();
        System.out.println("숫자가 랜덤생성되었습니다.");
        return baseBallNumber;
    }

    private List<Integer> getInputIntegerList(String inputStr) {
        String[] inputStrArr = inputStr.split("");
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < BaseBallNumber.BASEBALL_NUMBER_SIZE; i++) {
            inputList.add(Integer.parseInt(inputStrArr[i]));
        }
        return inputList;
    }
}
