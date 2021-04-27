package baseball.testutils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class IntegerListConverter implements ArgumentConverter {
	@Override
	public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
		if (!(source instanceof String)) {
			throw new IllegalArgumentException("The argument should be a string type");
		}
		String[] strArr = ((String)source).split(",");
		List<Integer> ret = new ArrayList<>();
		for (String s : strArr) {
			ret.add(Integer.parseInt(s));
		}
		return ret;
	}
}
