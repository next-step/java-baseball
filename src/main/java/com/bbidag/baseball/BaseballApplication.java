package com.bbidag.baseball;

import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args){

    }

    public int[] inputThreeDigits(){
        Scanner scan = new Scanner(System.in);
        String[] args = scan.nextLine().split("");
        int[] numbers = new int[3];
        int idx = 0;
        for(String numStr : args){
            numbers[idx++] = Integer.parseInt(numStr);
        }
        return numbers;
    }

}
