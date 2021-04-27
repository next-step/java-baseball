package baseball.model;

import baseball.constants.BaseballConstant;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class TestParametersProvider {
    private static final int MAX_RADIX = BaseballConstant.MAX_RADIX;
    private static final int MIN_RADIX = BaseballConstant.MIN_RADIX;
    private static final int MAX_SIZE = BaseballConstant.MAX_SIZE;
    private static final int MIN_SIZE = BaseballConstant.MIN_SIZE;
    private static final String[] CHARACTERS = "`1234567890-=~!@#$%^&*()_+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPRSTUVWXYZ[]{};'\":,./<>?".split("");
    private static final int DEFAULT_TEST_CASE_COUNT = 100;

    public static List<Arguments> provideSize() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <= MAX_RADIX; radix++) {
            list.add(Arguments.of(radix));
        }
        return list;
    }

    public static List<Arguments> provideRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int size = MIN_SIZE; size < MAX_SIZE; size++) {
            list.add(Arguments.of(size));
        }
        return list;
    }

    public static List<Arguments> provideSizeAndRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <= MAX_RADIX; radix++) {
            for (int size = 1; size < radix; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    public static List<Arguments> provideNonPositiveSizeOrNonPositiveSizeRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = -MAX_RADIX; radix <= 1; radix++) {
            for (int size = -MAX_RADIX; size <= 0; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    public static List<Arguments> provideTooMuchSizeOrTooMuchRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MAX_RADIX * 2; radix > MAX_RADIX; radix--) {
            for (int size = 2 * radix; size >= radix; size--) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    public static List<Arguments> provideRandomBaseballNumberOfAllSizeAndAllRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                generateRandomBaseballNumberString(size, radix),
                                size,
                                radix
                        )
                );
            }
        }
        return list;
    }

    public static List<Arguments> provideRandomBaseballNumberOfDefaultSizeAndDefaultRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int i = 0; i < DEFAULT_TEST_CASE_COUNT; i++) {
            list.add(
                    Arguments.of(
                            generateRandomBaseballNumberString()
                    )
            );
        }
        return list;
    }

    public static List<Arguments> provideRandomBaseballRadixOutBoundExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                generateRandomBaseballNumberStringRadixOutBoundException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    public static List<Arguments> provideRandomBaseballContainsZeroExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                generateRandomBaseballNumberStringContainsZeroException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    public static List<Arguments> provideRandomBaseballDuplicatedExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX + 1; radix <=  MAX_RADIX; radix++) {
            for (int size = 2; size < radix; size++) {
                list.add(
                        Arguments.of(
                                generateRandomBaseballNumberStringDuplicatedException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    public static List<Arguments> provideRandomBaseballHavingWrongLengthExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX + 1; radix <=  MAX_RADIX; radix++) {
            for (int size = 2; size < radix; size++) {
                int differentSize = generateDifferentValue(size, MIN_SIZE, MAX_SIZE);
                list.add(
                        Arguments.of(
                                generateRandomNumberString(differentSize, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    public static List<Arguments> provideRandomBaseballNotValidCharacterExceptionCase() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MIN_RADIX; radix <=  MAX_RADIX; radix++) {
            for (int size = MIN_SIZE; size < radix; size++) {
                list.add(
                        Arguments.of(
                                generateRandomBaseballNumberStringNotValidCharacterException(size, radix),
                                size,
                                radix
                        )
                );
            }
        }

        return list;
    }

    private static Character generateRandomCharacter(Function<Character, Boolean> filter) {
        Random random = new Random();

        String result = "";
        do {
            result = CHARACTERS[random.nextInt(CHARACTERS.length)];
        } while(!filter.apply(result.charAt(0)));

        return result.charAt(0);
    }

    public static Character generateRandomCharacter() {
        return generateRandomCharacter(Character::isDefined);
    }

    private static Character generateRandomNumberCharacter() {
        return generateRandomCharacter(c -> Character.isDigit(c) || Character.isAlphabetic(c));
    }

    private static Character generateRandomNumberCharacter(int radix) {
        return generateRandomCharacter(c -> {
            if (radix >= 2 && radix <= 10) {
                return c >= '0' && c < '0' + radix;
            } else if (radix <= 'z' - 'a' + 10) {
                char upperC = Character.toUpperCase(c);
                return Character.isDigit(c) || (Character.isAlphabetic(c) && upperC >= 'A' && upperC < 'A' + radix - 10);
            }
            return false;
        });
    }

    private static String generateRandomString(int length, Function<Character, Boolean> filter, Function<Void, Character> characterGenerator) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String result;
            do {
                result = String.valueOf(characterGenerator.apply(null));
            } while(!filter.apply(result.charAt(0)));

            sb.append(result);
        }

        return sb.toString();
    }

    private static String generateRandomString(int length, Function<Character, Boolean> filter) {
        return generateRandomString(length, filter, (v) -> generateRandomCharacter());
    }

    private static String generateRandomNumberString(int length, Function<Character, Boolean> filter) {
        return generateRandomString(length, filter, (v) -> generateRandomNumberCharacter());
    }

    private static String generateRandomNumberString(int length, int radix, Function<Character, Boolean> filter) {
        return generateRandomString(length, filter, (v) -> generateRandomNumberCharacter(radix));
    }

    private static String generateRandomNumberString(int length, int radix) {
        return generateRandomNumberString(length, c -> {
            if (radix >= 2 && radix <= 10) {
                return c >= '0' && c < '0' + radix;
            } else if (radix <= 'z' - 'a' + 10) {
                char upperC = Character.toUpperCase(c);
                return Character.isDigit(c) || (Character.isAlphabetic(c) && upperC >= 'A' && upperC < 'A' + radix - 10);
            }

            return false;
        }).toUpperCase();
    }

    private static String generateRandomBaseballNumberString() {
        return generateRandomBaseballNumberString(BaseballConstant.DEFAULT_NUMBERS_SIZE, BaseballConstant.DEFAULT_NUMBER_RADIX);
    }

    private static String generateRandomBaseballNumberString(int length, int radix) {
        boolean[] isChecked = new boolean[radix];
        return generateRandomNumberString(length, radix, c -> {
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

    private static String generateRandomBaseballNumberStringRadixOutBoundException(int size, int radix) {
        char[] original = generateRandomBaseballNumberString(size, radix).toCharArray();

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
                original[index] = generateRandomCharacter(c -> !Character.isDigit(c) && !Character.isAlphabetic(c));
            }
        }

        return new String(original);
    }

    private static String generateRandomBaseballNumberStringContainsZeroException(int size, int radix) {
        char[] original = generateRandomBaseballNumberString(size, radix).toCharArray();

        Random random = new Random();
        int count = random.nextInt(size) + 1;
        for (int i = 0 ; i < count; i++) {
            int index = random.nextInt(size);
            original[index] = '0';
        }

        return new String(original);
    }

    private static String generateRandomBaseballNumberStringDuplicatedException(int size, int radix) {
        char[] original = generateRandomBaseballNumberString(size, radix).toCharArray();

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

    private static String generateRandomBaseballNumberStringNotValidCharacterException(int size, int radix) {
        char[] original = generateRandomBaseballNumberString(size, radix).toCharArray();

        Random random = new Random();
        int count = random.nextInt(size) + 1;
        for (int i = 0 ; i < count; i++) {
            int index = random.nextInt(size);
            original[index] = generateRandomCharacter(c -> !Character.isDigit(c) && !Character.isAlphabetic(c));
        }

        return new String(original);
    }

    private static int generateDifferentValue(int pivot, int min, int max) {
        int result;
        do {
            result = new Random().nextInt(max - min + 1) + min;
        } while(result == pivot);

        return result;
    }
}
