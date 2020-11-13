package io.homo_efficio.base_ball;

import java.util.Scanner;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class App {

    public static void main(String[] args) {
        System.out.print("숫자를 입력해 주세요: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputValidator.check3Digits(input);

    }

}
