package baseball.view;

import baseball.domain.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int FULL_COUNT = 3;

    public static void printResult(Map<Status, Integer> result) {
        String message = buildResultMessage(result);
        System.out.println(message);
        printAdditionalMessage(result);
    }

    private static String buildResultMessage(Map<Status, Integer> result) {
        if (isOut(result)) {
            return Status.OUT.getDisplayName();
        }

        List<String> message = new ArrayList<>();
        for (Status status : Status.values()) {
            addMessage(result, message, status);
        }

        return String.join(" ", message);
    }

    private static boolean isOut(Map<Status, Integer> result) {
        Integer matchCount = result.getOrDefault(Status.OUT, 0);
        return FULL_COUNT == matchCount;
    }

    private static void addMessage(Map<Status, Integer> result, List<String> message, Status status) {
        if (Status.OUT.equals(status)) {
            return;
        }

        if (!result.containsKey(status)) {
            return;
        }

        message.add(result.get(status) + " " + status.getDisplayName());
    }

    private static void printAdditionalMessage(Map<Status, Integer> result) {
        Integer matchCount = result.getOrDefault(Status.STRIKE, 0);

        if (FULL_COUNT == matchCount) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
