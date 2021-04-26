package view;

import java.util.Scanner;

public class ViewLayer {

    public String inputValue() {
        return new Scanner(System.in).nextLine();
    }

    public void outValue(String value) {
        System.out.println(value);
    }
}
