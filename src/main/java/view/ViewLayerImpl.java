package view;

import java.util.Scanner;

public class ViewLayerImpl implements ViewLayer {

    @Override
    public String inputValue() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void outValue(String value) { System.out.println(value); }
}
