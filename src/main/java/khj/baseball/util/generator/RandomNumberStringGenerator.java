package khj.baseball.util.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberStringGenerator implements RandomStringGenerator {
    private char[] availableCharacters  = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @Override
    public String generatorString(int length) {
        Set<Character> choiceCharSet = createRandomCharacterSet(length);

        StringBuilder builder = mergeCharacter(choiceCharSet);

        return builder.toString();
    }

    private Set<Character> createRandomCharacterSet(int length) {
        Set<Character> choiceCharSet = new HashSet<>();

        Random random = new Random();
        while (choiceCharSet.size() < length) {
            choiceCharSet.add(availableCharacters[random.nextInt(availableCharacters.length)]);
        }

        return choiceCharSet;
    }

    private StringBuilder mergeCharacter(Set<Character> choiceCharSet) {
        StringBuilder builder = new StringBuilder();

        for (Character choiceChar: choiceCharSet) {
            builder.append(choiceChar);
        }

        return builder;
    }
}
