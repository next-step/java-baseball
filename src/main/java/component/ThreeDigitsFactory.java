package component;

import model.ThreeDigits;

public class ThreeDigitsFactory {
    private ThreeDigitsFactory() {
    }

    public static ThreeDigits createFrom(String value) {
        char digit1 = value.charAt(0);
        char digit2 = value.charAt(1);
        char digit3 = value.charAt(2);
        return new ThreeDigits(digit1, digit2, digit3);
    }
}
