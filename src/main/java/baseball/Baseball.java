package baseball;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Baseball {
    public Scanner sc = new Scanner(System.in);

    public void start() {
        int flag = 1;

        while (flag == 1) {
            int[] computerNumber = setComputerNumber();
            playBall(computerNumber);
            flag = getFlag();
        }
    }

    public int[] setComputerNumber() {
        int[] computerNumber = new int[3];
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        while (integerList.size() > 6) {
            int randomIndex = new Random().nextInt(integerList.size());
            computerNumber[9 - integerList.size()] = integerList.get(randomIndex);
            integerList.remove(randomIndex);
        }

        return computerNumber;
    }

    public void playBall(int[] computerNumber) {
        boolean gameOver = false;

        while (!gameOver) {
            String myNumber = getMyNumber();
            Point count = getCount(computerNumber, myNumber);
            printCount(count);
            gameOver = count.x == 3 ? true : false;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String getMyNumber() {
        boolean isCorrectInput = false;
        String myNumber = "";

        while (!isCorrectInput) {
            System.out.print("숫자를 입력해주세요 : ");
            myNumber = sc.next();
            isCorrectInput = myNumber.length() == 3 ? true : false;
        }

        return myNumber;
    }

    public Point getCount(int[] computerNumber, String myNumber) {
        Point count = new Point(0, 0);

        for (int i = 0; i < 3; i++) {
            count.x = computerNumber[i] == (myNumber.charAt(i) - '0') ? count.x + 1 : count.x;
            count.y = ballCheck(computerNumber, i, myNumber.charAt(i) - '0') ? count.y + 1 : count.y;
        }

        return count;
    }

    public boolean ballCheck(int[] computerNumber, int idx, int num) {
        boolean isBall = false;

        for (int i = 0; i < 3; i++) {
            isBall = (idx != i && num == computerNumber[i]) ? true : isBall;
        }

        return isBall;
    }

    public void printCount(Point count) {
        String str = "";
        str += count.x != 0 ? (count.x + " 스트라이크 ") : "";
        str += count.y != 0 ? (count.y + "볼") : "";

        if (str.length() == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(str);
    }

    public int getFlag() {
        boolean isCorrectInput = false;
        int newFlag = 1;

        while (!isCorrectInput) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newFlag = sc.nextInt();
            isCorrectInput = (newFlag == 1 || newFlag == 2) ? true : false;
        }

        return newFlag;
    }
}
