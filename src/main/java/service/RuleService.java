package service;

class RuleService {

    int countStrike(int[] botNumber, int[] userNumber) {
        int count = 0;
        for (int i = 0; i < botNumber.length; i++) {
            if (botNumber[i] == userNumber[i]) {
                count++;
            }
        }
        return count;
    }

    boolean isOverlap(int[] arr, int newNumber) {
        for (int number : arr) {
            if (number == newNumber) {
                return true;
            }
        }
        return false;
    }
}
