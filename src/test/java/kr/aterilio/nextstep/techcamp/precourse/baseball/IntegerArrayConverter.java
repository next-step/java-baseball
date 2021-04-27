package kr.aterilio.nextstep.techcamp.precourse.baseball;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntegerArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if ( !(source instanceof String) ) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source
            );
        }

        String strSource = (String) source;
        String[] strArray = strSource.split(",");

        if (strArray.length == 0) {
            return new int[]{};
        }

        Integer[] newArray = new Integer[strArray.length];
        for (int i = 0; i < strArray.length; ++i) {
            newArray[i] = Integer.parseInt(strArray[i]);
        }

        return newArray;
    }
}
