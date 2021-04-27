package baseball;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConverter;

class IntArrayConverter implements ArgumentConverter {

	@Override
	public int[] convert(Object source, ParameterContext context) {
		String string = (String)source;
		String[] split = string.split(",");
		int[] intArr = new int[split.length];

		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		return intArr;
	}
}

