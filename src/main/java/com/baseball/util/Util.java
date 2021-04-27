package com.baseball.util;

import com.baseball.view.Message;

import java.util.*;

public class Util {

    final static Scanner scanner = new Scanner(System.in);

    public static List<Integer> readPlayerInput() {
        Message.showInputMessage();
        return rawDataToInput(scanner.next());
    }

    private static List<Integer> rawDataToInput(String rawData) {
        List<Integer> input = new ArrayList<>();

        String arr[] = rawData.trim().split("");
        for (int i = 0; i < arr.length; i++) {
            input.add(Integer.parseInt(arr[i]));
        }

        return input;
    }

    public static int readGameOption() {
        Message.selectGameOption();
        return scanner.nextInt();
    }

}
