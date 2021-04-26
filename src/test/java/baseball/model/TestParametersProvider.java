package baseball.model;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class TestParametersProvider {
    private static final int MAX_RADIX = BaseballNumber.MAX_RADIX;
    private static final int MIN_RADIX = BaseballNumber.MIN_RADIX;
    private static final int MAX_SIZE = BaseballNumber.MAX_SIZE;
    private static final int MIN_SIZE = BaseballNumber.MIN_SIZE;
    private static final String[] CHARACTERS = "`1234567890-=~!@#$%^&*()_+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPRSTUVWXYZ[]{};'\":,./<>?".split("");
    private static final int DEFAULT_TEST_CASE_COUNT = 100;

    private static List<Arguments> provideSize() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <= MAX_RADIX; radix++) {
            list.add(Arguments.of(radix));
        }
        return list;
    }

    private static List<Arguments> provideRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int size = MIN_SIZE; size < MAX_SIZE; size++) {
            list.add(Arguments.of(size));
        }
        return list;
    }

    private static List<Arguments> provideSizeAndRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <= MAX_RADIX; radix++) {
            for (int size = 1; size < radix; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideNonPositiveSizeOrNonPositiveSizeRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = -MAX_RADIX; radix <= 1; radix++) {
            for (int size = -MAX_RADIX; size <= 0; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideTooMuchSizeOrTooMuchRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MAX_RADIX * 2; radix > MAX_RADIX; radix--) {
            for (int size = 2 * radix; size >= radix; size--) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideRandomBaseballNumber() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(Arguments.of(provideRandomBaseballNumberString(size, radix), size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideRandomBaseballNumberDefault() {
        List<Arguments> list = new ArrayList<>();
        for (int i = 0; i < DEFAULT_TEST_CASE_COUNT; i++) {
            list.add(
                    Arguments.of(
                            provideRandomBaseballNumberString()
                    )
            );
        }
        return list;
    }

    private static List<Arguments> provideRandomBaseballRadixOutBoundExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                provideRandomBaseballNumberStringRadixOutBoundException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    private static List<Arguments> provideRandomBaseballContainsZeroExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                provideRandomBaseballNumberStringContainsZeroException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    private static List<Arguments> provideRandomBaseballDuplicatedExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX + 1; radix <=  MAX_RADIX; radix++) {
            for (int size = 2; size < radix; size++) {
                list.add(
                        Arguments.of(
                                provideRandomBaseballNumberStringDuplicatedException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    private static List<Arguments> provideRandomBaseballNotValidCharacterExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                provideRandomBaseballNumberStringNotValidCharacterException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    private static Character provideRandomCharacter(Function<Character, Boolean> filter) {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        String result = "";
        do {
            result = CHARACTERS[random.nextInt(CHARACTERS.length)];
        } while(!filter.apply(result.charAt(0)));

        return result.charAt(0);
    }

    public static String provideRandomString(int length, Function<Character, Boolean> filter) {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        String result = "";
        for (int i = 0; i < length; i++) {
            do {
                result = String.valueOf(provideRandomCharacter());
            } while(!filter.apply(result.charAt(0)));

            sb.append(result);
        }

        return sb.toString();
    }

    public static String provideRandomNumberString(int length, int radix) {
        boolean[] isChecked = new boolean[radix];
        return provideRandomString(length, c -> {
            if (radix >= 2 && radix <= 10) {
                return c >= '0' && c < '0' + radix;
            } else if (radix <= 'z' - 'a' + 10) {
                char upperC = Character.toUpperCase(c);
                return Character.isDigit(c) || (Character.isAlphabetic(c) && upperC >= 'A' && upperC < 'A' + radix - 10);
            }

            return false;
        }).toUpperCase();
    }

    public static String provideRandomBaseballNumberString() {
        return provideRandomBaseballNumberString(BaseballNumber.DEFAULT_NUMBERS_SIZE, BaseballNumber.DEFAULT_NUMBER_RADIX);
    }

    public static String provideRandomBaseballNumberString(int length, int radix) {
        boolean[] isChecked = new boolean[radix];

        return provideRandomString(length, c -> {
            if (radix >= 2 && radix <= 10) {
                return Character.isDigit(c) && c > '0' && c < '0' + radix && !isChecked[c - '0'] && (isChecked[c - '0'] = true);
            } else if (radix <= 'z' - 'a' + 10) {
                char upperC = Character.toUpperCase(c);
                return (Character.isDigit(c) && c != '0' && !isChecked[c - '0'] && (isChecked[c - '0'] = true))
                        || (Character.isAlphabetic(c) && upperC >= 'A' && upperC < 'A' + radix - 10 && !isChecked[upperC - 'A' + 10] && (isChecked[upperC - 'A' + 10] = true));
            }

            return false;
        }).toUpperCase();
    }

    public static String provideRandomBaseballNumberStringRadixOutBoundException(int size, int radix) {
        char[] original = provideRandomBaseballNumberString(size, radix).toCharArray();

        Random random = new Random();
        int count = random.nextInt(size) + 1;
        for (int i = 0 ; i < count; i++) {
            int index = random.nextInt(size);
            if (radix >= 2 && radix < 10) {
                int gap = random.nextInt(10 - radix);
                original[index] = (char)('0' + radix + gap);
            } else if (radix >= 10 && radix < MAX_RADIX) {
                int gap = random.nextInt('z' - 'a' - radix  + 11);
                original[index] = (char)('a' + radix - 10 + gap);
            } else if (radix == MAX_RADIX) {
                original[index] = provideRandomCharacter(c -> !Character.isDigit(c) && !Character.isAlphabetic(c));
            }
        }

        return new String(original);
    }

    public static String provideRandomBaseballNumberStringContainsZeroException(int size, int radix) {
        char[] original = provideRandomBaseballNumberString(size, radix).toCharArray();

        Random random = new Random();
        int count = random.nextInt(size) + 1;
        for (int i = 0 ; i < count; i++) {
            int index = random.nextInt(size);
            original[index] = '0';
        }

        return new String(original);
    }

    public static String provideRandomBaseballNumberStringDuplicatedException(int size, int radix) {
        char[] original = provideRandomBaseballNumberString(size, radix).toCharArray();

        if (size < 2) {
            return new String(original);
        }

        Random random = new Random();
        int count = random.nextInt(size / 2) + 1;
        for (int i = 0 ; i < count; i++) {
            int left = random.nextInt(size);
            int right;
            do {
                right = random.nextInt(size);
            } while(left == right);


            original[left] = original[right];
        }

        return new String(original);
    }

    public static String provideRandomBaseballNumberStringNotValidCharacterException(int size, int radix) {
        char[] original = provideRandomBaseballNumberString(size, radix).toCharArray();

        Random random = new Random();
        int count = random.nextInt(size) + 1;
        for (int i = 0 ; i < count; i++) {
            int index = random.nextInt(size);
            original[index] = provideRandomCharacter(c -> !Character.isDigit(c) && !Character.isAlphabetic(c));
        }

        return new String(original);
    }


    public static Character provideRandomCharacter() {
        return provideRandomCharacter(Character::isDefined);
    }

    public static Character provideRandomNumericCharacter() {
        return provideRandomCharacter(Character::isDigit);
    }

    public static Character provideRandomAlphabeticCharacter() {
        return provideRandomCharacter(Character::isAlphabetic);
    }
}
