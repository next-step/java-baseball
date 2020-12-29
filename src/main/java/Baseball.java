import java.util.*;

public class Baseball {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_SIZE = 3;
    private static final int NEW_GAME = 1;

    public int getNumber() {
        return scanner.nextInt();
    }

    public boolean isCorrectAnswer(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        return computerNumberList.equals(playerNumberList);
    }

    public List<Integer> getPlayerNumberList(int playerNumber) {
        List<Integer> playerNumberList = new ArrayList<>();

        while (playerNumberList.size() < MAX_SIZE) {
            playerNumberList.add(playerNumber % 10);
            playerNumber /= 10;
        }

        Collections.reverse(playerNumberList);
        return playerNumberList;
    }

    public int getPlayerNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return getNumber();
    }

    public int getBaseballResultIndex(int playerNumber, int playerNumberIndex, List<Integer> computerNumberList) {
        if (computerNumberList.contains(playerNumber)
                && (computerNumberList.indexOf(playerNumber) == playerNumberIndex)) {
            return 0;
        }
        if (computerNumberList.contains(playerNumber)
                && (computerNumberList.indexOf(playerNumber) != playerNumberIndex)) {
            return 1;
        }
        return 2;
    }

    public int[] getResult(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int[] baseballResult = new int[3];

        for (int i = 0; i < playerNumberList.size(); i++) {
            baseballResult[getBaseballResultIndex(playerNumberList.get(i),i,computerNumberList)]++;
        }
        return baseballResult;
    }

    public void identifyAndPrintResult(int[] baseballResult) {
        if (baseballResult[0] != 0) {
            System.out.print(baseballResult[0] + " 스트라이크 ");
        }
        if (baseballResult[1] != 0) {
            System.out.print(baseballResult[1] + " 볼 ");
        }
        if (baseballResult[2] == MAX_SIZE) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void compareComputerNumberAndPlayerNumber(List<Integer> computerNumberList) {
        List<Integer> playerNumberList;
        do {
            playerNumberList = getPlayerNumberList(getPlayerNumber());
            identifyAndPrintResult(getResult(computerNumberList,playerNumberList));
        } while (!isCorrectAnswer(computerNumberList, playerNumberList));

        System.out.println("세개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getNumber() == NEW_GAME;
    }

    public int getRandomIndex(List<Integer> listForComputerNumber) {
        return (int)(Math.random() * listForComputerNumber.size());
    }

    public List<Integer> getComputerNumber() {
        List<Integer> listForComputerNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < MAX_SIZE) {
            int randomIndex = getRandomIndex(listForComputerNumber);
            computerNumberList.add(listForComputerNumber.get(randomIndex));
            listForComputerNumber.remove(randomIndex);
        }

        return computerNumberList;
    }

    public void gameStart() {
        do {
            compareComputerNumberAndPlayerNumber(getComputerNumber());
        } while (continueGame());
    }
}
