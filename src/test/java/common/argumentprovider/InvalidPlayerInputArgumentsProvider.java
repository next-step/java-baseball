package common.argumentprovider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import common.enumeration.InvalidPlayerInputType;

public class InvalidPlayerInputArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

		Stream<Arguments> argumentsStream = Stream.of();

		for (InvalidPlayerInputType invalidPlayerInputType : InvalidPlayerInputType.values()) {

			/// region Given input
			Arguments arguments = null;
			switch (invalidPlayerInputType) {
				case ZERO:
					arguments = Arguments.of(
						invalidPlayerInputType.name(),
						0
					);
					break;
				case NEGATIVE:
					arguments = Arguments.of(
						invalidPlayerInputType.name(),
						-12
					);

					break;
				case LESS_THAN_THREE_DIGITS:
					arguments = Arguments.of(
						invalidPlayerInputType.name(),
						12
					);
					break;
				case MORE_THAN_THREE_DIGITS:
					arguments = Arguments.of(
						invalidPlayerInputType.name(),
						1234
					);
					break;
				case INCLUDE_ZERO:
					arguments = Arguments.of(
						invalidPlayerInputType.name(),
						102
					);
					break;
			}
			/// endregion

			argumentsStream = Stream.concat(argumentsStream, Stream.of(arguments));
		}

		return argumentsStream;
	}
}
