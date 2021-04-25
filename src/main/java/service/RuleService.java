package service;

class RuleService {
    boolean isOverlap(int[] arr, int newNumber) {
        for (int number : arr) {
            if (number == newNumber) {
                return true;
            }
        }
        return false;
    }
}
