package me.kingcjy.baseball;

/**
 * @author KingCjy
 */
public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        int[] numbers = inputManager.scanValidInput();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
