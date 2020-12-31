package game;

import validators.Validator;

import java.util.Scanner;

public class InputManager {
    static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    public String receiveInput(String comment, Validator checker){
        try{
            System.out.print(comment);
            String input = scanner.next();

            checker.checkValid(input);
            return input;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return receiveInput(comment, checker);
        }
    }
}
